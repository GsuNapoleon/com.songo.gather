/**
 * 
 */
package com.songo.gather.bbs.stackoverflow.jonskeet;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/**
 * <p>decription:HashMap with multiple values under the same key.</p>
 * <p>date:2014年4月24日 下午4:09:01</p>
 * @author gsu·napoleon
 */
public class AboutMultiMap {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年4月24日 下午4:09:01</p>
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		doMultiMap();
		doMap();
		
	}

	/**
	 * <p>decription:</p>
	 * <p>date:2014年4月24日 下午4:25:19</p>
	 * @author gsu·napoleon
	 */
	private static void doMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", "K");
		map.put("key", "F");
		map.put("key", "C");
		Collection<String> nvalues = map.values();
		for (String s : nvalues) {
			System.out.println(s);
		}
	}

	/**
	 * <p>decription:</p>
	 * <p>date:2014年4月24日 下午4:25:05</p>
	 * @author gsu·napoleon
	 */
	private static void doMultiMap() {
		Multimap<String, String> multimap = HashMultimap.create();
		multimap.put("key", "K");
		multimap.put("key", "F");
		multimap.put("key", "C");
		Collection<String> values = multimap.values();
		for (String s : values) {
			System.out.println(s);
		}
	}

}
