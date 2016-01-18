/**
 * 
 */
package com.songo.gather.db.entity;

import java.util.List;

/**
 * <p>decription:</p>
 * <p>date:2015年9月24日 下午5:45:03</p>
 * @author gsu·napoleon
 */
public class Channel {

	private long id;
	private long parentId;
	private String name;
	private int rank;
	private List<Channel> childrens;

	public Channel() {}
	
	public Channel(long id, long parentId, String name, int rank) {
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.rank = rank;
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}

	/**
	 * @return the parentId
	 */
	public long getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the childrens
	 */
	public List<Channel> getChildrens() {
		return childrens;
	}

	/**
	 * @param childrens the childrens to set
	 */
	public void setChildrens(List<Channel> childrens) {
		this.childrens = childrens;
	}
	
}
