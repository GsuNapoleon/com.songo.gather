/**
 * 
 */
package com.songo.gather.lang;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>decription:</p>
 * <p>date:2014年9月3日 下午3:05:34</p>
 * @author gsu·napoleon
 */
public class TimeUnitTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年9月3日 下午3:05:34</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		long duration = 1L;
		println("天    ", TimeUnit.DAYS.toDays(duration));
		println("小时", TimeUnit.DAYS.toHours(duration));
		println("分钟", TimeUnit.DAYS.toMinutes(duration));
		println("秒    ", TimeUnit.DAYS.toSeconds(duration));
		println("毫秒", TimeUnit.DAYS.toMillis(duration));
		println("微秒", TimeUnit.DAYS.toMicros(duration));
	}

	private void println(String toName, long value) {
		System.out.println(toName + " = { " + value + " };");
	}
	
	@Test
	public void testBit() {
		System.out.println(1 << 4);
		System.out.println(1 >> 4);
		System.out.println(1 << 30);
		System.out.println(1 >> 30);
	}
	
}
