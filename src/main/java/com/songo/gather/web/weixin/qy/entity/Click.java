/**
 * 
 */
package com.songo.gather.web.weixin.qy.entity;

/**
 * <p>decription:</p>
 * <p>date:2015年6月17日 上午10:17:06</p>
 * @author gsu·napoleon
 */
public class Click extends QyEntity {

	/**
	 * <p>attribute:</p>
	 */
	private static final long serialVersionUID = 1L;

	private String eventKey;

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
	
}
