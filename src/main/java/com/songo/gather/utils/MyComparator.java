/**
 * 
 */
package com.songo.gather.utils;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.ObjectUtils;

public class MyComparator implements Comparator<Map.Entry<Object, Object>> {
	
	private boolean isAsc;
	private boolean isKey;
	
	
	public MyComparator(boolean isAsc, boolean isKey) {
		this.isAsc = isAsc;
		this.isKey = isKey;
	}
	
	public static MyComparator getDefaultInstance() {
		return new MyComparator(true, false);
	}

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Entry<Object, Object> o1, Entry<Object, Object> o2) {
		Object oo1 = isKey ? o1.getKey() : o1.getValue();
		Object oo2 = isKey ? o2.getKey() : o2.getValue();
		
		if (oo1 instanceof Integer) {
			return isAsc ? ObjectUtils.compare((Integer)oo1, (Integer)oo2) : ObjectUtils.compare((Integer)oo2, (Integer)oo1);
		} else if (oo1 instanceof String) {
			return isAsc ? ObjectUtils.compare((String)oo1, (String)oo2) : ObjectUtils.compare((String)oo2, (String)oo1);
		} else if (oo1 instanceof Long) {
			return isAsc ? ObjectUtils.compare((Long)oo1, (Long)oo2) : ObjectUtils.compare((Long)oo2, (Long)oo1);
		} else if (oo1 instanceof Boolean) {
			return isAsc ? ObjectUtils.compare((Boolean)oo1, (Boolean)oo2) : ObjectUtils.compare((Boolean)oo2, (Boolean)oo1);
		} else if (oo1 instanceof Float) {
			return isAsc ? ObjectUtils.compare((Float)oo1, (Float)oo2) : ObjectUtils.compare((Float)oo2, (Float)oo1);
		} else if (oo1 instanceof Double) {
			return isAsc ? ObjectUtils.compare((Double)oo1, (Double)oo2) : ObjectUtils.compare((Double)oo2, (Double)oo1);
		} else if (oo1 instanceof Byte) {
			return isAsc ? ObjectUtils.compare((Byte)oo1, (Byte)oo2) : ObjectUtils.compare((Byte)oo2, (Byte)oo1);
		} else if (oo1 instanceof Character) {
			return isAsc ? ObjectUtils.compare((Character)oo1, (Character)oo2) : ObjectUtils.compare((Character)oo2, (Character)oo1);
		} else {
			return -1;
		}
	}
}