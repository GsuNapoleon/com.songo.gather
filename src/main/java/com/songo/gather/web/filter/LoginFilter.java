/**
 * 
 */
package com.songo.gather.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>decription:该Filter实现这样一个功能----跳转到前一个请求URL</p>
 * <p>date:2014年4月25日 下午2:55:51</p>
 * @author gsu·napoleon
 */
public class LoginFilter implements Filter {
	private final Logger logger = LoggerFactory.getLogger(LoginFilter.class);
    private String beforeURL;
    
    @Override
    public void init(FilterConfig fc) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.debug("进入LoginFilter ............");
        HttpServletRequest hsreq = (HttpServletRequest)request;
        HttpServletResponse hsresp = (HttpServletResponse)response;
        String currentRequestURL = getBeforeRequestURL(hsreq);
        
        String reqServletURL = hsreq.getServletPath();
        logger.debug("请求的URL = {}, servlet path = {}", currentRequestURL, reqServletURL);
        HttpSession session = hsreq.getSession();
        UserInfo user = (UserInfo)session.getAttribute("__USER__");
        
        setBeforeRequestURL(user, currentRequestURL, reqServletURL);
//        if (user == null && (currentRequestURL != null && !currentRequestURL.contains("login.jsp") && !currentRequestURL.contains("logout.jsp")
//                && !currentRequestURL.contains("timeout.htm") && !currentRequestURL.contains("no-authority.htm") && !reqServletURL.contains("index.jsp"))) {
//            logger.debug("设置当前URL..................");
//            beforeURL = currentRequestURL;
//        }
        logger.info("Before URL : {}", beforeURL );
        if (user != null && StringUtils.isNotEmpty(beforeURL)) {
            logger.debug("Special .................................");
            hsresp.sendRedirect(beforeURL);
            cleanBeforeRequestURL();
        } else {
            logger.debug("Normal ...................................");
            chain.doFilter(hsreq, hsresp);
        }
        
    }
    
    private String getBeforeRequestURL(HttpServletRequest req) {
        String queryString = req.getQueryString();
        return req.getRequestURI() + 
                ((queryString != null && !"".equals(queryString)) ? ("?" + req.getQueryString()) : "");
    }
    
    private void setBeforeRequestURL(UserInfo user, String currentRequestURL, String reqServletURL) {
        if (user == null && (currentRequestURL != null && !currentRequestURL.contains("login.jsp") && !currentRequestURL.contains("logout.jsp")
                && !currentRequestURL.contains("timeout.htm") && !currentRequestURL.contains("no-authority.htm") && !reqServletURL.contains("index.jsp"))) {
            logger.debug("设置当前URL..................");
            beforeURL = currentRequestURL;
        }
    }
    
    private void cleanBeforeRequestURL() {
        if (StringUtils.isNotEmpty(beforeURL)) {
            beforeURL = StringUtils.EMPTY;
        }
    }

    @Override
    public void destroy() {
        
    }
}
class UserInfo {
	
}
