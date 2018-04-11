package wechat.util;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

public class WechatHttpReq {

    private static PoolingHttpClientConnectionManager cm = null;

    static {
        LayeredConnectionSocketFactory sslsf = null;
        try {
            sslsf = new SSLConnectionSocketFactory(SSLContext.getDefault());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("https", sslsf)
                .register("http", new PlainConnectionSocketFactory())
                .build();
        cm =new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        cm.setMaxTotal(200);
        cm.setDefaultMaxPerRoute(20);
    }

    private static CloseableHttpClient getHttpClient() {
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .build();
        return httpClient;
    }

    public static String get(String url) {
        // ����Ĭ�ϵ�httpClientʵ��
        CloseableHttpClient httpClient = WechatHttpReq.getHttpClient();
        CloseableHttpResponse httpResponse = null;
        // ����get����
        try {
            // ��get��������http����
            HttpGet get = new HttpGet(url);
            httpResponse = httpClient.execute(get);
            // responseʵ��
            HttpEntity entity = httpResponse.getEntity();
            if (null != entity) {
                String response = EntityUtils.toString(entity);
                int statusCode = httpResponse.getStatusLine().getStatusCode();
                if (statusCode == HttpStatus.SC_OK) {
                    // �ɹ�
                    return response;
                } else {
                    return null;
                }
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (httpResponse != null) {
                try {
                    EntityUtils.consume(httpResponse.getEntity());
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static String post(String url, String param) {
        // ����Ĭ�ϵ�httpClientʵ��
        CloseableHttpClient httpClient = WechatHttpReq.getHttpClient();
        CloseableHttpResponse httpResponse = null;
        // ����get����
        try {
            // ��get��������http����
            HttpPost post = new HttpPost(url);
            if (null != param) {
                StringEntity entity = new StringEntity(param, "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                post.setEntity(entity);
            }
            httpResponse = httpClient.execute(post);
            // responseʵ��
            HttpEntity entity = httpResponse.getEntity();
            if (null != entity) {
                String response = EntityUtils.toString(entity);
                int statusCode = httpResponse.getStatusLine().getStatusCode();
                if (statusCode == HttpStatus.SC_OK) {
                    // �ɹ�
                    return response;
                } else {
                    return null;
                }
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (httpResponse != null) {
                try {
                    EntityUtils.consume(httpResponse.getEntity());
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
