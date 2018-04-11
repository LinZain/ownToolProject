package wechat.service.impl;

import wechat.service.WechatMsgService;
import wechat.util.WechatConstants;
import wechat.util.WechatHttpReq;

public class WechatMsgServiceImpl implements WechatMsgService {

    @Override
    public String sendMsg(String msg) {
        String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + WechatConstants.ACCESS_TOKEN;
        return WechatHttpReq.post(url, msg);
    }
}
