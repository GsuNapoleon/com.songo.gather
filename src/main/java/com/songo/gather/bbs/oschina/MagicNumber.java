/**
 * 
 */
package com.songo.gather.bbs.oschina;

import java.lang.reflect.Field;

/**
 * <p>decription:</p>
 * <p>date:2014年6月23日 下午6:03:45</p>
 * @author gsu·napoleon
 */
public class MagicNumber {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年6月23日 下午6:03:45</p>
	 * @author gsu·napoleon
	 * @param args
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public static void main(String[] args) throws Exception {
		Class cache = Integer.class.getDeclaredClasses()[0];
        Field c = cache.getDeclaredField("cache");
        c.setAccessible(true);
        Integer[] array = (Integer[]) c.get(cache);
        array[132] = array[133];
        System.out.printf("%d",2 + 2);

	}

}
