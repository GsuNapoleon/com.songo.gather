/**
 * 
 */
package com.songo.gather.pattern.strategy;

/**
 * <p>decription:</p>
 * <p>date:2014年5月12日 下午12:20:41</p>
 * @author gsu·napoleon
 */
public class Context {

	private Strategy strategy;
	
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public void handle() {
		this.strategy.handle();
	}
	
}
