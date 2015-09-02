/**
 * 
 */
package com.songo.gather.io.console;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * <p>decription:</p>
 * <p>date:2015年8月31日 上午11:24:26</p>
 * @author gsu·napoleon
 */
public class MyPrintLineTable {

	public void line() {
		
	}
	
	public static void main(String[] args) {
		try {
			CommandLineParser parser = new DefaultParser();
			Options options = new Options();
			options.addOption("line", "线");
			CommandLine commandLine = parser.parse(options, new String[]{"-"});
			System.err.println(commandLine.getOptionValue("line"));
			System.err.println(String.format("%4s", "-"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
}
