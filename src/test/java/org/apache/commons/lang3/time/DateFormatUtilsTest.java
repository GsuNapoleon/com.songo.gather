/**
 * 
 */
package org.apache.commons.lang3.time;

import static org.junit.Assert.*;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>decription:</p>
 * <p>date:2014年6月23日 下午2:03:42</p>
 * @author gsu·napoleon
 */
public class DateFormatUtilsTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年6月23日 下午2:03:42</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.time.DateFormatUtils#DateFormatUtils()}.
	 */
	@Test
	public void testDateFormatUtils() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.time.DateFormatUtils#formatUTC(long, java.lang.String)}.
	 */
	@Test
	public void testFormatUTCLongString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.time.DateFormatUtils#formatUTC(java.util.Date, java.lang.String)}.
	 */
	@Test
	public void testFormatUTCDateString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.time.DateFormatUtils#formatUTC(long, java.lang.String, java.util.Locale)}.
	 */
	@Test
	public void testFormatUTCLongStringLocale() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.time.DateFormatUtils#formatUTC(java.util.Date, java.lang.String, java.util.Locale)}.
	 */
	@Test
	public void testFormatUTCDateStringLocale() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.time.DateFormatUtils#format(long, java.lang.String)}.
	 */
	@Test
	public void testFormatLongString() {
		
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.time.DateFormatUtils#format(java.util.Date, java.lang.String)}.
	 */
	@Test
	public void testFormatDateString() {
		String str = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
		System.out.println(str);
		FastDateFormat fdf = DateFormatUtils.ISO_DATE_FORMAT;
		String str1 = fdf.format(new Date());
		System.out.println(str1);
		FastDateFormat fdf1 = DateFormatUtils.ISO_DATE_TIME_ZONE_FORMAT;
		System.out.println(fdf1.format(new Date()));
		FastDateFormat fdf2 = DateFormatUtils.ISO_DATETIME_FORMAT;
		System.out.println(fdf2.format(new Date()));
		FastDateFormat fdf3 = FastDateFormat.getDateInstance(FastDateFormat.LONG);
		System.out.println(fdf3.format(new Date()));
		
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.time.DateFormatUtils#format(java.util.Calendar, java.lang.String)}.
	 */
	@Test
	public void testFormatCalendarString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.time.DateFormatUtils#format(long, java.lang.String, java.util.TimeZone)}.
	 */
	@Test
	public void testFormatLongStringTimeZone() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.time.DateFormatUtils#format(java.util.Date, java.lang.String, java.util.TimeZone)}.
	 */
	@Test
	public void testFormatDateStringTimeZone() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.time.DateFormatUtils#format(java.util.Calendar, java.lang.String, java.util.TimeZone)}.
	 */
	@Test
	public void testFormatCalendarStringTimeZone() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.time.DateFormatUtils#format(long, java.lang.String, java.util.Locale)}.
	 */
	@Test
	public void testFormatLongStringLocale() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.time.DateFormatUtils#format(java.util.Date, java.lang.String, java.util.Locale)}.
	 */
	@Test
	public void testFormatDateStringLocale() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.time.DateFormatUtils#format(java.util.Calendar, java.lang.String, java.util.Locale)}.
	 */
	@Test
	public void testFormatCalendarStringLocale() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.time.DateFormatUtils#format(long, java.lang.String, java.util.TimeZone, java.util.Locale)}.
	 */
	@Test
	public void testFormatLongStringTimeZoneLocale() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.time.DateFormatUtils#format(java.util.Date, java.lang.String, java.util.TimeZone, java.util.Locale)}.
	 */
	@Test
	public void testFormatDateStringTimeZoneLocale() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.apache.commons.lang3.time.DateFormatUtils#format(java.util.Calendar, java.lang.String, java.util.TimeZone, java.util.Locale)}.
	 */
	@Test
	public void testFormatCalendarStringTimeZoneLocale() {
		fail("Not yet implemented");
	}

}
