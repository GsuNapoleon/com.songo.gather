/**
 * 
 */
package com.songo.gather.web.weixin.qy.entity;

import java.math.BigDecimal;

/**
 * <p>decription:</p>
 * <p>date:2015年6月17日 上午10:13:32</p>
 * @author gsu·napoleon
 */
public class Location extends QyEntity {

	/**
	 * <p>attribute:</p>
	 */
	private static final long serialVersionUID = 1L;

	private BigDecimal latitude;
	private BigDecimal longitude;
	
	private BigDecimal precision;

	/**
	 * @return the latitude
	 */
	public BigDecimal getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public BigDecimal getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the precision
	 */
	public BigDecimal getPrecision() {
		return precision;
	}

	/**
	 * @param precision the precision to set
	 */
	public void setPrecision(BigDecimal precision) {
		this.precision = precision;
	}
	
}
