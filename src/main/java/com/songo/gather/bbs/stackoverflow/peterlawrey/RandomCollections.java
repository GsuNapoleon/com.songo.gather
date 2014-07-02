/**
 * 
 */
package com.songo.gather.bbs.stackoverflow.peterlawrey;

import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

/**
 * <p>decription:</p>
 * <p>date:2014年6月30日 上午10:19:02</p>
 * @author gsu·napoleon
 */
public class RandomCollections<V> {

	private final NavigableMap<Double, V> navigableMap = new TreeMap<Double, V>();
	private final Random random;
	private double totals;
	
	public RandomCollections() {
		this(new Random());
	}
	
	public RandomCollections(Random random) {
		this.random = random;
	}
	
	public void add(double weight, V v) {
		if (weight < 0) {
			return;
		}
		totals += weight;
		navigableMap.put(totals, v);
	}
	
	public V get() {
		double key = random.nextDouble() * totals;
		return navigableMap.ceilingEntry(key).getValue();
	}
}
