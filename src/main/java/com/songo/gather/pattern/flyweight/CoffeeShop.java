/**
 * 
 */
package com.songo.gather.pattern.flyweight;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>decription:</p>
 * <p>date:2015年6月12日 上午9:13:36</p>
 * @author gsu·napoleon
 */
public class CoffeeShop {

	private static final Logger logger = LoggerFactory.getLogger(CoffeeShop.class);
	private final List<Order> orders = new CopyOnWriteArrayList<Order>();
	private final Menus menus = new Menus();
	
	public void takeOrder(String flavourName, int table) {
		CoffeeFlavour flavour = menus.lookup(flavourName);
		Order order = new Order(table, flavour);
		orders.add(order);
	}
	
	public void service() {
		for (Order order : orders) {
			order.server();
			orders.remove(order);
		}
	}
	
	public String report() {
		return "total CoffeeFlavour objects made : [" + menus.totalCoffeeFlavoursMade() + "]";
	}
	
	public static void main(String[] args) {
		CoffeeShop shop = new CoffeeShop();
		
		shop.takeOrder("Cappuccino", 2);
	    shop.takeOrder("Frappe", 1);
	    shop.takeOrder("Espresso", 1);
	    shop.takeOrder("Frappe", 897);
	    shop.takeOrder("Cappuccino", 97);
	    shop.takeOrder("Frappe", 3);
	    shop.takeOrder("Espresso", 3);
	    shop.takeOrder("Cappuccino", 3);
	    shop.takeOrder("Espresso", 96);
	    shop.takeOrder("Frappe", 552);
	    shop.takeOrder("Cappuccino", 121);
	    shop.takeOrder("Espresso", 121);
	 
	    shop.service();
	    
	    logger.info("Service Report : {{}}", shop.report());
	}
	
}
