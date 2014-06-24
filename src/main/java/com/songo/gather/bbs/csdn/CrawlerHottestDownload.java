/**
 * 
 */
package com.songo.gather.bbs.csdn;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URL;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.util.HttpURLConnection;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>decription:尝试爬去csdn的极热下载文章</p>
 * <p>problem:在获取最终的下载URL时,出意外了</p>
 * <p>date:2014年6月19日 下午2:24:07</p>
 * @author gsu·napoleon
 */
public class CrawlerHottestDownload {
	
	private static final Logger logger = LoggerFactory.getLogger(CrawlerHottestDownload.class);
	
	private static final String CSDN_DOWNLOAD_URL = "http://download.csdn.net";
	
	public void runDownload(String uri) {
		HttpURLConnection httpURLConn = null;
		try {
			URL url = new URL(uri);
			httpURLConn = new HttpURLConnection(new GetMethod(), url);
			InputStream is = httpURLConn.getInputStream();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		HttpConnection httpConn = 
	}
	
	public String getPageContent(String uri) {
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		HttpClient httpClient = httpClientBuilder.build();
		HttpUriRequest httpReq = new HttpGet(uri);
		HttpResponse httpResp = null;
		HttpEntity httpEntity = null;
		try {
			httpResp = httpClient.execute(httpReq);
			httpEntity = httpResp.getEntity();
			if (httpEntity != null) {
				InputStream is = httpEntity.getContent();
				StringWriter writer = new StringWriter();
				IOUtils.copy(is, writer, "UTF-8");
				writer.close();
				is.close();
				return writer.toString();
			}
		} catch (IOException e) {
			logger.error("获取网页内容时,发生异常,具体为：{}", e);
			return StringUtils.EMPTY;
		} finally {
			httpReq.abort();
			try {
				EntityUtils.consume(httpEntity);
			} catch (Exception e2) {
				
			}
		}
		return StringUtils.EMPTY;
	}
	
	public Set<String> getDownloadHref(String pageContent) {
		if (pageContent == null) {
			return null;
		}
		Set<String> downloadHrefSets = new LinkedHashSet<String>();
		try {
			Document document = Jsoup.parse(pageContent);
			Elements elements = document.select("div.res_classfiy");
			elements = document.select("ul.recom_list li a");
			addURLs(downloadHrefSets, elements);
			Elements elements1 = document.select("div.res_classfiy");
			elements1 = document.select("ul.res_list li a");
			addURLs(downloadHrefSets, elements1);
		} catch (Exception e) {
			
		}
		return downloadHrefSets;
	}
	
	private void addURLs(Set<String> sets, Elements eles) {
		if (eles == null) {
			return;
		}
		
		if (sets == null) {
			sets = new LinkedHashSet<String>();
		}
		
		for (Element e : eles) {
			String url = startWithHttp(e.attr("href"));
			sets.add(url);
		}
	}
	
	public String getConcreteDownloadHref(String downloadPageContent) {
		if (downloadPageContent == null) {
			return null;
		}
		
		try {
			Document document = Jsoup.parse(downloadPageContent);
			Elements elements = document.select("div.btn_area a");
			if (elements != null && elements.size() > 0) {
				return startWithHttp(elements.get(0).attr("href"));
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private String startWithHttp(String url) {
		return (StringUtils.isNotEmpty(url) && !url.startsWith("http://")) 
				? CSDN_DOWNLOAD_URL + url : url;
	}
	
	/**
	 * http://dlwt.csdn.net/fd.php?i=154769278331809&s=a333033b08830b3e950cad5f43d83bad
	 * <p>decription:</p>
	 * <p>date:2014年6月19日 下午4:36:23</p>
	 * @author gsu·napoleon
	 * @param downloadPageContent
	 * @return
	 */
	public String getConcreteDownloadURL(String downloadPageContent) {
		if (downloadPageContent == null) {
			return null;
		}
		
		try {
			Document document = Jsoup.parse(downloadPageContent);
			Elements elements = document.select("div.res_down_area");
			if (elements != null && elements.size() > 0) {
				return startWithHttp(elements.get(0).attr("href"));
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
