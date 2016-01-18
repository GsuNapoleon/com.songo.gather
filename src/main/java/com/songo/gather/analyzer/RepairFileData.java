/**
 * 
 */
package com.songo.gather.analyzer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.songo.gather.utils.MyFileUtils;

/**
 * <p>decription:</p>
 * <p>date:2016年1月8日 上午9:48:46</p>
 * @author gsu·napoleon
 */
public class RepairFileData {

	private static final Logger logger = LoggerFactory.getLogger(RepairFileData.class);
	private static final String REPAIR_FOLDER = "E:\\counterworkspace\\counter\\games\\repair\\";
	private static final String ORIGIN_FOLDER = "E:\\counterworkspace\\counter\\baby\\temp\\";
	private static final String ORIGIN_OLD_FOLDER = "E:\\counterworkspace\\counter\\games\\old-temp\\";
	private static final String ORIGIN_NEW_FOLDER = "E:\\counterworkspace\\counter\\games\\new-temp\\";
	
	public static void correctionChannel(final String time, int channelId) throws Exception {
		String[] files = getFileNames(time, ORIGIN_FOLDER);
        files = MyFileUtils.sortFileName(files);
        String line;
        for (String file : files) {
        	BufferedReader reader = new BufferedReader(new FileReader(ORIGIN_FOLDER + file));
        	PrintWriter writer = new PrintWriter(REPAIR_FOLDER + file);
        	while ((line = reader.readLine()) != null) {
        		writer.println(repairLine(channelId, line));
        	}
        	writer.flush();
        	writer.close();
        	reader.close();
        }
	}

	/**
	 * <p>decription:</p>
	 * <p>date:2016年1月15日 上午9:37:44</p>
	 * @author gsu·napoleon
	 * @param time
	 * @return
	 */
	private static String[] getFileNames(final String time, String folder) {
		String[] files = new File(folder).list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.startsWith(time);
            }
        });
		return files;
	}

	/**
	 * <p>decription:</p>
	 * <p>date:2016年1月8日 上午10:06:45</p>
	 * @author gsu·napoleon
	 * @param channelId
	 * @param line
	 */
	private static String repairLine(int channelId, String line) {
		String [] lines = line.split("\t");
		if (StringUtils.equals("0", lines[6])) {
			logger.info("{}", line);
			lines[6] = String.valueOf(channelId);
			StringBuilder sb = new StringBuilder(line.length());
			String prefix = "";
			for (String l : lines) {
				sb.append(prefix).append(l);
				prefix = "\t";
			}
			return sb.toString();
		}
		return line;
	}
	
	private static void mergeFile(String time) {
		String [] newFiles = getFileNames(time, ORIGIN_NEW_FOLDER);
		
		try {
			for (String nf : newFiles) {
				System.out.println("===================[" + nf + "]===================");
				String [] ofs = getFileNames(nf, ORIGIN_OLD_FOLDER);
				if (ofs == null || ofs.length == 0) {
					continue;
				}
				File wf = new File(REPAIR_FOLDER + nf);
				if (!wf.exists()) {
					wf.createNewFile();
				}
				BufferedWriter wReader = new BufferedWriter(new FileWriter(wf, true));
				String os = readerLine(new File(ORIGIN_OLD_FOLDER + ofs[0]));
				String ns = readerLine(new File(ORIGIN_NEW_FOLDER + nf));
				wReader.append(os).write(ns);
				wReader.flush();
				wReader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * <p>decription:</p>
	 * <p>date:2016年1月15日 上午10:08:22</p>
	 * @author gsu·napoleon
	 * @param wReader
	 * @param of
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static String readerLine(File f)
			throws FileNotFoundException, IOException {
		BufferedReader r = new BufferedReader(new FileReader(f));
		String ol;
		StringBuilder sb = new StringBuilder();
		while ((ol = r.readLine()) != null) {
//			w.write(ol);
			sb.append(ol).append('\n');
		}
		r.close();
		return sb.toString();
	}
	
	/**
	 * <p>decription:</p>
	 * <p>date:2016年1月8日 上午9:48:46</p>
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		try {
//			correctionChannel("20160111", 3723);
			mergeFile("20160115");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
