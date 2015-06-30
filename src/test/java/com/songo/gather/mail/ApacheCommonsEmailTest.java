/**
 * 
 */
package com.songo.gather.mail;

import org.apache.commons.mail.EmailException;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>decription:</p>
 * <p>date:2015年6月25日 上午10:04:33</p>
 * @author gsu·napoleon
 */
public class ApacheCommonsEmailTest {

	private static final Logger logger = LoggerFactory.getLogger(ApacheCommonsEmailTest.class);
	
	/**
	 * <p>decription:</p>
	 * <p>date:2015年6月25日 上午10:04:33</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		try {
			ApacheCommonsEmail.sendMailOfHtml("Apache Commons Email", "come on!!!", "chenbiao@pconline.com.cn");
		} catch (EmailException e) {
			logger.error("邮件发送失败,请检测异常：{}", e);
		}
	}

}
