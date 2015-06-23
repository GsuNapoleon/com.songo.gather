/**
 * 
 */
package com.songo.gather.utils;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.FastDateFormat;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>decription:</p>
 * <p>date:2015年6月2日 上午10:17:20</p>
 * @author gsu·napoleon
 */
public class MyDateUtilsTest {

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

}
