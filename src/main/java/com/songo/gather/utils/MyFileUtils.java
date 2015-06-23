/**
 * 
 */
package com.songo.gather.utils;

import java.io.File;
import java.text.ParseException;
import java.util.Date;

/**
 * <p>
 * decription:
 * </p>
 * <p>
 * date:2015年6月3日 上午11:12:15
 * </p>
 * 
 * @author gsu·napoleon
 */
public final class MyFileUtils {

	private FileItem[] timeTable = new FileItem[24 * 4];
	private static String SRC_PATH;
	private static String TARGET_PATH;

	public void init(String srcPath, String targetPath, int batchSize) {

		MyFileUtils.SRC_PATH = srcPath + File.separator;
		MyFileUtils.TARGET_PATH = targetPath + File.separator;

		initTimeTable();

	}

	private void initTimeTable() {
		String today = MyDateFormatter.YYYYMMDD.formatter(new Date());

		// set first item of today
		timeTable[0] = new FileItem();
		try {
			
			timeTable[0].startTime = MyDateFormatter.YYYYMMDDHHMMSSSSS.parser(today + "000001000");
			timeTable[0].endTime = MyDateFormatter.YYYYMMDDHHMMSSSSS.parser(today + "001500999");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		timeTable[0].dir = MyFileUtils.SRC_PATH;

		for (int i = 0, c = timeTable.length - 1; i < c; ++i) {
			timeTable[i + 1] = new FileItem();
			timeTable[i + 1].startTime = new Date(
					timeTable[i].startTime.getTime() + 900000);
			timeTable[i + 1].endTime = new Date(
					timeTable[i].endTime.getTime() + 900000);
			if (i % 2 == 0) {
				timeTable[i + 1].dir = MyFileUtils.TARGET_PATH;
			} else {
				timeTable[i + 1].dir = MyFileUtils.SRC_PATH;
			}
		}
	}

	/**
	 * 交换写入文件，每15分会换一个硬盘些文件，以减少io冲突
	 */
	synchronized public void swapFile() {
		// 如果到了第二天，重新初始化时间文件名对照表
		if (new Date().compareTo(timeTable[timeTable.length - 1].endTime) > 0) {
			initTimeTable();
		}
		// writer.flush();
		// writer.setFileName(getFileName());
	}

	/**
	 * 获得当前时间的写入文件名
	 * 
	 * @return
	 */
	public String getFileName() {
		Date now = new Date();
		String result = null;

		for (int i = 0, c = timeTable.length; i < c; ++i) {
			if (now.compareTo(timeTable[i].startTime) > 0
					&& now.compareTo(timeTable[i].endTime) < 0) {
				result = timeTable[i].getFileName();
				break;
			}
		}

		if (result == null) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}

			now = new Date();
			for (int i = 0, c = timeTable.length; i < c; ++i) {
				if (now.compareTo(timeTable[i].startTime) > 0
						&& now.compareTo(timeTable[i].endTime) < 0) {
					result = timeTable[i].getFileName();
					break;
				}
			}

		}

		return result;
	}

	/**
	 * 获得本周期的开始时间
	 * 
	 * @return
	 */
	public Date getStartTime() {
		Date now = new Date();
		Date result = null;

		for (int i = 0, c = timeTable.length; i < c; ++i) {
			if (now.compareTo(timeTable[i].startTime) > 0
					&& now.compareTo(timeTable[i].endTime) < 0) {
				result = timeTable[i].startTime;
				break;
			}
		}

		if (result == null) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}

			now = new Date();
			for (int i = 0, c = timeTable.length; i < c; ++i) {
				if (now.compareTo(timeTable[i].startTime) > 0
						&& now.compareTo(timeTable[i].endTime) < 0) {
					result = timeTable[i].startTime;
					break;
				}
			}

		}

		return result;
	}

	/**
	 * 获得下一个周期的开始时间
	 * 
	 * @return
	 */
	public Date getNextStartTime() {
		Date now = new Date();
		Date result = null;

		for (int i = 0, c = timeTable.length; i < c; ++i) {
			if (now.compareTo(timeTable[i].startTime) > 0
					&& now.compareTo(timeTable[i].endTime) < 0) {
				result = new Date(timeTable[i].endTime.getTime() + 1000);
				break;
			}
		}

		if (result == null) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}

			now = new Date();
			for (int i = 0, c = timeTable.length; i < c; ++i) {
				if (now.compareTo(timeTable[i].startTime) > 0
						&& now.compareTo(timeTable[i].endTime) < 0) {
					result = new Date(timeTable[i].endTime.getTime() + 1000);
					break;
				}
			}
		}

		return result;
	}

	public static class FileItem {
		Date startTime;
		Date endTime;
		String dir;

		/**
		 * 获得当前时间范围的文件名
		 * 
		 * @return
		 */
		public String getFileName() {
			StringBuffer buf = new StringBuffer(dir);
			buf.append(MyDateFormatter.YYYYMMDDHHMM.formatter(startTime));
			return buf.toString();
		}
	}

}
