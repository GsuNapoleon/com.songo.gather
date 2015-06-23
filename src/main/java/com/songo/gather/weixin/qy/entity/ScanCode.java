/**
 * 
 */
package com.songo.gather.weixin.qy.entity;

/**
 * <p>decription:</p>
 * <p>date:2015年6月17日 上午10:19:18</p>
 * @author gsu·napoleon
 */
public class ScanCode extends QyEntity {

	/**
	 * <p>attribute:</p>
	 */
	private static final long serialVersionUID = 1L;

	private String eventKey;
	
	private ScanCodeInfo scanCodeInfo;
	
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
	 * @return the scanCodeInfo
	 */
	public ScanCodeInfo getScanCodeInfo() {
		return scanCodeInfo;
	}

	/**
	 * @param scanCodeInfo the scanCodeInfo to set
	 */
	public void setScanCodeInfo(ScanCodeInfo scanCodeInfo) {
		this.scanCodeInfo = scanCodeInfo;
	}

	private class ScanCodeInfo {
		private String scanType;
		
		private String scanResult;

		/**
		 * @return the scanType
		 */
		public String getScanType() {
			return scanType;
		}

		/**
		 * @param scanType the scanType to set
		 */
		public void setScanType(String scanType) {
			this.scanType = scanType;
		}

		/**
		 * @return the scanResult
		 */
		public String getScanResult() {
			return scanResult;
		}

		/**
		 * @param scanResult the scanResult to set
		 */
		public void setScanResult(String scanResult) {
			this.scanResult = scanResult;
		}
		
	}
	
}
