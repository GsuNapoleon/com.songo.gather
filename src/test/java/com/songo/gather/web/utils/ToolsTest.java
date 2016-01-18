/**
 * 
 */
package com.songo.gather.web.utils;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>decription:</p>
 * <p>date:2015年11月23日 上午9:31:36</p>
 * @author gsu·napoleon
 */
public class ToolsTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2015年11月23日 上午9:31:36</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		String adId = "AAAA";
		System.out.println(Tools.updateAd("url?other=xxx&ad=xxx", adId));
		System.out.println(Tools.updateAd("url#other=xxx&ad=xxx", adId));
	}

}
