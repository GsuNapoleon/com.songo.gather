/**
 * 
 */
package com.songo.gather.pattern.decorator;

import com.songo.gather.pattern.absfactorymethod.Shape;

/**
 * <p>decription:</p>
 * <p>date:2015年10月15日 上午11:37:09</p>
 * @author gsu·napoleon
 */
public abstract class ShapeDecorator implements Shape {

	protected Shape decoratorShape;
	
	public ShapeDecorator(Shape decoratorShape) {
		this.decoratorShape = decoratorShape;
	}

	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.absfactorymethod.Shape#draw()
	 */
	@Override
	public void draw() {
		this.decoratorShape.draw();
	}
	
}
