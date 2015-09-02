/**
 * 
 */
package com.songo.gather.concurrent.disruptor.file;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * <p>decription:</p>
 * <p>date:2015年8月12日 上午10:04:27</p>
 * @author gsu·napoleon
 */
public class Data implements Serializable {

	/**
	 * <p>attribute:</p>
	 */
	private static final long serialVersionUID = 1L;

	private String currentTime;	// 采集器写入时间
	private String type;		// 类型
	private String ipAddr;		// IP地址
	private String xforward;	// 
	private String resolution;	// 分辨率
	private String currentUrl;	// 采集页的URL
	private String referer;		// 采集页的来源页
	private long channel;		// 当前访问栏目ID
	private long fromChannel;	// 当前访问栏目的来源栏目
	private long adId;		// 广告ID	
	
	/**
	 * <p>cookie中pcsuv的值.
	 * <p>cookie中为pcsuv.其值为0，则是新访客；
	 * <p>若不为0，则标记格式为：第一次访问时间(long).a.随机数，例如：1438075724285.a.92883281.
	 */
	private String suv;			
	
	/**
	 * <p>lastAccessTime与suv中用点分割的第一段组合，可用来判断用户是否是新访客.
	 * <p>标记格式：lastAccessTime=1438075724285|visits=2，visits2是遗留字段，已无实际意义，可忽略！
	 */
	private String uvdata;		// cookie中pcuvdata的值
	
	private long currentTimeInMillis;
	private long lastAccessTime;
	private int refererType;	// 来源类型，直接1站内2站外3，如果是0，则没有处理
	private String uuid;		// 产品ID、库类或者某些活动会带来的编码
	private String pcgroupCid;	// 废弃字段,权当作预留
	private String ldjc;		// 链点检测，用于挂标记字段用，阿拉丁等合作时会用到，需要网络帮忙获取
	
	/**
	 * <p>辅助字段，依赖链接第一次和第二次访问.
	 * <p>未标识的用户访问，会形成pcxuv=Ex87re1(随机字符串)，同时，pcsuv的值为0！第二次访问时，需要从cookie中擦去.
	 * <p>还当作标识用来接visit的数据.
	 */
	private String pcxuv;		
	
	private String from;		// 标识位字段,主要有cms与event
	private int iframeCode;		// 嵌套防刷.>0的一律剔除
	private String line;

	private void parse() {
		if (StringUtils.isBlank(line)) {
			return;
		}
		String [] fields = StringUtils.splitPreserveAllTokens(line, "\t", 20);
		if (fields.length < 12) {
			return;
		}
		setCurrentTime(fields[0]);
		setType(fields[1]);
		setIpAddr(fields[2]);
		setResolution(fields[3]);
		setCurrentUrl(fields[4]);
		setReferer(fields[5]);
		setChannel(NumberUtils.toLong(fields[6], -999999));
		setAdId(NumberUtils.toLong(fields[7], 0)); // First set adId
		setFromChannel(NumberUtils.toLong(fields[8], -999999));
		setSuv(fields[9]);
		setUvdata(fields[10]);
		setCurrentTimeInMillis(NumberUtils.toLong(fields[11], System.currentTimeMillis()));
		setUuid(fields[12]);
		
		setPcgroupCid(fields[13]);
		if (fields.length > 15) {
			if (StringUtils.isNotBlank(fields[15])) {
				setPcxuv(fields[15].trim());
			}
			setLdjc(fields[14]);
		}
        if (fields.length > 16) {
			setFrom(fields[16].trim());
        }    
        if (fields.length > 17) {
        	setIframeCode(NumberUtils.toInt(fields[17], -1));
		}
        setLastAccessTime(uvdata2LastAccessTime(getUvdata())); //lastAccessTime
        setRefererType(referType(getReferer())); //判断refer类型
	}
	
	public long uvdata2LastAccessTime(String uvdata) {
		if (uvdata == null) {
			return 0;
		}
		int startIndex = uvdata.indexOf("lastAccessTime=");
		if (startIndex == -1) {
			return 0;
		}
		int endIndex = uvdata.indexOf("|", startIndex);
		if (endIndex == -1) {
			return 0;
		}
		return NumberUtils.toLong(
				uvdata.substring(startIndex + 15, endIndex), -1);
	}
	
	protected int referType(String refer) {
		int referType;
		if (refer == null || "".equals(refer)) {
			referType = 1;
		} else if (matchSite(refer)) {
			referType = 2;
		} else {
			referType = 3;
		}
		return referType;
	}
	
	public static boolean matchSite(String url) {
        int pos = url.indexOf("pcauto.com.cn");
        int pos2 = url.indexOf('.');
        
        int pos3g = url.indexOf("3g." + "pcauto.com.cn");

        if (pos == -1) return false;
        if (pos > 30) return false;
        if (pos > pos2 + 1 && pos3g > pos2 + 1) return false;

        return true;
    }
	
