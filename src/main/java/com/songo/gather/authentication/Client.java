/**
 * 
 */
package com.songo.gather.authentication;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>
 * decription:
 * </p>
 * <p>
 * date:2015年5月20日 下午4:21:31
 * </p>
 * 
 * @author gsu·napoleon
 */
public class Client {
	private static final Log LOG = LogFactory.getLog(Client.class);
	private static boolean inited = false;

	private static HttpInvoker httpInvoker;
	private static String authServerUrl;
	private static String authServerUrl2;
	private static String authServerUrlSSL;
	private static String authServerUrlSSL2;
	private static Properties config;
	private static ConcurrentHashMap<String, List<UserInfo>> adminCache;
	private static ConcurrentHashMap<String, UserInfo> userCache;
	private static ConcurrentHashMap<String, UserInfo> userCache2;
	// private static String application;
	private static boolean mainServerErrored = false;
	private static long server2StratTime = 0;
	private static final long TWO_HOURS = 2 * 3600 * 1000;
	private static boolean authUseSSL;
	private static String authenticationUrl = "";
	private static String changePasswordUrl = "";

	private static String getAuthServerUrl() {
		synchronized (Class.class) {
			ensureInited();
			if (mainServerErrored) {
				if (System.currentTimeMillis() - server2StratTime > TWO_HOURS) {
					mainServerErrored = false;
				} else {
					return authServerUrl2;
				}
			}
		}
		return authServerUrl;
	}

	private static String getAuthServerUrlSSL() {
		synchronized (Class.class) {
			ensureInited();
			if (mainServerErrored) {
				if (System.currentTimeMillis() - server2StratTime > TWO_HOURS) {
					mainServerErrored = false;
				} else {
					return authServerUrlSSL2;
				}
			}
		}
		return authServerUrlSSL;
	}

	private static void ensureInited() {
		if (!inited) {
			throw new IllegalStateException("Client必须先初始化才能使用，请先调用init()方法初始化");
		}
	}

	/**
	 * 初始化
	 */
	public static synchronized void init() {
		if (inited)
			return;
		inited = true;

		loadConfig();
		initHttpInvoker();

		authenticationUrl = config.getProperty("auth.authenticationUrl");
		changePasswordUrl = config.getProperty("auth.changePasswordUrl");

		authServerUrlSSL = config.getProperty("auth.serverSSL");
		authServerUrlSSL2 = config.getProperty("auth.serverSSL2");
		authServerUrl = config.getProperty("auth.server");
		authServerUrl2 = config.getProperty("auth.server2");

		adminCache = new ConcurrentHashMap<String, List<UserInfo>>();
		userCache = new ConcurrentHashMap<String, UserInfo>();
		userCache2 = new ConcurrentHashMap<String, UserInfo>();
	}

	/**
	 * 获取登录结果
	 * 
	 * @param request
	 * @return UserInfo object
	 */
	public static UserInfo authResult(HttpServletRequest request) {
		String st = request.getParameter("st");
		if (st == null)
			return null;
		try {
			String ip = request.getRemoteAddr();
			String xForward = request.getHeader("X-Forwarded-For");
			if (xForward != null) {
				ip = ip + '/' + xForward;
			}
			if (authUseSSL) {
				return UserParser.decode(invokeHttps(getAuthServerUrlSSL()
						+ "todo.do?st=" + st + "&ip=" + ip));
			} else {
				return UserParser.decode(invokeHttp(getAuthServerUrl()
						+ "todo.do?st=" + st + "&ip=" + ip));
			}
		} catch (Throwable e) {
			LOG.error(e);
			throw new RuntimeException("error when execute todo!", e);
		}
	}

