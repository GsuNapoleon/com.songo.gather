/**
 * 
 */
package com.songo.gather.weixin.qy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.songo.gather.weixin.qy.aes.AesException;
import com.songo.gather.weixin.qy.aes.WXBizMsgCrypt;

/**
 * <p>
 * decription:
 * </p>
 * <p>
 * date:2015年5月7日 上午10:23:10
 * </p>
 * 
 * @author gsu·napoleon
 */
public class CertificationCenterServlet extends HttpServlet {

	/**
	 * <p>
	 * attribute:
	 * </p>
	 */
	private static final long serialVersionUID = 1L;

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
		String token = "TE2arg5itxlb4kL92jtp6";
		String corpID = "wx741487935be9c835";
		String encodingAESKey = "9pOZFEenIGbi4IcC1nvV80my5zM5jvJ9wzwGg1uhLf9";
		String verifyMsgSig = req.getParameter("msg_signature");
		String verifyTimeStamp = req.getParameter("timestamp");
		String verifyNonce = req.getParameter("nonce");
		String verifyEchoStr = req.getParameter("echostr");
		if (StringUtils.isNotBlank(verifyEchoStr)) {
			String echoStr; // 需要返回的明文
			WXBizMsgCrypt wxcpt = WXBizMsgCrypt.newInstance(token, encodingAESKey, corpID);
			resp.setContentType("text/html;charset=UTF-8");
	
			
			PrintWriter out = resp.getWriter();
			try {
				echoStr = wxcpt.verifyURL(verifyMsgSig, verifyTimeStamp,
						verifyNonce, verifyEchoStr);
				System.out.println("echoStr:" + echoStr);
				out.print(echoStr);
			} catch (Exception e) {
				e.printStackTrace();
				try {
					echoStr = wxcpt.verifyURL(verifyMsgSig, verifyTimeStamp,
							verifyNonce, verifyEchoStr);
					out.print(echoStr);
				} catch (AesException e1) {
					e1.printStackTrace();
				}
			} finally {
				out.close();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}

}
