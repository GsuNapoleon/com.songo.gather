/**
 * 
 */
package com.songo.gather.weixin.qy.entity;

import com.songo.gather.weixin.entity.Entity;

/**
 * <p>decription:成员关注/取消关注事件</p>
 * <p>date:2015年6月17日 上午10:07:06</p>
 * @author gsu·napoleon
 */
public class QyEntity extends Entity {

	/**
	 * <p>attribute:</p>
	 */
	private static final long serialVersionUID = 1L;

	private int agentId;

	/**
	 * @return the agentId
	 */
	public int getAgentId() {
		return agentId;
	}

	/**
	 * @param agentId the agentId to set
	 */
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	
}
