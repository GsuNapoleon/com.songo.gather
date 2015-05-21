/**
 * 
 */
package com.songo.gather.weixin.mp.utils;

import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.StringUtils;

/**
 * <p>decription:</p>
 * <p>date:2015年4月28日 上午11:50:08</p>
 * @author gsu·napoleon
 */
public final class CommonsUtils {

	public static String getUuid(int length) {
		if (length <= 0) {
			return StringUtils.EMPTY;
		}
		String baseString = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i ++) {
			sb.append(baseString.charAt(ThreadLocalRandom.current().nextInt(7, 62)));
		}
		return sb.reverse().toString();
	}
	
}
