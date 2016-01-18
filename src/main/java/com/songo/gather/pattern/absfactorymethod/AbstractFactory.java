/**
 * 
 */
package com.songo.gather.pattern.absfactorymethod;

/**
 * <p>decription:</p>
 * <p>date:2015年10月15日 上午10:48:32</p>
 * @author gsu·napoleon
 */
public abstract class AbstractFactory {

	public abstract Color getColor(String color);
	public abstract Shape getShape(String shape);
	
}
