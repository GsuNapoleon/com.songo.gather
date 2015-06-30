package com.songo.gather.web.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Iterator;

import javax.sql.DataSource;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * <p>decription:</p>
 * <p>date:2014年7月22日 上午9:16:47</p>
 * @author gsu·napoleon
 */
public class WebUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(WebUtil.class);
	
	/**
	 * 请求网络地址(GET方法)并获取返回内容
	 * @param requestURL 请求地址
	 * @param charset 内容编码
	 * @return 服务器返回内容
	 */
	public static String getService(String requestURL, String charset) {
		HttpURLConnection connection = null;
		try {
			URL url = new URL(requestURL);
			connection = (HttpURLConnection) url.openConnection();
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");
			System.setProperty("sun.net.client.defaultReadTimeout", "30000");
			connection.setConnectTimeout(10000);
			connection.setReadTimeout(10000);
			connection.setRequestProperty("User-Agent", "MSIE 7.0");
			return getResponseContent(connection.getInputStream(), charset);
		} catch (Exception e) {
			logger.warn("以GET方式获取信息时,发生异常：{}", e);
			return "";
		} finally{
			if(connection!=null) {
				connection.disconnect();
			}
		}
	}
	
	/**
	 * 请求网络地址(POST方法)并获取返回内容
	 * @param requestURL 请求地址
	 * @param params 所请求的参数-值对
	 * @param charset 内容编码
	 * @return 服务器返回内容
	 */
	public static String postService(String requestURL, HashMap<String, String> params, String charset) {
		
		String BOUNDARY = "gsu·napoleon";
		StringBuilder sb = new StringBuilder();
		if (MapUtils.isNotEmpty(params)) {
			Iterator<String> keyIt = params.keySet().iterator();
			while(keyIt.hasNext()){
				String key = keyIt.next();
				String value = params.get(key);
				sb.append("--" + BOUNDARY + "\r\n");
				sb.append("Content-Disposition: form-data; name=\""+key+"\"" + "\r\n\r\n");
				sb.append(value+"\r\n");
			}
			sb.append("\r\n--" + BOUNDARY + "--\r\n");
		}
		HttpURLConnection conn = null;
		try {
			URL uUrl = new URL(requestURL);
			conn = (HttpURLConnection) uUrl.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
			conn.setRequestProperty("Content-Length", String.valueOf(sb.toString().getBytes("UTF-8").length));
			conn.setRequestProperty("Host", uUrl.getHost());
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.2; rv:18.0) Gecko/20100101 Firefox");
			conn.setRequestProperty("Connection", "keep-alive");
			conn.setDoOutput(true);
			
			outputStreamWriter(conn.getOutputStream(), charset, sb.toString(), true);
			
			return getResponseContent(conn.getInputStream(), charset);
		} catch (Exception e) {
			logger.warn("以POST方式提交数据时,发生异常：{}", e);
			return "";
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}
	
	/**
	 * 请求网络地址(POST方法)并获取返回内容
	 * @param requestURL 请求地址
	 * @param params 所请求的参数-值对
	 * @param postMsg 要发送给服务器的消息
	 * @param charset 内容编码
	 * @return 服务器返回内容
	 */
	public static String postService(String requestURL, HashMap<String, String> params, String postMsg, String charset) {
		try {
			URL url = new URL(requestURL);
			URLConnection uc = null;
			uc = url.openConnection();
			uc.setDoOutput(true);
			uc.setRequestProperty("Content-Type", "text/xml");
			
			if (MapUtils.isNotEmpty(params)) {
				Iterator<String> keyIt = params.keySet().iterator();
				while(keyIt.hasNext()){
					String key = keyIt.next();
					String value = params.get(key);
					uc.setRequestProperty(key, value);
				}
			}
			
			outputStreamWriter(uc.getOutputStream(), charset, postMsg, false);
			
			return getResponseContent(uc.getInputStream(), charset);
		} catch (Exception ex) {
			return "";
		}
	}
	
	/**
	 * 请求网络地址(POST方法)并获取返回内容
	 * @param requestURL 请求地址
	 * @param params 所请求的参数-值对
	 * @param postMsg 要发送给服务器的消息
	 * @param charset 内容编码
	 * @return 服务器返回内容
	 */
	public static String httpClientPostService(String requestURL, HashMap<String, String> params, String postMsg, String charset) {
		PostMethod postMethod = null;
		try {
			HttpClient client = new HttpClient();
			postMethod = new PostMethod(requestURL);
			RequestEntity requestEntity = new ByteArrayRequestEntity(postMsg.getBytes(charset));
			requestEntity.writeRequest(new ByteArrayOutputStream());
			postMethod.setRequestEntity(requestEntity);
			client.executeMethod(postMethod);
			
			return getResponseContent(postMethod.getResponseBodyAsStream(),charset);
		} catch (Exception ex) {
			return "";
		} finally {
			releaseConnection(postMethod);
		}
	}
	
	private static void releaseConnection (HttpMethodBase method) {
		try {
			logger.warn("Please wait!Release Connection coming!");
		} finally {
			if (method != null) {
				method.releaseConnection();
				method = null;
			}
		}
	}
	
	private static String getResponseContent(InputStream is, String charset) {
		
		if (is == null) {
			throw new IllegalAccessError("HttpServletResponse未做任何响应信息输出");
		}
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(is, charset));
			StringBuilder builder = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}
			if (logger.isDebugEnabled()) {
				logger.debug("客户端获取的响应信息是：[{}]", builder.toString());
			}
			return builder.toString();
		} catch (Exception e) {
			logger.error("获取Response的响应信息时,发生异常：{}", e);
			return StringUtils.EMPTY;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	private static void outputStreamWriter(OutputStream os, String charset, String content, boolean isBytes) {
		
		if (os == null) {
			throw new UnsupportedOperationException("OutputStream is null,System exits!");
		}
		
		OutputStreamWriter out = null;
		try {
			if (!isBytes) {
				out = new OutputStreamWriter(os, charset);
				out.write(content);
				out.flush();
			} else {
				os.write(content.getBytes(StringUtils.defaultString(charset, "UTF-8")));
				os.flush();
			}
			if (logger.isDebugEnabled()) {
				logger.debug("Output Stream Writer is Successly!!!");
			}
		} catch (Exception e) {
			logger.warn("输出流时,发生异常：{}", e);
		} finally {
			try {
				if (os != null) {
					os.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
			}
		}
	}

	/**
	 * 下载文件，这是一个阻塞方法，直到下载完成
	 * @param url 下载目标文件的URL地址
	 * @param newFilePath 下载到本地的文件路径
	 * @return 下载结果
	 */
	public static boolean downloadFile(String url, String newFilePath) {
		File dwnloadFile = new File(newFilePath);
		File destDir = dwnloadFile.getParentFile();
		if(dwnloadFile.isDirectory()
				|| (!destDir.exists() && !destDir.mkdirs())
				|| !destDir.isDirectory())
			return false;
		try {
			if(dwnloadFile.exists() && !dwnloadFile.delete())
				return false;
			if(!dwnloadFile.createNewFile())
				return false;
			URL uUrl = new URL(url);
			FileOutputStream os = new FileOutputStream(dwnloadFile);
			InputStream is = uUrl.openStream();
			byte[] buff = new byte[1024];
			while(true) {
				int readed = is.read(buff);
				if(readed == -1) {
					break;
				}
				byte[] temp = new byte[readed];
				System.arraycopy(buff, 0, temp, 0, readed);
				os.write(temp);
			}
			is.close(); 
			os.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * 上传文件，这是一个阻塞方法，直到上传完成
	 * @param localFilePath 本地待上传的文件路径
	 * @param fileParamName 文件数据的参数名
	 * @param url 上传到网络的目标地址
	 * @param params 其他额外参数
	 * @return 上传结果
	 */
	public static boolean uploadFile(String localFilePath, String fileParamName, String url, HashMap<String, String> params) {
		if(localFilePath==null
				|| fileParamName==null || fileParamName.trim().length()==0
				|| url==null || url.trim().length()==0)
			return false;
		File file = new File(localFilePath);
		if(!file.exists() || file.isDirectory())
			return false;
		if(params==null)
			params=new HashMap<String, String>();
		String BOUNDARY = "---------------------------WaflysWebUtil";
		StringBuilder sb = new StringBuilder();
		
		Iterator<String> keyIt = params.keySet().iterator();
		while(keyIt.hasNext()){
			String key = keyIt.next();
			String value = params.get(key);
			sb.append("--" + BOUNDARY + "\r\n");
			sb.append("Content-Disposition: form-data; name=\""+key+"\"" + "\r\n\r\n");
			sb.append(value+"\r\n");
		}
		sb.append("--" + BOUNDARY + "\r\n");
		sb.append("Content-Disposition: form-data; name=\""+fileParamName+"\"; filename=\"" + file.getName() + "\"" + "\r\n");
		sb.append("Content-Type: application/octet-stream" + "\r\n\r\n");

		byte[] before;
		try {
			before = sb.toString().getBytes("UTF-8");
		} catch (Exception e) { 
			before = new byte[0];
		}
		byte[] after = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();

		try {
			URL uUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) uUrl.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
			conn.setRequestProperty("Content-Length", String.valueOf(before.length + file.length() + after.length));
			conn.setRequestProperty("Host", uUrl.getHost());
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.2; rv:18.0) Gecko/20100101 Firefox");
			conn.setRequestProperty("Connection", "keep-alive");
			conn.setDoOutput(true);

			OutputStream out = conn.getOutputStream();
			InputStream in = new FileInputStream(file);

			out.write(before);

			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) != -1)
				out.write(buf, 0, len);

			out.write(after);

			in.close();
			out.close();
			return conn.getResponseCode() == 200;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static void main(String[] args){
//		postService("http://127.0.0.1:8080/angular/t/post", null, 
//				"<todolist><title>test</title><content>已同步的代办事项</content>"
//				+ "<sender>adcadministrator@2000101126</sender>"
//				+ "<receivers>adcadministrator@2000101126</receivers>"
//				+ "<identifytype>1</identifytype>"
//				+ "<completetime>2013-06-06 00:00:00</completetime>"
//				+ "<importance>2</importance><urgency>1</urgency>"
//				+ "<targeturl>http://127.0.0.1:8080/</targeturl>"
//				+ "<createtime>2013-02-04 16:11:13</createtime>"
//				+ "<appcode>35_3</appcode></todolist>", "UTF-8");
		httpClientPostService("http://127.0.0.1:8080/angular/t/post", null, 
				"<todolist><title>test</title><content>已同步的代办事项</content>"
						+ "<sender>adcadministrator@2000101126</sender>"
						+ "<receivers>adcadministrator@2000101126</receivers>"
						+ "<identifytype>1</identifytype>"
						+ "<completetime>2013-06-06 00:00:00</completetime>"
						+ "<importance>2</importance><urgency>1</urgency>"
						+ "<targeturl>http://127.0.0.1:8080/</targeturl>"
						+ "<createtime>2013-02-04 16:11:13</createtime>"
						+ "<appcode>35_3</appcode></todolist>", "UTF-8");
	}
}
