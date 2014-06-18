/**
 * 
 */
package com.songo.gather.bbs.oschina;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>decription:</p>
 * <p>date:2014年6月18日 上午9:05:57</p>
 * @author gsu·napoleon
 */
public class SecureDeleteFileTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年6月18日 上午9:05:57</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		try {
			SecureDeleteFile sdf = new SecureDeleteFile();
			sdf.destroyFileContent("D:\\DevelopmentEnvironment\\logs\\admin\\fb.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteFile() {
		SecureDeleteFile sdf = new SecureDeleteFile();
		sdf.deleteFile("D:\\DevelopmentEnvironment\\logs\\admin\\fb.txt");
	}
	
}
