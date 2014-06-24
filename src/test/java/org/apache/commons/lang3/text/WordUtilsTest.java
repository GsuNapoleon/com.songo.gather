/**
 * 
 */
package org.apache.commons.lang3.text;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>decription:</p>
 * <p>date:2014年6月23日 下午2:43:18</p>
 * @author gsu·napoleon
 */
public class WordUtilsTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年6月23日 下午2:43:18</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		String html = "<table>\n"
				+ "  <tr>\n"
				+ "    <td>aaaa</td>\n"
				+ "    <td>aaaa</td>\n"
				+ "    <td>aaaa</td>\n"
				+ "  </tr>\n"
				+ "</table>\n";
		System.out.println(html);		
		String s = WordUtils.wrap(html, 15, "\t", true);
		System.out.println(s);
	}
	
	@Test
	public void testSwapCase() {
		String strr = "Allen Iverson";
		String str = WordUtils.swapCase(strr);
		System.out.println(str);
	}

	@Test
	public void testCapitalize() {
		String strr = "I AM FINE";
		String str = WordUtils.capitalize(strr);
		System.out.println(str);
		String strr1 = "i am fine and the thanks";
		String str1 = WordUtils.capitalizeFully(strr1);
		System.out.println(str1);
	}
	
}
