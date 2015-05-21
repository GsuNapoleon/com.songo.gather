/**
 * 
 */
package com.songo.gather.pattern.builder;

/**
 * <p>decription:</p>
 * <p>date:2014年10月11日 上午9:37:52</p>
 * @author gsu·napoleon
 */
public interface Builder {

	void builderName();
	
	void builderPrice();
	
	AbstractProduct getResult();
}
