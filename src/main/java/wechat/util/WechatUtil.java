package wechat.util;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class WechatUtil {

    private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    public static boolean verificaWechatMsg(HttpServletRequest req) {
        String signature = req.getParameter("signature");//微信加密签名  
        String timestamp = req.getParameter("timestamp");//时间戳  
        String nonce = req.getParameter("nonce");//随机数  
        List<String> list = new ArrayList<String>();
        list.add("linzp");
        list.add(timestamp);
        list.add(nonce);
        Collections.sort(list);//字典排序  
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

    private static String encode(String algorithm, String str) {
        if (str == null) {
            return null;
        }
        try {
            //Java自带的加密类  
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            //转为byte  
            messageDigest.update(str.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        // 把密文转换成十六进制的字符串形式  
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }
}
