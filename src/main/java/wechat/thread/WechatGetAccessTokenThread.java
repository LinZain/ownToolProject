package wechat.thread;

import com.alibaba.fastjson.JSONObject;
import wechat.util.WechatConstants;
import wechat.util.WechatHttpReq;

public class WechatGetAccessTokenThread extends Thread {

    @Override
    public void run() {
//        while (true) {
//            StringBuffer urlStr = new StringBuffer();
//            urlStr.append("https://api.weixin.qq.com/cgi-bin/token?").append(getReqParam());
//            String result = WechatHttpReq.get(urlStr.toString());
//            JSONObject json = JSONObject.fromObject(result);
//            if (json.containsKey("access_token")) {
//                WechatConstants.ACCESS_TOKEN = (String) json.get("access_token");
//                WechatConstants.EXPIRES_IN = (int) json.get("expires_in");
//                System.out.println("��access_token:"+WechatConstants.ACCESS_TOKEN);
//            }
//            try {
//                if (WechatConstants.EXPIRES_IN != 0) {
//                    Thread.sleep(WechatConstants.EXPIRES_IN * 1000);
//                }
//                else{
//                    Thread.sleep(30 * 1000);
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

    }

    private String getReqParam() {
        StringBuffer param = new StringBuffer();
        param.append("grant_type=client_credential").append("&");
        param.append("appid=").append("wx366bb9d9de591a0b").append("&");
        param.append("secret=").append("7151669ddf28556a785e1e6cba1a8527");
        return param.toString();
    }
}
