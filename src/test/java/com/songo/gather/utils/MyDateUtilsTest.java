/**
 * 
 */
package com.songo.gather.utils;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.FastDateFormat;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>decription:</p>
 * <p>date:2015年6月2日 上午10:17:20</p>
 * @author gsu·napoleon
 */
public class MyDateUtilsTest {

	private static final Logger logger = LoggerFactory.getLogger(MyDateUtilsTest.class);
	
	/**
	 * <p>decription:</p>
	 * <p>date:2015年6月2日 上午10:17:20</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws ParseException {
		int days = MyDateUtils.getMonthDays(new Date());
		int days1 = MyDateUtils.getMonthDays("2012-02-01 00:00:00");
		int dayOfInt = MyDateUtils.parseInteger(null);
		long dayOfLong = MyDateUtils.parseLong(null);
		System.err.println("days = " + days);
		System.err.println("days1 = " + days1);
		System.err.println("dayOfInt = " + dayOfInt);
		System.err.println("dayOfLong = " + dayOfLong);
	}
	
	@Test
	public void testGetPrevYm() {
		int ym = 201505;
		int pym0 = MyDateUtils.getPrevYm(ym, 1);
		System.err.println("prev ym : " + pym0);
		int pym = MyDateUtils.getPrevYm(ym, 12);
		System.err.println("prev ym : " + pym);
		int pym1 = MyDateUtils.getPrevYm(ym, 24);
		System.err.println("prev ym : " + pym1);
		int pym2 = MyDateUtils.getPrevYm(ym, 36);
		System.err.println("prev ym : " + pym2);
	}
	
	@Test
	public void testFormatPattern() {
		System.err.println("****************** {" + MyDateFormatter.YYYY.formatter(new Date()) + "}");
	}

	@Test
	public void testGetFirstDayOfMonth() throws ParseException {
		Date date = MyDateFormatter.YYYY_MM_DD.parser("2015-06-01");
		logger.debug("前一个月的第一天：{}, 最后一天：{}", 
				MyDateFormatter.YYYY_MM_DD.formatter(MyDateUtils.getFirstDayOfMonth(date, -1)),
				MyDateFormatter.YYYY_MM_DD.formatter(MyDateUtils.getLastDayOfMonth(date, -1)));
		logger.debug("前两个月的第一天：{}, 最后一天：{}", 
				MyDateFormatter.YYYY_MM_DD.formatter(MyDateUtils.getFirstDayOfMonth(date, -2)),
				MyDateFormatter.YYYY_MM_DD.formatter(MyDateUtils.getLastDayOfMonth(date, -2)));
	}
	
	@Test
	public void testGetTodayBeforeDays() throws Exception {
		Date date = MyDateFormatter.YYYY_MM_DD.parser("2015-09-28");
		logger.info("今天：[{}]", MyDateUtils.getToday(date));
		logger.info("上周同日：[{}]", MyDateFormatter.YYYY_MM_DD_HH_MM_SS.formatter(MyDateUtils.getTheSameDateOfWeeks(date, 0)));
		logger.info("上周同日：[{}]", MyDateFormatter.YYYY_MM_DD_HH_MM_SS.formatter(MyDateUtils.getTheSameDateOfWeeks(date, -1)));
		logger.info("上上周同日：[{}]", MyDateFormatter.YYYY_MM_DD_HH_MM_SS.formatter(MyDateUtils.getTheSameDateOfWeeks(date, -2)));
		logger.info("前三周同日：[{}]", MyDateFormatter.YYYY_MM_DD_HH_MM_SS.formatter(MyDateUtils.getTheSameDateOfWeeks(date, -3)));
		logger.info("前四周同日：[{}]", MyDateFormatter.YYYY_MM_DD_HH_MM_SS.formatter(MyDateUtils.getTheSameDateOfWeeks(date, -4)));
		logger.info("下周同日：[{}]", MyDateFormatter.YYYY_MM_DD_HH_MM_SS.formatter(MyDateUtils.getTheSameDateOfWeeks(date, 1)));
		logger.info("下下周同日：[{}]", MyDateFormatter.YYYY_MM_DD_HH_MM_SS.formatter(MyDateUtils.getTheSameDateOfWeeks(date, 2)));
		logger.info("后三周同日：[{}]", MyDateFormatter.YYYY_MM_DD_HH_MM_SS.formatter(MyDateUtils.getTheSameDateOfWeeks(date, 3)));
		logger.info("后四周同日：[{}]", MyDateFormatter.YYYY_MM_DD_HH_MM_SS.formatter(MyDateUtils.getTheSameDateOfWeeks(date, 4)));
	}
	
}
