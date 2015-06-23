/**
 * 
 */
package com.songo.gather.weixin.mp.http;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.MessageFormat;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.songo.gather.utils.MyStringUtils;
import com.songo.gather.weixin.HttpApi;
import com.songo.gather.weixin.mp.utils.DevApp;
import com.songo.gather.weixin.mp.utils.GlobalReturnCode;
import com.songo.gather.weixin.mp.utils.Scope;

/**
 * <p>decription:</p>
 * <p>date:2015年4月27日 下午4:46:19</p>
 * @author gsu·napoleon
 */
public class MpApi {

	private static volatile MpApi INSTANCE = null;
	
	private MpApi() {}
	
	public static MpApi getInstance() {
		if (INSTANCE == null) {
			synchronized (MpApi.class) {
				if (INSTANCE == null) {
					INSTANCE = new MpApi();
				}
			}
		}
		return INSTANCE;
	}
	
	public JSONObject getAccessToken(String grantType, String appId, String secret) {
		
		if (StringUtils.isEmpty(appId)) {
			return JSONObject.parseObject(returnErrorInfo(GlobalReturnCode.CUSTOM_NULL_APP_ID));
		}
		
		if (StringUtils.isEmpty(secret)) {
			return JSONObject.parseObject(returnErrorInfo(GlobalReturnCode.CUSTOM_NULL_APP_SECRET));
		}
		
		if (StringUtils.isEmpty(grantType)) {
			grantType = Mp.DEFAULT_GRANT_TYPE.getValue();
		}
		
		String url = MessageFormat.format(DevApp.API_ACCESS_TOKEN.getValue(), 
				grantType, appId, secret);
		
		String accessToken = HttpApi.get(url, Mp.LANG_CODE_GBK.getValue());
		
		return JSONObject.parseObject(accessToken);
	}
	
	public JSONObject getUserInfoByOpenID(String accessToken, String openID) throws UnsupportedEncodingException {
		
		if (StringUtils.isEmpty(accessToken)) {
			return JSONObject.parseObject(returnErrorInfo(GlobalReturnCode.CUSTOM_NULL_ACCESS_TOKEN));
		}
		
		if (StringUtils.isEmpty(openID)) {
			return JSONObject.parseObject(returnErrorInfo(GlobalReturnCode.CUSTOM_NULL_OPEN_ID));
		}
		
		String reqURL = MessageFormat.format(DevApp.API_GET_USERINFO_BY_OPENID.getValue(), 
				URLEncoder.encode(accessToken, Mp.LANG_CODE_GBK.getValue()),
				openID);
		return JSONObject.parseObject(HttpApi.get(reqURL, Mp.LANG_CODE_GBK.getValue()));
	}
	
	public JSONObject getUserList(String accessToken) throws UnsupportedEncodingException {
		
		if (StringUtils.isEmpty(accessToken)) {
			return JSONObject.parseObject(returnErrorInfo(GlobalReturnCode.CUSTOM_NULL_ACCESS_TOKEN));
		}
		
		String requestURL = MessageFormat.format(
				DevApp.API_GET_USER_LIST.getValue(), 
				accessToken, Mp.LANG_CODE_GBK.getValue());
		System.out.println(requestURL);
		return JSONObject.parseObject(HttpApi.get(requestURL, Mp.LANG_CODE_GBK.getValue()));
	}
	
	/**
	 * 
	 * <p>decription:第一步：用户同意授权，获取code</p>
	 * <p>date:2015年4月27日 下午5:22:54</p>
	 * @author gsu·napoleon
	 * @param appId			必填项,公众号的唯一标识
	 * @param redirectUri	必填项,授权后重定向的回调链接地址,请使用urlencode对链接进行处理
	 * @param responseType	必填项,返回类型,默认值"code"
	 * @param scope			必填项,<code>cn.com.pcgroup.weixin.utils.Scope</code>
	 * @param state			非必填,重定向后会带上state参数,开发者可以填写a-zA-Z0-9的参数值,最多128字节
	 * @param flag			必填项,默认值 "#wechat_redirect"
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String getCodeByAuthorize(String appId, String redirectUri, 
			String responseType, String scope, String state, String flag) throws UnsupportedEncodingException {
		
		if (StringUtils.isEmpty(appId)) {
			return returnErrorInfo(GlobalReturnCode.CUSTOM_NULL_APP_ID);
		}
		if (StringUtils.isEmpty(redirectUri)) {
			return returnErrorInfo(GlobalReturnCode.CUSTOM_NULL_REDIRECT_URI);
		}
		if (StringUtils.isEmpty(responseType)) {
			responseType = Mp.DEFAULT_RESPONSE_TYPE_CODE.getValue();
		}
		if (StringUtils.isEmpty(scope)) {
			scope = Scope.SNSAPI_BASE.getScope();
		}
		if (StringUtils.isEmpty(state)) {
			state = MyStringUtils.getUuid(4);
		}
		if (StringUtils.isEmpty(flag)) {
			flag = Mp.DEFAULT_FALG.getValue();
		}
		
		String url = MessageFormat.format(DevApp.API_AUTHORIZE_AND_GET_CODE.getValue(), 
				appId, URLEncoder.encode(redirectUri, Mp.LANG_CODE_EN.getValue()), responseType, scope, state, flag);
		return HttpApi.get(url, Mp.LANG_CODE_GBK.getValue());
	}

	/**
	 * <p>decription:</p>
	 * <p>date:2015年4月28日 上午11:38:55</p>
	 * @author gsu·napoleon
	 * @return
	 */
	private String returnErrorInfo(GlobalReturnCode gr) {
		return "{\"errcode\":"+ gr.getCode() 
				+ ",\"errmsg\":\"" + gr.getExplanation() + "\"}";
	}
	
