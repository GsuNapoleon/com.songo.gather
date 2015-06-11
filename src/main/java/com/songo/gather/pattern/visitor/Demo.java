/**
 * 
 */
package com.songo.gather.pattern.visitor;

/**
 * <p>decription:</p>
 * <p>date:2015年6月11日 上午10:58:18</p>
 * @author gsu·napoleon
 */
public class Demo {

	/**
	 * <p>decription:</p>
	 * <p>date:2015年6月11日 上午10:58:18</p>
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		CarElement ele = new Car();
		ele.accept(new CarElementPrintVisitor());
		ele.accept(new CarElementDoVisitor());
	}

}
