/**
 * 
 */
package com.songo.gather.weixin.qy.http;

import java.text.MessageFormat;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.songo.gather.utils.MyStringUtils;
import com.songo.gather.weixin.HttpApi;
import com.songo.gather.weixin.qy.utils.DevApp;

/**
 * <p>
 * decription:
 * </p>
 * <p>
 * date:2015年5月7日 上午11:25:32
 * </p>
 * 
 * @author gsu·napoleon
 */
public final class HttpRequest {

	private static final Logger logger = LoggerFactory.getLogger(HttpRequest.class);
	
	private HttpRequest() {
	}

	public static String getAccessToken() {
		String requestURL = messageFormat(DevApp.API_GET_ACCESS_TOKEN, 
				DevApp.APP_CORP_ID.getValue(),
				DevApp.APP_CORP_SECRET.getValue());
		String result = StringUtils.isNotEmpty(requestURL) ? HttpApi.get( 
				requestURL, DevApp.UTF_8.getValue()) : msgRequestURLIsNull();
		JSONObject json = stringToJSONObject(result);
		
		logger.info("获取access_token时,返回的消息：{}", json.toJSONString());		
				
		return getValueByKey(json, "access_token");
	}

	public static boolean isSecondaryVerification(String accessToken, String userid) {
		
		if (StringUtils.isEmpty(accessToken) || StringUtils.isEmpty(userid)) {
			return false;
		}
		
		String requestURL = messageFormat(DevApp.API_GET_USE_AUTHSUCC, accessToken, userid);
		
		String result = StringUtils.isNotEmpty(requestURL) 
				? HttpApi.get(requestURL, DevApp.UTF_8.getValue())
				: msgRequestURLIsNull();
		JSONObject json = stringToJSONObject(result);
		logger.info("二次验证用户信息时,返回的消息：{}", json.toJSONString());
		
		return "ok".equals(getValueByKey(json, "errcode"));
	}

	/**
	 * {
		   "errcode": 0,
		   "errmsg": "ok",
		   "userid": "zhangsan",
		   "name": "李四",
		   "department": [1, 2],
		   "position": "后台工程师",
		   "mobile": "15913215421",
		   "email": "zhangsan@gzdev.com",
		   "weixinid": "lisifordev",  
		   "avatar": "http://wx.qlogo.cn/mmopen/ajNVdqHZLLA3WJ6DSZUfiakYe37PKnQhBIeOQBO4czqrnZDS79FH5Wm5m4X69TBicnHFlhiafvDwklOpZeXYQQ2icg/0",
		   "status": 1,
		   "extattr": {"attrs":[{"name":"爱好","value":"旅游"},{"name":"卡号","value":"1234567234"}]}
		}
	 * <p>decription:获取用户信息</p>
	 * <p>status-关注状态: 1=已关注，2=已冻结，4=未关注</p>
	 * <p>date:2015年5月7日 下午4:11:10</p>
	 * @author gsu·napoleon
	 * @param accessToken
	 * @param userid
	 * @return
	 */
	public static JSONObject getUserInfo(String accessToken, String userid) {
		
		if (StringUtils.isEmpty(accessToken) || StringUtils.isEmpty(userid)) {
			return new JSONObject(0);
		}
		
		String requestURL = messageFormat(DevApp.API_GET_USER_INFO, accessToken, userid);
		
		String result = StringUtils.isNotEmpty(requestURL) 
				? HttpApi.get(requestURL, DevApp.UTF_8.getValue())
				: msgRequestURLIsNull();
		
		return stringToJSONObject(result);
	}
	
	/**
	 * {
		   "errcode": 0,
		   "errmsg": "ok",
		   "userlist": [
		           {
		                  "userid": "zhangsan",
		                  "name": "李四"
		           }
		     ]
		}
	 * <p>decription:获取部门成员的基本信息列表</p>
	 * <p>date:2015年5月7日 下午4:27:47</p>
	 * @author gsu·napoleon
	 * @param accessToken
	 * @param departmentId
	 * @param fetchChild	1/0：是否递归获取子部门下面的成员.
	 * @param status		0获取全部成员,1获取已关注成员列表,2获取禁用成员列表,4获取未关注成员列表.status可叠加
	 * @return
	 */
	public static JSONObject getUserInfoList(boolean isSimple, String accessToken, 
			String departmentId, String fetchChild, String status) {
		
		if (StringUtils.isEmpty(accessToken) || StringUtils.isEmpty(departmentId)) {
			return new JSONObject(0);
		}
		
		String localFetchChild = StringUtils.isEmpty(fetchChild) ? "1" : fetchChild;
		String localStatus = StringUtils.isEmpty(status) ? "0" : status;
		
		String requestURL = messageFormat(
				isSimple ? DevApp.API_GET_USER_INFO_SIMPLE_LIST : DevApp.API_GET_USER_INFO_LIST, 
				accessToken, departmentId, localFetchChild, localStatus);
		
		String result = StringUtils.isNotEmpty(requestURL) 
				? HttpApi.get(requestURL, DevApp.UTF_8.getValue())
				: msgRequestURLIsNull();
		
		return stringToJSONObject(result);
	}
	
