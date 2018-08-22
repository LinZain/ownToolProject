package wechat.service.impl;

import org.springframework.stereotype.Service;

import wechat.service.WechatMenuService;
import wechat.util.WechatConstants;
import wechat.util.WechatHttpReq;

@Service
public class WechatMenuServiceImpl implements WechatMenuService {
    public String addMenu(String param) {
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + WechatConstants.ACCESS_TOKEN;
        return WechatHttpReq.post(url, param);
    }

    public String queryMenu() {
        String url = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=" + WechatConstants.ACCESS_TOKEN;
        return WechatHttpReq.get(url);
    }

    public String deleteMenu() {
        String url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=" + WechatConstants.ACCESS_TOKEN;
        return WechatHttpReq.get(url);
    }
}
