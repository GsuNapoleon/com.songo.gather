/**
 * 
 */
package com.songo.gather.web.filter;

import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.HtmlUtils;

/**
 * <p>decription:</p>
 * <p>date:2015年7月9日 下午4:07:19</p>
 * @author gsu·napoleon
 */
public class MyXSSFilter {
	
	private static final Logger logger = LoggerFactory.getLogger(MyXSSFilter.class);

	public static String filter(String src) {
		String s = StringEscapeUtils.escapeEcmaScript(src);
		logger.debug("{src:{}, result:{}}", src, s);
		return s;
	}

	public static String htmlFilter(String src) {
		String s = HtmlUtils.htmlEscape(src);
		logger.debug("{src:{}, result:{}}", src, s);
		return s;
	}
	
}
