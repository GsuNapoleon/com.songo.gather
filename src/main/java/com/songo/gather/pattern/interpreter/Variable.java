/**
 * 
 */
package com.songo.gather.pattern.interpreter;

import java.util.Map;

/**
 * <p>decription:</p>
 * <p>date:2015年6月11日 上午11:29:27</p>
 * @author gsu·napoleon
 */
public class Variable implements Expression {
	
	private String name;
	
	public Variable(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.interpreter.Expression#interpreter(java.util.Map)
	 */
	@Override
	public int interpreter(Map<String, Expression> variables) {
		return variables.get(name) == null ? 0 : variables.get(name).interpreter(variables);
	}

}
