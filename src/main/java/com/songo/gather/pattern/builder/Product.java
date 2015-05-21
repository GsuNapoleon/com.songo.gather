/**
 * 
 */
package com.songo.gather.pattern.builder;

import java.math.BigDecimal;

/**
 * <p>decription:</p>
 * <p>date:2014年10月11日 上午9:38:02</p>
 * @author gsu·napoleon
 */
public class Product extends AbstractProduct {

	private String name;
	private BigDecimal price;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
