/**
 * 
 */
package com.songo.gather.security;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>decription:</p>
 * <p>date:2015年7月3日 下午5:08:23</p>
 * @author gsu·napoleon
 */
public class PasswordAuthenticatorTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2015年7月3日 下午5:08:23</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		try {
			PasswordAuthenticator.authenticatePassword("Ab1234567&^%$");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPasswordEncrypt() {
		try {
			System.err.println(PasswordAuthenticator.encrypt(new char[]{'A', 'b', '1', '$', '%', '^', '&'},  "09876543210"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
