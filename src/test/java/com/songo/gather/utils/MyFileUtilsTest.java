/**
 * 
 */
package com.songo.gather.utils;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

/**
 * <p>decription:</p>
 * <p>date:2015年8月21日 上午10:47:51</p>
 * @author gsu·napoleon
 */
public class MyFileUtilsTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2015年8月21日 上午10:47:51</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		MyFileUtils mfu = new MyFileUtils();
		mfu.depthDeleteFile("D:\\DevelopmentEnvironment\\counter\\");
		long ip = MyWebUtils.parseIp("192.168.201.100");
		System.err.println(ip);
		HashFunction hf = Hashing.murmur3_128();
		System.err.println(hf.hashLong(ip));
	}
	
	@Test
	public void testCombinerFile() {
		try {
			MyFileUtils.combinerFile("E:\\counterworkspace\\counter\\auto\\work\\", "20150731");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
