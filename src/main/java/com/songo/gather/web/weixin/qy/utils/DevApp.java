/**
 * 
 */
package com.songo.gather.web.weixin.qy.utils;

/**
 * <p>decription:</p>
 * <p>date:2015年5月7日 上午11:26:22</p>
 * @author gsu·napoleon
 */
public enum DevApp {

	APP_CORP_ID("", "企业号ID"),
	APP_CORP_SECRET("", "开发者凭证密钥"),
	APP_PARTY_ID("11", "组ID"),
	APP_AGENT_ID("2", "应用ID"),
	APP_ACCESS_TOKEN_EXPIRED("7200", "默认有效时间"),
	API_GET_ACCESS_TOKEN("https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid={0}&corpsecret={1}", "主动调用模式下,获取AccessToken"),
	API_GET_IP_LIST("https://qyapi.weixin.qq.com/cgi-bin/getcallbackip?access_token={0}", "获取微信服务器的ip段"),
	API_GET_USE_AUTHSUCC("https://qyapi.weixin.qq.com/cgi-bin/user/authsucc?access_token={0}&userid={1}", "企业服务的二次验证"),
	API_GET_USER_INFO("https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token={0}&userid={1}", "获取用户信息"),
	API_GET_USER_INFO_SIMPLE_LIST("https://qyapi.weixin.qq.com/cgi-bin/user/simplelist?access_token={0}&department_id={1}&fetch_child={2}&status={3}", "获取部门员工信息列表"),
	API_GET_USER_INFO_LIST("https://qyapi.weixin.qq.com/cgi-bin/user/list?access_token={0}&department_id={1}&fetch_child={2}&status={3}", "获取部门员工的详细信息列表"),
	API_GET_AGENT("https://qyapi.weixin.qq.com/cgi-bin/agent/get?access_token={0}&agentid={1}", "获取企业应用"),
	API_GET_AUTHORIZE_CODE("https://open.weixin.qq.com/connect/oauth2/authorize?appid={0}&redirect_uri={1}&response_type=code&scope=snsapi_base&state={2}#wechat_redirect", "获取企业授权的code"),
	API_GET_USER_INFO_BY_CODE("https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token={0}&code={1}&agentid={2}", "根据code获取成员信息"),
	API_POST_INVITE_SEND("https://qyapi.weixin.qq.com/cgi-bin/invite/send?access_token={0}", "邀请成员关注.消息体：{\"userid\":\"xxxxx\", \"invite_tips\":\"xxx\"}"),
	API_POST_CREATE_DEPARTMENT("https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token={0}", "创建部门.消息体：{\"name\": \"广州研发中心\",\"parentid\": \"1\",\"order\": \"1\",\"id\": \"1\"}"),
	API_POST_CREATE_USER("https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token={0}", "创建用户.消息体："),
	UTF_8("UTF-8", "");
	
	private String value;
	private String desc;
	
	private DevApp(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		String s = "{\"name\": \"广州研发中心\",\"parentid\": \"1\",\"order\": \"1\",\"id\": \"1\"}";
		String s1 = "{\"userid\":\"xxxxx\", \"invite_tips\":\"xxx\"}";
		return desc;
	}
	
}
