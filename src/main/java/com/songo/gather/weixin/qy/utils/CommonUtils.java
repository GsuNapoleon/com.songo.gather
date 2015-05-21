/**
 * 
 */
package com.songo.gather.weixin.qy.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * <p>decription:</p>
 * <p>date:2015年5月11日 下午2:30:18</p>
 * @author gsu·napoleon
 */
public final class CommonUtils {

	public static boolean hasExpired(long beforeTimes) {
		
		long since = setDate("1970-01-01 00:00:00").getTimeInMillis();
		
		if (beforeTimes <= since) {
			return false;
		}
		
		long expired = Long.valueOf(DevApp.APP_ACCESS_TOKEN_EXPIRED.getValue());
		long times = (System.currentTimeMillis() - beforeTimes) / 1000;
		
		System.err.println("times : " + times);
		
		return times >= expired;
	}
	
	public static void main(String[] args) {
		Calendar c = setDate("2015-05-11 14:00:00");
//		boolean isExpired = hasExpired(c.getTimeInMillis());
//		System.err.println(isExpired);
		System.err.println(c.getTimeInMillis());
		Calendar c1 = setDate("2015-05-11 15:00:00");
		System.err.println(c1.getTimeInMillis());
		Calendar c2 = setDate("2015-05-11 16:00:00");
		System.err.println(c2.getTimeInMillis());
		Calendar c3 = setDate("2015-05-11 17:00:00");
		System.err.println(c3.getTimeInMillis());
	}

	/**
	 * <p>decription:</p>
	 * <p>date:2015年5月11日 下午2:43:23</p>
	 * @author gsu·napoleon
	 * @return
	 */
	private static Calendar setDate(String date) {
		Calendar c = Calendar.getInstance();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			c.setTime(sdf.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return c;
	}
	
}
