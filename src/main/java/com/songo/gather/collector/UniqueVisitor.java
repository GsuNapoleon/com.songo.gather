/**
 * 
 */
package com.songo.gather.collector;

import java.util.Date;

import javax.servlet.http.Cookie;

import com.songo.gather.security.SecurityPasswordHash;
import com.songo.gather.utils.MyDateFormatter;
import com.songo.gather.utils.MyDateUtils;
import com.songo.gather.utils.MyStringUtils;

/**
 * <p>decription:</p>
 * <p>date:2015年6月19日 下午4:16:26</p>
 * @author gsu·napoleon
 */
public class UniqueVisitor {

    // 网站用户唯一标识
    String suv;

    // 最近一次访问网站时间
    long lastAccessTime;

    long tme;

    // 广告id
    String adId;

    // 到访网站次数
    int visits;

    public static String DEFINED_VAR_TIME = "lastAccessTime";

    public static String DEFINED_VAR_AD = "adId";

    public static String DEFINED_VAR_VISITS = "visits";

    final static long thirtyminutes = 30 * 60 * 1000;

    public UniqueVisitor() {
        suv = "0";
        lastAccessTime = 0;
        visits = 1;
        adId = "";
    }

    public String getSuv() {
        return suv;
    }

    public void setSuv(String suv) {
        this.suv = suv;
    }

    public long getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(long lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    public static UniqueVisitor parseByRequest(Cookie[] cookies) {
        UniqueVisitor uv = new UniqueVisitor();
        String uvData = null;
        int cookieCount = 2;

        for (int i = 0; cookies != null && i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if ("pcsuv".equals(cookie.getName())) {
                if ("0".equals(cookie.getValue())) {
                    uv.setSuv(String.valueOf(System.currentTimeMillis())
                            + "." + MyStringUtils.getUuid(4)
                            + "." + SecurityPasswordHash.base64Hash(MyStringUtils.getUuid(32), MyStringUtils.getUuid(8)));
                } else {
                    uv.setSuv(cookie.getValue());
                }
                cookieCount--;
            }

            if ("pcuvdata".equals(cookie.getName())) {
                uvData = cookie.getValue();
                cookieCount--;
            }
            if (cookieCount == 0) {
                break;
            }
        }

        uv.setUvData(uvData);
        if (isLastAccess(uv.getLastAccessTime())) {
            uv.setVisits(uv.getVisits() + 1);
        }

        return uv;
    }
    
    private static boolean isLastAccess(long srcTimes) {
    	long targetTimes = Integer.valueOf(
    			MyDateFormatter.YYYYMMDD.formatter(new Date())
    			+ FileOutputManager.getStartTime());
    	return srcTimes <= targetTimes;
    }

    public void setUvData(String uvdata) {
        try {
            if (uvdata == null || "".equals(uvdata)) {
                return;
            }

            String[] datas = uvdata.split("\\|");
            for (int j = 0; j < datas.length; j++) {
                String data = datas[j];
                if (data == null || "".equals(data) || data.indexOf("=") < 0) {
                    continue;
                }
                String key = data.substring(0, data.indexOf("="));
                String value = data.substring(data.indexOf("=") + 1);
                if (DEFINED_VAR_TIME.equals(key.trim())) {
                    this.lastAccessTime = Long.parseLong(value);
                } else if (DEFINED_VAR_AD.equals(key.trim())) {
                    this.adId = value;
                } else if (DEFINED_VAR_VISITS.equals(key.trim())) {
                    this.visits = Integer.parseInt(value);
                }
            }
        } catch (Exception ex) {
            // passed
        }
    }

    public String getUvData() {
        String data = "";

        data += DEFINED_VAR_TIME + "=" + this.lastAccessTime;

        if (adId != null && !"".equals(adId) && suv == null) {
            data += "|" + DEFINED_VAR_AD + "=" + adId;
        }

        if (suv != null && !"0".equals(suv)) {
            data += "|" + DEFINED_VAR_VISITS + "=" + (this.visits);
        }

        return data;
    }

    public static void main(String[] args) {
        String data = "visits=10";
        String key = data.substring(0, data.indexOf("="));
        String value = data.substring(data.indexOf("=") + 1);
        System.out.println(key);
        System.out.print(value);
    }

}
