/**
 * 
 */
package com.songo.gather.web.utils;

import org.apache.commons.lang.math.NumberUtils;

/**
 * <p>decription:</p>
 * <p>date:2015年8月4日 下午2:00:47</p>
 * @author gsu·napoleon
 */
public class Request {

	public final static int REFERER_DIRECT = 1;
	public final static int REFERER_INSITE = 2;
	public final static int REFERER_OUTSITE = 3;
	protected String line;
	protected long currentTimeYmdhms;
	protected String currentUrl;
	protected String referer;
	protected String ipAddress; // include xForward;
	protected long channelId;
	protected String oldChannel;
	protected int adId;
	protected String resolution;
	protected String type;
	// uv related
	protected String suv;
	protected String uvdata;
	protected long currentTimeInMillis;
	protected long lastAccessTime;
	//补丁字段，用来链接第一次和第二次访问，items[14]
	private String pcxuv;
	private String ldjc;
	private String uuid;
	//来源类型，直接1站内2站外3，如果是0，则没有处理
	protected int refererType;
	
	// 采集为空或者from的长度超过64,则为0;反之,则原样记录
	// 默认为0
	private String from;

	public Request() {
		currentTimeYmdhms = 0;
		currentUrl = "";
		referer = "";
		ipAddress = "";
		channelId = 0;
		oldChannel = "";
		adId = 0;
		resolution = "";
		type = "1";
		suv = "";
		uvdata = "";
		currentTimeInMillis = 0;
		uuid = "";
		from = "0";
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public long getCurrentTimeYmdhms() {
		return currentTimeYmdhms;
	}

	public void setCurrentTimeYmdhms(String currentTimeYmdhms) {
		this.currentTimeYmdhms = NumberUtils.toLong(currentTimeYmdhms);
	}

	public String getCurrentUrl() {
		return currentUrl;
	}

	public void setCurrentUrl(String currentUrl) {
		this.currentUrl = currentUrl.trim();
	}

	public String getReferer() {
		return referer;
	}

	public void setReferer(String referer) {
		this.referer = referer.trim();
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public long getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = NumberUtils.toLong(channelId, 0);
	}

	public void setChannelId(long channelId) {
		this.channelId = channelId;
	}

	public String getOldChannel() {
		return oldChannel;
	}

	public void setOldChannel(String oldChannel) {
		this.oldChannel = oldChannel;
	}

	public int getAdId() {
		return adId;
	}

	public void setAdId(String adId) {
		this.adId = NumberUtils.toInt(adId, 0);
	}

	public void setAdId(int adId) {
		this.adId = adId;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution.trim();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type.trim();
	}

	public String getSuv() {
		return suv;
	}

	public void setSuv(String suv) {
		this.suv = suv.trim();
	}

	public long getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(long lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	public String getUvdata() {
		return uvdata;
	}

	public void setUvdata(String uvdata) {
		this.uvdata = uvdata.trim();
	}

	public long getCurrentTimeInMillis() {
		return this.currentTimeInMillis;
	}

	public void setCurrentTimeInMillis(String currentTimeInMillis) {
		this.currentTimeInMillis = NumberUtils.toLong(currentTimeInMillis, 0);
	}

	public void setCurrentTimeInMillis(long currentTimeInMillis) {
		this.currentTimeInMillis = currentTimeInMillis;
	}

	public int getRefererType() {
		return refererType;
	}

	public void setRefererType(int refererType) {
		this.refererType = refererType;
	}

	@Override
	public String toString() {
		return this.line;
	}

	public String getPcxuv() {
		return pcxuv;
	}

	public void setPcxuv(String pcxuv) {
		this.pcxuv = pcxuv;
	}

	public String getLdjc() {
		return ldjc;
	}

	public void setLdjc(String ldjc) {
		this.ldjc = ldjc;
	}

	public String getUuid(){
		return uuid;
	}

	public void setUuid(String uuid){
		this.uuid = uuid;
	}

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	
}
