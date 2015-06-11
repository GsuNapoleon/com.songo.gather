/**
 * 
 */
package com.songo.gather.pattern.chainresponsibility;

/**
 * <p>decription:</p>
 * <p>date:2015年6月11日 上午9:27:52</p>
 * @author gsu·napoleon
 */
public class ChainStderrLogger extends ChainLogger {

	/**
	 * @param mask
	 */
	public ChainStderrLogger(int mask) {
		super(mask);
	}

	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.chainresponsibility.ChainLogger#writeMsg(java.lang.String)
	 */
	@Override
	public void writeMsg(String msg) {
		System.err.println("*********** [standerr] " + msg);
	}

}
