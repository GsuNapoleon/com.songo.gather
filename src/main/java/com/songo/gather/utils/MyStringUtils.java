/**
 * 
 */
package com.songo.gather.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>decription:</p>
 * <p>date:2014年6月18日 上午10:03:37</p>
 * @author gsu·napoleon
 */
public class MyStringUtils {

	public static List<String> splitSimpleString(final String row, final char separatorChar) {
		if (row == null) {
			return null;
		}
		
		int length = row.length();
		if (length == 0) {
			return Collections.emptyList();
		}
		
		final List<String> result = new ArrayList<String>();
		int endIndex = 0;
		int startIndex = 0;
		boolean match = false;
		boolean lastMatch = false;
		while (endIndex < length) {
			if (row.charAt(endIndex) == separatorChar) {
				System.out.println("startIndex = {" + startIndex + "}, endIndex = {" + endIndex + "}");
				if (match) {
					result.add(row.substring(startIndex, endIndex));
					lastMatch = true;
					match = false;
				}
				startIndex = ++ endIndex;
				continue;
			}
			lastMatch = false;
			match = true;
			endIndex ++;
		}
		
		if (match && lastMatch) {
			result.add(row.substring(startIndex, endIndex));
		}
		
		return result;
	}
	
}