	/**
	 * @return the currentTime
	 */
	public String getCurrentTime() {
		return currentTime;
	}

	/**
	 * @param currentTime the currentTime to set
	 */
	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the ipAddr
	 */
	public String getIpAddr() {
		return ipAddr;
	}

	/**
	 * @param ipAddr the ipAddr to set
	 */
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	/**
	 * @return the xforward
	 */
	public String getXforward() {
		return xforward;
	}

	/**
	 * @param xforward the xforward to set
	 */
	public void setXforward(String xforward) {
		this.xforward = xforward;
	}

	/**
	 * @return the resolution
	 */
	public String getResolution() {
		return resolution;
	}

	/**
	 * @param resolution the resolution to set
	 */
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	/**
	 * @return the currentUrl
	 */
	public String getCurrentUrl() {
		return currentUrl;
	}

	/**
	 * @param currentUrl the currentUrl to set
	 */
	public void setCurrentUrl(String currentUrl) {
		this.currentUrl = currentUrl;
	}

	/**
	 * @return the referer
	 */
	public String getReferer() {
		return referer;
	}

	/**
	 * @param referer the referer to set
	 */
	public void setReferer(String referer) {
		this.referer = referer;
	}

	/**
	 * @return the channel
	 */
	public long getChannel() {
		return channel;
	}

	/**
	 * @param channel the channel to set
	 */
	public void setChannel(long channel) {
		this.channel = channel;
	}

	/**
	 * @return the fromChannel
	 */
	public long getFromChannel() {
		return fromChannel;
	}

	/**
	 * @param fromChannel the fromChannel to set
	 */
	public void setFromChannel(long fromChannel) {
		this.fromChannel = fromChannel;
	}

	/**
	 * @return the adId
	 */
	public long getAdId() {
		return adId;
	}

	/**
	 * @param adId the adId to set
	 */
	public void setAdId(long adId) {
		this.adId = adId;
	}

	/**
	 * @return the suv
	 */
	public String getSuv() {
		return suv;
	}

	/**
	 * @param suv the suv to set
	 */
	public void setSuv(String suv) {
		this.suv = suv;
	}

	/**
	 * @return the uvdata
	 */
	public String getUvdata() {
		return uvdata;
	}

	/**
	 * @param uvdata the uvdata to set
	 */
	public void setUvdata(String uvdata) {
		this.uvdata = uvdata;
	}

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the pcgroupCid
	 */
	public String getPcgroupCid() {
		return pcgroupCid;
	}

	/**
	 * @param pcgroupCid the pcgroupCid to set
	 */
	public void setPcgroupCid(String pcgroupCid) {
		this.pcgroupCid = pcgroupCid;
	}

	/**
	 * @return the ldjc
	 */
	public String getLdjc() {
		return ldjc;
	}

	/**
	 * @param ldjc the ldjc to set
	 */
	public void setLdjc(String ldjc) {
		this.ldjc = ldjc;
	}

	/**
	 * @return the pcxuv
	 */
	public String getPcxuv() {
		return pcxuv;
	}

	/**
	 * @param pcxuv the pcxuv to set
	 */
	public void setPcxuv(String pcxuv) {
		this.pcxuv = pcxuv;
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

	/**
	 * @return the iframeCode
	 */
	public int getIframeCode() {
		return iframeCode;
	}

	/**
	 * @param iframeCode the iframeCode to set
	 */
	public void setIframeCode(int iframeCode) {
		this.iframeCode = iframeCode;
	}

	/**
	 * @return the currentTimeInMillis
	 */
	public long getCurrentTimeInMillis() {
		return currentTimeInMillis;
	}

	/**
	 * @param currentTimeInMillis the currentTimeInMillis to set
	 */
	public void setCurrentTimeInMillis(long currentTimeInMillis) {
		this.currentTimeInMillis = currentTimeInMillis;
	}

	/**
	 * @return the lastAccessTime
	 */
	public long getLastAccessTime() {
		return lastAccessTime;
	}

	/**
	 * @param lastAccessTime the lastAccessTime to set
	 */
	public void setLastAccessTime(long lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	/**
	 * @return the refererType
	 */
	public int getRefererType() {
		return refererType;
	}

	/**
	 * @param refererType the refererType to set
	 */
	public void setRefererType(int refererType) {
		this.refererType = refererType;
	}

	/**
	 * @return the line
	 */
	public String getLine() {
		return line;
	}

	/**
	 * @param line the line to set
	 */
	public void setLine(String line) {
		this.line = line;
		parse();
	}
	
}
