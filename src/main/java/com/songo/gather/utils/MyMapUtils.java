/**
 * 
 */
package com.songo.gather.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections4.MapUtils;

/**
 * <p>decription:</p>
 * <p>date:2015年7月1日 下午2:45:37</p>
 * @author gsu·napoleon
 */
public final class MyMapUtils {

	public static List<Map.Entry<String, Long>> sortByValue(Map<String, Long> data, boolean isAsc) {
		List<Map.Entry<String, Long>> list=new ArrayList<Map.Entry<String, Long>>();  
        list.addAll(data.entrySet());
		Collections.sort(list, new LongCompartor(isAsc));
		return list;
	}
	
	/**
	 * 
	 * <p>decription:默认按升序(ASC)排序</p>
	 * <p>date:2015年7月7日 上午10:56:36</p>
	 * @author gsu·napoleon
	 * @param data
	 * @param isAsc
	 * @return
	 */
	public static List<Map.Entry<Object, Object>> sorts(Map<Object, Object> data) {
		return sorts(data, true, false);
	}
	
	/**
	 * 
	 * <p>decription:默认按value排序</p>
	 * <p>date:2015年7月7日 上午10:56:36</p>
	 * @author gsu·napoleon
	 * @param data
	 * @param isAsc
	 * @return
	 */
	public static List<Map.Entry<Object, Object>> sorts(Map<Object, Object> data, boolean isAsc) {
		return sorts(data, isAsc, false);
	}
	
	/**
	 * 
	 * <p>decription:</p>
	 * <p>date:2015年7月7日 下午2:01:21</p>
	 * @author gsu·napoleon
	 * @param data
	 * @param isAsc
	 * @param isKey
	 * @return		若<code>MapUtils.isEmpty(data)</code>成立,则返回不可操作的List
	 */
	public static List<Map.Entry<Object, Object>> sorts(Map<Object, Object> data, boolean isAsc, boolean isKey) {
		
		if (MapUtils.isEmpty(data)) {
			return Collections.unmodifiableList(new ArrayList<Map.Entry<Object,Object>>(0));
		}
		
		List<Map.Entry<Object, Object>> list = new ArrayList<Map.Entry<Object,Object>>();
		list.addAll(data.entrySet());
		Collections.sort(list, new MyComparator(isAsc, isKey));
		
		return list;
	}
	
}

class LongCompartor implements Comparator<Map.Entry<String, Long>> {
	
	private boolean isAsc;
	
	public LongCompartor(boolean isAsc) {
		this.isAsc = isAsc;
	}

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Entry<String, Long> o1, Entry<String, Long> o2) {
		return this.isAsc ? o1.getValue().compareTo(o2.getValue()) : o2.getValue().compareTo(o1.getValue());
	}
	
}