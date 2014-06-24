/**
 * 
 */
package org.apache.commons.lang3.math;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>decription:</p>
 * <p>date:2014年6月23日 下午2:39:14</p>
 * @author gsu·napoleon
 */
public class IEEE754rUtilsTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年6月23日 下午2:39:14</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(IEEE754rUtils.max(new double[]{3,12,321,10,435,1}));
		System.out.println(IEEE754rUtils.min(new double[]{3,12,321,10,435,1}));
	}

}
