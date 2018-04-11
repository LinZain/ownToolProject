package wechat.service.impl;

import wechat.service.WechatTemplateService;
import wechat.util.WechatConstants;
import wechat.util.WechatHttpReq;

public class WechatTemplateServiceImpl implements WechatTemplateService {

    @Override
    public String setIndustry(String msg) {
        String url = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=" + WechatConstants.ACCESS_TOKEN;
        return WechatHttpReq.post(url, msg);
    }

    @Override
    public String getIndustry() {
        String url = "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=" + WechatConstants.ACCESS_TOKEN;
        return WechatHttpReq.get(url);
    }

    @Override
    public String getTemplateID(String msg) {
        String url = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=" + WechatConstants.ACCESS_TOKEN;
        return WechatHttpReq.post(url, msg);
    }

    @Override
    public String getTemplateList(String msg) {
        String url = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=" + WechatConstants.ACCESS_TOKEN;
        return WechatHttpReq.post(url, msg);
    }

    @Override
    public String deleteTemplate(String msg) {
        String url = "https://api.weixin.qq.com/cgi-bin/template/del_private_template?access_token=" + WechatConstants.ACCESS_TOKEN;
        return WechatHttpReq.post(url, msg);
    }

    @Override
    public String sendMsg(String msg) {
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + WechatConstants.ACCESS_TOKEN;
        return WechatHttpReq.post(url, msg);
    }

}
