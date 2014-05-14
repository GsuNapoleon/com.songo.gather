/**
 * 
 */
package com.songo.gather.pattern.strategy;

/**
 * <p>decription:</p>
 * <p>date:2014年5月12日 下午12:28:10</p>
 * @author gsu·napoleon
 */
public class Client {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年5月12日 下午12:28:10</p>
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		Context ca = new Context(new StrategyA());
		ca.handle();
		Context cb = new Context(new StrategyB());
		cb.handle();
	}

}
