/**
 * 
 */
package com.songo.gather.concurrent.disruptor.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.PrefixFileFilter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.EventHandlerGroup;

/**
 * <p>decription:</p>
 * <p>date:2015年8月12日 上午9:59:09</p>
 * @author gsu·napoleon
 */
public class TrafficAnalysis {
	
	private static final Logger logger = LoggerFactory.getLogger(TrafficAnalysis.class);
	private static final String SEPERATOR = "\t";
	// 每个文件里每一个时间的第一行。由于取时间的时候，行已经读出来了，所以要把第一行保留下来。
	private String[] timeFirstLines;
	// 对应timeFirstLines保存的时间
	private String[] times;
	// 文件个数
	int length;

	private int timeStartIndex = 0;
	private int timeEndIndex = 14;
	private List<BufferedReader> inputs = new ArrayList<BufferedReader>();
	private EventHandlerGroup<Data> handleEvents;
	
	public TrafficAnalysis() {
		
	}
	
	@SuppressWarnings("unchecked")
	public void analysis(String prefix) {
		logger.info("数据已经准备好,请开始分析");
		long start = System.currentTimeMillis();
		Disruptor<Data> disruptor = new Disruptor<Data>(new DataFactory(), 
				8, Executors.newCachedThreadPool());
		DataHandler handler = new DataHandler();
		handleEvents = disruptor.handleEventsWith(handler);
		disruptor.start();
		
		RingBuffer<Data> ringBuffer = disruptor.getRingBuffer();
		DataReader dataReader = new DataReader(ringBuffer);
		try {
			setFiles(prefix);
			length = inputs.size();
			logger.warn("文件数：【{}】", length);
			run(dataReader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		long times = end - start;
		Object [] objs = {handler.getUvNums(), handler.getUvIpNums(), handler.getIpNums(), handler.getPvs(), times}; 
		logger.warn("统计结果：{UVS->{{}}, UPS->{{}}, IPS->{{}}, PVS->{{}}, TIMES->{{}}}.", objs);
	}
	
	private void setFiles(String prefix) throws IOException {
		File directory = new File("D:\\DevelopmentEnvironment\\counter\\auto\\work\\");
		IOFileFilter fileFilter = new PrefixFileFilter(prefix);
		IOFileFilter dirFilter = FalseFileFilter.FALSE;
		Collection<File> files = FileUtils.listFiles(directory, fileFilter, dirFilter);
		for (File file : files) {
			inputs.add(new BufferedReader(new FileReader(file)));
		}
	}
	
	private void run(DataReader dataReader) throws IOException {
		timeFirstLines = new String[length];
		times = new String[length];
		int index = 0;

		String line = null;
		BufferedReader reader = null;
		String _time = null;

		initTime();
		// 读文件
		// 读最小时间的那个文件，先从timeFirstLines里读第一行，再从文件里读同一个时间段的内容
		while (!isCompeleted(timeFirstLines)) {
			index = getMinTimeFileIndex(times);
			// 处理第一行信息
			if (timeFirstLines[index] != null) {
				dataReader.reader(timeFirstLines[index]);
//				handler.handleLine(timeFirstLines[index]);
			}
			reader = inputs.get(index);
			// 读同一时间段
			while ((line = reader.readLine()) != null) {
				_time = getTime(line);
				// 时间格式不正确，则忽略
				if (_time == null) {
					continue;
				}	
				if (!isSameTime(times[index], _time)) {
					break;
				}
				dataReader.reader(line);
//				handler.handleLine(line);
			}
			// 文件读完
			if (line == null) {
				_time = null;
			}
			// 设置时间与行信息
			timeFirstLines[index] = line;
			times[index] = _time;
		}
	}

	/**
	 * 取得行时间
	 * 
	 * @param line
	 * @return
	 */
	private String getTime(String line) {
		String time = null;
		// 时间格式不正确
		if (line == null || line.length() < timeEndIndex) {
			System.out.println("error:" + line);
			return null;
		}
		try {
			time = line.substring(timeStartIndex, timeEndIndex);
			if (time.contains(SEPERATOR)) {
				System.out.println("error:" + line);
				return null;
			}
			return time;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 初始化时间
	 * 
	 * @throws IOException
	 */
	private void initTime() throws IOException {
		String line = null;
		BufferedReader reader = null;
		for (int i = 0; i < inputs.size(); i++) {
			reader = inputs.get(i);
			line = reader.readLine();
			if (line != null) {
				timeFirstLines[i] = line;
				times[i] = getTime(line);
			}
		}
	}

	/**
	 * 得到最少时间的文件索引
	 * 
	 * @param times
	 * @return
	 */
	private int getMinTimeFileIndex(String[] times) {
		int minIndex = 0;
		String minTime = null;
		for (int i = 0; i < times.length; i++) {
			if (times[i] != null && (numCompare(times[i], minTime) < 0)) {
				minTime = times[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	private int numCompare(String str1, String str2) {
		if (str1 == null && str2 == null)
			return 0;
		else if (str1 == null)
			return 1;
		else if (str2 == null)
			return -1;
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		int length = chars1.length;
		if (chars1.length != chars2.length)
			return chars2.length > chars1.length ? -1 : 1;
		for (int i = 0; i < length; i++) {
			if (chars1[i] > chars2[i])
				return 1;
			else if (chars1[i] < chars2[i])
				return -1;
		}
		return 0;
	}
	
	/**
	 * 判断是否全部文件读完
	 * 
	 * @param timeFirstLines
	 * @return
	 */
	private boolean isCompeleted(String[] timeFirstLines) {
		boolean completed = true;
		for (String line : timeFirstLines) {
			completed = completed && (line == null);
			if (!completed) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 时间是否相同
	 * 
	 * @param time
	 * @param comparedTime
	 * @return
	 */
	private boolean isSameTime(String time, String comparedTime) {
		return time != null && comparedTime != null
				&& StringUtils.equals(time, comparedTime);
	}
	
}
