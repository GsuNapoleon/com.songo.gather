/**
 * 
 */
package com.songo.gather.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>decription:</p>
 * <p>date:2014年5月8日 下午5:31:33</p>
 * @author gsu·napoleon
 */
public class LogThread {
	private Logger logger = LoggerFactory.getLogger(LogThread.class);
	private ThreadLocal<String> threadLocal = new ThreadLocal<String>() {

		/* (non-Javadoc)
		 * @see java.lang.ThreadLocal#initialValue()
		 */
		@Override
		protected String initialValue() {
			return "";
		}
	
	};

	public void thread1() {
		String threadLocalName = Thread.currentThread().getName();
		LogThread.class.getName();
		threadLocal.set(LogThread.class.getName());
	}
	
	public void test() {
		logger.debug(Thread.currentThread().getName() + "............. Test");
	}
	public void test(String s) {
		logger.debug(Thread.currentThread().getName() + "............. Test, s = " + s);
	}
	public void test(String s, String s1) {
		Thread.currentThread().setName("");
		logger.debug(Thread.currentThread().getName() + "............. Test, s = " + s + ", s1 = " + s1);
	}
	
	/**
	 * <p>decription:</p>
	 * <p>date:2014年5月8日 下午5:31:33</p>
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		LogThread logThread = new LogThread();
		logThread.test();
		logThread.test("AAAAAAA");
		logThread.test("NNNNNN", "MMMMMMM");
	}

}
