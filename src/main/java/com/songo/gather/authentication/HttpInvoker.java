/**
 * 
 */
package com.songo.gather.authentication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpClientError;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.apache.commons.httpclient.protocol.SecureProtocolSocketFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>decription:</p>
 * <p>date:2015年5月20日 下午4:27:03</p>
 * @author gsu·napoleon
 */
public class HttpInvoker {
	private static final Log LOG = LogFactory.getLog(HttpInvoker.class);

    private int timeout = 10000;
    private boolean useProxy;
    private String proxyUrl;
    private int proxyPort;
    private String proxyUser;
    private String proxyPassword;
    private boolean useSSL;
    private int sslPort;

    public void setUseSSL(boolean userSSL) {
        this.useSSL = userSSL;
    }

    public void setSslPort(int sslPort) {
        this.sslPort = sslPort;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public void setUseProxy(boolean useProxy) {
        this.useProxy = useProxy;
    }

    public void setProxyUrl(String proxyUrl) {
        this.proxyUrl = proxyUrl;
    }

    public void setProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
    }

    public void setProxyUser(String proxyUser) {
        this.proxyUser = proxyUser;
    }

    public void setProxyPassword(String password) {
        this.proxyPassword = password;
    }

    /**
     * 初始化，必须执行
     */
    public void init() {
    }
    
    private HttpClient getClient() {
        HttpClient httpClient = new HttpClient();
        httpClient.getParams().setParameter("http.protocol.content-charset", "gbk");
        httpClient.getParams().setSoTimeout(timeout);

        if (useSSL) {
            if (sslPort > 0) {
                Protocol myhttps = new Protocol("https",
                        (ProtocolSocketFactory)new EasySSLProtocolSocketFactory(), sslPort);
                Protocol.registerProtocol("https", myhttps);
            }
        }

        if (useProxy) {
            HostConfiguration hc = new HostConfiguration();
            hc.setProxy(proxyUrl, proxyPort);
            httpClient.setHostConfiguration(hc);
            if (proxyUser != null) {
                httpClient.getState().setProxyCredentials(
                        AuthScope.ANY,
                        new UsernamePasswordCredentials(proxyUser, proxyPassword)
                );
            }
        }
        
        return httpClient;
    }

    /**
     * 执行http get请求
     * @param url
     * @return HttpResult
     */
    public HttpResult invoke(String url) {
        GetMethod get = null;
        HttpResult result = null;
        try {
            get = new GetMethod(url);
            getClient().executeMethod(get);
            int statusCode = get.getStatusCode();
            String statusText = get.getStatusText();
            result = new HttpResult(statusCode, statusText);

            if (statusCode == 200) {
                StringBuffer buf = new StringBuffer();
                BufferedReader br = new BufferedReader(new InputStreamReader(get.getResponseBodyAsStream()));
                String line;
                while ((line = br.readLine()) != null) {
                    buf.append(line).append('\n');
                }
                result.setBody(buf.toString());
            }

        } catch (SocketTimeoutException e) {
            result = new HttpResult(408, "REQUEST TIMEOUT. " + e.getMessage());
        } catch (java.net.ConnectException e) {
            result = new HttpResult(321, "Connection refused. " + e.getMessage());
        } catch (Exception e) {
            LOG.error(e);
            result = new HttpResult(123, e.getMessage());
        } finally {
            if (get != null) {
                try {
                    //byte[] bytes = get.getResponseBody();
                    get.releaseConnection();
                } catch (Exception e) {
                    LOG.error(e);
                }
            }
        }

        return result;
    }

    /**
     * HTTP请求结果
     */
    public static class HttpResult {
        int statusCode;
        String statusText;
        String body;

        public HttpResult() {
        }

