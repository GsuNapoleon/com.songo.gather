/**
 * 
 */
package com.songo.gather.pattern.absfactorymethod;

/**
 * <p>decription:</p>
 * <p>date:2015年10月15日 上午10:50:33</p>
 * @author gsu·napoleon
 */
public class Rectangle implements Shape {

	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.absfactorymethod.Shape#draw()
	 */
	@Override
	public void draw() {
		System.err.println("Shape : draw is Rectangle, to do!");
	}

}
