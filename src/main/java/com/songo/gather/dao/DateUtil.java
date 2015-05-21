/**
 * 
 */
package com.songo.gather.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * decription:
 * </p>
 * <p>
 * date:2015年3月27日 下午12:23:36
 * </p>
 * 
 * @author gsu·napoleon
 */
public class DateUtil {

	private static String[] hours = { "00:00 - 00:59", "01:00 - 01:59",
			"02:00 - 02:59", "03:00 - 03:59", "04:00 - 04:59", "05:00 - 05:59",
			"06:00 - 06:59", "07:00 - 07:59", "08:00 - 08:59", "09:00 - 09:59",
			"10:00 - 10:59", "11:00 - 11:59", "12:00 - 12:59", "13:00 - 13:59",
			"14:00 - 14:59", "15:00 - 15:59", "16:00 - 16:59", "17:00 - 17:59",
			"18:00 - 18:59", "19:00 - 19:59", "20:00 - 20:59", "21:00 - 21:59",
			"22:00 - 22:59", "23:00 - 23:59" };

	/**
	 * example. -> 20120409 - "2012-04-09"
	 * 
	 * @param ymd
	 * @return yyyy-MM-dd
	 */
	public static String ymd2String(int ymd) {
		StringBuilder builder = new StringBuilder();
		builder.append(ymd / 10000);
		builder.append("-");
		builder.append(formatInt((ymd / 100) % 100));
		builder.append("-");
		builder.append(formatInt(ymd % 100));
		return builder.toString();
	}

	/**
	 * example. -> "2012-04-09" - 20120409
	 * 
	 * @param str
	 * @return
	 */
	public static int string2ymd(String str) {
		String ymdStr = str.replaceAll("-", "");
		return Integer.parseInt(ymdStr);
	}

	/**
	 * 1 -> "01", 10 -> "10"
	 * 
	 * @param num
	 * @return
	 */
	public static String formatInt(int num) {
		return (num < 10 ? "0" : "") + num;
	}

	/**
	 * seconds to string , 如： 123 -> 02:03
	 * 
	 * @param second
	 * @return [hh:]mm:ss
	 */
	public static String formatSecond(int second) {
		if (second == 0) {
			return "N/A";
		}
		int h = second / 3600;
		int m;
		int s;
		int ms = second % 3600;
		m = ms / 60;
		s = ms % 60;

		StringBuilder builder = new StringBuilder();
		if (h != 0) {
			builder.append(formatInt(h)).append(":");
		}
		builder.append(formatInt(m)).append(":").append(formatInt(s));

		return builder.toString();
	}

