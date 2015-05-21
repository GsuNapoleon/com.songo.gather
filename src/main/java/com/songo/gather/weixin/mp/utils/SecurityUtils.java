/**
 * 
 */
package com.songo.gather.weixin.mp.utils;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * decription:
 * </p>
 * <p>
 * date:2015年4月22日 下午12:03:51
 * </p>
 * 
 * @author gsu·napoleon
 */
public final class SecurityUtils {

	private final static String DEFAULT_CHARSET = "GBK";
	private final static String DEFAULT_KEY = "Counter6Nets@wx.com";
	private final static String DEFAULT_SALT = "PacificOceanCounter1997&^%$#";
	private final static String DEFAULT_ALGORITHM = "SHA-256";

	private SecurityUtils() {
	}

	public static boolean certificationCenter(String signature, String timestamp, String nonce) {
        
        if (StringUtils.isEmpty(signature) || StringUtils.isEmpty(timestamp)
                || StringUtils.isEmpty(nonce)) {
            return false;
        }
        
        String token = DevApp.APP_CUSTOM_TOKEN.getValue();
        String [] datas = {token, timestamp, nonce};
        Arrays.sort(datas);
        String data = datas[0] + datas[1] + datas[2];

        System.err.println("{token:" + token + ", timestamp:" + timestamp 
            + ", nonce:" + nonce + "; data:" + data 
            + "; signature:" + signature + "}");

        String localSignature = SecurityUtils.sha1HashToHex(data);
        System.err.println("local signature : " + localSignature);
        
        return StringUtils.isNotEmpty(localSignature) &&
                signature.equals(localSignature);
    }
	
	public static String sha256Hash() {
		return stringHash(DEFAULT_KEY, DEFAULT_SALT, DEFAULT_ALGORITHM);
	}

	public static String stringHash(String key, String salt,
			String algorithm) {
		
		key = StringUtils.isBlank(key) ? DEFAULT_KEY : key;
		salt = StringUtils.isBlank(salt) ? DEFAULT_SALT : salt;
		algorithm = StringUtils.isBlank(algorithm) ? DEFAULT_ALGORITHM : algorithm;
		
		byte[] bys = byteHash(key, salt, algorithm);
		return StringUtils.replaceEach(new String(Base64.encodeBase64(bys)), 
				new String[]{"+", "/", "="}, new String[]{"j", "X", ""});
	}
	
	public static String sha1HashToString(String key) {
		byte [] bytes = byteHash(key, null, "SHA-1");
		return new String(Base64.encodeBase64(bytes));
	}
	
	public static String sha1HashToHex(String key) {
		byte [] bytes = byteHash(key, null, "SHA-1");
		StringBuffer hexString = new StringBuffer();
        // 字节数组转换为 十六进制 数
        for (int i = 0; i < bytes.length; i++) {
            String shaHex = Integer.toHexString(bytes[i] & 0xFF);
            if (shaHex.length() < 2) {
                hexString.append(0);
            }
            hexString.append(shaHex);
        }
        return hexString.toString();
	}

	private static byte[] byteHash(String key, String salt, String algorithm) {
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm.trim());
			if (salt != null) {
				md.update((salt.toLowerCase() + ":" + key)
						.getBytes(DEFAULT_CHARSET));
				byte[] bys = md.digest();
				md.reset();
				md.update(key.getBytes(DEFAULT_CHARSET));
				md.update(bys);
			} else {
				md.update(key.getBytes(DEFAULT_CHARSET));
			}
			return md.digest();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	

	/**
	 * <p>
	 * decription:
	 * </p>
	 * <p>
	 * date:2015年4月22日 下午12:03:51
	 * </p>
	 * 
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		String token = DevApp.APP_CUSTOM_TOKEN.getValue();
		String timestamp = String.valueOf(System.currentTimeMillis());
		String randInt = String.valueOf(ThreadLocalRandom.current().nextInt(31, 512));
		String [] datas = {token, timestamp, randInt};
		Arrays.sort(datas);
		String data = datas[0] + datas[1] + datas[2];
		System.err.println("{token:" + token + ", timestamp:" + timestamp + ", randInt:"
				+ randInt + "; data:" + data + "}");	
		String shaString = sha1HashToString(data);
		String shaHexString = sha1HashToHex(data);
		System.err.println("{shaString:" + shaString + ", shaHexString:" + shaHexString + "}");	
		
		String hash = sha256Hash();
		System.err.println("hash:\"" + hash + "\", hash length:\"" + hash.length() + "\".");
	}

}
