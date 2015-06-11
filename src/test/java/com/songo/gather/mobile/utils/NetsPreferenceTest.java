/**
 * 
 */
package com.songo.gather.mobile.utils;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>decription:</p>
 * <p>date:2015年6月8日 上午11:32:31</p>
 * @author gsu·napoleon
 */
public class NetsPreferenceTest {

	private static final Logger logger = LoggerFactory.getLogger(NetsPreferenceTest.class);
	
	/**
	 * <p>decription:</p>
	 * <p>date:2015年6月8日 上午11:32:31</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		boolean isInitMobile = NetsPreference.MOBILE.isMobile();
		logger.debug("is mobile : {{}}", isInitMobile);
	}

}
