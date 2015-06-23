/**
 * 
 */
package com.songo.gather.pattern.flyweight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>decription:</p>
 * <p>date:2015年6月12日 上午9:09:32</p>
 * @author gsu·napoleon
 */
public class Order {
	
	private static final Logger logger = LoggerFactory.getLogger(Order.class);
	
	private final int tableNumber;
	private final CoffeeFlavour flavour;
	
	public Order(int tableNumber, CoffeeFlavour flavour) {
		this.tableNumber = tableNumber;
		this.flavour = flavour;
	}
	
	public void server() {
		logger.info("Serving {{}} to table {{}}.", flavour, tableNumber);
	}

}
