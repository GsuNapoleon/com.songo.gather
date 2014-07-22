/**
 * 
 */
package com.songo.gather.algorithm;

import java.net.URLEncoder;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>decription:</p>
 * <p>date:2014年7月21日 下午3:42:07</p>
 * @author gsu·napoleon
 */
public class RSATest {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private String privateKey;
	private String publicKey;
	
	/**
	 * <p>decription:</p>
	 * <p>date:2014年7月21日 下午3:42:07</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		Map<String, Object> keyMap = RSA.initKey();
		
		privateKey = RSA.getPrivateKey(keyMap);
		publicKey = RSA.getPublicKey(keyMap);
		
		logger.info("初始化后的私钥为：{}", privateKey);
		logger.info("初始化后的公钥为：{}", publicKey);
	}

	@Test
	public void testPubToPri() {
		logger.info("来到公钥加密,私钥解密区.................");
		
		String waitString = "Ab123456!@#$";
		
		try {
			byte [] data = waitString.getBytes("UTF-8");
			byte [] ed = RSA.encryptByPublicKey(data, publicKey);
			logger.info("加密后的值为：{}", URLEncoder.encode(new String(ed), "UTF-8"));
			byte [] dd = RSA.decryptByPrivateKey(ed, privateKey);
			logger.info("解密后的值为：{}", new String(dd, "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPubToPriForString() {
		logger.info("来到公钥加密,私钥解密区.................");
		
		String waitString = "Ab123456!@#$";
		
		try {
			String encryptString = RSA.encryptByPublicKey(waitString, publicKey);
			logger.info("加密后的值为：{}", encryptString);
			String decryptString = RSA.decryptByPrivateKey(encryptString, privateKey);
			logger.info("解密后的值为：{}", decryptString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPriToPubForString() {
		logger.info("来到公钥解密,私钥加密区.................");
		
		String waitString = "Ab123456!@#$";
		
		try {
			String encryptString = RSA.encryptByPublicKey(waitString, publicKey);
			logger.info("加密后的值为：{}", encryptString);
			String decryptString = RSA.decryptByPrivateKey(encryptString, privateKey);
			logger.info("解密后的值为：{}", decryptString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
