/**
 * 
 */
package com.songo.gather.pattern.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>decription:</p>
 * <p>date:2015年6月11日 上午10:56:58</p>
 * @author gsu·napoleon
 */
public class CarElementDoVisitor implements CarElementVisitor {
	
	private static final Logger logger = LoggerFactory.getLogger(CarElementDoVisitor.class);

	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.visitor.CarElementVisitor#visit(com.songo.gather.pattern.visitor.Wheel)
	 */
	@Override
	public void visit(Wheel wheel) {
		logger.error("Do Wheel seq is [{}]", 1);
	}

	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.visitor.CarElementVisitor#visit(com.songo.gather.pattern.visitor.Engine)
	 */
	@Override
	public void visit(Engine engine) {
		logger.error("Do Engine seq is [{}]", 11);
	}

	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.visitor.CarElementVisitor#visit(com.songo.gather.pattern.visitor.Body)
	 */
	@Override
	public void visit(Body body) {
		logger.error("Do Body seq is [{}]", 111);
	}

	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.visitor.CarElementVisitor#visit(com.songo.gather.pattern.visitor.Car)
	 */
	@Override
	public void visit(Car car) {
		logger.error("Do Car seq is [{}]", 1111);
	}

}
