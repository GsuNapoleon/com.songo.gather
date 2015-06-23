/**
 * 
 */
package com.songo.gather.pattern.interpreter;

import java.util.Map;

/**
 * <p>decription:</p>
 * <p>date:2015年6月12日 下午4:52:56</p>
 * @author gsu·napoleon
 */
public class Multi implements Expression {
	
	private final Expression leftOperand;
	private final Expression rightOperand;
	
	public Multi(Expression leftOperand, Expression rightOperand) {
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}

	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.interpreter.Expression#interpreter(java.util.Map)
	 */
	@Override
	public int interpreter(Map<String, Expression> variables) {
		return leftOperand.interpreter(variables) * rightOperand.interpreter(variables);
	}

}
