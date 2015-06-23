/**
 * 
 */
package com.songo.gather.weixin;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * decription:
 * </p>
 * <p>
 * date:2015年4月22日 下午2:29:44
 * </p>
 * 
 * @author gsu·napoleon
 */
public class HttpApi {

	private static final Logger logger = LoggerFactory.getLogger(HttpApi.class);
	
	public static String httpsGet(String requestURL, String charset) {
        HttpsURLConnection connection = null;
        try {
            
            TrustManager [] tms = { new MyTrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tms, new SecureRandom());
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
			URL url = new URL(requestURL);
            connection = (HttpsURLConnection) url.openConnection();
            connection.setSSLSocketFactory(sslSocketFactory);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod("GET");
            connection.connect();
            String respStr = getResponseContent(connection.getInputStream(), charset);
            return respStr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
	
	private static class MyTrustManager implements X509TrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
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
	public static String jpost(String requestURL, Map<String, String> params, 
			String postMsg, String charset) {
		try {
			URL url = new URL(requestURL);
			URLConnection uc = null;
			uc = url.openConnection();
			uc.setDoOutput(true);
			uc.setRequestProperty("Content-Type", "text/xml");
			
			if (params != null && !params.isEmpty()) {
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
	 * 
	 * @param requestURL
	 *            请求地址
	 * @param params
	 *            所请求的参数-值对
	 * @param postMsg
	 *            要发送给服务器的消息
	 * @param charset
	 *            内容编码
	 * @return 服务器返回内容
	 */
	public static String post(String requestURL,
			Map<String, String> params, String postMsg, String charset) {
		PostMethod method = null;
		try {
			HttpClient client = new HttpClient();
			method = new PostMethod(requestURL);
			RequestEntity requestEntity = new ByteArrayRequestEntity(postMsg.getBytes(charset));
			requestEntity.writeRequest(new ByteArrayOutputStream());
			method.setRequestEntity(requestEntity);
			client.executeMethod(method);
			
			return getResponseContent(method.getResponseBodyAsStream(),
					charset);
		} catch (Exception ex) {
			return "";
		} finally {
			releaseConnection(method);
		}
	}
	
	public static String get(String uri, String code) {
		GetMethod method = null;
		
		try {
			method = new GetMethod(uri);
			HttpClient client = new HttpClient();
			client.executeMethod(method);
			
			return getResponseContent(method.getResponseBodyAsStream(), code);
		} catch(Exception ex) {
			
		} finally {
			releaseConnection(method);
		}
		
		return "";
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
        InputStreamReader isr = null;
		try {
            isr = new InputStreamReader(is, charset);
			reader = new BufferedReader(isr);
			StringBuilder builder = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}
			return builder.toString();
		} catch (IOException e) {
            e.printStackTrace();
			return StringUtils.EMPTY;
		} finally {
            try {
                if (isr != null) {
                    isr.close();
                }
                if (reader != null) {
                    reader.close();
                }
                is.close();
            } catch (IOException e) {
            }
		}
	}

	private static void outputStreamWriter(OutputStream os, String charset,
			String content, boolean isBytes) {

		if (os == null) {
			throw new UnsupportedOperationException(
					"OutputStream is null,System exits!");
		}

		OutputStreamWriter out = null;
		try {
			if (!isBytes) {
				out = new OutputStreamWriter(os, charset);
				out.write(content);
				out.flush();
			} else {
				os.write(content.getBytes(StringUtils.defaultString(charset,
						"UTF-8")));
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
	 * <p>
	 * decription:
	 * </p>
	 * <p>
	 * date:2015年4月22日 下午2:29:45
	 * </p>
	 * 
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		String accessToken = httpsGet("https://api.weixin.qq.com/cgi-bin/token"
				+ "?grant_type=client_credential&appid=wx9f50d8f776c31906"
				+ "&secret=db07fe94b5c664abcf1b5a0b1d4529a8", "UTF-8");
		System.err.println( accessToken);		
		System.out.println("kR9rwCZVMtUEFSOHrUQUvCxEnPUK0mFZ".length());
	}

}
