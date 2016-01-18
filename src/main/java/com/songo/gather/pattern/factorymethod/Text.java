/**
 * 
 */
package com.songo.gather.pattern.factorymethod;

/**
 * <p>decription:</p>
 * <p>date:2015年10月15日 上午10:31:43</p>
 * @author gsu·napoleon
 */
public class Text {

	/**
	 * <p>decription:</p>
	 * <p>date:2015年10月15日 上午10:31:43</p>
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		Entity entity = EntityFactory.create(args.length > 0 ? args[0] : null);
		System.out.println(entity.getSymbol());
	}

}
