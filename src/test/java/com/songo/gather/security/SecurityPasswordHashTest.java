/**
 * 
 */
package com.songo.gather.security;

import org.junit.Before;
import org.junit.Test;

import com.songo.gather.utils.MySecurityPasswordHash;
import com.songo.gather.utils.MyStringUtils;

/**
 * <p>decription:</p>
 * <p>date:2014年6月23日 下午4:21:18</p>
 * @author gsu·napoleon
 */
public class SecurityPasswordHashTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年6月23日 下午4:21:18</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		String hash = MySecurityPasswordHash.base64Hash("123456789holdfishplam##", "Key!@#$%^&*(){}009");
		System.out.println(hash.length());
		String x = String.valueOf(System.currentTimeMillis())
                + "." + MyStringUtils.getUuid(4)
                + "." + MySecurityPasswordHash.base64Hash(MyStringUtils.getUuid(32), MyStringUtils.getUuid(8));
		System.out.println(x);
		
	}

}
