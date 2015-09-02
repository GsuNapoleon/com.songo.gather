/**
 * 
 */
package com.songo.gather.web.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>decription:</p>
 * <p>date:2015年7月9日 下午4:48:46</p>
 * @author gsu·napoleon
 */
public class MyXSSFilterTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2015年7月9日 下午4:48:46</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		MyXSSFilter.filter("<script></script>");
		MyXSSFilter.htmlFilter("<script>document</script>");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("num", -1);
		param.put("name", "");
	    param.put("event_id", 62);
	    String eventIdStr = param != null && !param.isEmpty() && param.containsKey("event_id")
	    		? String.valueOf(param.get("event_id")) : "-1";
   		System.err.println(eventIdStr);
		long eventId = StringUtils.isNotBlank(eventIdStr) && StringUtils.isNumericSpace(eventIdStr)
                ? Long.valueOf(String.valueOf(param.get("event_id"))) : -1L;
        System.err.println(eventId);
        String sb = "select * from cnt_tag as ct "
                + "where exists(select tag_id from cnt_event_tag cet where ct.id=cet.tag_id "
                + (eventId > -1 ? "and cet.event_id=" + eventId : "") 
                + ")";
        System.err.println(sb);
	}

	@Test
	public void testSet() {
		Set<String> nullSet = new HashSet<String>();
		nullSet.add(null);
		nullSet.add("");
		nullSet.add("a");
		nullSet.add("b");
		nullSet.add("c");
		System.err.println(nullSet);
		for (String s : nullSet) {
			System.err.println(s);
		}
		List<String> nullList = new ArrayList<String>();
		nullList.add(null);
	}
	
}
