/**
 * 
 */
package com.songo.gather.pattern.visitor;

/**
 * <p>decription:</p>
 * <p>date:2015年6月11日 上午10:25:05</p>
 * @author gsu·napoleon
 */
public interface CarElement {

	void accept(CarElementVisitor visitor);
	
}
