/**
 * 
 */
package com.songo.gather.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * <p>decription:</p>
 * <p>date:2014年6月18日 上午10:03:37</p>
 * @author gsu·napoleon
 */
public class MyStringUtils {
	
	private static final String REPLACE_DELIMITER = "!@#$%^&*)(_-+=|,:; <>./?";

	public static List<String> splitSimpleString(final String row, final CharSequence separatorChar) {
		return splitSimpleString(row, separatorChar, false);
	}
	
	public static List<String> splitSimpleString(final String row, 
			final CharSequence separator, boolean isUnifiedDelimiter) {
		System.out.println(row.length());
		if (row == null || row.length() == 0 || separator == null) {
			return null;
		}
		
		String localRow = isUnifiedDelimiter 
				? replaceUnifiedDelimiter(row, separator)
				: row;
		System.out.println(localRow.length());
		char separatorChar = separator.charAt(0);
		
		final List<String> result = new ArrayList<String>();
		int length = localRow.length();
		int endIndex = 0;
		int startIndex = 0;
		boolean match = false;
		while (endIndex < length) {
			if (localRow.charAt(endIndex) == separatorChar) {
				if (match) {
					result.add(localRow.substring(startIndex, endIndex));
					match = false;
				}
				startIndex = ++ endIndex;
				continue;
			}
			match = true;
			endIndex ++;
		}
		
		if (match) {
			result.add(localRow.substring(startIndex, endIndex));
		}
		
		return result;
	}
	
	public static String replaceUnifiedDelimiter(final String text, final CharSequence replacement) {
		
		if (StringUtils.isEmpty(text) || StringUtils.isEmpty(replacement)) {
			return StringUtils.EMPTY;
		}
		
		if (replacement.length() > 1) {
			throw new UnsupportedOperationException("该方法不支持多替换字符的操作,"
					+ "当前替换字符的length = " + replacement.length());
		}
		
		if (!StringUtils.contains(REPLACE_DELIMITER, replacement)) {
			throw new UnsupportedOperationException("该方法不支持该替换参数replacement=\"" 
					+ replacement + "\",Sorry!");
		}
		
		char [] textChars = text.toCharArray();
		char [] searchReplacements = REPLACE_DELIMITER.toCharArray();
		char [] newText = new char[textChars.length];
		char replacementChar = replacement.length() == 1 ? replacement.charAt(0) : 0;
		for (int i = 0; i < textChars.length; i ++) {
			newText[i] = textChars[i];
			for (int j = 0; j < searchReplacements.length; j ++) {
				if (newText[i] == searchReplacements[j]) {
					newText[i] = replacementChar;
				}
			}
		}
		
		return String.valueOf(newText);
	}
	
}
