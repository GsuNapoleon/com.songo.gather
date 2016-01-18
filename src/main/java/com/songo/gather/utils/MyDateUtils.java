/**
 * 
 */
package com.songo.gather.utils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * <p>decription:</p>
 * <p>date:2015年6月2日 上午10:02:18</p>
 * @author gsu·napoleon
 */
public final class MyDateUtils {

	private static final String[] hours = {
        "00:00 - 00:59", "01:00 - 01:59", "02:00 - 02:59", "03:00 - 03:59",
        "04:00 - 04:59", "05:00 - 05:59", "06:00 - 06:59", "07:00 - 07:59",
        "08:00 - 08:59", "09:00 - 09:59", "10:00 - 10:59", "11:00 - 11:59",
        "12:00 - 12:59", "13:00 - 13:59", "14:00 - 14:59", "15:00 - 15:59",
        "16:00 - 16:59", "17:00 - 17:59", "18:00 - 18:59", "19:00 - 19:59",
        "20:00 - 20:59", "21:00 - 21:59", "22:00 - 22:59", "23:00 - 23:59"};
	
	public static int parseInteger(Date date) {
		if (date == null) {
			date = new Date();
		}
		return Integer.valueOf(MyDateFormatter.YYYYMMDD.formatter(date));
	}
	
	public static long parseLong(Date date) {
		if (date == null) {
			date = new Date();
		}
		return Long.valueOf(MyDateFormatter.YYYYMMDDHHMMSS.formatter(date));
	}
	
	public static int getMonthDays(Date date) {
		
		if (date == null) {
			date = new Date();
		}
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	public static int getMonthDays(String date) throws ParseException {
		Date localDate = StringUtils.isNotEmpty(date) ? MyDateFormatter.YYYY_MM_DD.parser(date) : new Date();
		return getMonthDays(localDate);
	}
	
	public static int getNextYm(int ym) {
        int y = ym / 100;
        int m = ym % 100;
        if (m + 1 < 13) {
            return y * 100 + (m + 1);
        } else {
            return (y + 1) * 100 + 1;
        }
    }

	/**
	 * 
	 * <p>decription:计算ym对应的前f个月的具体月份,包含本月.</p>
	 * <p>f <= 1,都将返回本月.f >= 2,才有实际价值.</p>
	 * <p>date:2015年6月3日 上午10:20:20</p>
	 * @author gsu·napoleon
	 * @param ym	指定日期
	 * @param f		前N个月	
	 * @return		返回前N个月的具体月份
	 */
    public static int getPrevYm(int ym, int f) {
        if (f <= 1) {
            return ym;
        }

        int y = ym / 100;
        int m = ym % 100;
        int i = f / 12;
        int mo = (m - (f - 12 * i) + 1);
        int k = mo > 0 ? i : i + 1;
        return (y - k) * 100 + (mo > 0 ? mo : (12 + mo));
    }
    
    public static Date getFirstDayOfMonth(Date date, int amount) {
    	Calendar calendar = Calendar.getInstance();
    	if (date != null) {
    		calendar.setTime(date);
    	}
    	calendar.add(Calendar.MONTH, amount);
    	calendar.set(Calendar.DAY_OF_MONTH, 1);
    	return calendar.getTime();
    }
    
    public static Date getLastDayOfMonth(Date date, int amount) {
    	Calendar calendar = Calendar.getInstance();
    	if (date != null) {
    		calendar.setTime(date);
    	}
    	calendar.add(Calendar.MONTH, amount);
    	calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
    	return calendar.getTime();
    }
    
    public static Date getToday(Date date) {
    	
    	if (date == null) {
    		date = new Date();
    	}
    	
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(new Date());
    	if (cal.get(Calendar.HOUR_OF_DAY) == 0) {
    		cal.add(Calendar.HOUR_OF_DAY, -1);
    	}
    	return cal.getTime();
    }
    
    /**
     * 
     * <p>decription:</p>
     * <p>date:2015年9月28日 上午9:28:27</p>
     * @author gsu·napoleon
     * @param date		默认为今天
     * @param amount	正数：表示当前周往后数的第amount周；负数：表示当前周往前数的第amount周；0：表示本周当日
     * @return
     */
    public static Date getTheSameDateOfWeeks(Date date, int amount) {
    	Date localDate = getToday(date);
    	Calendar c = Calendar.getInstance();
    	c.setTime(localDate);
    	c.add(Calendar.DATE, amount * 7);
    	return c.getTime();
    }
    
//    private void initTask() {
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(t1.getDate());
//		if (t1.getHour() == 0) {
//			cal.add(Calendar.HOUR_OF_DAY, -1);
//		}
//		today = date2ymd(new Date(cal.getTimeInMillis()));
//		//7天前
//		cal.add(Calendar.DATE, -7);
//		preDate1 = date2ymd(new Date(cal.getTimeInMillis()));
//		//14天前
//		cal.add(Calendar.DATE, -7);
//		preDate2 = date2ymd(new Date(cal.getTimeInMillis()));
//		//21天前
//		cal.add(Calendar.DATE, -7);
//		preDate3 = date2ymd(new Date(cal.getTimeInMillis()));
//	}
    
}
