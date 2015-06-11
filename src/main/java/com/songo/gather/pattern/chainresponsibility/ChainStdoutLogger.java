/**
 * 
 */
package com.songo.gather.pattern.chainresponsibility;

/**
 * <p>decription:</p>
 * <p>date:2015年6月11日 上午9:25:48</p>
 * @author gsu·napoleon
 */
public class ChainStdoutLogger extends ChainLogger {

	/**
	 * @param mask
	 */
	public ChainStdoutLogger(int mask) {
		super(mask);
	}

	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.chainresponsibility.ChainLogger#writeMsg(java.lang.String)
	 */
	@Override
	public void writeMsg(String msg) {
		System.out.println("*********** [standout] " + msg);
	}

}
