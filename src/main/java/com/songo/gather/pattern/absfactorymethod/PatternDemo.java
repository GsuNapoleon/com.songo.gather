/**
 * 
 */
package com.songo.gather.pattern.absfactorymethod;

/**
 * <p>decription:</p>
 * <p>date:2015年10月15日 上午10:45:36</p>
 * @author gsu·napoleon
 */
public class PatternDemo {

	/**
	 * <p>decription:</p>
	 * <p>date:2015年10月15日 上午10:45:36</p>
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
//		AbstractFactory shapeFactory = FactoryProducer.getFactory("S");
		AbstractFactory shapeFactory = new ShapeFactory();
		shapeFactory.getShape("C").draw();
		shapeFactory.getShape("S").draw();
		shapeFactory.getShape("R").draw();
//		AbstractFactory colorFactory = FactoryProducer.getFactory("C");
		AbstractFactory colorFactory = new ColorFactory();
		colorFactory.getColor("R").fill();
		colorFactory.getColor("B").fill();
		colorFactory.getColor("G").fill();
	}

}
