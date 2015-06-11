/**
 * 
 */
package com.songo.gather.pattern.visitor;

/**
 * <p>decription:</p>
 * <p>date:2015年6月11日 上午10:53:54</p>
 * @author gsu·napoleon
 */
public class Engine implements CarElement {

	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.visitor.CarElement#accept(com.songo.gather.pattern.visitor.CarElementVisitor)
	 */
	@Override
	public void accept(CarElementVisitor visitor) {
		visitor.visit(this);
	}

}
