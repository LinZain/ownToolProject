package wechat.service.impl;

import wechat.service.WechatTemplateService;
import wechat.util.WechatConstants;
import wechat.util.WechatHttpReq;

public class WechatTemplateServiceImpl implements WechatTemplateService {

    public String setIndustry(String msg) {
        String url = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=" + WechatConstants.ACCESS_TOKEN;
        return WechatHttpReq.post(url, msg);
    }

    public String getIndustry() {
        String url = "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=" + WechatConstants.ACCESS_TOKEN;
        return WechatHttpReq.get(url);
    }

    public String getTemplateID(String msg) {
        String url = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=" + WechatConstants.ACCESS_TOKEN;
        return WechatHttpReq.post(url, msg);
    }

    public String getTemplateList(String msg) {
        String url = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=" + WechatConstants.ACCESS_TOKEN;
        return WechatHttpReq.post(url, msg);
    }

    public String deleteTemplate(String msg) {
        String url = "https://api.weixin.qq.com/cgi-bin/template/del_private_template?access_token=" + WechatConstants.ACCESS_TOKEN;
        return WechatHttpReq.post(url, msg);
    }

    public String sendMsg(String msg) {
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + WechatConstants.ACCESS_TOKEN;
        return WechatHttpReq.post(url, msg);
    }

}
