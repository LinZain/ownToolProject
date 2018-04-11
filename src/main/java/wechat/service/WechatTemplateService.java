package wechat.service;

public interface WechatTemplateService {
    public String setIndustry(String msg);
    public String getIndustry();
    public String getTemplateID(String msg);
    public String getTemplateList(String msg);
    public String deleteTemplate(String msg);
    public String sendMsg(String msg);
}
