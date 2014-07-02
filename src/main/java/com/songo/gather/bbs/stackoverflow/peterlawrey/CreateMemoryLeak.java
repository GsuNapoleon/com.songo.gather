/**
 * 
 */
package com.songo.gather.bbs.stackoverflow.peterlawrey;

import java.util.Map;

/**
 * <p>decription:创建一个内存泄漏的小程序</p>
 * <p>The application creates a long-running thread (or use a thread pool to leak even faster).
 * <p>The thread loads a class via an (optionally custom) ClassLoader.
 * <p>The class allocates a large chunk of memory (e.g. new byte[1000000]), stores a strong reference to it in a static field, and then stores a reference to itself in a ThreadLocal. Allocating the extra memory is optional (leaking the Class instance is enough), but it will make the leak work that much faster.
 * <p>The thread clears all references to the custom class or the ClassLoader it was loaded from.
 * <p>Repeat.
 * <p>date:2014年6月30日 上午9:59:50</p>
 * @author gsu·napoleon
 */
public class CreateMemoryLeak {

	public static void main(String[] args) {
		Map<Object, Object> m = System.getProperties();
		m.put(new BadKey("key"), "value");
	}
	
}
class BadKey {
	// no hashCode(),no equals()
	public final String key;
	
	public BadKey(String _key) {
		this.key = _key;
	}
}
