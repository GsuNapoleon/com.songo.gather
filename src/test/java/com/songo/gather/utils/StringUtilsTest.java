/**
 * 
 */
package com.songo.gather.utils;

import static org.junit.Assert.fail;

import java.net.URLDecoder;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * <p>decription:</p>
 * <p>date:2014年7月2日 上午9:48:57</p>
 * @author gsu·napoleon
 */
public class StringUtilsTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年7月2日 上午9:48:57</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#StringUtils()}.
	 */
	@Test
	public void testStringUtils() {
		int i = 10;
		int j = i + (i << 1) + 1;
		System.out.println(j);
		System.out.println(i >> 2);
		System.out.println(i << 2);
		
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#isEmpty(java.lang.CharSequence)}.
	 */
	@Test
	public void testIsEmpty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#isNotEmpty(java.lang.CharSequence)}.
	 */
	@Test
	public void testIsNotEmpty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#isAnyEmpty(java.lang.CharSequence[])}.
	 */
	@Test
	public void testIsAnyEmpty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#isNoneEmpty(java.lang.CharSequence[])}.
	 */
	@Test
	public void testIsNoneEmpty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#isBlank(java.lang.CharSequence)}.
	 */
	@Test
	public void testIsBlank() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#isNotBlank(java.lang.CharSequence)}.
	 */
	@Test
	public void testIsNotBlank() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#isAnyBlank(java.lang.CharSequence[])}.
	 */
	@Test
	public void testIsAnyBlank() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#isNoneBlank(java.lang.CharSequence[])}.
	 */
	@Test
	public void testIsNoneBlank() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#trim(java.lang.String)}.
	 */
	@Test
	public void testTrim() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#trimToNull(java.lang.String)}.
	 */
	@Test
	public void testTrimToNull() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#trimToEmpty(java.lang.String)}.
	 */
	@Test
	public void testTrimToEmpty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#strip(java.lang.String)}.
	 */
	@Test
	public void testStripString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#stripToNull(java.lang.String)}.
	 */
	@Test
	public void testStripToNull() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#stripToEmpty(java.lang.String)}.
	 */
	@Test
	public void testStripToEmpty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#strip(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testStripStringString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#stripStart(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testStripStart() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#stripEnd(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testStripEnd() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#stripAll(java.lang.String[])}.
	 */
	@Test
	public void testStripAllStringArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#stripAll(java.lang.String[], java.lang.String)}.
	 */
	@Test
	public void testStripAllStringArrayString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#stripAccents(java.lang.String)}.
	 */
	@Test
	public void testStripAccents() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#equals(java.lang.CharSequence, java.lang.CharSequence)}.
	 */
	@Test
	public void testEqualsCharSequenceCharSequence() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#equalsIgnoreCase(java.lang.CharSequence, java.lang.CharSequence)}.
	 */
	@Test
	public void testEqualsIgnoreCase() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#indexOf(java.lang.CharSequence, int)}.
	 */
	@Test
	public void testIndexOfCharSequenceInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#indexOf(java.lang.CharSequence, int, int)}.
	 */
	@Test
	public void testIndexOfCharSequenceIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#indexOf(java.lang.CharSequence, java.lang.CharSequence)}.
	 */
	@Test
	public void testIndexOfCharSequenceCharSequence() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#indexOf(java.lang.CharSequence, java.lang.CharSequence, int)}.
	 */
	@Test
	public void testIndexOfCharSequenceCharSequenceInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#ordinalIndexOf(java.lang.CharSequence, java.lang.CharSequence, int)}.
	 */
	@Test
	public void testOrdinalIndexOf() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#indexOfIgnoreCase(java.lang.CharSequence, java.lang.CharSequence)}.
	 */
	@Test
	public void testIndexOfIgnoreCaseCharSequenceCharSequence() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#indexOfIgnoreCase(java.lang.CharSequence, java.lang.CharSequence, int)}.
	 */
	@Test
	public void testIndexOfIgnoreCaseCharSequenceCharSequenceInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#lastIndexOf(java.lang.CharSequence, int)}.
	 */
	@Test
	public void testLastIndexOfCharSequenceInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#lastIndexOf(java.lang.CharSequence, int, int)}.
	 */
	@Test
	public void testLastIndexOfCharSequenceIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#lastIndexOf(java.lang.CharSequence, java.lang.CharSequence)}.
	 */
	@Test
	public void testLastIndexOfCharSequenceCharSequence() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#lastOrdinalIndexOf(java.lang.CharSequence, java.lang.CharSequence, int)}.
	 */
	@Test
	public void testLastOrdinalIndexOf() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#lastIndexOf(java.lang.CharSequence, java.lang.CharSequence, int)}.
	 */
	@Test
	public void testLastIndexOfCharSequenceCharSequenceInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#lastIndexOfIgnoreCase(java.lang.CharSequence, java.lang.CharSequence)}.
	 */
	@Test
	public void testLastIndexOfIgnoreCaseCharSequenceCharSequence() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#lastIndexOfIgnoreCase(java.lang.CharSequence, java.lang.CharSequence, int)}.
	 */
	@Test
	public void testLastIndexOfIgnoreCaseCharSequenceCharSequenceInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#contains(java.lang.CharSequence, int)}.
	 */
	@Test
	public void testContainsCharSequenceInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#contains(java.lang.CharSequence, java.lang.CharSequence)}.
	 */
	@Test
	public void testContainsCharSequenceCharSequence() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#containsIgnoreCase(java.lang.CharSequence, java.lang.CharSequence)}.
	 */
	@Test
	public void testContainsIgnoreCase() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#containsWhitespace(java.lang.CharSequence)}.
	 */
	@Test
	public void testContainsWhitespace() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#indexOfAny(java.lang.CharSequence, char[])}.
	 */
	@Test
	public void testIndexOfAnyCharSequenceCharArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#indexOfAny(java.lang.CharSequence, java.lang.String)}.
	 */
	@Test
	public void testIndexOfAnyCharSequenceString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#containsAny(java.lang.CharSequence, char[])}.
	 */
	@Test
	public void testContainsAnyCharSequenceCharArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#containsAny(java.lang.CharSequence, java.lang.CharSequence)}.
	 */
	@Test
	public void testContainsAnyCharSequenceCharSequence() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#indexOfAnyBut(java.lang.CharSequence, char[])}.
	 */
	@Test
	public void testIndexOfAnyButCharSequenceCharArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#indexOfAnyBut(java.lang.CharSequence, java.lang.CharSequence)}.
	 */
	@Test
	public void testIndexOfAnyButCharSequenceCharSequence() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#containsOnly(java.lang.CharSequence, char[])}.
	 */
	@Test
	public void testContainsOnlyCharSequenceCharArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#containsOnly(java.lang.CharSequence, java.lang.String)}.
	 */
	@Test
	public void testContainsOnlyCharSequenceString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#containsNone(java.lang.CharSequence, char[])}.
	 */
	@Test
	public void testContainsNoneCharSequenceCharArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#containsNone(java.lang.CharSequence, java.lang.String)}.
	 */
	@Test
	public void testContainsNoneCharSequenceString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#indexOfAny(java.lang.CharSequence, java.lang.CharSequence[])}.
	 */
	@Test
	public void testIndexOfAnyCharSequenceCharSequenceArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#lastIndexOfAny(java.lang.CharSequence, java.lang.CharSequence[])}.
	 */
	@Test
	public void testLastIndexOfAny() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#substring(java.lang.String, int)}.
	 */
	@Test
	public void testSubstringStringInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#substring(java.lang.String, int, int)}.
	 */
	@Test
	public void testSubstringStringIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#left(java.lang.String, int)}.
	 */
	@Test
	public void testLeft() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#right(java.lang.String, int)}.
	 */
	@Test
	public void testRight() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#mid(java.lang.String, int, int)}.
	 */
	@Test
	public void testMid() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#substringBefore(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testSubstringBefore() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#substringAfter(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testSubstringAfter() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#substringBeforeLast(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testSubstringBeforeLast() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#substringAfterLast(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testSubstringAfterLast() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#substringBetween(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testSubstringBetweenStringString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#substringBetween(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testSubstringBetweenStringStringString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#substringsBetween(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testSubstringsBetween() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#split(java.lang.String)}.
	 */
	@Test
	public void testSplitString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#split(java.lang.String, char)}.
	 */
	@Test
	public void testSplitStringChar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#split(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testSplitStringString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#split(java.lang.String, java.lang.String, int)}.
	 */
	@Test
	public void testSplitStringStringInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#splitByWholeSeparator(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testSplitByWholeSeparatorStringString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#splitByWholeSeparator(java.lang.String, java.lang.String, int)}.
	 */
	@Test
	public void testSplitByWholeSeparatorStringStringInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#splitByWholeSeparatorPreserveAllTokens(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testSplitByWholeSeparatorPreserveAllTokensStringString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#splitByWholeSeparatorPreserveAllTokens(java.lang.String, java.lang.String, int)}.
	 */
	@Test
	public void testSplitByWholeSeparatorPreserveAllTokensStringStringInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#splitPreserveAllTokens(java.lang.String)}.
	 */
	@Test
	public void testSplitPreserveAllTokensString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#splitPreserveAllTokens(java.lang.String, char)}.
	 */
	@Test
	public void testSplitPreserveAllTokensStringChar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#splitPreserveAllTokens(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testSplitPreserveAllTokensStringString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#splitPreserveAllTokens(java.lang.String, java.lang.String, int)}.
	 */
	@Test
	public void testSplitPreserveAllTokensStringStringInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#splitByCharacterType(java.lang.String)}.
	 */
	@Test
	public void testSplitByCharacterType() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#splitByCharacterTypeCamelCase(java.lang.String)}.
	 */
	@Test
	public void testSplitByCharacterTypeCamelCase() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#join(T[])}.
	 */
	@Test
	public void testJoinTArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#join(java.lang.Object[], char)}.
	 */
	@Test
	public void testJoinObjectArrayChar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#join(long[], char)}.
	 */
	@Test
	public void testJoinLongArrayChar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#join(int[], char)}.
	 */
	@Test
	public void testJoinIntArrayChar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#join(short[], char)}.
	 */
	@Test
	public void testJoinShortArrayChar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#join(byte[], char)}.
	 */
	@Test
	public void testJoinByteArrayChar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#join(char[], char)}.
	 */
	@Test
	public void testJoinCharArrayChar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#join(float[], char)}.
	 */
	@Test
	public void testJoinFloatArrayChar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#join(double[], char)}.
	 */
	@Test
	public void testJoinDoubleArrayChar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#join(java.lang.Object[], char, int, int)}.
	 */
	@Test
	public void testJoinObjectArrayCharIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#join(long[], char, int, int)}.
	 */
	@Test
	public void testJoinLongArrayCharIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#join(int[], char, int, int)}.
	 */
	@Test
	public void testJoinIntArrayCharIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#join(byte[], char, int, int)}.
	 */
	@Test
	public void testJoinByteArrayCharIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#join(short[], char, int, int)}.
	 */
	@Test
	public void testJoinShortArrayCharIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#join(char[], char, int, int)}.
	 */
	@Test
	public void testJoinCharArrayCharIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#join(double[], char, int, int)}.
	 */
	@Test
	public void testJoinDoubleArrayCharIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#join(float[], char, int, int)}.
	 */
	@Test
	public void testJoinFloatArrayCharIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#join(java.lang.Object[], java.lang.String)}.
	 */
	@Test
	public void testJoinObjectArrayString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#join(java.lang.Object[], java.lang.String, int, int)}.
	 */
	@Test
	public void testJoinObjectArrayStringIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#join(java.util.Iterator, char)}.
	 */
	@Test
	public void testJoinIteratorOfQChar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#join(java.util.Iterator, java.lang.String)}.
	 */
	@Test
	public void testJoinIteratorOfQString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#join(java.lang.Iterable, char)}.
	 */
	@Test
	public void testJoinIterableOfQChar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#join(java.lang.Iterable, java.lang.String)}.
	 */
	@Test
	public void testJoinIterableOfQString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#deleteWhitespace(java.lang.String)}.
	 */
	@Test
	public void testDeleteWhitespace() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#removeStart(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testRemoveStart() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#removeStartIgnoreCase(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testRemoveStartIgnoreCase() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#removeEnd(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testRemoveEnd() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#removeEndIgnoreCase(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testRemoveEndIgnoreCase() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#remove(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testRemoveStringString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#remove(java.lang.String, char)}.
	 */
	@Test
	public void testRemoveStringChar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#replaceOnce(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testReplaceOnce() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#replacePattern(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testReplacePattern() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#removePattern(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testRemovePattern() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#replace(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testReplaceStringStringString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#replace(java.lang.String, java.lang.String, java.lang.String, int)}.
	 */
	@Test
	public void testReplaceStringStringStringInt() {
		fail("Not yet implemented");
	}
	
	private final String testReplaceString = "abcd!efgh@ijk$LMNG&OP^q,rst?456";
	private final String REPLACE_DELIMITER = "!@#$%^&*()_-+=|:; <>./?";
	
	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#replaceEach(java.lang.String, java.lang.String[], java.lang.String[])}.
	 */
	@Test
	public void testReplaceEach() {
		String [] searchList = REPLACE_DELIMITER.split("");
		System.out.println(searchList);
		String test = StringUtils.replaceEach(testReplaceString, searchList, new String[]{","});
		System.out.println(test);
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#replaceEachRepeatedly(java.lang.String, java.lang.String[], java.lang.String[])}.
	 */
	@Test
	public void testReplaceEachRepeatedly() {
		String [] searchList = REPLACE_DELIMITER.split("");
		System.out.println(searchList);
		String test = StringUtils.replaceEachRepeatedly(testReplaceString, searchList, new String[]{","});
		System.out.println(test);
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#replaceChars(java.lang.String, char, char)}.
	 */
	@Test
	public void testReplaceCharsStringCharChar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#replaceChars(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testReplaceCharsStringStringString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#overlay(java.lang.String, java.lang.String, int, int)}.
	 */
	@Test
	public void testOverlay() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#chomp(java.lang.String)}.
	 */
	@Test
	public void testChompString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#chop(java.lang.String)}.
	 */
	@Test
	public void testChop() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#repeat(java.lang.String, int)}.
	 */
	@Test
	public void testRepeatStringInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#repeat(java.lang.String, java.lang.String, int)}.
	 */
	@Test
	public void testRepeatStringStringInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#repeat(char, int)}.
	 */
	@Test
	public void testRepeatCharInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#rightPad(java.lang.String, int)}.
	 */
	@Test
	public void testRightPadStringInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#rightPad(java.lang.String, int, char)}.
	 */
	@Test
	public void testRightPadStringIntChar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#rightPad(java.lang.String, int, java.lang.String)}.
	 */
	@Test
	public void testRightPadStringIntString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#leftPad(java.lang.String, int)}.
	 */
	@Test
	public void testLeftPadStringInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#leftPad(java.lang.String, int, char)}.
	 */
	@Test
	public void testLeftPadStringIntChar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#leftPad(java.lang.String, int, java.lang.String)}.
	 */
	@Test
	public void testLeftPadStringIntString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#length(java.lang.CharSequence)}.
	 */
	@Test
	public void testLength() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#center(java.lang.String, int)}.
	 */
	@Test
	public void testCenterStringInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#center(java.lang.String, int, char)}.
	 */
	@Test
	public void testCenterStringIntChar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#center(java.lang.String, int, java.lang.String)}.
	 */
	@Test
	public void testCenterStringIntString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#upperCase(java.lang.String)}.
	 */
	@Test
	public void testUpperCaseString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#upperCase(java.lang.String, java.util.Locale)}.
	 */
	@Test
	public void testUpperCaseStringLocale() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#lowerCase(java.lang.String)}.
	 */
	@Test
	public void testLowerCaseString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#lowerCase(java.lang.String, java.util.Locale)}.
	 */
	@Test
	public void testLowerCaseStringLocale() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#capitalize(java.lang.String)}.
	 */
	@Test
	public void testCapitalize() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#uncapitalize(java.lang.String)}.
	 */
	@Test
	public void testUncapitalize() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#swapCase(java.lang.String)}.
	 */
	@Test
	public void testSwapCase() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#countMatches(java.lang.CharSequence, java.lang.CharSequence)}.
	 */
	@Test
	public void testCountMatches() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#isAlpha(java.lang.CharSequence)}.
	 */
	@Test
	public void testIsAlpha() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#isAlphaSpace(java.lang.CharSequence)}.
	 */
	@Test
	public void testIsAlphaSpace() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#isAlphanumeric(java.lang.CharSequence)}.
	 */
	@Test
	public void testIsAlphanumeric() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#isAlphanumericSpace(java.lang.CharSequence)}.
	 */
	@Test
	public void testIsAlphanumericSpace() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#isAsciiPrintable(java.lang.CharSequence)}.
	 */
	@Test
	public void testIsAsciiPrintable() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#isNumeric(java.lang.CharSequence)}.
	 */
	@Test
	public void testIsNumeric() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#isNumericSpace(java.lang.CharSequence)}.
	 */
	@Test
	public void testIsNumericSpace() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#isWhitespace(java.lang.CharSequence)}.
	 */
	@Test
	public void testIsWhitespace() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#isAllLowerCase(java.lang.CharSequence)}.
	 */
	@Test
	public void testIsAllLowerCase() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#isAllUpperCase(java.lang.CharSequence)}.
	 */
	@Test
	public void testIsAllUpperCase() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#defaultString(java.lang.String)}.
	 */
	@Test
	public void testDefaultStringString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#defaultString(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDefaultStringStringString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#defaultIfBlank(T, T)}.
	 */
	@Test
	public void testDefaultIfBlank() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#defaultIfEmpty(T, T)}.
	 */
	@Test
	public void testDefaultIfEmpty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#reverse(java.lang.String)}.
	 */
	@Test
	public void testReverse() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#reverseDelimited(java.lang.String, char)}.
	 */
	@Test
	public void testReverseDelimited() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#abbreviate(java.lang.String, int)}.
	 */
	@Test
	public void testAbbreviateStringInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#abbreviate(java.lang.String, int, int)}.
	 */
	@Test
	public void testAbbreviateStringIntInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#abbreviateMiddle(java.lang.String, java.lang.String, int)}.
	 */
	@Test
	public void testAbbreviateMiddle() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#difference(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testDifference() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#indexOfDifference(java.lang.CharSequence, java.lang.CharSequence)}.
	 */
	@Test
	public void testIndexOfDifferenceCharSequenceCharSequence() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#indexOfDifference(java.lang.CharSequence[])}.
	 */
	@Test
	public void testIndexOfDifferenceCharSequenceArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#getCommonPrefix(java.lang.String[])}.
	 */
	@Test
	public void testGetCommonPrefix() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#getLevenshteinDistance(java.lang.CharSequence, java.lang.CharSequence)}.
	 */
	@Test
	public void testGetLevenshteinDistanceCharSequenceCharSequence() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#getLevenshteinDistance(java.lang.CharSequence, java.lang.CharSequence, int)}.
	 */
	@Test
	public void testGetLevenshteinDistanceCharSequenceCharSequenceInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#getJaroWinklerDistance(java.lang.CharSequence, java.lang.CharSequence)}.
	 */
	@Test
	public void testGetJaroWinklerDistance() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#startsWith(java.lang.CharSequence, java.lang.CharSequence)}.
	 */
	@Test
	public void testStartsWith() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#startsWithIgnoreCase(java.lang.CharSequence, java.lang.CharSequence)}.
	 */
	@Test
	public void testStartsWithIgnoreCase() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#startsWithAny(java.lang.CharSequence, java.lang.CharSequence[])}.
	 */
	@Test
	public void testStartsWithAny() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#endsWith(java.lang.CharSequence, java.lang.CharSequence)}.
	 */
	@Test
	public void testEndsWith() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#endsWithIgnoreCase(java.lang.CharSequence, java.lang.CharSequence)}.
	 */
	@Test
	public void testEndsWithIgnoreCase() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#normalizeSpace(java.lang.String)}.
	 */
	@Test
	public void testNormalizeSpace() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#endsWithAny(java.lang.CharSequence, java.lang.CharSequence[])}.
	 */
	@Test
	public void testEndsWithAny() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#appendIfMissing(java.lang.String, java.lang.CharSequence, java.lang.CharSequence[])}.
	 */
	@Test
	public void testAppendIfMissing() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#appendIfMissingIgnoreCase(java.lang.String, java.lang.CharSequence, java.lang.CharSequence[])}.
	 */
	@Test
	public void testAppendIfMissingIgnoreCase() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#prependIfMissing(java.lang.String, java.lang.CharSequence, java.lang.CharSequence[])}.
	 */
	@Test
	public void testPrependIfMissing() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#prependIfMissingIgnoreCase(java.lang.String, java.lang.CharSequence, java.lang.CharSequence[])}.
	 */
	@Test
	public void testPrependIfMissingIgnoreCase() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.StringUtils#toEncodedString(byte[], java.nio.charset.Charset)}.
	 */
	@Test
	public void testToEncodedString() {
	}
	
	@Test
	public void testList() {
		System.out.println(hasExistsFilterChannel("", 1));
		System.out.println(hasExistsFilterChannel("0", 1));
		System.out.println(hasExistsFilterChannel("0,1", 1));
	}

	private boolean hasExistsFilterChannel(String filterChannels, long cid) {
        if (StringUtils.isBlank(filterChannels)) {
            return false;
        }
        String [] channels = filterChannels.split(",");
        for (String channel : channels) {
            if (StringUtils.equals(channel, String.valueOf(cid))) {
                return true;
            }
        }
        return false;
    }
	
	@Test
	public void testUrl() throws Exception {
		String referer = "http%3A%2F%2Fwww.baidu.com%2Flink%3Furl%3DCRktSIu24hENiJNst32z5ampacG7mGFnZ7JEGWCY5fdSYkqNX1vaIbJPYooothKH_a3ziLpeb2fLDvuhHfQemq%26wd%3D%26eqid%3D963fb80800007e4a000000025606ced1";
		String enReferer = URLDecoder.decode(referer, "gbk");
		System.out.println(enReferer);
		System.out.println("汗".length());
	}
	
}
