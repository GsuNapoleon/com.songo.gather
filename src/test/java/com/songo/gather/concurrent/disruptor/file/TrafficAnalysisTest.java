/**
 * 
 */
package com.songo.gather.concurrent.disruptor.file;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>decription:</p>
 * <p>date:2015年8月12日 下午12:12:03</p>
 * @author gsu·napoleon
 */
public class TrafficAnalysisTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2015年8月12日 下午12:12:03</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		TrafficAnalysis ta = new TrafficAnalysis();
		ta.analysis("20150731");
	}
	
	@Test
	public void test1() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Calendar c = Calendar.getInstance();
		c.set(2015, 8, 13, 12, 21, 00);
		long s = NumberUtils.toLong(dateFormat.format(c.getTime()));
		int no = (int) (s / 100 % 100) % 30;
		System.err.println(s);
		System.err.println(no);
	}

}
