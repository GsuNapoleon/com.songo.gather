/**
 * 
 */
package com.songo.gather.pattern.interpreter;

import java.util.Map;

/**
 * <p>decription:</p>
 * <p>date:2015年6月11日 上午11:18:53</p>
 * @author gsu·napoleon
 */
public class Number implements Expression {
	
	private int number;
	
	public Number(int number) {
		this.number = number;
	}

	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.interpreter.Expression#interpreter(java.util.Map)
	 */
	@Override
	public int interpreter(Map<String, Expression> variables) {
		return this.number;
	}

}
