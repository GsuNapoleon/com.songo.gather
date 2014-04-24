/**
 * 
 */
package com.songo.gather.bbs.stackoverflow.jonskeet;

import java.io.InputStream;

/**
 * <p>Asker:How to really read text file from classpath in Java</p>
 * <p>Answer:With the directory on the classpath, from a class loaded by the same classloader</p>
 * <p>decription:</p>
 * <p>date:2014年4月24日 上午9:04:01</p>
 * @author gsu·napoleon
 */
public class AboutFileFromClasspath {
	
	@SuppressWarnings("unused")
	public void run() {
		// From ClassLoader, all paths are "absolute" already - there's no context
		// from which they could be relative. Therefore you don't need a leading slash.
		InputStream in = this.getClass().getClassLoader()
				.getResourceAsStream("SomeTextFile.txt");
		// From Class, the path is relative to the package of the class unless
		// you include a leading slash, so if you don't want to use the current
		// package, include a slash like this:
		InputStream in1 = this.getClass().getResourceAsStream("/SomeTextFile.txt");
	}

	/**
	 * <p>decription:</p>
	 * <p>date:2014年4月24日 上午9:04:01</p>
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
