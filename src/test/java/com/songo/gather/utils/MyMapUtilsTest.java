/**
 * 
 */
package com.songo.gather.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * decription:
 * </p>
 * <p>
 * date:2015年7月1日 下午2:53:44
 * </p>
 * 
 * @author gsu·napoleon
 */
public class MyMapUtilsTest {

	private static final Logger logger = LoggerFactory
			.getLogger(MyMapUtilsTest.class);

	/**
	 * <p>
	 * decription:
	 * </p>
	 * <p>
	 * date:2015年7月1日 下午2:53:45
	 * </p>
	 * 
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Map<String, Long> data = getTestLongMap();
		logger.debug("测试<String, Long>的数据源：[{}]", data);
		List<Map.Entry<String, Long>> lists = MyMapUtils
				.sortByValue(data, true);
		logger.debug("测试<String, Long>的排序结果：<<{}>>", lists);
	}

	@Test
	public void testObjectByLong() {
		Map<Object, Object> data = getTestObjectLongMap();
		logger.debug("测试<Object, Object>中Object instanceof Long的数据源：[{}]", data);
		List<Map.Entry<Object, Object>> listsOfValue = MyMapUtils.sorts(data,
				false, false);
		logger.debug(
				"测试<Object, Object>中Object instanceof Long,按Value降序排序结果：<<{}>>",
				listsOfValue);
		List<Map.Entry<Object, Object>> listsOfKey = MyMapUtils.sorts(data,
				true, true);
		logger.debug(
				"测试<Object, Object>中Object instanceof Long,按Key升序排序结果：<<{}>>",
				listsOfKey);
	}

	@Test
	public void testObjectByString() {
		Map<Object, Object> data = getTestObjectStringMap();
		logger.debug("测试<Object, Object>中Object instanceof String的数据源：[{}]",
				data);
		List<Map.Entry<Object, Object>> listsOfValue = MyMapUtils.sorts(data,
				false, false);
		logger.debug(
				"测试<Object, Object>中Object instanceof String,按Value降序排序结果：<<{}>>",
				listsOfValue);
		List<Map.Entry<Object, Object>> listsOfKey = MyMapUtils.sorts(data,
				true, true);
		logger.debug(
				"测试<Object, Object>中Object instanceof String,按Key升序排序结果：<<{}>>",
				listsOfKey);
	}

	/**
	 * <p>
	 * decription:
	 * </p>
	 * <p>
	 * date:2015年7月7日 上午10:36:35
	 * </p>
	 * 
	 * @author gsu·napoleon
	 * @return
	 */
	private Map<String, Long> getTestLongMap() {
		Map<String, Long> data = new HashMap<String, Long>();
		data.put("1", 100L);
		data.put("3", 105L);
		data.put("2", 102L);
		data.put("9", 145L);
		data.put("5", 110L);
		data.put("6", 120L);
		data.put("8", 125L);
		data.put("7", 121L);
		data.put("4", 108L);
		return data;
	}

	/**
	 * <p>
	 * decription:
	 * </p>
	 * <p>
	 * date:2015年7月7日 上午10:36:35
	 * </p>
	 * 
	 * @author gsu·napoleon
	 * @return
	 */
	private Map<Object, Object> getTestObjectLongMap() {
		Map<Object, Object> data = new HashMap<Object, Object>();
		data.put("1", 100L);
		data.put("3", 105L);
		data.put("2", 102L);
		data.put("9", 145L);
		data.put("5", 110L);
		data.put("6", 120L);
		data.put("8", 125L);
		data.put("7", 121L);
		data.put("4", 108L);
		return data;
	}

	private Map<Object, Object> getTestObjectStringMap() {
		Map<Object, Object> data = new HashMap<Object, Object>();
		data.put("A", "aA");
		data.put("R", "Kl");
		data.put("E", "Fp");
		data.put("Q", "Hq");
		data.put("J", "Gr");
		data.put("O", "nV");
		data.put("D", "Cx");
		data.put("B", "zU");
		data.put("M", "It");
		return data;
	}
}
