/**
 * 
 */
package com.songo.gather.pattern.chainresponsibility;

/**
 * <p>decription:</p>
 * <p>date:2015年6月11日 上午9:40:38</p>
 * @author gsu·napoleon
 */
public class ChainStdinfoLogger extends ChainLogger {

	/**
	 * @param mask
	 */
	public ChainStdinfoLogger(int mask) {
		super(mask);
	}

	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.chainresponsibility.ChainLogger#writeMsg(java.lang.String)
	 */
	@Override
	public void writeMsg(String msg) {
		System.err.println("*********** [standinfo] " + msg);
	}

}
