/**
 * 
 */
package com.songo.gather.mail;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>decription:</p>
 * <p>date:2015年6月25日 下午5:21:55</p>
 * @author gsu·napoleon
 */
public class GeronimoJavamailTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2015年6月25日 下午5:21:55</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		GeronimoJavamail.sendMailOfHtml("Geronimo Java mail", "geronimo javamail", "chenbiao@pconline.com.cn");
	}

}
