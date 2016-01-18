/**
 * 
 */
package com.songo.gather.pattern.factorymethod;

import org.apache.commons.lang3.StringUtils;

/**
 * <p>decription:</p>
 * <p>date:2015年10月15日 上午10:26:53</p>
 * @author gsu·napoleon
 */
public class EntityFactory {

	public static Entity create(String name) {
		
		if (StringUtils.equals("His", name)) {
			return new History();
		} else if (StringUtils.equals("Geo", name)) {
			return new Geography();
		} else if (StringUtils.equals("Bio", name)) {
			return new Biological();
		} else {
			return new DefaultEntity();
		}
 		
	}
	
}
