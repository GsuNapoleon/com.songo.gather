/**
 * 
 */
package com.songo.gather.lang;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>decription:</p>
 * <p>date:2014年6月18日 下午2:46:18</p>
 * @author gsu·napoleon
 */
public class StringTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年6月18日 下午2:46:18</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link java.lang.String#String()}.
	 */
	@Test
	public void testString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#String(java.lang.String)}.
	 */
	@Test
	public void testStringString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#String(char[])}.
	 */
	@Test
	public void testStringCharArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#String(char[], int, int)}.
	 */
	@Test
	public void testStringCharArrayIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#String(int[], int, int)}.
	 */
	@Test
	public void testStringIntArrayIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#String(byte[], int, int, java.lang.String)}.
	 */
	@Test
	public void testStringByteArrayIntIntString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#String(byte[], int, int, java.nio.charset.Charset)}.
	 */
	@Test
	public void testStringByteArrayIntIntCharset() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#String(byte[], java.lang.String)}.
	 */
	@Test
	public void testStringByteArrayString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#String(byte[], java.nio.charset.Charset)}.
	 */
	@Test
	public void testStringByteArrayCharset() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#String(byte[], int, int)}.
	 */
	@Test
	public void testStringByteArrayIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#String(byte[])}.
	 */
	@Test
	public void testStringByteArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#String(java.lang.StringBuffer)}.
	 */
	@Test
	public void testStringStringBuffer() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#String(java.lang.StringBuilder)}.
	 */
	@Test
	public void testStringStringBuilder() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#length()}.
	 */
	@Test
	public void testLength() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#charAt(int)}.
	 */
	@Test
	public void testCharAt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#codePointAt(int)}.
	 */
	@Test
	public void testCodePointAt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#codePointBefore(int)}.
	 */
	@Test
	public void testCodePointBefore() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#codePointCount(int, int)}.
	 */
	@Test
	public void testCodePointCount() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#offsetByCodePoints(int, int)}.
	 */
	@Test
	public void testOffsetByCodePoints() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#getChars(int, int, char[], int)}.
	 */
	@Test
	public void testGetCharsIntIntCharArrayInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#getBytes(java.lang.String)}.
	 */
	@Test
	public void testGetBytesString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#getBytes(java.nio.charset.Charset)}.
	 */
	@Test
	public void testGetBytesCharset() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#getBytes()}.
	 */
	@Test
	public void testGetBytes() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#contentEquals(java.lang.StringBuffer)}.
	 */
	@Test
	public void testContentEqualsStringBuffer() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#contentEquals(java.lang.CharSequence)}.
	 */
	@Test
	public void testContentEqualsCharSequence() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#equalsIgnoreCase(java.lang.String)}.
	 */
	@Test
	public void testEqualsIgnoreCase() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#compareTo(java.lang.String)}.
	 */
	@Test
	public void testCompareTo() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#compareToIgnoreCase(java.lang.String)}.
	 */
	@Test
	public void testCompareToIgnoreCase() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#regionMatches(int, java.lang.String, int, int)}.
	 */
	@Test
	public void testRegionMatchesIntStringIntInt() {
		String test = "aaoodd";
		String text = "aaooee";
		System.out.println(test.regionMatches(0, text, 0, 2));
		System.out.println(test.regionMatches(2, text, 2, 2));
		System.out.println(test.regionMatches(4, text, 4, 2));
	}

	/**
	 * Test method for {@link java.lang.String#regionMatches(boolean, int, java.lang.String, int, int)}.
	 */
	@Test
	public void testRegionMatchesBooleanIntStringIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#startsWith(java.lang.String, int)}.
	 */
	@Test
	public void testStartsWithStringInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#startsWith(java.lang.String)}.
	 */
	@Test
	public void testStartsWithString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#endsWith(java.lang.String)}.
	 */
	@Test
	public void testEndsWith() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#indexOf(int)}.
	 */
	@Test
	public void testIndexOfInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#indexOf(int, int)}.
	 */
	@Test
	public void testIndexOfIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#lastIndexOf(int)}.
	 */
	@Test
	public void testLastIndexOfInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#lastIndexOf(int, int)}.
	 */
	@Test
	public void testLastIndexOfIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#indexOf(java.lang.String)}.
	 */
	@Test
	public void testIndexOfString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#indexOf(java.lang.String, int)}.
	 */
	@Test
	public void testIndexOfStringInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#lastIndexOf(java.lang.String)}.
	 */
	@Test
	public void testLastIndexOfString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#lastIndexOf(java.lang.String, int)}.
	 */
	@Test
	public void testLastIndexOfStringInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#substring(int)}.
	 */
	@Test
	public void testSubstringInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#substring(int, int)}.
	 */
	@Test
	public void testSubstringIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#subSequence(int, int)}.
	 */
	@Test
	public void testSubSequence() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#concat(java.lang.String)}.
	 */
	@Test
	public void testConcat() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#replace(char, char)}.
	 */
	@Test
	public void testReplaceCharChar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#matches(java.lang.String)}.
	 */
	@Test
	public void testMatches() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#contains(java.lang.CharSequence)}.
	 */
	@Test
	public void testContains() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#replaceFirst(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testReplaceFirst() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#replaceAll(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testReplaceAll() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#replace(java.lang.CharSequence, java.lang.CharSequence)}.
	 */
	@Test
	public void testReplaceCharSequenceCharSequence() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#split(java.lang.String, int)}.
	 */
	@Test
	public void testSplitStringInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#split(java.lang.String)}.
	 */
	@Test
	public void testSplitString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#toLowerCase(java.util.Locale)}.
	 */
	@Test
	public void testToLowerCaseLocale() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#toLowerCase()}.
	 */
	@Test
	public void testToLowerCase() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#toUpperCase(java.util.Locale)}.
	 */
	@Test
	public void testToUpperCaseLocale() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#toUpperCase()}.
	 */
	@Test
	public void testToUpperCase() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#trim()}.
	 */
	@Test
	public void testTrim() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#toCharArray()}.
	 */
	@Test
	public void testToCharArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#format(java.lang.String, java.lang.Object[])}.
	 */
	@Test
	public void testFormatStringObjectArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#format(java.util.Locale, java.lang.String, java.lang.Object[])}.
	 */
	@Test
	public void testFormatLocaleStringObjectArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#valueOf(java.lang.Object)}.
	 */
	@Test
	public void testValueOfObject() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#valueOf(char[])}.
	 */
	@Test
	public void testValueOfCharArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#valueOf(char[], int, int)}.
	 */
	@Test
	public void testValueOfCharArrayIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#copyValueOf(char[], int, int)}.
	 */
	@Test
	public void testCopyValueOfCharArrayIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#copyValueOf(char[])}.
	 */
	@Test
	public void testCopyValueOfCharArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#valueOf(boolean)}.
	 */
	@Test
	public void testValueOfBoolean() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#valueOf(char)}.
	 */
	@Test
	public void testValueOfChar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#valueOf(int)}.
	 */
	@Test
	public void testValueOfInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#valueOf(long)}.
	 */
	@Test
	public void testValueOfLong() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#valueOf(float)}.
	 */
	@Test
	public void testValueOfFloat() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#valueOf(double)}.
	 */
	@Test
	public void testValueOfDouble() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link java.lang.String#intern()}.
	 */
	@Test
	public void testIntern() {
		fail("Not yet implemented");
	}

}
