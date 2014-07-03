/**
 * 
 */
package com.songo.gather.utils;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>decription:</p>
 * <p>date:2014年7月2日 下午3:25:53</p>
 * @author gsu·napoleon
 */
public class MapTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年7月2日 下午3:25:53</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testDescendingMap() {
		NavigableMap<String, String> map = new TreeMap<String, String>();
		map.descendingMap();
		for (Map.Entry<String, String> me : map.descendingMap().entrySet()) {
			me.getKey();
			me.getValue();
		}
	}

}