        public HttpResult(int code, String text) {
            this.statusCode = code;
            this.statusText = text;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        public String getStatusText() {
            return statusText;
        }

        public void setStatusText(String statusText) {
            this.statusText = statusText;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String toString() {
            StringBuffer buf = new StringBuffer();
            buf.append(statusCode);
            buf.append("#");
            buf.append(statusText);
            return buf.toString();
        }
    }
    
    private static class EasySSLProtocolSocketFactory implements SecureProtocolSocketFactory {
    	/** Log object for this class. */
        private static final Log LOG = LogFactory.getLog(EasySSLProtocolSocketFactory.class);

        private SSLContext sslcontext = null;

        /**
         * Constructor for cn.pconline.security.authentication.ssl.EasySSLProtocolSocketFactory.
         */
        public EasySSLProtocolSocketFactory() {
            super();
        }

        private static SSLContext createEasySSLContext() {
            try {
                SSLContext context = SSLContext.getInstance("SSL");
                context.init(
                  null,
                  new TrustManager[] {new EasyX509TrustManager(null)},
                  null);
                return context;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                throw new HttpClientError(e.toString());
            }
        }

        private SSLContext getSSLContext() {
            if (this.sslcontext == null) {
                this.sslcontext = createEasySSLContext();
            }
            return this.sslcontext;
        }

        /**
         * @see SecureProtocolSocketFactory#createSocket(java.lang.String,int,java.net.InetAddress,int)
         */
        public Socket createSocket(
            String host,
            int port,
            InetAddress clientHost,
            int clientPort)
            throws IOException, UnknownHostException {

            return getSSLContext().getSocketFactory().createSocket(
                host,
                port,
                clientHost,
                clientPort
            );
        }

        /**
         * Attempts to get a new socket connection to the given host within the given time limit.
         * <p>
         * To circumvent the limitations of older JREs that do not support connect timeout a
         * controller thread is executed. The controller thread attempts to create a new socket
         * within the given limit of time. If socket constructor does not return until the
         * timeout expires, the controller terminates and throws an {@link ConnectTimeoutException}
         * </p>
         *
         * @param host the host name/IP
         * @param port the port on the host
         * @param params {@link HttpConnectionParams Http connection parameters}
         *
         * @return Socket a new socket
         *
         * @throws IOException if an I/O error occurs while creating the socket
         * @throws UnknownHostException if the IP address of the host cannot be
         * determined
         */
        public Socket createSocket(
            final String host,
            final int port,
            final InetAddress localAddress,
            final int localPort,
            final HttpConnectionParams params
        ) throws IOException, UnknownHostException, ConnectTimeoutException {
            if (params == null) {
                throw new IllegalArgumentException("Parameters may not be null");
            }
            int timeout = params.getConnectionTimeout();
            SocketFactory socketfactory = getSSLContext().getSocketFactory();
            if (timeout == 0) {
                return socketfactory.createSocket(host, port, localAddress, localPort);
            } else {
                Socket socket = socketfactory.createSocket();
                SocketAddress localaddr = new InetSocketAddress(localAddress, localPort);
                SocketAddress remoteaddr = new InetSocketAddress(host, port);
                socket.bind(localaddr);
                socket.connect(remoteaddr, timeout);
                return socket;
            }
        }

        /**
         * @see SecureProtocolSocketFactory#createSocket(java.lang.String,int)
         */
        public Socket createSocket(String host, int port)
            throws IOException, UnknownHostException {
            return getSSLContext().getSocketFactory().createSocket(
                host,
                port
            );
        }

        /**
         * @see SecureProtocolSocketFactory#createSocket(java.net.Socket,java.lang.String,int,boolean)
         */
        public Socket createSocket(
            Socket socket,
            String host,
            int port,
            boolean autoClose)
            throws IOException, UnknownHostException {
            return getSSLContext().getSocketFactory().createSocket(
                socket,
                host,
                port,
                autoClose
            );
        }

        public boolean equals(Object obj) {
            return ((obj != null) && obj.getClass().equals(EasySSLProtocolSocketFactory.class));
        }

        public int hashCode() {
            return EasySSLProtocolSocketFactory.class.hashCode();
        }
    }
}
