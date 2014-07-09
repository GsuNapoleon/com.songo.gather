/**
 * 
 */
package com.songo.gather.io;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Splitter;

/**
 * <p>decription:</p>
 * <p>date:2014年6月18日 下午3:36:43</p>
 * @author gsu·napoleon
 */
public class MyFileOutInputStreamTest {
	
	private MyFileOutInputStream mfos;
	private String pathname;

	/**
	 * <p>decription:</p>
	 * <p>date:2014年6月18日 下午3:36:43</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mfos = new MyFileOutInputStream();
		pathname = "D:\\DevelopmentEnvironment\\logs\\admin\\output.txt";
	}

	@Test
	public void testInput() {
		mfos.input(pathname);
	}

	/**
	 * Test method for {@link com.songo.gather.io.MyFileOutInputStream#output(java.lang.String)}.
	 */
	@Test
	public void testOutput() {
		mfos.output(pathname);
	}
	
	@Test
	public void testChannel() {
		mfos.writeChannel(pathname);
	}

}
