/**
 * 
 */
package com.songo.gather.pattern.interpreter;

import java.util.Map;

/**
 * <p>decription:</p>
 * <p>date:2015年6月11日 上午11:20:03</p>
 * @author gsu·napoleon
 */
public class Plus implements Expression {
	
	private Expression leftOperant;
	private Expression rightOperant;
	
	public Plus(Expression leftOperant, Expression rightOperant) {
		this.leftOperant = leftOperant;
		this.rightOperant = rightOperant;
	}
	
	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.interpreter.Expression#interpreter(java.util.Map)
	 */
	@Override
	public int interpreter(Map<String, Expression> variables) {
		return leftOperant.interpreter(variables) + rightOperant.interpreter(variables);
	}

}
