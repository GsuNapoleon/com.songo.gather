/**
 * 
 */
package com.songo.gather.web.weixin.mp.xml;

/**
 * <p>decription:</p>
 * <p>date:2015年5月5日 上午10:52:17</p>
 * @author gsu·napoleon
 */
public enum EventTemplate {

	FOLLOW_OR_UNFOLLOW("<xml>\n<ToUserName><![CDATA[{0}]]></ToUserName>\n"
			+ "<FromUserName><![CDATA[{1}]]></FromUserName>\n"
			+ "<MsgType><![CDATA[{2}]]></MsgType>\n"
			+ "<Event><![CDATA[{3}]]></Event>\n</xml>", "关注/取消关注事件"),
	CUSTOM_MENU("<xml>\n<ToUserName><![CDATA[{0}]]></ToUserName>\n"
			+ "<FromUserName><![CDATA[{1}]]></FromUserName>\n"
			+ "<CreateTime>{2}</CreateTime>\n"
			+ "<MsgType><![CDATA[{3}]]></MsgType>\n"
			+ "<Event><![CDATA[{4}]]></Event>\n"
			+ "<EventKey><![CDATA[{5}]]></EventKey>\n</xml>", "自定义菜单事件");
	
	private String xml;
	private String description;
	
	private EventTemplate(String xml, String description) {
		this.xml = xml;
		this.description = description;
	}

	/**
	 * @return the xml
	 */
	public String getXml() {
		return this.xml;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}
	
}
