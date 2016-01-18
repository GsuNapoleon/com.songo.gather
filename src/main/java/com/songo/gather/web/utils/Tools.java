/**
 * 
 */
package com.songo.gather.web.utils;

/**
 * <p>decription:</p>
 * <p>date:2015年11月23日 上午9:30:51</p>
 * @author gsu·napoleon
 */
public class Tools {

	public static String updateAd(String urlx, String adId) {
        int px = urlx.indexOf("#ad=");
        if (px == -1) {
            px = urlx.indexOf("&ad=");
        }
        if (px == -1) {
            px = urlx.indexOf("?ad=");
        }
        if (px > 0) {
            StringBuilder buf = new StringBuilder();
            for (int i = px + 4, c = urlx.length(); i < c; i++) {
                char ch = urlx.charAt(i);
                if (ch == '&') {
                    break;
                }
                buf.append(ch);
            }
            if (buf.length() > 0) {
                adId = buf.toString();
            }
        }
        return adId;
    }
	
}
