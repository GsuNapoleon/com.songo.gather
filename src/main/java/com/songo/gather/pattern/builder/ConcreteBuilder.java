/**
 * 
 */
package com.songo.gather.pattern.builder;

import java.math.BigDecimal;

/**
 * <p>decription:</p>
 * <p>date:2014年10月11日 上午9:39:50</p>
 * @author gsu·napoleon
 */
public class ConcreteBuilder implements Builder {
	
	private Product product;

	public ConcreteBuilder() {
		this.product = new Product();
	}
	
	public ConcreteBuilder(Product _product) {
		this.product = _product;
	}
	
	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.builder.Builder#builderName()
	 */
	@Override
	public void builderName() {
		product.setName("香烟_黄鹤楼");
	}

	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.builder.Builder#builderPrice()
	 */
	@Override
	public void builderPrice() {
		product.setPrice(new BigDecimal(200.00d));
	}

	/* (non-Javadoc)
	 * @see com.songo.gather.pattern.builder.Builder#getResult()
	 */
	@Override
	public AbstractProduct getResult() {
		return this.product;
	}
	
}
