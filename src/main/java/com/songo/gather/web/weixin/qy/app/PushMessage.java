/**
 * 
 */
package com.songo.gather.web.weixin.qy.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.songo.gather.web.weixin.HttpApi;
import com.songo.gather.web.weixin.qy.http.HttpRequest;

/**
 * <p>decription:</p>
 * <p>date:2015年9月24日 上午9:53:39</p>
 * @author gsu·napoleon
 */
public class PushMessage {

	private static final Logger logger = LoggerFactory.getLogger(PushMessage.class);
	
	/**
	 * 
	 * https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=ACCESS_TOKEN
	 * wJhgbSfEI-aqjZu2dO_njvAWgXuxwLDPMQHROL67KbMCzxstG-J7BKO3OUkLZd3i7g8jZQyIbMYOPxDwNUREtQ
	 * <p>decription:</p>
	 * <p>date:2015年9月24日 上午9:53:39</p>
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		String accessToken = HttpRequest.getAccessToken();
		logger.info("access token is [{}].", accessToken);
		HttpApi.jpost("https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=" + accessToken, null, text(), "UTF-8");
//		text();
	}
	
	/**
	 * {
		   "touser": "UserID1|UserID2|UserID3",
		   "toparty": " PartyID1 | PartyID2 ",
		   "totag": " TagID1 | TagID2 ",
		   "msgtype": "text",
		   "agentid": "1",
		   "text": {"content": "Holiday Request For Pony(http://xxxxx)"},
		   "safe":"0"
		}
	 * <p>decription:</p>
	 * <p>date:2015年9月24日 上午10:22:45</p>
	 * @author gsu·napoleon
	 * @return
	 */
	private static String text() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n{\n").append("\"touser\": \"\",\n")
			.append("\"toparty\": \"\",\n")
			.append("\"totag\": \"2\",\n")
			.append("\"msgtype\": \"text\",\n")
			.append("\"agentid\": \"2\",\n")
			.append("\"text\": {\"content\": \"Hello, everybody! It's this test! Don't no answer!\"},\n")
			.append("\"safe\":\"0\"\n}");
		logger.debug("message content : [{}].", sb);
		return sb.toString();
	}

}
