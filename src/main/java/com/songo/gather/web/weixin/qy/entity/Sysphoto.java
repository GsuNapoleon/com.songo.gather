/**
 * 
 */
package com.songo.gather.web.weixin.qy.entity;

import java.util.List;

/**
 * <p>decription:</p>
 * <p>date:2015年6月17日 上午10:47:41</p>
 * @author gsu·napoleon
 */
public class Sysphoto extends QyEntity {

	/**
	 * <p>attribute:</p>
	 */
	private static final long serialVersionUID = 1L;

	private String eventKey;
	
	private SendPicsInfo sendPicsInfo;
		
	/**
	 * @return the eventKey
	 */
	public String getEventKey() {
		return eventKey;
	}

	/**
	 * @param eventKey the eventKey to set
	 */
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	/**
	 * @return the sendPicsInfo
	 */
	public SendPicsInfo getSendPicsInfo() {
		return sendPicsInfo;
	}

	/**
	 * @param sendPicsInfo the sendPicsInfo to set
	 */
	public void setSendPicsInfo(SendPicsInfo sendPicsInfo) {
		this.sendPicsInfo = sendPicsInfo;
	}

	private class SendPicsInfo {
		
		private int count;
		private List<String> picList;

		/**
		 * @return the count
		 */
		public int getCount() {
			return count;
		}

		/**
		 * @param count the count to set
		 */
		public void setCount(int count) {
			this.count = count;
		}

		/**
		 * @return the picList
		 */
		public List<String> getPicList() {
			return picList;
		}

		/**
		 * @param picList the picList to set
		 */
		public void setPicList(List<String> picList) {
			this.picList = picList;
		}
		
	}
	
}
