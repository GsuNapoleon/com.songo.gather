/**
 * 
 */
package com.songo.gather.pattern.interpreter;

import java.util.Map;

/**
 * <p>decription:</p>
 * <p>date:2015年6月11日 上午11:17:21</p>
 * @author gsu·napoleon
 */
public interface Expression {

	int interpreter(Map<String, Expression> variables);
	
}
