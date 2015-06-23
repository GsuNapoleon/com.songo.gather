/**
 * 
 */
package com.songo.gather.utils;

import java.util.ResourceBundle;

/**
 * <p>decription:</p>
 * <p>date:2015年6月18日 上午10:14:12</p>
 * @author gsu·napoleon
 */
public final class MyPropertiesUtils {
	
	private static final String LOCAL_STRING = "com.songo.gather.utils.MyLocalStrings";
	private static ResourceBundle lstring = ResourceBundle.getBundle(LOCAL_STRING);

	/**
	 * <p>decription:</p>
	 * <p>date:2015年6月18日 上午10:14:12</p>
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		System.err.println(lstring.getString("err.servlet_config_not_initialized"));
	}

}
