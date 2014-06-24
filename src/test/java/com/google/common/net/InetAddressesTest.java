/**
 * 
 */
package com.google.common.net;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>decription:</p>
 * <p>date:2014年6月23日 下午3:25:32</p>
 * @author gsu·napoleon
 */
public class InetAddressesTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年6月23日 下午3:25:32</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		String hostAddress = InetAddresses.forString("91.213.30.151").getHostAddress();
		System.out.println(hostAddress);
		String addrString = InetAddresses.toAddrString(InetAddresses.forString("91.213.30.151"));
		System.out.println(addrString);
	}

}
