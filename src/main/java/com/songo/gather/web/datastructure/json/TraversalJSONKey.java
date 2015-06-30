/**
 * 
 */
package com.songo.gather.web.datastructure.json;

import java.util.Set;

import com.alibaba.fastjson.JSONObject;

/**
 * <p>decription:</p>
 * <p>date:2015年6月24日 上午9:14:42</p>
 * @author gsu·napoleon
 */
public class TraversalJSONKey {

	public void traversal(JSONObject json) {
		if (json == null || json.isEmpty()) {
			return;
		}
		Set<String> keys = json.keySet();
		for (String key : keys) {
			System.err.println("key = " + key);
		}
	}
	
}
