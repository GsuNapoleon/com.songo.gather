/**
 * 
 */
package com.songo.gather.bbs.stackoverflow.jonskeet;

/**
 * <p>decription:</p>
 * <p>date:2014年4月28日 下午4:44:50</p>
 * @author gsu·napoleon
 */
public class SafeLongToInt {
	
	public int toInt(long loValue) {
		if (loValue > Integer.MAX_VALUE || loValue < Integer.MIN_VALUE) {
			throw new IllegalArgumentException(loValue + 
					" cannot be cast to int without changing its value.");
		}
		return (int)loValue;
	}

}