	public static JSONObject getAgent(String accessToken, String agentId) {
		
		if (StringUtils.isEmpty(accessToken) || StringUtils.isEmpty(agentId)) {
			return JSONObject.parseObject("{\"errmsg\":\"请求参数不完整.请检查access_token或agent_id是否为空.\"}");
		}
		
		String requestURL = messageFormat(DevApp.API_GET_AGENT, accessToken, agentId);
		String result = StringUtils.isNotEmpty(requestURL) 
				? HttpApi.get(requestURL, DevApp.UTF_8.getValue())
				: msgRequestURLIsNull();
		
		return JSONObject.parseObject(result);		
	}
	
	/**
	 * 
	 * <p>decription:response.sendRedirect(url)</p>
	 * <p>date:2015年5月8日 上午9:49:27</p>
	 * @author gsu·napoleon
	 * @param appId			企业的CorpID
	 * @param redirectUri	授权后重定向的回调链接地址，请使用urlencode对链接进行处理
	 * @param state			重定向后会带上state参数，企业可以填写a-zA-Z0-9的参数值，长度不可超过128个字节
	 * @return				最终重定向的url
	 */
	public static String getAuthorizeCode(String appId, String redirectUri, String state) {
		
		if (StringUtils.isEmpty(redirectUri)) {
			return "{\"errmsg\":\"请求参数不完整.请检查redirect_uri是否为空.\"}";
		}
		
		if (StringUtils.isEmpty(appId)) {
			appId = DevApp.APP_CORP_ID.getValue();
		}
		
		if (StringUtils.isEmpty(state)) {
			state = MyStringUtils.getUuid(16);
		}
		
		return messageFormat(DevApp.API_GET_AUTHORIZE_CODE, appId, redirectUri, state);
	}
	
	/**
	 * 
	 * <p>decription:</p>
	 * <p>date:2015年5月8日 上午9:57:44</p>
	 * @author gsu·napoleon
	 * @param accessToken	调用接口凭证
	 * @param code			通过成员授权获取到的code，每次成员授权带上的code将不一样，code只能使用一次，5分钟未被使用自动过期
	 * @param agentId		跳转链接时所在的企业应用ID
	 * @return				{"UserId":"USERID",  "DeviceId":"DEVICEID"}
	 */
	public static JSONObject getUserInfoByCode(String accessToken, String code, String agentId) {
		if (StringUtils.isEmpty(accessToken) || StringUtils.isEmpty(code)) {
			return JSONObject.parseObject("{\"errmsg\":\"请求参数不完整.请检查access_token或code是否为空.\"}");
		}
		
		if (StringUtils.isEmpty(agentId)) {
			agentId = DevApp.APP_AGENT_ID.getValue();
		}
		
		String requestURL = messageFormat(DevApp.API_GET_USER_INFO_BY_CODE, accessToken, code, agentId);
		String result = StringUtils.isNotEmpty(requestURL)
				? HttpApi.get(requestURL, DevApp.UTF_8.getValue())
				: msgRequestURLIsNull();
		
		return JSONObject.parseObject(result);
	}
	
	public static String postInvitationSend(String accessToken, String userid) {
		if (StringUtils.isEmpty(accessToken)) {
			return "{\"errmsg\":\"access_token is null\"}";
		}
		String requestURL = messageFormat(DevApp.API_POST_INVITE_SEND, accessToken);
		JSONObject postData = new JSONObject();
		postData.put("userid", userid);
		postData.put("invite_tips", "请关注太平洋网络-流量分析系统");
		return HttpApi.post(requestURL, null, postData.toJSONString(), DevApp.UTF_8.getValue());
	}
	
	/**
	 * <p>decription:</p>
	 * <p>date:2015年5月7日 下午3:12:01</p>
	 * @author gsu·napoleon
	 * @param accessToken
	 * @param userid
	 * @return
	 */
	private static String messageFormat(DevApp devApp, Object...arguments) {
		return MessageFormat.format(devApp.getValue(), arguments);
	}
	
	/**
	 * <p>decription:</p>
	 * <p>date:2015年5月7日 下午3:30:15</p>
	 * @author gsu·napoleon
	 * @param result
	 * @return
	 */
	private static JSONObject stringToJSONObject(String result) {
		JSONObject json = StringUtils.isNotBlank(result) 
				? JSONObject.parseObject(result) : new JSONObject(0);
		return json;
	}
	
	private static String msgRequestURLIsNull() {
		return "{\"errmsg\":\"request url is null,please check.\"}";
	}

	/**
	 * <p>
	 * decription:
	 * </p>
	 * <p>
	 * date:2015年5月7日 下午2:18:03
	 * </p>
	 * 
	 * @author gsu·napoleon
	 * @param json
	 * @return
	 */
	private static String getValueByKey(JSONObject json, String key) {
		return json != null && !json.isEmpty()
				&& json.containsKey(key)
				&& StringUtils.isNotEmpty(key.trim()) 
				? json.getString(key) : "";
	}

}
