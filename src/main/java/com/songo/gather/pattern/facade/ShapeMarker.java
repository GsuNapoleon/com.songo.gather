/**
 * 
 */
package com.songo.gather.pattern.facade;

import com.songo.gather.pattern.absfactorymethod.Circle;
import com.songo.gather.pattern.absfactorymethod.Rectangle;
import com.songo.gather.pattern.absfactorymethod.Shape;
import com.songo.gather.pattern.absfactorymethod.Square;

/**
 * <p>decription:</p>
 * <p>date:2015年10月15日 上午11:21:32</p>
 * @author gsu·napoleon
 */
public class ShapeMarker {

	private Shape circle;
	private Shape square;
	private Shape rectangle;
	
	public ShapeMarker() {
		this.circle = new Circle();
		this.square = new Square();
		this.rectangle = new Rectangle();
	}
	
	public void drawCircle() {
		this.circle.draw();
	}
	
	public void drawSquare() {
		this.square.draw();
	}
	
	public void drawRectangle() {
		this.rectangle.draw();
	}
	
}
