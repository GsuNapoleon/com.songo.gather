/**
 * 
 */
package com.songo.gather.pattern.builder;

/**
 * <p>decription:</p>
 * <p>date:2014年10月11日 上午9:46:43</p>
 * @author gsu·napoleon
 */
public class Director {

	private Builder builder;
	
	public AbstractProduct builder() {
		builder = new ConcreteBuilder();
		builder.builderName();
		builder.builderPrice();
		return this.builder.getResult();
	}

}
