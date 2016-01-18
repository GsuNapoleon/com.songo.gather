/**
 * 
 */
package com.songo.gather.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

/**
 * <p>decription:</p>
 * <p>date:2015年10月28日 上午9:42:58</p>
 * @author gsu·napoleon
 */
public final class MyRegularUtils {

	public static void main(String[] args) {
//		Pattern p = Pattern.compile("^" + "http://gm.(.*)(?!pconline).com.*");
//		Matcher m = p.matcher("http://gm.zhanyilu.com/tt/genxin/it.html");
//		System.out.println(m.find());
//		String cid = "1,2,3,4,5,";
//		System.out.println(StringUtils.substringBeforeLast(cid, ","));
//		JSONObject json = JSONObject.parseObject("{}");
//		JSONArray jsons = JSONArray.parseArray("[{\"sid\":1, \"cid\":\"1,2,3,4\"}, "
//				+ "{\"sid\":2, \"cid\":\"5,6,7,8\"}, {\"sid\":3, \"cid\":\"9,10,11,12\"}]");
//		for (int i = 0; i < jsons.size(); i ++) {
//			JSONObject j = jsons.getJSONObject(i);
//			System.out.println(j.getIntValue("sid") + " | " + j.get("cid"));
//		}
//		System.out.println(getChannel(1, true, "{}"));
//		System.out.println(getChannel(1, true, "[{}]"));
//		System.out.println(getChannel(1, true, "[{\"sid1\":1, \"cid1\":\"1,2,3,4\"}]"));
//		System.out.println(getChannel(1, true, "[{\"sid\":1, \"cid1\":\"1,2,3,4\"}]"));
//		System.out.println(getChannel(1, true, "[{\"sid1\":1, \"cid\":\"1,2,3,4\"}]"));
//		System.out.println(getChannel(1, true, "[{"sid\":1, \"cid\":\"1,2,3,4\"}]"));
		System.out.println(getChannel(1, true, "[{'sid':1, 'cid':'1,2,3,4'}]"));
//		System.out.println(getChannel(1, true, "[{\"sid\":1, \"cid\":\"\"}]"));
//		System.out.println(StringUtils.contains(null, ","));
//		System.out.println(StringUtils.contains("", ","));
//		System.out.println(StringUtils.contains("1", ","));
//		System.out.println(StringUtils.contains("1,2,3,4", ","));
		String cid = "1,2,3,4";
		System.out.println(StringUtils.endsWith(cid, ",") ?
				StringUtils.substringBeforeLast(cid, ",") : cid);
//		String cid1 = "1,2,3,4,";
//		System.out.println(StringUtils.endsWith(cid1, ",") ?
//				StringUtils.substringBeforeLast(cid1, ",") : cid1);
	}
	
	private static void getChannel(String channel) {
		
		if (StringUtils.isBlank(channel)) {
			System.out.println("操作异常");
			return;
		}
		
		if (StringUtils.contains(channel, ",")) {
			System.out.println("为单一栏目,可判断是否有");
			return;
		}
		
	}
	
	private static String getChannel(int sid, boolean isWap, String channels) {
		String channel = isWap ? "5284" : "1";
		if (StringUtils.isBlank(channels)) {
			System.out.println("直接获取各网站{pc|wap}的根栏目");
			return channel;
		}
		
		try {
			JSONArray jsonChannels = JSONArray.parseArray(channels);
			if (jsonChannels == null || jsonChannels.isEmpty()) {
				System.out.println("直接获取各网站{pc|wap}的根栏目");
				return channel;
			}
			for (int i = 0; i < jsonChannels.size(); i ++) {
				JSONObject jo = jsonChannels.getJSONObject(i);
				if (sid == jo.getIntValue("sid") && StringUtils.isNotBlank(jo.getString("cid"))) {
					System.out.println(jo.getIntValue("sid") + " | " + jo.get("cid"));
					return jo.getString("cid");
				}
			}
			return channel;
		} catch (JSONException e) {
			e.printStackTrace();
			System.out.println("直接获取各网站{pc|wap}的根栏目");
			return channel;
		}
		
	}
	
}
