/**
 * 
 */
package com.songo.gather.bbs.stackoverflow.jonskeet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import com.google.common.io.ByteStreams;
import com.google.common.io.Files;

/**
 * <p>decription:Reading a binary file into a single byte array in JAVA</p>
 * <p>date:2014年4月24日 下午3:47:15</p>
 * @author gsu·napoleon
 */
public class ReadBinaryFile {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年4月24日 下午3:47:15</p>
	 * @author gsu·napoleon
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			InputStream in = null;
			byte[] bytes = ByteStreams.toByteArray(in);
			File file = null;
			byte[] fbytes = Files.toByteArray(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
