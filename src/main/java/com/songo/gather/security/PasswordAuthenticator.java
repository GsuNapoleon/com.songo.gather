/**
 * 
 */
package com.songo.gather.security;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import sun.misc.BASE64Encoder;

/**
 * <p>
 * decription:
 * </p>
 * <p>
 * date:2015年7月3日 下午5:03:46
 * </p>
 * 
 * @author gsu·napoleon
 */
public class PasswordAuthenticator {

	public static void authenticatePassword(String password) throws Exception {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		FileInputStream fis = new FileInputStream("password");
		int theByte = 0;
		while ((theByte = fis.read()) != -1) {
			baos.write(theByte);
		}
		fis.close();
		byte[] hashedPasswordWithSalt = baos.toByteArray();
		baos.reset();

		byte[] salt = new byte[12];
		System.arraycopy(hashedPasswordWithSalt, 0, salt, 0, 12);

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(salt);
		md.update(password.getBytes("UTF8"));
		byte[] digest = md.digest();

		byte[] digestInFile = new byte[hashedPasswordWithSalt.length - 12];
		System.arraycopy(hashedPasswordWithSalt, 12, digestInFile, 0,
				hashedPasswordWithSalt.length - 12);

		System.out.println(Arrays.equals(digest, digestInFile));
	}

	public static String encrypt(char[] password, String plaintext)
			throws Exception {

		byte[] salt = new byte[8];
		Random random = new Random();
		random.nextBytes(salt);

		PBEKeySpec keySpec = new PBEKeySpec(password);

//		SecretKeyFactory keyFactory = SecretKeyFactory
//				.getInstance("PBEWithSHAAndTwofish-CBC");
		SecretKeyFactory keyFactory = SecretKeyFactory
				.getInstance("PBEWithSHA1AndRC2_40");

		SecretKey key = keyFactory.generateSecret(keySpec);

		PBEParameterSpec paramSpec = new PBEParameterSpec(salt, 1000);

//		Cipher cipher = Cipher.getInstance("PBEWithSHAAndTwofish-CBC");
		Cipher cipher = Cipher.getInstance("PBEWithSHA1AndRC2_40");
		cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);

		byte[] ciphertext = cipher.doFinal(plaintext.getBytes());

		BASE64Encoder encoder = new BASE64Encoder();

		String saltString = encoder.encode(salt);
		String ciphertextString = encoder.encode(ciphertext);

		return saltString + ciphertextString;
	}

}
