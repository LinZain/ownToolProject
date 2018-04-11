package wechat.controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WechatConnTestController {
    private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5',  
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };  
    
    @RequestMapping(value = "/test", method = { RequestMethod.POST, RequestMethod.GET })
    public void TestConn(HttpServletRequest request, HttpServletResponse response) throws Exception {
        boolean validate = validate(request);  
        if (validate) {  
            response.getWriter().write(request.getParameter("echostr"));  
            response.getWriter().close();  
        }  
    }
   
   
    private boolean validate(HttpServletRequest req) throws IOException {  
        String signature = req.getParameter("signature");//΢�ż���ǩ��  
        String timestamp = req.getParameter("timestamp");//ʱ���  
        String nonce = req.getParameter("nonce");//�����  
        List<String> list = new ArrayList<String>();  
        list.add("linzp");  
        list.add(timestamp);  
        list.add(nonce);  
        Collections.sort(list);//�ֵ�����  
        String s = "";  
        for (int i = 0; i < list.size(); i++) {  
            s += (String) list.get(i);  
        }  
        if (encode("SHA1", s).equalsIgnoreCase(signature)) {  
            return true;  
        } else {  
            return false;  
        }  
    }  
  
    public static String encode(String algorithm, String str) {  
        if (str == null) {  
            return null;  
        }  
        try {  
            //Java�Դ��ļ�����  
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);  
            //תΪbyte  
            messageDigest.update(str.getBytes());  
            return getFormattedText(messageDigest.digest());  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }  
  
    private static String getFormattedText(byte[] bytes) {  
        int len = bytes.length;  
        StringBuilder buf = new StringBuilder(len * 2);  
        // ������ת����ʮ�����Ƶ��ַ�����ʽ  
        for (int j = 0; j < len; j++) {  
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);  
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);  
        }  
        return buf.toString();  
    }  
}
