/**
 * 
 */
package com.songo.gather.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.time.FastDateFormat;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>decription:</p>
 * <p>date:2014年6月18日 上午10:14:13</p>
 * @author gsu·napoleon
 */
public class MyStringUtilsTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年6月18日 上午10:14:13</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link com.songo.gather.utils.MyStringUtils#splitSimpleString(java.lang.String, char)}.
	 */
	@Test
	public void testSplitSimpleString() {
		String row = "!1!2!3!4!5!6!7!";
		List<String> lists = MyStringUtils.splitSimpleString(row, "!");
		
		System.out.println(lists);
	}
	private final String testReplaceString = "abcd!efgh@ijk$LMNG&OP^q,rst?qwe";
	
	@Test
	public void testReplaceUnifiedDelimiter() {
		String newText = MyStringUtils.replaceUnifiedDelimiter(testReplaceString, ",");
		System.out.println(newText);
		List<String> lists = MyStringUtils.splitSimpleString(testReplaceString, ",", true);
		System.out.println(lists);
	}

	@Test
	public void testGetCapitalByNumber() {
		
		int i_10 = 10;
		int i_11 = 12;
		int i_21 = 23;
		int i_23 = 34;
		System.err.println(i_10 / 10 + "; " + i_10 % 10);
		System.err.println(i_11 / 10 + "; " + i_11 % 10);
		System.err.println(i_21 / 10 + "; " + i_21 % 20);
		System.err.println(i_23 / 10 + "; " + i_23 % 30);
		
		String capital_9 = MyStringUtils.getCapitalByNumber(9);
		System.err.println("9 = " + capital_9);
		String capital_10 = MyStringUtils.getCapitalByNumber(10);
		System.err.println("10 = " + capital_10);
		String capital_19 = MyStringUtils.getCapitalByNumber(19);
		System.err.println("19 = " + capital_19);
		String capital_29 = MyStringUtils.getCapitalByNumber(29);
		System.err.println("29 = " + capital_29);
		String capital_39 = MyStringUtils.getCapitalByNumber(39);
		System.err.println("39 = " + capital_39);
		String capital_45 = MyStringUtils.getCapitalByNumber(45);
		System.err.println("45 = " + capital_45);
		String capital_99 = MyStringUtils.getCapitalByNumber(99);
		System.err.println("99 = " + capital_99);
	}

	@Test
	public void testStringSplitByRegular() {
		String s = "{A}{b}{C}{d}{E}{e}{F}";
		String [] ss = s.split("[{}]");
		for (String sv : ss) {
			System.err.println(sv);
		}
		String s1 = "[A][b][C][d][E][e][F]";
		String [] ss1 = s1.split("[\\[\\]]");
		for (String sv : ss1) {
			System.err.println(sv);
		}
	}
	
	@Test
	public void testXoy() {
		int type = 8;
		for (int i = 1; i <= 4; i++, type = type / 2) {
    		boolean needCount = type % 2 == 1;
    		switch (i){
	    		case 1:
	    			if (needCount) {
	    				System.err.println("*******************UV***************");
	    			} else {
	    				System.err.println("*******************N-UV***************");
	    			}
	    			break;
	    		case 2:
	    			if (needCount) {
	    				System.err.println("*******************IP***************");
	    			} else {
	    				System.err.println("*******************N-IP***************");
	    			}
	    			break;
	    		case 3:
	    			if (needCount) {
	    				System.err.println("*******************VISIT***************");
	    			} else {
	    				System.err.println("*******************N-VISIT***************");
	    			}
	    			break;
	    		case 4:
	    			if (needCount) {
	    				System.err.println("*******************PV***************");
	    			} else {
	    				System.err.println("*******************N-PV***************");
	    			}
	    			break;
    		}
    	}
	}
	
	@Test
	public void testStringN() {
		String x = "1,2,3,4,5,6,7,8,9";
		String [] xs = x.split(",");
		StringBuilder builder = new StringBuilder();
		String prefix = "";
		for (String s : xs) {
			builder.append(prefix).append(s);
			prefix = ",";
		}
		System.out.println(builder.toString());
	}
	
	@Test
	public void testUrl() {
		Pattern p = Pattern.compile("http://gm.*?(?<!\\.pconline|\\.pcauto).com.*");
		System.out.println(p.matcher("http://gm.1pcauto.com.cn/qiche/qc_t2.html").find());
		System.out.println(p.matcher("http://gm.pcauto1.com.cn/qiche/qc_t2.html").find());
		System.out.println(p.matcher("http://gm.wpcauto.com.cn/qiche/qc_t2.html").find());
		System.out.println(p.matcher("http://gm.pcautow.com.cn/qiche/qc_t2.html").find());
		System.out.println(p.matcher("http://gm.pcauto.com.cn/qiche/qc_t2.html").find());
		System.out.println(p.matcher("http://gm.1pconline.com.cn/qiche/qc_t2.html").find());
		System.out.println(p.matcher("http://gm.pconline1.com.cn/qiche/qc_t2.html").find());
		System.out.println(p.matcher("http://gm.wpconline.com.cn/qiche/qc_t2.html").find());
		System.out.println(p.matcher("http://gm.pconlinew.com.cn/qiche/qc_t2.html").find());
		System.out.println(p.matcher("http://gm.pconline.com.cn/qiche/qc_t2.html").find());
	}
	
	@Test
	public void testFile() throws Exception {
		Pattern p = Pattern.compile("http://gm.*?(?<!\\.pconline|\\.pcauto).com.*");
		String referer = "http://gm.pconline-555.com.cn/qiche/qc_t2.html";
		if (p.matcher(referer).find()) {
			FastDateFormat fdf = FastDateFormat.getInstance("yyyyMMdd");
			File file = new File("E:\\counterworkspace\\data\\" + fdf.format(new Date()) + "-gm-refererS.txt");
			StringBuilder sb = new StringBuilder();
			if (file.exists() && file.isFile()) {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String url;
				boolean isExists = false;
				while ((url = reader.readLine()) != null) {
					String [] urls = url.split("\t");
					if (StringUtils.equals("T", urls[2])) {
						continue;
					}
					isExists = StringUtils.equals(referer, urls[0]);
					sb.append(urls[0]).append('\t').append(isExists ? Integer.valueOf(urls[1]) + 1 : urls[1]).append('\t').append("F").append('\n');
				}
				if (!isExists) {
					sb.append(referer).append('\t').append(1).append('\t').append("F").append('\n');
				}
				reader.close();
			} else {
				file.createNewFile();
				sb.append(referer).append('\t').append(1).append('\t').append("F").append('\n');
			}
			PrintWriter writer = new PrintWriter(file);
			writer.write(sb.toString());
			writer.close();
		}
	}
	
	@Test
	public void testSS() {
		String s = "###http://price.pcauto.com.cn/qcbk/zymc/qtmc/1210/2191565.html";
		System.out.println(s.split("###")[0]);
		System.out.println(s.split("###")[1]);
	}
	
}
