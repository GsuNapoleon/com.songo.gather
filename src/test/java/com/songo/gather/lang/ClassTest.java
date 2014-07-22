/**
 * 
 */
package com.songo.gather.lang;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>decription:</p>
 * <p>date:2014年7月17日 上午9:25:16</p>
 * @author gsu·napoleon
 */
public class ClassTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年7月17日 上午9:25:16</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		boolean b1 = AbsT.class.isAssignableFrom(T.class);
		System.out.println(b1);
		boolean b2 = IT.class.isAssignableFrom(T.class);
		System.out.println(b2);
		boolean b3 = T.class.isAssignableFrom(T.class);
		System.out.println(b3);
		boolean b4 = AbsT.class.isAssignableFrom(Tt.class);
		System.out.println(b4);
		boolean b5 = IT.class.isAssignableFrom(AbsTt.class);
		System.out.println(b5);
	}

}
interface IT {}
abstract class AbsT {}
class T extends AbsT implements IT {}
abstract class AbsTt implements IT {}
class Tt extends AbsT {}
