/**
 * 
 */
package com.songo.gather.pattern.factorymethod;

/**
 * <p>decription:</p>
 * <p>date:2015年10月15日 上午10:28:19</p>
 * @author gsu·napoleon
 */
public class DefaultEntity implements Entity {

	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.factorymethod.Entity#getSymbol()
	 */
	@Override
	public String getSymbol() {
		return "Default";
	}

}