	/**
	 * 
	 * @param ymd
	 * @param beforeNum
	 * @return ymd - beforeNum , exampe: 20120410 - 31 = 20120310
	 */
	public static int getDayBefore(int ymd, int beforeNum) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat ymdSdf = new SimpleDateFormat("yyyyMMdd");
		Date date = null;
		try {
			date = ymdSdf.parse(ymd + "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - beforeNum);

		String dayBefore = ymdSdf.format(c.getTime());
		return Integer.parseInt(dayBefore);
	}

	public static int getYesterday(int ymd) {
		return getDayBefore(ymd, 1);
	}

	public static int getYesterday() {
		return getDayBefore(getTodayYmd(), 1);
	}

	public static int getTheSameDayAtLastWeek(int ymd) {
		return getDayBefore(ymd, 7);
	}

	/**
	 * 
	 * @return example. 20120410
	 */
	public static int getTodayYmd() {
		SimpleDateFormat ymdSdf = new SimpleDateFormat("yyyyMMdd");
		int todayYmd = Integer.parseInt(ymdSdf.format(new Date()));
		return todayYmd;
	}

	/**
	 * 时间跨度 如20120102 - 20120130 ，跨度不是28天， 而是29天 contains the startYmd and
	 * endYmd [startYmd, endYmd] (+1)
	 * 
	 * @param startYmd
	 * @param endYmd
	 * @return
	 */
	public static int getDateSpan(int startYmd, int endYmd) {
		if (startYmd == endYmd) {
			return 1;
		}
		try {
			SimpleDateFormat ymdSdf = new SimpleDateFormat("yyyyMMdd");
			Date start = ymdSdf.parse(startYmd + "");
			Date end = ymdSdf.parse(endYmd + "");
			long diff = end.getTime() - start.getTime();
			return (int) (diff / (1000 * 60 * 60 * 24) + 1);
		} catch (ParseException ex) {
		}
		return 0;
	}

	/**
	 * 取当前时间，比如现在是14:18, 则返回14
	 * 
	 * @return
	 */
	public static int getCurHour() {
		return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
	}

	public static int getCurMinutes() {
		return Calendar.getInstance().get(Calendar.MINUTE);
	}

	/**
	 * 取某个月份的天数,如2013.02返回28，2013.03返回31
	 * 
	 * @param ym
	 * @return
	 */
	public static int getDays(int ym) {
		int year = ym / 100;
		int mm = ym % 100;
		if (mm == 13) {
			mm = 1;
		}
		int maxDay = 30;
		switch (mm) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			maxDay = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			maxDay = 30;
			break;
		case 2:
			if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
				maxDay = 29;
			} else {
				maxDay = 28;
			}
			break;
		}
		return maxDay;
	}

	/**
	 * 返回数组 ，24小时 00 , 01, .. 12 .. 23.
	 * 
	 * @return
	 */
	public static String[] getHours() {
		String[] hoursArray = new String[24];
		for (int i = 0; i < 24; i++) {
			hoursArray[i] = formatInt(i);
		}
		return hoursArray;
	}

	/**
	 * 根据起始日期和结束日期输出日期列表
	 * 
	 * @param startYmd
	 * @param endYmd
	 * @return
	 */
	public static List<String> getDateList(int startYmd, int endYmd) {
		int startYm = startYmd / 100;
		int endYm = endYmd / 100;
		int startDay = startYmd % 100;
		int endDay = endYmd % 100;
		List<String> dateList = new ArrayList<String>();

		for (int ym = startYm; ym <= endYm; ym++) {
			int year = ym / 100;
			int month = ym % 100;
			int maxDay = getDays(ym);

			if (month > 12) {
				month = 1;
				year++;
				ym = year * 100 + month;
				if (ym > endYm) {
					break;
				}
			}

			int from = 1;
			int to = maxDay;
			if (ym == startYm) {
				from = startDay;
			}
			if (ym == endYm) {
				to = endDay;
			}
			for (int day = from; day <= to; day++) {
				dateList.add(year + "-" + formatInt(month) + "-"
						+ formatInt(day));
			}
		}

		return dateList;
	}

	public static int[] getYmdArray(int startYmd, int endYmd) {
		int startYm = startYmd / 100;
		int endYm = endYmd / 100;
		int startDay = startYmd % 100;
		int endDay = endYmd % 100;

		int[] dates = new int[getDateSpan(startYmd, endYmd)];
		int index = 0;

		for (int ym = startYm; ym <= endYm; ym++) {
			int year = ym / 100;
			int month = ym % 100;
			int maxDay = getDays(ym);

			if (month > 12) {
				month = 1;
				year++;
				ym = year * 100 + month;
				if (ym > endYm) {
					break;
				}
			}

			int from = 1;
			int to = maxDay;
			if (ym == startYm) {
				from = startDay;
			}
			if (ym == endYm) {
				to = endDay;
			}
			for (int day = from; day <= to; day++) {
				dates[index++] = year * 10000 + month * 100 + day;
			}
		}

		return dates;
	}

	/**
	 * 取从startYm开始到当前月份结束的月份列表
	 * 
	 * @param startYm
	 * @return
	 */
	public static List<Integer> getMonthList(int startYm) {
		return getMonthList(startYm, getTodayYmd() / 100);
	}

	public static List<Integer> getMonthList(int startYm, int endYm) {
		if (startYm < 201201) {
			startYm = 201201;
		}
		if (endYm > 209912) {
			throw new RuntimeException("ym must not bigger than 2099");
		}
		List<Integer> ymList = new ArrayList<Integer>();
		for (int ym = startYm; ym <= endYm; ym = getNextYm(ym)) {
			ymList.add(ym);
		}
		return ymList;
	}

	public static List<String> getMonthList4Ch(int startYm, int endYm) {
		if (startYm < 201201) {
			startYm = 201201;
		}
		List<String> ymList = new ArrayList<String>();
		for (int ym = startYm; ym <= endYm; ym = getNextYm(ym)) {
			ymList.add(ym / 100 + "年" + formatInt(ym % 100) + "月");
		}
		return ymList;
	}

	/**
	 * 取指定ym的下一月，如201201 -> 201202, 201212 -> 201301
	 * 
	 * @param ym
	 * @return
	 */
	public static int getNextYm(int ym) {
		int y = ym / 100;
		int m = ym % 100;
		if (m + 1 < 13) {
			return y * 100 + (m + 1);
		} else {
			return (y + 1) * 100 + 1;
		}
	}

	public static String[] get24Hours(int ymd, int curHour) {
		if (ymd != getTodayYmd()) {
			return hours;
		} else {
			String[] result = new String[curHour + 1];
			System.arraycopy(hours, 0, result, 0, curHour + 1);
			return result;
		}
	}

	public static String[] get24Hours(int ymd) {
		return get24Hours(ymd, getCurHour());
	}

	public static int date2ymd(Date date) {
		SimpleDateFormat ymdSdf = new SimpleDateFormat("yyyyMMdd");
		int todayYmd = Integer.parseInt(ymdSdf.format(date));
		return todayYmd;
	}

	public static List<Integer> getWeekList(int startyear, int startweek,
			int endyear, int endweek) {
		List<Integer> weekList = new ArrayList<Integer>();
		if (startyear == endyear) {
			for (int i = startweek; i <= endweek; i++) {
				weekList.add(startyear * 100 + i);
			}
		} else {
			for (int i = startyear; i <= endyear; i++) {
				int weektotal = getWeeksOfYear(i);
				int endj = i == endyear ? endweek : weektotal;
				int startj = i == startyear ? startweek : 1;
				for (int j = startj; j <= endj; j++) {
					weekList.add(i * 100 + j);
				}
			}
		}
		return weekList;
	}

	public static int getWeeksOfYear(int year) {
		int week = 0;
		int days = 365;
		int day = 0; // 判断是否闰年，闰年366天
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
			days = 366;
		}
		// 得到一年所有天数然后除以7
		day = days % 7 > 0 ? week += 1 : week;
		// 得到余下几天如果有余则周+1，否则不加
		week += days / 7;
		// 得到多少周
		return week;
	}

	/**
	 * days=1，获取的是该月的第一天;days>1，获取该月的最后一天。其它功能，一律不提供。
	 * 
	 * @param ymd
	 *            20141229
	 * @param days
	 * @return
	 */
	public static int getMonthDayOfFirstOrLast(int ymd, int days) {
		return getMonthDayOfFirstOrLast(ymd, days, null);
	}
	
	public static int getMonthDayOfFirstOrLast(int ymd, int days, String pattern) {
		try {
			Calendar c = Calendar.getInstance();
			SimpleDateFormat ymdSdf = new SimpleDateFormat(
					StringUtils.isNotBlank(pattern) ? pattern : "yyyyMMdd");
			Date dateYmd = ymdSdf.parse(ymd + "");
			c.setTime(dateYmd);
			c.add(Calendar.DAY_OF_MONTH, 0);
			if (days > 1) {
				c.set(Calendar.DAY_OF_MONTH,
						c.getActualMaximum(Calendar.DAY_OF_MONTH));
			} else {
				c.set(Calendar.DAY_OF_MONTH, days);
			}
			return date2ymd(c.getTime());
		} catch (ParseException ex) {
			return 0;
		}
	}

	public static void main(String[] args) {
		System.err.println("----------------------- "
				+ getMonthDayOfFirstOrLast(20150104, 1));
		System.err.println("----------------------- "
				+ getMonthDayOfFirstOrLast(20140929, 2));
		BigDecimal bd1 = new BigDecimal("2523461");
		BigDecimal bd2 = new BigDecimal("31329");
		System.err.println(bd1.divide(bd2, 2, BigDecimal.ROUND_HALF_UP));
	}

	/**
	 * <p>decription:</p>
	 * <p>date:2015年3月27日 下午4:01:03</p>
	 * @author gsu·napoleon
	 */
	private static Map<String, Integer> getWeekFirstAndLastDay(int weekOfYear) {
		Map<String, Integer> weekDay = new HashMap<String, Integer>();
		Calendar calendar = Calendar.getInstance(); 
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.set(Calendar.WEEK_OF_YEAR, weekOfYear);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		weekDay.put("first_day", format(calendar.getTime()));
		
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		weekDay.put("last_day", format(calendar.getTime()));
		
		System.err.println("First day is " + weekDay.get("first_day") 
				+ "; Last day is " + weekDay.get("last_day"));
		return weekDay;	
	}
	
	private static Integer format(Date date) {
		return format(date, null);
	}
	
	public static Integer format(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(StringUtils.isNotBlank(pattern) ? pattern : "yyyyMMdd");
		String dateString = sdf.format(date);
		return Integer.valueOf(dateString);
	}
}
