/**
 * 
 */
package com.songo.gather.utils;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>decription:</p>
 * <p>date:2015年9月2日 下午3:41:24</p>
 * @author gsu·napoleon
 */
public class MyWebUtilsTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2015年9月2日 下午3:41:24</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		System.err.println(MyWebUtils.matchSite("http://price.pcauto.com.cn/"));
		System.err.println(MyWebUtils.matchSite("http://price.3g.pcauto.com.cn/"));
		System.err.println(MyWebUtils.matchSite("http://m.pcauto.com.cn/"));
		System.err.println(MyWebUtils.matchSite("http://www.pcauto1.com.cn/xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxpcauto.com.cn"));
		System.err.println(MyWebUtils.matchSite("http://price.pcauto1.com.cn/"));
	}

}
