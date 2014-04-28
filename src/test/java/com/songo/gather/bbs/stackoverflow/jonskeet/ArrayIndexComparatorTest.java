/**
 * 
 */
package com.songo.gather.bbs.stackoverflow.jonskeet;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>decription:</p>
 * <p>date:2014年4月28日 下午4:25:51</p>
 * @author gsu·napoleon
 */
public class ArrayIndexComparatorTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年4月28日 下午4:25:51</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test() {
		String[] arrays = { "France", "Spain", "France", "France", "Italy",
				"Spain", "Spain", "Italy" };

		ArrayIndexComparator comparator = new ArrayIndexComparator(arrays);
		Integer[] indexs = comparator.createIndex();
		Arrays.sort(indexs, comparator);
		for (Integer i : indexs) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