	/**
	 * @param ids
	 *            用逗号分割的用户id
	 * @return 用户列表
	 */
	public static List<UserInfo> getUsers(int sid, List<String> ids) {
		String notInCache = null;
		List<UserInfo> result = new ArrayList<UserInfo>(ids.size());
		Map<String, UserInfo> resultMap = new HashMap<String, UserInfo>();
		List<String> miss = new ArrayList<String>();

		// 首先给result中加入cache中存在的user，缺少的加入userId
		for (int i = 0, c = ids.size(); i < c; ++i) {
			String userId = (String) ids.get(i);
			UserInfo user = (UserInfo) userCache.get(sid + "-" + userId);
			if (user == null) {
				if (notInCache == null) {
					notInCache = userId;
				} else {
					notInCache = notInCache + ',' + userId;
				}
				miss.add(userId);
			} else {
				// result.add(user);
				resultMap.put(userId, user);
			}
		}

		// 给cache中加入缺少的user
		if (notInCache != null) {
			try {
				List<UserInfo> missing = UserParser
						.decodeList(invokeHttp(getAuthServerUrl()
								+ "todo.do?ids=" + notInCache));
				for (int i = 0, c = missing.size(); i < c; ++i) {
					UserInfo user = missing.get(i);
					userCache.put(sid + "-" + user.getId() + "", user);
					userCache2.put(sid + "-" + user.getAccount(), user);

					resultMap.put(user.getId() + "", user);
				}
			} catch (Throwable e) {
				LOG.error(e);
				throw new RuntimeException("error when execute todo!", e);
			}
		}
		result = new ArrayList<UserInfo>(resultMap.values());

		return result;
	}

	/**
	 * 获取指定应用的管理员列表
	 * 
	 * @param app
	 * @return 管理员列表
	 */
	public static List<UserInfo> getAdministrators(String app) {
		try {
			return UserParser.decodeList(invokeHttp(getAuthServerUrl()
					+ "todo.do?app=" + app));
		} catch (Throwable e) {
			LOG.error(e);
			throw new RuntimeException("error when execute todo!", e);
		}
	}

	/**
	 * 获取指定部门的用户列表html页面
	 * 
	 * @param areaId
	 * @param dept
	 * @return 用户列表
	 */
	public static String getUserListHtml(int areaId, long dept) {
		return invokeHttp(getAuthServerUrl() + "todo.jsp?areaId=" + areaId
				+ "&departmentId=" + dept);
	}

	public static String getUserListHtml(String account) {
		return getUserListHtml(account, 0);
	}

	public static String getUserListHtml(String account, int type) {
		if (type == 0)
			return invokeHttp(getAuthServerUrl() + "todo.jsp?account="
					+ account);
		else
			return invokeHttp(getAuthServerUrl() + "todo.jsp?account2="
					+ account);
	}

	/**
	 * 执行http请求
	 * 
	 * @param url
	 * @return 请求结果
	 */
	private static String invokeHttp(String url) {
		String result = "NULL";
		try {
			HttpInvoker.HttpResult httpResult = httpInvoker.invoke(url);
			if (httpResult.getStatusCode() == 200) {
				result = httpResult.getBody();
			} else {
				LOG.warn(httpResult + " when get url:" + url);
				if (httpResult.getStatusCode() == 321
						|| httpResult.getStatusCode() == 408) {
					synchronized (Client.class) {
						if (!mainServerErrored) {
							server2StratTime = System.currentTimeMillis();
							mainServerErrored = true;
							LOG.info("发现主服务器错误(" + authServerUrl
									+ ")，系统自动切换导从服务器(" + authServerUrl2 + ")");
						} else {
							mainServerErrored = false;
							server2StratTime = 0;
							LOG.info("发现从服务器错误(" + authServerUrl2
									+ ")，系统自动切换导主服务器(" + authServerUrl + ")");
						}
					}
				}
			}
		} catch (Throwable t) {
			LOG.error(t);
		}

		return result;
	}

	/**
	 * 执行http请求
	 * 
	 * @param url
	 * @return 请求结果
	 */
	private static String invokeHttps(String url) {
		String result = "NULL";
		try {
			HttpInvoker.HttpResult httpResult = httpInvoker.invoke(url);
			if (httpResult.getStatusCode() == 200) {
				result = httpResult.getBody();
			} else {
				LOG.warn(httpResult + " when get url:" + url);
				if (httpResult.getStatusCode() == 321
						|| httpResult.getStatusCode() == 408) {
					synchronized (Client.class) {
						if (!mainServerErrored) {
							server2StratTime = System.currentTimeMillis();
							mainServerErrored = true;
							LOG.info("发现主服务器错误(" + authServerUrlSSL
									+ ")，系统自动切换导从服务器(" + authServerUrlSSL2
									+ ")");
						} else {
							mainServerErrored = false;
							server2StratTime = 0;
							LOG.info("发现从服务器错误(" + authServerUrlSSL2
									+ ")，系统自动切换导主服务器(" + authServerUrlSSL + ")");
						}
					}
				}
			}
		} catch (Throwable t) {
			LOG.error(t);
		}

		return result;
	}

