/**
 * 
 */
package com.songo.gather.pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

import com.songo.gather.pattern.strategy.Strategy;

/**
 * <p>decription:</p>
 * <p>date:2015年6月12日 上午9:05:36</p>
 * @author gsu·napoleon
 */
public class Menus {

	private Map<String, CoffeeFlavour> flavours = new HashMap<String, CoffeeFlavour>();
	private Map<Long, Strategy> strategies = new HashMap<Long, Strategy>();
	
	public CoffeeFlavour lookup(String flavourName) {
		
		if (!flavours.containsKey(flavourName)) {
			flavours.put(flavourName, new CoffeeFlavour(flavourName));
		}
		
		return flavours.get(flavourName);
	}
	
	public int totalCoffeeFlavoursMade() {
		return flavours.size();
	}
	
	public Strategy lookup(Long sequence, Strategy strategy) {
		if (!strategies.containsKey(sequence)) {
			strategies.put(sequence, strategy);
		}
		
		return strategies.get(sequence);
	}
	
}
