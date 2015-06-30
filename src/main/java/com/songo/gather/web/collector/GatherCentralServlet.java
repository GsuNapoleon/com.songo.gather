/**
 * 
 */
package com.songo.gather.web.collector;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * decription:
 * </p>
 * <p>
 * date:2015年6月19日 下午4:09:13
 * </p>
 * 
 * @author gsu·napoleon
 */
public class GatherCentralServlet extends HttpServlet {

	private static final Logger logger = LoggerFactory
			.getLogger(GatherCentralServlet.class);

	/**
	 * <p>
	 * attribute:
	 * </p>
	 */
	private static final long serialVersionUID = 1L;

	private static final int MONITOR = 0;
	private static final int NORMAL = 1;
	private static final int OLD = 2;

	// 1 * 1 的透明图片，用于手机计数，gif格式
	private static final byte[] BLANK_PIC = { 71, 73, 70, 56, 57, 97, 1, 0, 1,
			0, (byte) 128, 0, 0, (byte) 255, (byte) 255, (byte) 255, 0, 0, 0,
			33, (byte) 249, 4, 1, 0, 0, 0, 0, 44, 0, 0, 0, 0, 1, 0, 1, 0, 0, 2,
			2, 68, 1, 0, 59 };

	private static String personalizationUrl;
	private static String counterId;
	private FileOutputManager manager = FileOutputManager.getInstance();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		StringBuilder redirectBuf = new StringBuilder();
		String screen = "";
		String from = req.getParameter("from");
		Cookie[] cookies = req.getCookies();
		Map<String, String> dealMaps = dealCookies(cookies);
		String oldChannel = getValueByKey(dealMaps, "OLD_CHANNEL");
		String pcgroupCID = getValueByKey(dealMaps, "PCGROUP_CID");
		String pcxuv = addPCxuv(resp, req.getServerName(), cookies);
		String adId = getAdId(req.getParameter("ad"));

		String iframeCode = req.getParameter("iframeCode");
		String referrer = req.getParameter("refer");
		String curUrl = req.getHeader("referer");
		Map<String, String> dealAdMaps = dealAd(req.getParameter("url"), 
				adId, req.getParameter("ldjc4ta"));
		String ldjc = getValueByKey(dealAdMaps, "LDJC");
		adId = getValueByKey(dealAdMaps, "AD_ID");

		// 将计数器功能扩展以至此其他需要进行计数统计处理的应用，增加一个id来标识统计对象
		String __uuid = req.getParameter("__uuid");

		String monitorTestId = req.getParameter("monitor");
		Map<String, String> dealChannel = dealChannel(req, monitorTestId, curUrl);
		String channel = getValueByKey(dealChannel, "CHANNEL");
		int type = Integer.valueOf(getValueByKey(dealChannel, "TYPE"));
		adId = getValueByKey(dealChannel, "AD_ID");
		
		resp.setHeader("Pragma", "No-cache");
		resp.setDateHeader("Expires", 0);
		resp.setHeader("Cache-Control", "no-cache");

		// unique visitor cookie processing
		UniqueVisitor uv = UniqueVisitor.parseByRequest(cookies);
		
		// writer req to file
		// 增加了ngnix作为代理后，获取client的IP和代理的方式有所改变。
		String[] ips = getIp(req);
		
