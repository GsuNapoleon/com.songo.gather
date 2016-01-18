/**
 * 
 */
package com.songo.gather.pattern.decorator;

import com.songo.gather.pattern.absfactorymethod.Circle;
import com.songo.gather.pattern.absfactorymethod.Shape;
import com.songo.gather.pattern.absfactorymethod.Square;

/**
 * <p>decription:</p>
 * <p>date:2015年10月15日 上午11:44:08</p>
 * @author gsu·napoleon
 */
public class Demo {

	/**
	 * <p>decription:</p>
	 * <p>date:2015年10月15日 上午11:44:08</p>
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		Shape circle = new Circle();
		ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
		ShapeDecorator redSquare = new RedShapeDecorator(new Square());
		
		circle.draw();
		redCircle.draw();
		redSquare.draw();
	}

}
