/**
 * 
 */
package com.songo.gather.security;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Before;
import org.junit.Test;

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
		String hash = SecurityPasswordHash.base64Hash("123456789holdfishplam##", "Key!@#$%^&*(){}001");
		System.out.println(hash.length());
	}

}
