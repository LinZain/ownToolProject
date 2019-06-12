package http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpPostRequest {

    public static void main(String args[])throws Exception{
        HashMap paramMap = new HashMap();
        paramMap.put("evtInfo", "中毒2");
        paramMap.put("evtType", 2);
        paramMap.put("uid", "3000200");
        paramMap.put("token", "6EC60F4F794EA2C22C837669325F6D4B");

        List<MultipartFile> files = new ArrayList<MultipartFile>();
        {
            File pdfFile = new File("/Users/zain/Downloads/ceshi.amr");
            FileInputStream fileInputStream = new FileInputStream(pdfFile);
            MultipartFile multipartFile = new MockMultipartFile(pdfFile.getName(), pdfFile.getName(),
                    ContentType.APPLICATION_OCTET_STREAM.toString(), fileInputStream);
            files.add(multipartFile);
        }
        HttpPostRequest.postMultipartFile("http://47.103.35.148:6100/res/fileUploadToEvent",files,"files",paramMap,100000);
    }

    /**
     * post 方法
     *
     * @param url
     * @param json
     * @return
     */
    private static String post(String url, String json) {
        HttpClient httpClient = new DefaultHttpClient();
        org.apache.http.client.methods.HttpPost method = new org.apache.http.client.methods.HttpPost(url);
        String responseBody = null;
        try {
            // 建立一个NameValuePair数组，用于存储欲传送的参数
            method.addHeader("Content-type", "application/json; charset=utf-8");
            method.setHeader("Accept", "application/json");
            method.setEntity(new StringEntity(json, Charset.forName("UTF-8")));
            long startTime = System.currentTimeMillis();
            HttpResponse response = httpClient.execute(method);
            long endTime = System.currentTimeMillis();
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
            }
            // Read the response body
            responseBody = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            // 网络错误
            e.printStackTrace();
        } finally {
            return responseBody;
        }
    }

    public static Map<String, String> postMultipartFile(String url, List<MultipartFile> multipartFiles, String fileParName,
                                                       Map<String, Object> params, int timeout) {
        Map<String, String> resultMap = new HashMap<String, String>();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = "";
        try {
            HttpPost httpPostRequest = new HttpPost(url);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.setCharset(java.nio.charset.Charset.forName("UTF-8"));
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            String fileName = null;
            MultipartFile multipartFile = null;
            for (int i = 0; i < multipartFiles.size(); i++) {
                multipartFile = multipartFiles.get(i);
                fileName = multipartFile.getOriginalFilename();
                builder.addBinaryBody(fileParName, multipartFile.getInputStream(), ContentType.MULTIPART_FORM_DATA, fileName);// 文件流
            }
            //决中文乱码
            ContentType contentType = ContentType.create(HTTP.PLAIN_TEXT_TYPE, HTTP.UTF_8);
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (entry.getValue() == null)
                    continue;
                // 类似浏览器表单提交，对应input的name和value
                builder.addTextBody(entry.getKey(), entry.getValue().toString(),ContentType.APPLICATION_JSON);
            }
            HttpEntity entity = builder.build();
            httpPostRequest.setEntity(entity);
            HttpResponse response = httpClient.execute(httpPostRequest);// 执行提交



            // 设置连接超时时间
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(timeout)
                    .setConnectionRequestTimeout(timeout).setSocketTimeout(timeout).build();
            httpPostRequest.setConfig(requestConfig);

            HttpEntity responseEntity = response.getEntity();
            resultMap.put("scode", String.valueOf(response.getStatusLine().getStatusCode()));
            resultMap.put("data", "");
            if (responseEntity != null) {
                // 将响应内容转换为字符串
                result = EntityUtils.toString(responseEntity, java.nio.charset.Charset.forName("UTF-8"));
                resultMap.put("data", result);
            }
        } catch (Exception e) {
            resultMap.put("scode", "error");
            resultMap.put("data", "HTTP请求出现异常: " + e.getMessage());

            Writer w = new StringWriter();
            e.printStackTrace(new PrintWriter(w));
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultMap;
    }
}

