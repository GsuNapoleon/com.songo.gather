/**
 * 
 */
package com.songo.gather.pattern.absfactorymethod;

import org.apache.commons.lang3.StringUtils;

/**
 * <p>decription:</p>
 * <p>date:2015年10月15日 上午10:55:29</p>
 * @author gsu·napoleon
 */
public class ShapeFactory extends AbstractFactory {

	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.absfactorymethod.AbstractFactory#getColor(java.lang.String)
	 */
	@Override
	public Color getColor(String color) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.absfactorymethod.AbstractFactory#getShape(java.lang.String)
	 */
	@Override
	public Shape getShape(String shape) {
		if (StringUtils.equalsIgnoreCase(shape, "C")) {
			return new Circle();
		} else if (StringUtils.equalsIgnoreCase(shape, "S")) {
			return new Square();
		} else if (StringUtils.equalsIgnoreCase(shape, "R")) {
			return new Rectangle();
		} else {
			return null;
		}
	}

}
