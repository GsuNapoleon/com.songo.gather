/**
 * 
 */
package com.songo.gather.bbs.stackoverflow.peterlawrey;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * <p>decription:how do I get a unique ID per object in Java?</p>
 * <p>date:2014年6月18日 下午12:15:23</p>
 * @author gsu·napoleon
 */
public class UniqueID {

	private static final AtomicLong NEXT_ID = new AtomicLong(1);
	
	public long getId() {
		return NEXT_ID.getAndIncrement();
	}
	
	private static final Map<Object, Long> registry = new IdentityHashMap<Object, Long>();
	private static long nextId = 0;
	
	public static long idFor(Object o) {
		Long id = registry.get(o);
		if (id == null) {
			id = nextId ++;
			registry.put(o, id);
		}
		return id;
	}
	
	public static void idRemove(Object o) {
		registry.remove(o);
	}
	
	/**
	 * <p>decription:</p>
	 * <p>date:2014年6月18日 下午12:15:23</p>
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		UniqueID uid = new UniqueID();
		System.out.println(uid.getId());
		System.out.println(uid.getId());
		System.out.println(uid.getId());
		System.out.println(idFor(1));
		System.out.println(idFor(2));
		System.out.println(idFor(3));
	}

}
