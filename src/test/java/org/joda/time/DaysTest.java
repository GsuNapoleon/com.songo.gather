/**
 * 
 */
package org.joda.time;

import static org.junit.Assert.fail;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.FastDateFormat;
import org.junit.Before;
import org.junit.Test;

import com.songo.gather.utils.Tools;

/**
 * <p>decription:</p>
 * <p>date:2014年7月8日 上午9:09:20</p>
 * @author gsu·napoleon
 */
public class DaysTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年7月8日 上午9:09:20</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link org.joda.time.Days#days(int)}.
	 */
	@Test
	public void testDays() {
		int i = Days.days(100).getDays();
		System.out.println(i);
	}

	/**
	 * Test method for {@link org.joda.time.Days#daysBetween(org.joda.time.ReadableInstant, org.joda.time.ReadableInstant)}.
	 */
	@Test
	public void testDaysBetweenReadableInstantReadableInstant() {
		try {
			ReadableInstant ri1 = new DateTime(FastDateFormat.getInstance("yyyy-MM-dd").parse("2014-07-08"));
			Date date = FastDateFormat.getInstance("yyyy-MM-dd").parse("2014-06-08");
			ReadableInstant ri2 = new DateTime(date);
			Days days = Days.daysBetween(ri2, ri1);
			System.out.println(days.getDays());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link org.joda.time.Days#daysBetween(org.joda.time.ReadablePartial, org.joda.time.ReadablePartial)}.
	 */
	@Test
	public void testDaysBetweenReadablePartialReadablePartial() {
		try {
			ReadablePartial start = new YearMonth(Tools.parse("2014-06-09", "yyyy-MM-dd"));
			ReadablePartial end = new YearMonth(Tools.parse("2014-07-09", "yyyy-MM-dd"));
			int days = Days.daysBetween(start, end).getDays();
			System.out.println(days);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link org.joda.time.Days#daysIn(org.joda.time.ReadableInterval)}.
	 */
	@Test
	public void testDaysIn() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.joda.time.Days#standardDaysIn(org.joda.time.ReadablePeriod)}.
	 */
	@Test
	public void testStandardDaysIn() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.joda.time.Days#parseDays(java.lang.String)}.
	 */
	@Test
	public void testParseDays() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.joda.time.Days#toStandardWeeks()}.
	 */
	@Test
	public void testToStandardWeeks() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.joda.time.Days#toStandardHours()}.
	 */
	@Test
	public void testToStandardHours() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.joda.time.Days#toStandardMinutes()}.
	 */
	@Test
	public void testToStandardMinutes() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.joda.time.Days#toStandardSeconds()}.
	 */
	@Test
	public void testToStandardSeconds() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.joda.time.Days#toStandardDuration()}.
	 */
	@Test
	public void testToStandardDuration() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.joda.time.Days#getDays()}.
	 */
	@Test
	public void testGetDays() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.joda.time.Days#plus(int)}.
	 */
	@Test
	public void testPlusInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.joda.time.Days#plus(org.joda.time.Days)}.
	 */
	@Test
	public void testPlusDays() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.joda.time.Days#minus(int)}.
	 */
	@Test
	public void testMinusInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.joda.time.Days#minus(org.joda.time.Days)}.
	 */
	@Test
	public void testMinusDays() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.joda.time.Days#multipliedBy(int)}.
	 */
	@Test
	public void testMultipliedBy() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.joda.time.Days#dividedBy(int)}.
	 */
	@Test
	public void testDividedBy() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.joda.time.Days#negated()}.
	 */
	@Test
	public void testNegated() {
		fail("Not yet implemented");
	}

}
