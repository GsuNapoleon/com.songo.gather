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

}
