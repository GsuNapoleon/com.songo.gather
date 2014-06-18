/**
 * 
 */
package com.songo.gather.bbs.stackoverflow.peterlawrey;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>decription:How can an Integer be added to a String ArrayList?</p>
 * <p>date:2014年6月18日 下午2:01:52</p>
 * @author gsu·napoleon
 */
public class IntegerBeAddedToStringArrayList {
	
	public static void interest() {
		List<String> strings = new ArrayList<String>();
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<Integer> ints = (List) strings;
		ints.add(1);

		System.out.println(strings); // ok
		String s= strings.get(0); // throws a ClassCastException
		System.out.println(s);
	}
	
	public static void commons() {
		List<Integer> list = new ArrayList<Integer>() ;
		list.add(1) ;
		Integer hello = list.get(0); // generics add an implicit cast here
		System.out.println(hello);
	}

	public static void main(String[] args) {
		commons();
		interest();
	}
	
}
