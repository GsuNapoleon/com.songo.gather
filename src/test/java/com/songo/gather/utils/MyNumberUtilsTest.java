/**
 * 
 */
package com.songo.gather.utils;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>decription:</p>
 * <p>date:2015年7月2日 下午5:38:00</p>
 * @author gsu·napoleon
 */
public class MyNumberUtilsTest {
	
	private static final Logger logger = LoggerFactory.getLogger(MyNumberUtilsTest.class);

	/**
	 * <p>decription:</p>
	 * <p>date:2015年7月2日 下午5:38:00</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		logger.debug("Test result : {}", MyNumberUtils.getDivisionValue(21111, 30, 4, true));
		logger.debug("Test result : {}", MyNumberUtils.getDivisionValue(21, 30, 4, true));
		logger.debug("Test result : {}", MyNumberUtils.getDivisionValue(29, 30, 4, true));
		logger.debug("Test result : {}", MyNumberUtils.getDivisionValue(0, 30, 2, true));
		logger.debug("Test result : {}", MyNumberUtils.getDivisionValue(29, 0, 2, true));
		logger.debug("Test result : {}", MyNumberUtils.getDivisionValue(0, 30, 2, false));
		logger.debug("Test result : {}", MyNumberUtils.getDivisionValue(29, 0, 2, false));
	}

	@Test
	public void testCreateNumber() {
		logger.debug("String : {}, Result : {}", "0xDEAFFABCAAFFEEDDBB", MyNumberUtils.createNumber("0xDEAFFABCAAFFEEDDBB"));
	}
	
}
