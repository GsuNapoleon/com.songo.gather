/**
 * 
 */
package com.songo.gather.web.utils;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * decription:
 * </p>
 * <p>
 * date:2015年8月4日 下午1:51:53
 * </p>
 * 
 * @author gsu·napoleon
 */
public class InternetUtils {

	private InternetUtils() {
	}

	/**
	 * <p>
	 * decription:
	 * </p>
	 * <p>
	 * date:2015年8月4日 下午1:51:53
	 * </p>
	 * 
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		rt(1, -1);
		rt(3, -1);
		rt(3, 3);
		rt(4, -1);
	}

	/**
	 * 直接来源
	 */
	private final static int DIRCET_ACCESS_TYPE = 1;

	/**
	 * 站外来源
	 */
	private final static int OUTSITE_ACCESS_TYPE = 2;

	/**
	 * 搜索来源
	 */
	private final static int SEARCH_ENGINE_ACCESS_TYPE = 3;

	/**
	 * 广告来源
	 */
	private final static int AD_ACCESS_TYPE = 4;

	private static String[] EMPYT = new String[0];

	private static Set<Integer> insideAdSet = new HashSet<Integer>();
	private static List<SearchEngine> items = new ArrayList<SearchEngine>(10);

	private static void rt(int t, int o) {
		if (t == AD_ACCESS_TYPE) {
			System.err.println("广告来源··························");
			return;
		}
		if (t == Request.REFERER_OUTSITE) {
			if (o == SEARCH_ENGINE_ACCESS_TYPE) {
				System.err.println("搜索来源··························");
				return;
			}
			System.err.println("外部来源··························");
			return;
		}
		System.err.println("直接来源··························");
		return;
	}
	
	public static int referType(Request req) {
		if (isAd(req.getAdId())) {
			return AD_ACCESS_TYPE;
		}
		// 如果是站外，则再判断是是否是搜索
		if (referType(req.getReferer()) == Request.REFERER_OUTSITE) {
			if (isSearchEngine(req)) {
				return SEARCH_ENGINE_ACCESS_TYPE;
			}
			return OUTSITE_ACCESS_TYPE;
		}
		return DIRCET_ACCESS_TYPE;
	}

	private static boolean isAd(int adId) {
		boolean isNotAd = adId > 99999999 || adId <= 0;
		return isNotAd ? false : !isInsideAd(adId);
	}

	private static boolean isInsideAd(int adId) {
		return insideAdSet.contains(adId);
	}

	private static boolean isSearchEngine(Request req) {
		String[] result = matchQuick(req.getReferer());
		if (result.length == 0) {
			return false;
		}
		return true;
	}

	private static String[] matchQuick(String url) {
		String[] result = EMPYT;

		for (int i = 0, c = items.size(); i < c; ++i) {
			SearchEngine se = (SearchEngine) items.get(i);
			String[] temp = se.matchQuick(url);
			if (temp.length == 2) {
				return temp;
			}
		}
		return result;
	}

	/**
	 * 来源类型，直接1站内2站外3
	 * 
	 * @param refer
	 * @return
	 */
	private static int referType(String refer) {
		int referType;
		if (StringUtils.isBlank(refer)) {
			referType = Request.REFERER_DIRECT;
		} else if (matchSite("pclady.com.cn", "3g.", refer)) {
			referType = Request.REFERER_INSITE;
		} else {
			referType = Request.REFERER_OUTSITE;
		}
		return referType;
	}

	private static boolean matchSite(String site, String wapStr, String url) {
		int pos = url.indexOf(site);
		int pos2 = url.indexOf('.');

		int pos3g = url.indexOf(wapStr + site);

		if (pos == -1) {
			return false;
		}	
		if (pos > 30) {
			return false;
		}	
		if (pos > pos2 + 1 && pos3g > pos2 + 1) {
			return false;
		}

		return true;
	}

}

class SearchEngine {

	private final static String[] EMPTY = new String[0];

	private int id;
	private String urlPattern;
	private String searchKey;
	private String encoding;
	private Pattern pattern;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrlPattern() {
		return urlPattern;
	}

	public void setUrlPattern(String urlPattern) {
		this.urlPattern = urlPattern;
		pattern = Pattern.compile("^" + urlPattern);
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	// [0]：se的ID；[1]：keyword
	public String[] match(String url) {
		if (!pattern.matcher(url).find()) {
			return EMPTY;
		}

		String[] result = new String[2];
		result[0] = String.valueOf(id);

		String[] items = url.split(searchKey, 2);

		String key = null;

		boolean isCheck = false; // 用于判断是否能检查到默认编码

		if (items.length < 2) {
			key = "unknown";
		} else {
			int stop = items[1].indexOf('&');
			if (stop != -1) {
				key = items[1].substring(0, stop);
			} else {
				key = items[1];
			}
			if (key.length() > 255) {
				key = "unknown";
			}
		}

		String enc = encoding;
		/*
		 * 2011-02-14 114search是ec=gb2312, youdao是ue=gbk
		 * 
		 * google: ie=gb2312/ie=utf-8
		 * 
		 * baidu: m.baidu.com; wap.baidu.com 为utf8, 其他为gbk
		 */
		if (url.toUpperCase().indexOf("IE=GB") > 0
				|| url.toUpperCase().indexOf("EC=GB") > 0
				// url.toUpperCase().indexOf("HL=ZH-CN") > 0 ||
				|| url.toUpperCase().indexOf("UE=GB") > 0
				|| url.toUpperCase().indexOf("EI=GB") > 0
				|| url.toUpperCase().indexOf("IE=GBK") > 0) {
			enc = "gbk";
			isCheck = true;
		}
		if (url.toUpperCase().indexOf("IE=UTF") > 0
				|| url.toUpperCase().indexOf("EC=UTF") > 0
				|| url.toUpperCase().indexOf("UE=UTF") > 0
				|| url.toUpperCase().indexOf("EI=UTF") > 0
				|| url.toUpperCase().indexOf("IE=UTF-8") > 0) {
			enc = "utf-8";
			isCheck = true;
		}
		if (url.toUpperCase().indexOf("IE=GB2312") > 0) {
			enc = "gb2312";
			isCheck = true;
		}

		try {
			if (!isCheck) {
				// 如果没有匹配，只能一个个编码试，gbk的url编码很可能重复，故最后才测试
				if (key.equals(URLEncoder.encode(URLDecoder
						.decode(key, "utf-8").toLowerCase().trim(), "utf-8"))) {
					enc = "utf-8";
				} else if (key.equals(URLEncoder.encode(
						URLDecoder.decode(key, "gb2312").toLowerCase().trim(),
						"gb2312"))) {
					enc = "gb2312";
				} else if (key.equals(URLEncoder.encode(
						URLDecoder.decode(key, "gbk").toLowerCase().trim(),
						"gbk"))) {
					enc = "gbk";
				}
			}
			result[1] = URLDecoder.decode(key, enc).toLowerCase().trim();
		} catch (Exception e) {
			result[1] = "unknown";
		}
		return result;
	}

	public String[] matchQuick(String url) {
		if (!pattern.matcher(url).find())
			return EMPTY;

		String[] result = new String[2];
		result[0] = String.valueOf(id);

		return result;
	}

}