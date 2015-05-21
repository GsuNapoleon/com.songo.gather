/**
 * 
 */
package com.songo.gather.weixin.mp.utils;

/**
 * <p>decription:应用授权作用域，snsapi_base （不弹出授权页面，直接跳转，只能获取用户openid），
 * snsapi_userinfo （弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息）</p>
 * <p>date:2015年4月23日 上午10:04:12</p>
 * @author gsu·napoleon
 */
public enum Scope {
	
	SNSAPI_BASE("snsapi_base", "以snsapi_base为scope发起的网页授权，"
			+ "是用来获取进入页面的用户的openid的，并且是静默授权并自动跳转到回调页的。"
			+ "用户感知的就是直接进入了回调页（往往是业务页面）"),
	SNSAPI_USERINFO("snsapi_userinfo", "以snsapi_userinfo为scope发起的网页授权，是用来获取用户的基本信息的。"
			+ "但这种授权需要用户手动同意，并且由于用户同意过，所以无须关注，就可在授权后获取该用户的基本信息。");

	private String scope;
	private String description;
	
	private Scope(String scope, String description) {
		this.scope = scope;
		this.description = description;
	}

	/**
	 * @return the scope
	 */
	public String getScope() {
		return this.scope;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}
	
}