	/**
	 * 
	 * <p>decription:第二步：通过code换取网页授权access_token</p>
	 * <p>date:2015年4月27日 下午5:33:11</p>
	 * @author gsu·napoleon
	 * @param appId			必填,公众号的唯一标识
	 * @param secret		必填,公众号的appsecret
	 * @param code			必填,填写第一步获取的code参数
	 * @param grantType		必填,填写为authorization_code
	 * @return
	 */
	public String getAccessTokenByCode(String appId, String secret, String code, String grantType) {
		return null;
	}
	
	/**
	 * 
	 * <p>decription:第三步：刷新access_token（如果需要）</p>
	 * <p>date:2015年4月27日 下午5:40:42</p>
	 * @author gsu·napoleon
	 * @param appId			必填,公众号的唯一标识
	 * @param grantType		必填,填写为refresh_token
	 * @param refreshToken	必填,填写通过access_token获取到的refresh_token参数
	 * @return
	 */
	public String refreshAccessToken(String appId, String grantType, String refreshToken) {
		return null;
	}
	
	/**
	 * 
	 * <p>decription:</p>
	 * <p>date:2015年4月27日 下午5:46:37</p>
	 * @author gsu·napoleon
	 * @param accessToken	网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
	 * @param openid		用户的唯一标识
	 * @param lang			返回国家地区语言版本,zh_CN 简体,zh_TW 繁体,en 英语
	 * @return
	 */
	public String getUserInfo(String accessToken, String openid, String lang) {
		return null;
	}
	
	public String postCreateMenu() throws UnsupportedEncodingException {
		
		JSONArray menus = new JSONArray();
		JSONObject cmenu = new JSONObject();
		cmenu.put("type", "view");
		cmenu.put("name", "绑定账号");
		cmenu.put("url", "http://ta.pc.com.cn/weixin/index.jsp");
		menus.add(cmenu);
		JSONObject menu = new JSONObject();
		menu.put("button", menus);

		System.out.println("create menu is parameter : " + menu.toJSONString());
		
		JSONObject accessToken = getAccessToken(DevApp.DEFAULT_GRANT_TYPE.getValue(), 
				DevApp.APP_ID.getValue(), DevApp.APP_SECRET.getValue());
		String token = accessToken.getString("access_token");
		System.err.println("access token is " + token);		
		String requestURL = MessageFormat.format(DevApp.API_POST_CREATE_MENU.getValue(), 
				URLEncoder.encode(token, Mp.LANG_CODE_GBK.getValue()));
		
		return HttpApi.post(requestURL, null, menu.toJSONString(), Mp.LANG_CODE_GBK.getValue());
	}
	
	private enum Mp {
		
		LANG_ZH_CN("zh_CN", "中国"),
		LANG_ZH_TW("zh_TW", "台湾"),
		LANG_CODE_EN("UTF-8", "西欧"),
		LANG_CODE_GBK("gbk", "西欧"),
		DEFAULT_RESPONSE_TYPE_CODE("code", "用户授权码"),
		DEFAULT_FALG("#wechat_redirect", "无论直接打开还是做页面302重定向时候，必须带此参数"),
		DEFAULT_GRANT_TYPE("client_credential", "默认授权类型")
		;
		
		private String value;
		private String desc;
		
		private Mp(String value, String desc) {
			this.value = value;
			this.desc = desc;
		}

		/**
		 * @return the value
		 */
		public String getValue() {
			return this.value;
		}

		/**
		 * @return the desc
		 */
		@SuppressWarnings("unused")
		public String getDesc() {
			return this.desc;
		}
		
	}
}
