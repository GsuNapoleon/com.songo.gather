/**
 * 
 */
package org.apache.commons.collections4;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>decription:</p>
 * <p>date:2015年7月6日 上午10:14:34</p>
 * @author gsu·napoleon
 */
public class MapUtilsTest {

	private static final Logger logger = LoggerFactory.getLogger(MapUtilsTest.class);
	
	/**
	 * <p>decription:</p>
	 * <p>date:2015年7月6日 上午10:14:34</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		final Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < 10; i ++) {
			map.put("k_" + i, "v_" + i);
		}
		for (Entry<String, String> e : map.entrySet()) {
			logger.debug("fixed before:{key:{}, value:{}}", e.getKey(), e.getValue());
		}
		IterableMap<String, String> iter = MapUtils.fixedSizeMap(map);
		for (Entry<String, String> e : iter.entrySet()) {
			logger.debug("fixed after:{key:{}, value:{}}", e.getKey(), e.getValue());
		}
	}
	
	@Test
	public void testEquals() {
		Animals src1 = new Animals(1, "A");
		Animals target1 = new Animals(1, "A");
		Animals target2 = new Animals(2, "A");
		Animals target3 = new Animals(2, "B");
		Animals src2 = new Pig(1, "A");
		Animals target4 = new Pig(1, "A");
		Animals target5 = new Pig(2, "A");
		Animals target6 = new Pig(2, "B");
		Pig src3 = new Pig(1, "A");
		logger.debug("src1 equals target1 is result: {{}}", src1.equals(target1));
		logger.debug("src1 equals target2 is result: {{}}", src1.equals(target2));
		logger.debug("src1 equals target3 is result: {{}}", src1.equals(target3));
		logger.debug("src1 equals src2 is result: {{}}", src1.equals(src2));
		logger.debug("src1 equals src3 is result: {{}}", src1.equals(src3));
		logger.debug("src1 equals src3 is result: {{}}", src1.equals(src3));
	}

}

class Animals {
	
	private Integer code;
	private String name;
	
	public Animals(int code, String name) {
		this.code = code;
	}

	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Animals)) {
			return false;
		}
		Animals target = (Animals) obj;
		return StringUtils.equals(this.name, target.name) 
				&& NumberUtils.compare(this.code, target.code) == 0;
	}
	
}

class Pig extends Animals {

	/**
	 * @param code
	 */
	public Pig(int code, String name) {
		super(code, name);
	}
	
}

