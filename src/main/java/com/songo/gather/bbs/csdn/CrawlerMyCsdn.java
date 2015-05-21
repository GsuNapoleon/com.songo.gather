/**
 * 
 */
package com.songo.gather.bbs.csdn;

import java.net.URL;

import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.util.HttpURLConnection;

/**
 * <p>decription:</p>
 * <p>date:2014年8月27日 下午2:34:53</p>
 * @author gsu·napoleon
 */
public class CrawlerMyCsdn {
	
	public void login(String uri) throws Exception {
		try {
			URL url = new URL(uri);
			HttpURLConnection httpURLConnection = new HttpURLConnection(new GetMethod(), url);
		} finally {
			
		}
	}

}
