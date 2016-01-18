/**
 * 
 */
package com.songo.gather.pattern.decorator;

import com.songo.gather.pattern.absfactorymethod.Shape;

/**
 * <p>decription:</p>
 * <p>date:2015年10月15日 上午11:40:00</p>
 * @author gsu·napoleon
 */
public class RedShapeDecorator extends ShapeDecorator {

	/**
	 * @param decoratorShape
	 */
	public RedShapeDecorator(Shape decoratorShape) {
		super(decoratorShape);
	}

	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.decorator.ShapeDecorator#draw()
	 */
	@Override
	public void draw() {
		decoratorShape.draw();
		setRedBorder(decoratorShape);
	}
	
	private void setRedBorder(Shape shape) {
		System.out.println("Red Decorator!");
	}

}
