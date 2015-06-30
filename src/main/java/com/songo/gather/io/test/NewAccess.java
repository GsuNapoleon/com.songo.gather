/**
 * 
 */
package com.songo.gather.io.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.filefilter.RegexFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>decription:</p>
 * <p>date:2014年9月12日 下午3:32:55</p>
 * @author gsu·napoleon
 */
public class NewAccess {
	
	private static final Logger logger = LoggerFactory.getLogger(NewAccess.class);

	public static void run() throws IOException {
		File directory = new File("D:\\DevelopmentEnvironment\\counter\\lady\\self\\20140908");
		FilenameFilter filter = new RegexFileFilter("\\d+");
		File [] files = directory.listFiles(filter);
		logger.info("文件数：{{}}", files.length);
		List<BufferedReader> inputs = new LinkedList<BufferedReader>();
		for (File file : files) {
			logger.info("处理的文件名是：{{}}", file.getName());
			inputs.add(new BufferedReader(new FileReader(file)));
		}
	
		for (BufferedReader br : inputs) {
			String line;
			while ((line = br.readLine()) != null) {
				logger.info("读取的每行数据：{{}}", line);
			}
		}
		
	}
	
	public static void main(String[] args) {
		try {
			run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
