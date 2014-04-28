/**
 * 
 */
package com.songo.gather.bbs.stackoverflow.jonskeet;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * <p>Asker:IP Address not obtained in java</p>
 * <p>decription:</p>
 * <p>date:2014年4月25日 上午8:53:15</p>
 * @author gsu·napoleon
 */
public class IPAddress {
	
	public void address() {
		try {
			for (Enumeration<NetworkInterface> enums = NetworkInterface.getNetworkInterfaces();
					enums.hasMoreElements();) {
				NetworkInterface ni = enums.nextElement();
				System.out.println("name : " + ni.getName());
				for (Enumeration<InetAddress> ienums = ni.getInetAddresses();ienums.hasMoreElements();) {
					System.out.println("ip : " + ienums.nextElement().getHostAddress());
				}
			}
		} catch(Exception e) {
			
		}
	}

	/**
	 * <p>decription:</p>
	 * <p>date:2014年4月25日 上午8:53:16</p>
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		IPAddress ip = new IPAddress();
		ip.address();
	}

}
