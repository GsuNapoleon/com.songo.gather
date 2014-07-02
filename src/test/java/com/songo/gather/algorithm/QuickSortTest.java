/**
 * 
 */
package com.songo.gather.algorithm;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>decription:</p>
 * <p>date:2014年6月27日 上午10:15:47</p>
 * @author gsu·napoleon
 */
public class QuickSortTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年6月27日 上午10:15:47</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		int [] sorts = {850, 801, 500, 946, 798, 575, 128, 83, 929, 458, 491, 960, 830, 618, 314};
		QuickSort quickSort = new QuickSort();
		quickSort.sorts(sorts, 0, sorts.length - 1);
		for (int i : sorts) {
			System.out.println(i);
		}
	}

}
