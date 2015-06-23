/**
 * 
 */
package com.songo.gather.pattern.flyweight;

/**
 * <p>decription:</p>
 * <p>date:2015年6月12日 上午9:02:51</p>
 * @author gsu·napoleon
 */
public class CoffeeFlavour {

	private final String name;
	
	public CoffeeFlavour(String newFlavour) {
		this.name = newFlavour;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Coffee Flavour : ['name' : " + this.name + "]";
	}
	
}
