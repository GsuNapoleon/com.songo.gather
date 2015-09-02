/**
 * 
 */
package com.songo.gather.utils;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * decription:
 * </p>
 * <p>
 * date:2015年8月21日 下午4:15:20
 * </p>
 * 
 * @author gsu·napoleon
 */
public final class MyWebUtils {

	/**
	 * 将 IP 地址转换成为 long 类型数字
	 * 
	 * @param ip
	 *            以“.”分隔 4 段的 IPv4 地址
	 * @return 表示 IP 地址的 long 类型数值
	 * 
	 * @author gaobaowen
	 * @since 2011-8-17 15:26:07
	 */
	public static long parseIp(String ip) {
		if (ip == null || ip.length() == 0) {
			return -1;
		}
		char[] chs = ip.toCharArray();
		long t = 0;
		int n = 0;
		for (int i = 0, k = 0; i < chs.length; i++) {
			if (chs[i] == '.') {
				if (k++ > 2) {
					break;
				}
				t = (t << 8) | (n & 0xff);
				n = 0;
				continue;
			}
			if (chs[i] >= '0' && chs[i] <= '9') {
				n = n * 10 + (chs[i] - '0');
				continue;
			}
			break;
		}
		t = (t << 8) | (n & 0xff);
		return t & 0xffffffffL;
	}

	/**
	 * 将数值的 IPv4 地址转换成为四段的 IPv4 地址
	 * 
	 * @param numberIp
	 *            IPv4 地址的数值形式
	 * @return 四段格式的 IPv4 地址。若参数中的数值小于 0 或者大于 0xffffffffL 时将返回 null 值
	 * 
	 * @author gaobaowen
	 * @since 2011-10-27 13:48:55
	 */
	public static String toIPv4(long numberIp) {
		if (numberIp < 0 || numberIp > 0xffffffffL) {
			return null;
		}
		return ((numberIp >>> 24) & 0xff) + "." + ((numberIp >>> 16) & 0xff)
				+ "." + ((numberIp >>> 8) & 0xff) + "." + (numberIp & 0xff);
	}

	/**
	 * <p>
	 * 响应页面不允许被放于 frame, iframe 中。以下浏览器支持：IE8+, Firefox 3.6.9+, Chrome
	 * 4.1.249.1042+, Opera 10.50+, Safari 4.0+
	 * </p>
	 * 
	 * @author gaobaowen
	 * @since 2011-12-19 18:16:53
	 */
	public static void forbidFrame() {
		HttpServletResponse response = getResponse();
		response.addHeader("X-Frame-Options", "DENY");
	}

	/**
	 * <p>
	 * 响应页面除同源之外，不允许被放于 frame, iframe 中。以下浏览器支持：IE 8.0+, Firefox 3.6.9+, Chrome
	 * 4.1.249.1042+, Opera 10.50+, Safari 4.0+
	 * </p>
	 * 
	 * @author gaobaowen
	 * @since 2011-12-19 18:19:07
	 */
	public static void forbidFrameUsingSameorigin() {
		HttpServletResponse response = getResponse();
		response.addHeader("X-Frame-Options", "SAMEORIGIN");
	}

	/**
	 * <p>
	 * decription:
	 * </p>
	 * <p>
	 * date:2015年8月21日 下午4:20:50
	 * </p>
	 * 
	 * @author gsu·napoleon
	 * @return
	 */
	private static HttpServletResponse getResponse() {
		return null;
	}

	public static boolean matchSite(String url) {
        int pos = url.indexOf("pcauto.com.cn"); // 获取pcauto.com.cn在url中的位置
        int pos2 = url.indexOf('.'); // 获取.在url中的位置
        
        int pos3g = url.indexOf("3g.pcauto.com.cn");	// 获取3g.pcauto.com.cn在url中的位置
        System.out.println("pos = " + pos + "; pos2 = " + pos2 + "; pos3g = " + pos3g);

        if (pos == -1) return false;	// 不存在的情形
        if (pos > 30) return false;		// 域名出现在url中的位置超过了第三十位
        if (pos > pos2 + 1 && pos3g > pos2 + 1) return false;	// 计算url中.与域名的位置

        return true;
    }
	
}
