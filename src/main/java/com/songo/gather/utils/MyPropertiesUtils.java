/**
 * 
 */
package com.songo.gather.utils;

import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;

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
		System.err.println(isNewUv("0", new Date().getTime()));
		System.err.println(isNewUv(new Date().getTime() + ".a.1", new Date().getTime()));
		System.err.println(isNewUv("1.a.1", new Date().getTime()));
		System.err.println(isNewUv("1", new Date().getTime()));
		System.err.println(isNewUv("", new Date().getTime()));
		System.err.println(isNewUv(" ", new Date().getTime()));
		System.err.println(isNewUv("", 0L));
		System.err.println(isNewUv(null, new Date().getTime()));
	}

	private static boolean isNewUv(String pcsuv, long today){
        if (StringUtils.isBlank(pcsuv) || today <= 0 || (!StringUtils.equals("0", pcsuv) && pcsuv.indexOf(".") == -1)) {
            System.err.println(pcsuv);
        	return false;
        }
		if("0".equals(pcsuv)) {
            return true;
        }
		try{
			long t = NumberUtils.toLong(pcsuv.substring(0, pcsuv.indexOf(".")));
			return t - today >= 0;
		}catch (Exception ex){
			ex.printStackTrace();
			return false;
		}
	}
}
