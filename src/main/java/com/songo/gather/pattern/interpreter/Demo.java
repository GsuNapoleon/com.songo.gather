/**
 * 
 */
package com.songo.gather.pattern.interpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <p>decription:</p>
 * <p>date:2015年6月11日 上午11:42:42</p>
 * @author gsu·napoleon
 */
public class Demo {

	public static void test() {
		Stack<String> stack = new Stack<String>();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		System.err.println("1、pop = " + stack.pop());
		System.err.println("2、pop = " + stack.pop());
		System.err.println("3、pop = " + stack.pop());
		
	}
	
	/**
	 * <p>decription:5 + (3 + 4) * (2 + 3) = ?</p>
	 * <p>date:2015年6月11日 上午11:42:42</p>
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		String expression = "w x y * +";
		Expression evaluator = new Evaluator(expression);
		Map<String, Expression> context = new HashMap<String, Expression>();
		context.put("w", new Number(5));
		context.put("x", new Number(3 + 4));
		context.put("y", new Number(2 + 3));
		int result = evaluator.interpreter(context);
		System.err.println("result = " + result);
		
		test();
	}

}
