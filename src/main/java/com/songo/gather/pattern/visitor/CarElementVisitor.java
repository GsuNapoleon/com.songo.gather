/**
 * 
 */
package com.songo.gather.pattern.visitor;

/**
 * <p>decription:</p>
 * <p>date:2015年6月11日 上午10:24:07</p>
 * @author gsu·napoleon
 */
public interface CarElementVisitor {
	
	void visit(Wheel wheel);
	
    void visit(Engine engine);
    
    void visit(Body body);
    
    void visit(Car car);
    
}
