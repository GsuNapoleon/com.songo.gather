/**
 * 
 */
package com.songo.gather.bbs.stackoverflow.peterlawrey;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>decription:</p>
 * <p>date:2014年6月18日 下午12:31:21</p>
 * @author gsu·napoleon
 */
public class ParseStringIntoMap {
	
	public Map<String, String> parse() {
		String keyStrs = "A=B&C=D&E=F";
		Map<String, String> linkedMap = new LinkedHashMap<String, String>();
		for (String keyValue : keyStrs.split(" *& *")) {
			String[] pairs = keyValue.split(" *= *", 2);
			linkedMap.put(pairs[0], pairs.length == 1 ? "" : pairs[1]);
		}
		return linkedMap;
	}

	/**
	 * <p>decription:</p>
	 * <p>date:2014年6月18日 下午12:31:21</p>
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		ParseStringIntoMap psim = new ParseStringIntoMap();
		psim.parse();
	}

}
