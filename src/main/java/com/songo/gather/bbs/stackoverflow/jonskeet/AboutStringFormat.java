/**
 * 
 */
package com.songo.gather.bbs.stackoverflow.jonskeet;

/**
 * <p>Asker:String variable interpolation Java</p>
 * <p>Answer:If you're using Java 5 or higher, you can use String.format</p>
 * <p>decription:</p>
 * <p>date:2014年4月24日 上午8:57:29</p>
 * @author gsu·napoleon
 */
public class AboutStringFormat {

	public static void main(String[] args) {
		String format = String.format("a=%s;b=%s;c=%s;d=%s", "A", "B", "C", "D");
		System.out.println(format);
	}
	
}
