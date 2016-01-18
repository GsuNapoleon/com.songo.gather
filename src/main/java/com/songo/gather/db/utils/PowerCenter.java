/**
 * 
 */
package com.songo.gather.db.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * <p>decription:</p>
 * <p>date:2015年11月20日 下午3:42:19</p>
 * @author gsu·napoleon
 */
public class PowerCenter {

	private static List<String> reader(String path) {
		
		BufferedReader reader = null;
		List<String> tables = new ArrayList<String>();
		try {
			reader = new BufferedReader(new FileReader(new File(path)));
			String table;
			while ((table = reader.readLine()) != null) {
				if (StringUtils.contains(table, "bak") 
						|| StringUtils.contains(table, "old") 
						|| StringUtils.contains(table, "_1_")
						|| StringUtils.contains(table, "_2_")
						|| StringUtils.contains(table, "_4_")
						|| StringUtils.contains(table, "_5_")
						|| StringUtils.contains(table, "_6_")) {
					continue;
				}
				tables.add(table);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return tables;
	}
	
	/**
	 * <p>decription:</p>
	 * <p>date:2015年11月20日 下午3:42:19</p>
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
//		String outputPattern = "select * into outfile '''/usr/local/mysql/cnt_games/'{0}'.txt''' from {1} where sid=3;";
//		System.out.println(MessageFormat.format(outputPattern, "cnt_uv_daily", "cnt_uv_daily"));
		List<String> tableSids = reader("E:\\counterworkspace\\games\\2016_sid.txt");
		List<String> tableNoSids = reader("E:\\counterworkspace\\games\\2016_no_sid.txt");
		try {
			PrintWriter output = new PrintWriter("E:\\counterworkspace\\games\\games_output_2016.sql");
			PrintWriter execute = new PrintWriter("E:\\counterworkspace\\games\\games_execute_2016.sql");
			String outputPattern = "select * into outfile '''/usr/local/mysql/cnt_games/'{0}'.txt''' from {1} {2};";
			String executePattern = "load data infile '''/usr/local/mysql/cnt_games/'{0}'.txt''' into table {1};";
			for (String table : tableSids) {
				output.write(MessageFormat.format(outputPattern, table, table, "where sid=3") + "\n");
				execute.write(MessageFormat.format(executePattern, table, table) + "\n");
			}
			output.flush();
			execute.flush();
			for (String table : tableNoSids) {
				output.write(MessageFormat.format(outputPattern, table, table, "") + "\n");
				execute.write(MessageFormat.format(executePattern, table, table) + "\n");
			}
			output.flush();
			execute.flush();
			output.close();
			execute.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
