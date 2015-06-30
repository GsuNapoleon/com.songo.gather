/**
 * 
 */
package com.songo.gather.mail;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>decription:</p>
 * <p>date:2015年6月25日 上午9:31:52</p>
 * @author gsu·napoleon
 */
public class ApacheCommonsEmail {

	private static final Logger logger = LoggerFactory.getLogger(ApacheCommonsEmail.class);
	
	private ApacheCommonsEmail() {
		logger.warn("Not supported extends!");
	}
	
	public static void sendMailOfHtml(String subject, String content, String...toAddress) throws EmailException {
		logger.debug("Send mail parameter is {subject:{}, content:{}, addresses:{}}", subject, content, toAddress);
		Email he = new HtmlEmail();
		he.setHostName("smtp.163.com");
		he.setSmtpPort(465);
		he.setAuthentication("", "");
		he.setSSLOnConnect(true);
		he.setFrom("");
		he.setSubject(subject);
		he.setMsg(content);
		he.addTo(toAddress);
		he.send();
		logger.debug("Send successfully!");
	}
	
}
