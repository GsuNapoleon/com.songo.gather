/**
 * 
 */
package org.apache.commons.lang3.reflect;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>decription:</p>
 * <p>date:2014年6月23日 下午2:29:37</p>
 * @author gsu·napoleon
 */
public class FieldUtilsTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2014年6月23日 下午2:29:37</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		List<Field> fields = FieldUtils.getAllFieldsList(FieldTest.class);
		System.out.println(fields.toString());
		for (Field f : fields) {
			System.out.println(f.getName());
		}
	}

}
class FieldTest {
	
	private String id;
	private int age;
	private boolean isScreen;
	private List<String> lists;
	private Map<String, Object> maps;
	
}
