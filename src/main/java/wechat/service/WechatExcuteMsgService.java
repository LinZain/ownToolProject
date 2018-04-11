package wechat.service;

import wechat.role.WechatReqMsgRole;

public interface WechatExcuteMsgService {
    public String excuteSub(String subUser, String wechatDev);
    public String excuteunSub(String subUser, String wechatDev);
    public String excuteClick(WechatReqMsgRole reqMsgRole);
}
