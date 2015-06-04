/**
 * 
 */
package com.songo.gather.utils;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>decription:</p>
 * <p>date:2015年6月3日 下午3:32:03</p>
 * @author gsu·napoleon
 */
public class MySpecialUtilsTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2015年6月3日 下午3:32:03</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		System.err.println(RandomUtils.nextInt(1, 1000));
		System.err.println(MySpecialUtils.PERMS_ALL.getValue());
		System.err.println(1 << 0 | 1 << 1 | 1 << 2 | 1 << 3 | 1 << 4);
		System.err.println(MySpecialUtils.PERMS_READ.getValue());
		System.err.println(MySpecialUtils.PERMS_WRITE.getValue());
		System.err.println(MySpecialUtils.PERMS_CREATE.getValue());
		System.err.println(MySpecialUtils.PERMS_DELETE.getValue());
		System.err.println(MySpecialUtils.PERMS_ADMIN.getValue());
	}

}
