package request;  
  
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

import net.sf.json.JSONObject;  
  
  
public class HttpClientUtil {  
      
    /** 
     * POST方式调用 
     *  
     * @param url 
     * @param params 参数为NameValuePair键值对对象 
     * @return 响应字符串 
     * @throws java.io.UnsupportedEncodingException 
     */  
    public void executeByPOST(String URL, JSONObject json) {  
        try{
        URL url = new URL(URL); 
        HttpURLConnection connection = (HttpURLConnection) url 
                .openConnection(); 
        connection.setDoOutput(true); 
        connection.setDoInput(true); 
        connection.setRequestMethod("POST"); //设置请求方法
        connection.setRequestProperty("Charsert", "UTF-8"); //设置请求编码
        connection.setUseCaches(false); 
        connection.setInstanceFollowRedirects(true); 
        connection.setRequestProperty("Content-Type", 
                "application/json"); 

        connection.connect(); 

        //POST请求 
        DataOutputStream out = new DataOutputStream( 
                connection.getOutputStream()); //关键的一步


        out.writeBytes(json.toString()); 
        out.flush(); 
        out.close(); 

        // 读取响应
        if (connection.getResponseCode()==200) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String lines;
            StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes(), "utf-8");
                sb.append(lines);
            }
            System.out.println(sb.toString());
            reader.close();
        }
        connection.disconnect();
        }catch(Exception e){
            e.printStackTrace();
        }
    } 
    
    public void postRequest(){
        
    }
      
}  