/**
 * 
 */
package com.songo.gather.pattern.absfactorymethod;

import org.apache.commons.lang3.StringUtils;

/**
 * <p>decription:</p>
 * <p>date:2015年10月15日 上午10:58:28</p>
 * @author gsu·napoleon
 */
public class ColorFactory extends AbstractFactory {

	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.absfactorymethod.AbstractFactory#getColor(java.lang.String)
	 */
	@Override
	public Color getColor(String color) {
		
		if (StringUtils.equalsIgnoreCase(color, "R")) {
			return new Red();
		} else if (StringUtils.equalsIgnoreCase(color, "G")) {
			return new Green();
		} else if (StringUtils.equalsIgnoreCase(color, "B")) {
			return new Blue();
		} else {
			return null;
		}
		
	}

	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.absfactorymethod.AbstractFactory#getShape(java.lang.String)
	 */
	@Override
	public Shape getShape(String shape) {
		return null;
	}

}