		if (!"0000".equals(adId)) {
			manager.writer(String.valueOf(type), ips[0], ips[1],
					req.getParameter("screen"), curUrl, referrer, channel,
					adId, oldChannel,uv.getSuv(), uv.getUvData(), __uuid, pcgroupCID, ldjc,
					pcxuv, from, iframeCode);
			try {
				// clear cookie
				for (int i = 0; cookies != null && i < cookies.length; i++) {
					Cookie cookie = cookies[i];
					if ("pcsuv".equals(cookie.getName())
							|| "pcuvdata".equals(cookie.getName())) {
						cookie.setMaxAge(0);
						resp.addCookie(cookie);
					}
				}
				String domain = req.getServerName();
				domain = domain.substring(domain.indexOf('.'));
				uv.setAdId(adId);
				Cookie pcsuv = new Cookie("pcsuv", uv.getSuv());
				pcsuv.setMaxAge(63072000);
				pcsuv.setDomain(domain);
				resp.addCookie(pcsuv);

				uv.setLastAccessTime(System.currentTimeMillis());
				Cookie pcuvdata = new Cookie("pcuvdata", uv.getUvData());
				pcuvdata.setMaxAge(63072000);
				pcuvdata.setDomain(domain);
				resp.addCookie(pcuvdata);

				resp.addCookie(new Cookie("channel", channel));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		String wap = req.getParameter("wap");
		if (null != wap) {
			resp.setContentLength(BLANK_PIC.length);
			resp.setContentType("image/gif");
			resp.getOutputStream().write(BLANK_PIC);
			/*
			 * } else if (personalizationUrl != null && curUrl != null) {
			 * resp.sendRedirect(personalizationUrl +
			 * java.net.URLEncoder.encode(curUrl, "GBK"));
			 */
		} else if (personalizationUrl != null) {
			screen = req.getParameter("screen");
			if (referrer == null) {
				referrer = "";
			}
			if (channel == null) {
				channel = "";
			}
			if (screen == null) {
				screen = "";
			}

			redirectBuf.append(personalizationUrl).append("refer=")
					.append(java.net.URLEncoder.encode(referrer, "GBK"))
					.append("&screen=").append(screen).append("&channel=")
					.append(channel);

			resp.sendRedirect(redirectBuf.toString());
			// resp.sendRedirect(personalizationUrl +
			// java.net.URLEncoder.encode(curUrl,"GBK"));
		} else {
			out.println(" ");
		}
	}

	private Map<String, String> dealChannel(HttpServletRequest req, String monitorTestId, String curUrl) {
		Map<String, String> result = new HashMap<String, String>();
		int type = 1;
		String channel = req.getParameter("channel");
		String adId = null;
		if (monitorTestId != null) { // is a monitor test req
			type = MONITOR;
			adId = monitorTestId;
		} else if (channel != null) { // is a normal req
				type = NORMAL;
				if (adId == null || "".equals(adId)) {
					adId = getAd(curUrl);
				}
		} else {
			logger.error("处理广告、栏目等时,发生异常.栏目={{}}.", channel);
		}	
		
		result.put("CHANNEL", channel);
		result.put("AD_ID", adId);
		result.put("TYPE", String.valueOf(type));
		return result;
	}
	
	public String getValueByKey(Map<String, String> data, String key) {
		if (StringUtils.isEmpty(key) || data == null || data.isEmpty()) {
			return "";
		}
		return data.containsKey(key) ? data.get(key) : "";
	}
	
	/**
	 * <p>decription:</p>
	 * <p>date:2015年6月19日 下午5:42:29</p>
	 * @author gsu·napoleon
	 * @param adId
	 * @return
	 */
	private String getAdId(String adId) {
		if (adId != null) {
			adId = adId.trim();
		}
		return adId;
	}
	
	private Map<String, String> dealAd(String urlx, String adId, String ldjc) throws IOException {
		Map<String, String> result = new HashMap<String, String>();
		if (urlx != null && !"".equals(urlx)) {
			urlx = URLDecoder.decode(urlx, "UTF-8");
			result.put("URL_X", urlx);
			result.put("AD_ID", updateAd(urlx, adId));
			result.put("LDJC", updateLdjc(urlx, ldjc));
		}
		return result;
	}
	
	private Map<String, String> dealCookies(Cookie[] cookies) {
		try {
			Map<String, String> result = new HashMap<String, String>();
			int cookieCount = 2; // 修改cookie
			if (cookies != null) {
				for (int i = 0, c = cookies.length; i < c; ++i) {
					Cookie cookie = cookies[i];
					if ("channel".equals(cookie.getName())) {
						result.put("OLD_CHANNEL", cookie.getValue());
						cookieCount--;
					} else if ("u".equals(cookie.getName())) {
						result.put("PCGROUP_CID", cookie.getValue());
						cookieCount--;
					}
					if (cookieCount == 0) {
						break;
					}
				}
			}
			return result;
		} catch (Throwable e) {
			e.printStackTrace();
			logger.error("{}", e);
			return null;
		}
	}

	private String addPCxuv(HttpServletResponse response, String domain,
			Cookie[] cookies) {
		String pcxuv = "";
		Map<String, String> cookiesMap = getCookiesMap(cookies);

		// 只有在没有cookie，或者pcsuv没有值，或者pcsuv有值但是值为0的情况下
		// 才需要添加pcxuv,否则将其删除
		Cookie cookie = null;
		if (cookiesMap.isEmpty()
				|| !cookiesMap.containsKey("pcsuv")
				|| ("0".equals(cookiesMap.get("pcsuv")) && !cookiesMap
						.containsKey("pcxuv"))) {
			pcxuv = getUUID();
			cookie = new Cookie("pcxuv", pcxuv);
			cookie.setMaxAge(63072000);
			cookie.setDomain(domain);
			response.addCookie(cookie);
		} else if (cookiesMap.containsKey("pcxuv")) {
			pcxuv = cookiesMap.get("pcxuv");
			cookie = new Cookie("pcxuv", "0");
			cookie.setMaxAge(0);
			cookie.setDomain(domain);
			response.addCookie(cookie);
		}

		return pcxuv;
	}

	private Map<String, String> getCookiesMap(Cookie[] cookies) {
		Map<String, String> map = new HashMap<String, String>();
		if (cookies != null) {
			for (int i = 0, c = cookies.length; i < c; ++i) {
				Cookie cookie = cookies[i];
				map.put(cookie.getName(), cookie.getValue());
			}
		}
		return map;
	}

	private static String getAd(String url) {
		if (url == null) {
			return "";
		}

		int start = url.indexOf("?ad=");
		if (start == -1) {
			return "";
		}

		int end = url.indexOf("&", start + 1);

		String result = null;

		if (end == -1) {
			result = url.substring(start + 4);
		} else {
			result = url.substring(start + 4, end);
		}
		return result;
	}

	private static String updateAd(String urlx, String adId) {
		int px = urlx.indexOf("#ad=");
		if (px == -1) {
			px = urlx.indexOf("&ad=");
		}
		if (px == -1) {
			px = urlx.indexOf("#ad=");
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

	private static String updateLdjc(String urlx, String ldjc) {
		int px = urlx.indexOf("#ldjc4ta=");
		if (px == -1) {
			px = urlx.indexOf("&ldjc4ta=");
		}
		if (px == -1) {
			px = urlx.indexOf("?ldjc4ta=");
		}
		if (px > 0) {
			StringBuilder buf = new StringBuilder();
			for (int i = px + 9, c = urlx.length(); i < c; i++) {
				char ch = urlx.charAt(i);
				if (ch == '&') {
					break;
				}
				buf.append(ch);
			}
			if (buf.length() > 0) {
				ldjc = buf.toString();
			}
		}
		return ldjc;
	}

	public static String[] getIp(HttpServletRequest request) {
		String remoteAddr = request.getRemoteAddr();
		String forwarded = request.getHeader("X-Forwarded-For");
		String realIp = request.getHeader("X-Real-IP");
		String result[] = new String[2];

		// String ip = null;
		if (realIp == null) {
			// 无ngnix
			if (forwarded == null) {
				// 没有使用代理，用来填充getRemoteAddr()
				// ip = remoteAddr;
				result[0] = remoteAddr;
				result[1] = null;
			} else {
				// 使用了代理，用来填充getHeader("X-Forwarded-For")
				// ip = remoteAddr + "/" + forwarded;
				result[0] = remoteAddr;
				result[1] = forwarded;
			}
		} else {
			// 有ngnix层
			if (realIp.equals(forwarded)) {
				// 没有使用代理 ，用来填充getRemoteAddr()
				// ip = realIp;
				result[0] = realIp;
				result[1] = null;
			} else {
				// 使用了代理 , 用来填充getHeader("X-Forwarded-For")
				// ip = realIp + "/" + forwarded.replaceAll(", " + realIp, "");
				result[0] = realIp;
				result[1] = forwarded.replaceAll(", " + realIp, "");
			}
		}
		return result;
	}

	private static String getUUID() {
		StringBuilder builder = new StringBuilder();
		String s = UUID.randomUUID().toString();
		return builder.append(s.substring(0, 8)).append(s.substring(9, 13))
				.append(s.substring(14, 18)).append(s.substring(19, 23))
				.append(s.substring(24)).toString();
	}

}
