/**
 * 
 */
package com.google.common.math;

import java.math.RoundingMode;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>decription:</p>
 * <p>date:2014年6月23日 下午3:15:59</p>
 * @author gsu·napoleon
 */
public class IntMathTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年6月23日 下午3:15:59</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		int log2 = IntMath.log2(9, RoundingMode.CEILING);
		System.out.println(log2);
		int log10 = IntMath.log10(20, RoundingMode.CEILING);
		System.out.println(log10);
	}

}