	/**
	 * 初始化http请求者
	 */
	private static void initHttpInvoker() {
		httpInvoker = new HttpInvoker();
		httpInvoker.setTimeout(Integer.parseInt(config
				.getProperty("http.timeout")));
		boolean useProxy = Boolean.valueOf(
				config.getProperty("http.useproxy", "false")).booleanValue();
		httpInvoker.setUseProxy(useProxy);
		if (useProxy) {
			httpInvoker.setProxyUrl(config.getProperty("http.proxy.url"));
			httpInvoker.setProxyPort(Integer.parseInt(config
					.getProperty("http.proxy.port")));
			httpInvoker.setProxyUser(config.getProperty("http.proxy.user"));
			httpInvoker.setProxyPassword(config
					.getProperty("http.proxy.password"));
		}

		authUseSSL = Boolean
				.valueOf(config.getProperty("auth.useSSL", "false"))
				.booleanValue();

		if (authUseSSL) {
			String sslPort = config.getProperty("auth.ssl.port", "443");
			httpInvoker.setUseSSL(authUseSSL);
			httpInvoker.setSslPort(Integer.parseInt(sslPort));
		}

		httpInvoker.init();
	}

	/**
	 * 加载应用配置
	 */
	private static void loadConfig() {
		config = new Properties();
		InputStream is = null;
		try {
			is = Client.class.getResourceAsStream("/todo.properties");
			if (is == null) {
				is = Client.class
						.getResourceAsStream("/default_todo.properties");
			}
			if (is != null) {
				config.load(is);
			} else {
				throw new RuntimeException("not found");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (Exception e) {
					LOG.error(e);
				}
			}
		}
	}

	/**
	 * 缓冲管理员对象
	 */
	private static List<UserInfo> adminList;
	private static HashMap<String, UserInfo> adminMap = new HashMap<String, UserInfo>();

	public static synchronized boolean isAdmin(int sid, long userId) {
		// 检查是否刷新缓存
		if (adminList == null || adminList != adminCache.get("ADMIN_LIST")) {
			adminList = adminCache.get("ADMIN_LIST");
			if (adminList == null) {
				adminList = getAdministrators(Facade.getApplication(sid));
				adminCache.put("ADMIN_LIST", adminList);
			}
			adminMap.clear();
			for (int i = 0, c = adminList.size(); i < c; ++i) {
				UserInfo user = (UserInfo) adminList.get(i);
				adminMap.put(sid + "-" + user.getId(), user);
			}
		}

		return adminMap.get(sid + "-" + userId) != null;
	}

	/**
	 * 缓冲普通用户
	 */
	public static UserInfo getUser(int sid, String userId) {
		if (userId == null)
			return null;
		UserInfo result = (UserInfo) userCache.get(sid + "-" + userId);
		if (result == null) {
			List<UserInfo> list = UserParser
					.decodeList(invokeHttp(getAuthServerUrl() + "todo.do?ids="
							+ userId));
			if (list.size() > 0) {
				result = (UserInfo) list.get(0);
				userCache.put(userId, result);
				userCache2.put(result.getAccount(), result);
			}
		}
		return result;
	}

	public static UserInfo getUserByAccount(int sid, String account) {
		if (account == null)
			return null;
		UserInfo result = (UserInfo) userCache2.get(sid + "-" + account);
		if (result == null) {
			List<UserInfo> list = UserParser
					.decodeList(invokeHttp(getAuthServerUrl()
							+ "todo.do?accounts=" + account));
			if (list.size() > 0) {
				result = (UserInfo) list.get(0);
				userCache.put(sid + "-" + result.getId() + "", result);
				userCache2.put(sid + "-" + account, result);
			}
		}

		return result;
	}

	/**
	 * 清除缓存，主要用于偶尔增加了应用管理员的情况
	 * 
	 */
	public static void clearCache() {
		adminCache.clear();
		userCache.clear();
	}

	/**
	 * 获得配置信息
	 * 
	 * @return 配置信息
	 */
	public static Properties getConfig() {
		return config;
	}

	/**
	 * 获得登录认证提交的url
	 * 
	 * @return 认证url
	 */
	public static String getAuthenticationUrl() {
		ensureInited();
		return authenticationUrl;
	}

	/**
	 * 获得用户修改密码的url
	 * 
	 * @return url
	 */
	public static String getChangePasswordUrl() {
		return changePasswordUrl;
	}
}
