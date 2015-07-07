/**
 * 
 */
package com.songo.gather.utils;

import java.util.List;

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
}
