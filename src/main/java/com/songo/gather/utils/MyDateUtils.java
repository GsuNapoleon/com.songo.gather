/**
 * 
 */
package com.songo.gather.utils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;

/**
 * <p>decription:</p>
 * <p>date:2015年6月2日 上午10:02:18</p>
 * @author gsu·napoleon
 */
public final class MyDateUtils {

	private static final String DEFAULT_FORMAT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
	private static final String[] hours = {
        "00:00 - 00:59", "01:00 - 01:59", "02:00 - 02:59", "03:00 - 03:59",
        "04:00 - 04:59", "05:00 - 05:59", "06:00 - 06:59", "07:00 - 07:59",
        "08:00 - 08:59", "09:00 - 09:59", "10:00 - 10:59", "11:00 - 11:59",
        "12:00 - 12:59", "13:00 - 13:59", "14:00 - 14:59", "15:00 - 15:59",
        "16:00 - 16:59", "17:00 - 17:59", "18:00 - 18:59", "19:00 - 19:59",
        "20:00 - 20:59", "21:00 - 21:59", "22:00 - 22:59", "23:00 - 23:59"};
	
	public static Date stringFormatDate(String date, String pattern) throws ParseException {
		
		if (StringUtils.isEmpty(pattern)) {
			throw new UnsupportedOperationException("Not found format date pattern!");
		}
		if (StringUtils.isEmpty(date)) {
			throw new UnsupportedOperationException("Not found date string value!");
		}
		
		FastDateFormat fdf = FastDateFormat.getInstance(pattern);
		
		return fdf.parse(date);
	}
	
	public static Date stringFormatDate(String date) throws ParseException {
		return stringFormatDate(date, DEFAULT_FORMAT_DATE_PATTERN);
	}
	
	public static String dateFormatString(Date date, String pattern) {
		if (StringUtils.isEmpty(pattern)) {
			throw new UnsupportedOperationException("Not found format date pattern!");
		}
		if (date == null) {
			date = new Date();
		}
		
		FastDateFormat fdf = FastDateFormat.getInstance(pattern);
		
		return fdf.format(date);
	}
	
	public static String dateFormatString(Date date) {
		return dateFormatString(date, DEFAULT_FORMAT_DATE_PATTERN);
	}
	
	public static int dateFormatInteger(Date date) {
		if (date == null) {
			date = new Date();
		}
		return Integer.valueOf(dateFormatString(date, "yyyyMMdd"));
	}
	
	public static long dateFormatLong(Date date) {
		if (date == null) {
			date = new Date();
		}
		return Long.valueOf(dateFormatString(date, "yyyyMMddHHmmss"));
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
		
		Date localDate = StringUtils.isNotEmpty(date) ? stringFormatDate(date) : new Date();
		
		Calendar c = Calendar.getInstance();
		c.setTime(localDate);
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
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
    
}
