/**
 * 
 */
package com.songo.gather.pattern.absfactorymethod;

import org.apache.commons.lang3.StringUtils;

/**
 * <p>decription:</p>
 * <p>date:2015年10月15日 上午10:46:25</p>
 * @author gsu·napoleon
 */
public class FactoryProducer {

	public static AbstractFactory getFactory(String choice) {
		if (StringUtils.equalsIgnoreCase(choice, "S")) {
			return new ShapeFactory();
		} else if (StringUtils.equalsIgnoreCase(choice, "C")) {
			return new ColorFactory();
		}
		return null;
	}
	
}
