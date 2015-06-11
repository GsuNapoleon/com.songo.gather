/**
 * 
 */
package com.songo.gather.pattern.chainresponsibility;

import com.songo.gather.pattern.chainresponsibility.ChainLogger.Level;

/**
 * <p>decription:</p>
 * <p>date:2015年6月11日 上午9:29:39</p>
 * @author gsu·napoleon
 */
public class ChainExample {
	
	private static ChainLogger createChain() {
		ChainLogger loggerStdoutLogger = new ChainStdoutLogger(Level.DEBUG.getLevel());

		ChainLogger loggerStdinfoLogger = new ChainStdinfoLogger(Level.INFO.getLevel());
		loggerStdoutLogger.setNext(loggerStdinfoLogger);
		
		ChainLogger loggerStderrLogger = new ChainStderrLogger(Level.ERROR.getLevel());
		loggerStdinfoLogger.setNext(loggerStderrLogger);
		
		return loggerStdoutLogger;
	}

	/**
	 * <p>decription:</p>
	 * <p>date:2015年6月11日 上午9:29:39</p>
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		ChainLogger logger = createChain();
		
		logger.message("AABBCC", Level.DEBUG.getLevel());
		
		logger.message("112233", Level.INFO.getLevel());
		
		logger.message("gghhjj", Level.ERROR.getLevel());
	}

}
