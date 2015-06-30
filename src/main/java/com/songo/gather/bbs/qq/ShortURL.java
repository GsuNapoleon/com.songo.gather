/**
 * 
 */
package com.songo.gather.bbs.qq;

/**
 * <p>decription:短链接</p>
 * <p>date:2014年5月5日 上午9:37:01</p>
 * @author gsu·napoleon
 */
public class ShortURL {
	
	public static String getBaseString() {
		return "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	}
	
	public static String toShortString(long id) {
		if (id < 0) {
			throw new IllegalArgumentException("id = " + id);
		}
		StringBuffer buffer = new StringBuffer();
		while (id > 0) {
			buffer.append(getBaseString().charAt((int)(id % 62)));
			id /= 62;
		}
		System.out.println("before : " + buffer.toString());
		return buffer.reverse().toString();
	}

	public static long toLongValue(String str) {
		long result = 0;
		int length = str.length() - 1;
		if (length < 0) {
			throw new IllegalArgumentException("str = " + str);
		}
		for (int i = length; i >= 0; i --) {
			char ch = str.charAt(i);
			int index = getBaseString().indexOf("" + ch);
			if (index == -1) {
				return 0;
			}
			result += index * (long)Math.pow(62, length - i);
		}
		return result;
	}
	
	/**
	 * <p>decription:</p>
	 * <p>date:2014年5月5日 上午9:37:01</p>
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		long id = 900000L;
		String shortURL = toShortString(id);
		System.out.println("short url is : " + shortURL);
		long longValue = toLongValue(shortURL);
		System.out.println("long value is : " + longValue);
	}

}
