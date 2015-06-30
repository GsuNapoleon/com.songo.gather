/**
 * 
 */
package com.songo.gather.web.weixin.entity;

import java.io.Serializable;

/**
 * <p>decription:成员关注/取消关注事件</p>
 * <p>date:2015年6月16日 上午9:47:09</p>
 * @author gsu·napoleon
 */
public class Entity implements Serializable {

	/**
	 * <p>attribute:</p>
	 */
	private static final long serialVersionUID = 1L;

	private String toUserName;
	private String fromUserName;
	private long createTime;
	private String msgType;
	private String event;

	/**
	 * @return the toUserName
	 */
	public String getToUserName() {
		return toUserName;
	}

	/**
	 * @param toUserName the toUserName to set
	 */
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	/**
	 * @return the fromUserName
	 */
	public String getFromUserName() {
		return fromUserName;
	}

	/**
	 * @param fromUserName the fromUserName to set
	 */
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	/**
	 * @return the createTime
	 */
	public long getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the msgType
	 */
	public String getMsgType() {
		return msgType;
	}

	/**
	 * @param msgType the msgType to set
	 */
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	/**
	 * @return the event
	 */
	public String getEvent() {
		return event;
	}

	/**
	 * @param event the event to set
	 */
	public void setEvent(String event) {
		this.event = event;
	}
	
}
