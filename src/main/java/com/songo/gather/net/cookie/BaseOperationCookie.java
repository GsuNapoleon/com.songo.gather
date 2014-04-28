/**
 * 
 */
package com.songo.gather.net.cookie;

import java.io.IOException;
import java.net.HttpCookie;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>decription:</p>
 * <p>date:2014年4月25日 下午5:51:20</p>
 * @author gsu·napoleon
 */
public class BaseOperationCookie {

	public void clear(HttpServletResponse response, Cookie cookie) {
		cookie.setValue(null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	
	public void removes(HttpServletRequest request, HttpServletResponse response, MyType instance) {
		Cookie [] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (Long.valueOf(cookie.getValue()).equals(instance.getId())) {
					clear(response, cookie);
				}
			}
		}
	}
	
	public List<String> getCookieValuesByURLConnection() throws IOException {
		URLConnection conn = new URL("http://www.google.com.hk").openConnection();
		List<String> cookieValues = conn.getHeaderFields().get("Set-Cookie");
		return cookieValues;
	}
	
	public List<HttpCookie> parse() {
		List<HttpCookie> httpCookies = HttpCookie.parse("Set-Cookie");
		for (HttpCookie httpCookie : httpCookies) {
			httpCookie.setMaxAge(0);
		}
		return httpCookies;
	}
	
	/**
	 * 
	 * <p>decription:Cookie的Domain属性必须是真实、生效并可用的域.</p>
	 * <p>date:2014年4月28日 上午10:16:47</p>
	 * @author gsu·napoleon
	 */
	public void domain(Cookie cookie) {
		cookie.setDomain("www.google.com"); // 只能在域[www.google.com]下取到该cookie的值.
		cookie.setDomain(".google.com");	// 在符合该表达式[*.goolge.com]的域中,皆可访问该cookie
	}
	
	public void maxAge(Cookie cookie) {
		cookie.setMaxAge(-1);	// 不存储该cookie
		cookie.setMaxAge(0);	// 删除该cookie
	}
	
}
class MyType {
	private long id;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
}
