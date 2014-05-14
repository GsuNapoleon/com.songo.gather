/**
 * 
 */
package com.songo.gather.pattern.strategy;

/**
 * <p>decription:</p>
 * <p>date:2014年5月12日 下午12:23:57</p>
 * @author gsu·napoleon
 */
public class StrategyA implements Strategy {

	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.strategy.Strategy#handle()
	 */
	@Override
	public void handle() {
		System.out.println("............... A");
	}

}
