/**
 * 
 */
package com.songo.gather.web.collector;

import java.io.Serializable;

/**
 * <p>decription:</p>
 * <p>date:2015年8月7日 上午11:41:02</p>
 * @author gsu·napoleon
 */
public class Collector implements Serializable {

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
	
	/**
	 * @return the currentTime
	 */
	public String getCurrentTime() {
		return currentTime;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the ipAddr
	 */
	public String getIpAddr() {
		return ipAddr;
	}

	/**
	 * @return the xforward
	 */
	public String getXforward() {
		return xforward;
	}

	/**
	 * @return the resolution
	 */
	public String getResolution() {
		return resolution;
	}

	/**
	 * @return the currentUrl
	 */
	public String getCurrentUrl() {
		return currentUrl;
	}

	/**
	 * @return the referer
	 */
	public String getReferer() {
		return referer;
	}

	/**
	 * @return the channel
	 */
	public long getChannel() {
		return channel;
	}

	/**
	 * @return the fromChannel
	 */
	public long getFromChannel() {
		return fromChannel;
	}

	/**
	 * @return the adId
	 */
	public long getAdId() {
		return adId;
	}

	/**
	 * @return the suv
	 */
	public String getSuv() {
		return suv;
	}

	/**
	 * @return the uvdata
	 */
	public String getUvdata() {
		return uvdata;
	}

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @return the pcgroupCid
	 */
	public String getPcgroupCid() {
		return pcgroupCid;
	}

	/**
	 * @return the ldjc
	 */
	public String getLdjc() {
		return ldjc;
	}

	/**
	 * @return the pcxuv
	 */
	public String getPcxuv() {
		return pcxuv;
	}

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @return the iframeCode
	 */
	public int getIframeCode() {
		return iframeCode;
	}
	
}
