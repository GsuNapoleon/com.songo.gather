/**
 * 
 */
package com.songo.gather.security;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;

/**
 * <p>
 * decription:
 * </p>
 * <p>
 * date:2014年6月23日 下午4:18:58
 * </p>
 * 
 * @author gsu·napoleon
 */
public class SecurityPasswordHash {
	private final static String CHARSET = "UTF-8";

	private SecurityPasswordHash() {
	
	}

	public static String base64Hash(String password, String salt) {
		return base64Hash(password, salt, "SHA-384");
	}

	private static String base64Hash(String password, String salt,
			String algorithm) {
		byte[] bys = byteHash(password, salt, algorithm);
		return new String(Base64.encodeBase64(bys));
	}

	public static byte[] byteHash(String password, String salt, String algorithm) {
		if (password == null || algorithm == null) {
			return null;
		}
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm.trim());
			if (salt != null) {
				md.update((salt.toLowerCase() + ":" + password)
						.getBytes(CHARSET));
				byte[] bys = md.digest();
				md.reset();
				md.update(password.getBytes(CHARSET));
				md.update(bys);
			} else {
				md.update(password.getBytes(CHARSET));
			}
			return md.digest();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
