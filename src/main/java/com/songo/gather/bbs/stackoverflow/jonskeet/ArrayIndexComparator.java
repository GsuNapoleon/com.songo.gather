/**
 * 
 */
package com.songo.gather.bbs.stackoverflow.jonskeet;

import java.util.Comparator;

/**
 * <p>
 * decription:
 * </p>
 * <p>
 * date:2014年4月28日 下午2:18:37
 * </p>
 * 
 * @author gsu·napoleon
 */
public class ArrayIndexComparator implements Comparator<Integer> {

	private final String[] arrays;

	public ArrayIndexComparator(String[] arrays) {
		this.arrays = arrays;
	}

	public Integer[] createIndex() {
		Integer[] indexs = new Integer[arrays.length];
		for (int i = 0; i < arrays.length; i++) {
			indexs[i] = i;
		}
		return indexs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Integer index1, Integer index2) {
		return arrays[index1].compareTo(arrays[index2]);
	}

}
