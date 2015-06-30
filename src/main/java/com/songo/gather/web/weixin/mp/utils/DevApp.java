/**
 * 
 */
package com.songo.gather.web.weixin.mp.utils;


/**
 * 
 * <p>decription:</p>
 * <p>date:2015年4月27日 下午2:10:22</p>
 * @author gsu·napoleon
 */
public enum DevApp {
	
	APP_ID("", "应用ID"),
	APP_SECRET("", "应用密钥"),
	APP_REDIRECT_URI("https://www.google.com/", "应用跳转地址"),
	APP_CUSTOM_TOKEN("kR9rwCZVMtUEFSOHrUQUvCxEnPUK0mFZ", "自定义token,用来验证开发者身份.一经确定,请勿修改"),
	APP_CUSTOM_ENCODING_AES_KEY(SecurityUtils.sha256Hash(), "自定义的消息加密密钥"),
	API_ACCESS_TOKEN("https://api.weixin.qq.com/cgi-bin/token?grant_type={0}&appid={1}&secret={2}",
			"获取access token"),
	API_AUTHORIZE_AND_GET_CODE("https://open.weixin.qq.com/connect/oauth2/authorize?appid={0}"
			+ "&redirect_uri={1}&response_type={2}&scope={3}&state={4}{5}", 
			"用户同意授权，获取code"),
	API_GET_AUTHORIZE_ACCESS_TOKEN("https://api.weixin.qq.com/sns/oauth2/access_token?appid={0}&secret={1}"
			+ "&code={2}&grant_type={3}", 
			"通过code换取网页授权access_token"),
	API_REFRESH_ACCESS_TOKEN("https://api.weixin.qq.com/sns/oauth2/refresh_token?appid={0}"
			+ "&grant_type={1}&refresh_token={2}", "刷新access_token"),
	API_GET_USER_INFO("https://api.weixin.qq.com/sns/userinfo?access_token={0}&openid={1}&lang={2}", 
			"拉取用户信息(需scope为 snsapi_userinfo)"),
	API_GET_USERINFO_BY_OPENID("https://api.weixin.qq.com/cgi-bin/user/info?"
			+ "access_token={0}&openid={1}&lang=zh_CN", 
			"获取用户基本信息（包括UnionID机制）"),
	API_GET_USER_LIST("https://api.weixin.qq.com/cgi-bin/user/get?access_token={0}&next_openid=NEXT_OPENID", "获取用户列表"),
	API_POST_CREATE_MENU("https://api.weixin.qq.com/cgi-bin/menu/create?access_token={0}", "自定义菜单创建接口"),
	DEFAULT_RESPONSE_TYPE_CODE("code", "用户授权码"),
	DEFAULT_FALG("#wechat_redirect", "无论直接打开还是做页面302重定向时候，必须带此参数"),
	DEFAULT_GRANT_TYPE("client_credential", "默认授权类型");
	
	private String value;
	private String description;
	
	private DevApp(String value, String description) {
		this.value = value;
		this.description = description;
	}

	/**
	 * @return the app
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

}
