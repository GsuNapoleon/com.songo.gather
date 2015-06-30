/**
 * 
 */
package com.songo.gather.mail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.geronimo.javamail.transport.smtp.SMTPConnection;
import org.apache.geronimo.javamail.util.MailConnection;
import org.apache.geronimo.javamail.util.ProtocolProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>decription:</p>
 * <p>date:2015年6月25日 上午9:32:31</p>
 * @author gsu·napoleon
 */
public class GeronimoJavamail {
	
	private static final Logger logger = LoggerFactory.getLogger(GeronimoJavamail.class);
	
	private GeronimoJavamail() {
		logger.warn("Not supported extends!");
	}

	@SuppressWarnings("static-access")
	public static void sendMailOfHtml(String subject, String content, String toAddress) {

		try {
			Properties properties = new Properties();
			properties.load(GeronimoJavamail.class.getClassLoader().getResourceAsStream("geronimo-javamial.properties"));
			Session session = Session.getInstance(properties, 
					new DefaultAuthenticator("", ""));
			Transport transport = session.getTransport();
			MimeMessage mm = new MimeMessage(session);
			mm.addRecipients(RecipientType.TO, toAddress);
			mm.setSubject(subject);
			mm.setContent(content, "text/html; charset=utf-8");
			transport.connect(properties.getProperty("mail.user"), properties.getProperty("mail.password"));
			transport.send(mm);
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
