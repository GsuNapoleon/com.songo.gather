/**
 * 
 */
package com.songo.gather.pattern.interpreter;

import java.util.Map;
import java.util.Stack;

/**
 * <p>decription:</p>
 * <p>date:2015年6月11日 上午11:33:16</p>
 * @author gsu·napoleon
 */
public class Evaluator implements Expression {
	
	private Expression syntaxTree;
	
	public Evaluator(String expression) {
		Stack<Expression> stack = new Stack<Expression>();
		for (String token : expression.split(" ")) {
			if ("+".equals(token)) {
				Expression exp = new Plus(stack.pop(), stack.pop());
				stack.push(exp);
			} else if ("-".equals(token)) {
				Expression left = stack.pop();
				Expression right = stack.pop();
				Expression exp = new Minus(left, right);
				stack.push(exp);
			} else {
				stack.push(new Variable(token));
			}
		}
		this.syntaxTree = stack.pop();
	}

	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.interpreter.Expression#interpreter(java.util.Map)
	 */
	@Override
	public int interpreter(Map<String, Expression> variables) {
		return this.syntaxTree.interpreter(variables);
	}

}
