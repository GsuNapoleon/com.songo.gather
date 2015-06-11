/**
 * 
 */
package com.songo.gather.pattern.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>decription:</p>
 * <p>date:2015年6月11日 上午10:55:53</p>
 * @author gsu·napoleon
 */
public class CarElementPrintVisitor implements CarElementVisitor {

	private static final Logger logger = LoggerFactory.getLogger(CarElementPrintVisitor.class);
	
	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.visitor.CarElementVisitor#visit(com.songo.gather.pattern.visitor.Wheel)
	 */
	@Override
	public void visit(Wheel wheel) {
		logger.error("out stream Wheel seq is [{}]", 9);
	}

	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.visitor.CarElementVisitor#visit(com.songo.gather.pattern.visitor.Engine)
	 */
	@Override
	public void visit(Engine engine) {
		logger.error("out stream Engine seq is [{}]", 99);
	}

	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.visitor.CarElementVisitor#visit(com.songo.gather.pattern.visitor.Body)
	 */
	@Override
	public void visit(Body body) {
		logger.error("out stream Body seq is [{}]", 999);
	}

	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.visitor.CarElementVisitor#visit(com.songo.gather.pattern.visitor.Car)
	 */
	@Override
	public void visit(Car car) {
		logger.error("out stream Car seq is [{}]", 9999);
	}

}
