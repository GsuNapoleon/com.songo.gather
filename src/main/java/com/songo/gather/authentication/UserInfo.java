/**
 * 
 */
package com.songo.gather.authentication;

/**
 * <p>decription:</p>
 * <p>date:2015年5月20日 下午4:22:41</p>
 * @author gsu·napoleon
 */
public class UserInfo {
	private long id;
	private String account;
	private String name;
	private String department;
	private boolean parttime;
	private boolean safe;
	
	//用户所属网站
	private boolean isNetworksUser = false;
	
	//记录mobile权限
	private boolean isMobileNetworksUser = false;

	// 记录app权限, app节点已经脱离整站，要单独判断权限；
	private boolean isAppNetworksUser = false;

	//是否进入移动页面
	private boolean isInMobilePage = false;

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
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
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
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the parttime
	 */
	public boolean getParttime() {
		return parttime;
	}

	/**
	 * @param parttime the parttime to set
	 */
	public void setParttime(boolean parttime) {
		this.parttime = parttime;
	}

	/**
	 * @return the isNetworksUser
	 */
	public boolean getNetworksUser() {
		return isNetworksUser;
	}

	/**
	 * @param isNetworksUser the isNetworksUser to set
	 */
	public void setNetworksUser(boolean isNetworksUser) {
		this.isNetworksUser = isNetworksUser;
	}

	/**
	 * @return the isMobileNetworksUser
	 */
	public boolean getMobileNetworksUser() {
		return isMobileNetworksUser;
	}

	/**
	 * @param isMobileNetworksUser the isMobileNetworksUser to set
	 */
	public void setMobileNetworksUser(boolean isMobileNetworksUser) {
		this.isMobileNetworksUser = isMobileNetworksUser;
	}

	/**
	 * @return the isAppNetworksUser
	 */
	public boolean getAppNetworksUser() {
		return isAppNetworksUser;
	}

	/**
	 * @param isAppNetworksUser the isAppNetworksUser to set
	 */
	public void setAppNetworksUser(boolean isAppNetworksUser) {
		this.isAppNetworksUser = isAppNetworksUser;
	}

	/**
	 * @return the isInMobilePage
	 */
	public boolean getInMobilePage() {
		return isInMobilePage;
	}

	/**
	 * @param isInMobilePage the isInMobilePage to set
	 */
	public void setInMobilePage(boolean isInMobilePage) {
		this.isInMobilePage = isInMobilePage;
	}
	
	public boolean isSafe() {
		return safe;
	}

	public void setSafe(boolean safe) {
		this.safe = safe;
	}
	
}
