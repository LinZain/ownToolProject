package wechat.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import wechat.role.WechatReqMsgRole;
import wechat.role.WechatRespMsgRole;
import wechat.service.WechatExcuteMsgService;
import wechat.util.XmlUtil;

@Service
public class WechatExcuteMsgServiceImpl implements WechatExcuteMsgService {

	public String excuteClick(WechatReqMsgRole reqMsgRole) {
		WechatRespMsgRole receMsgRole = new WechatRespMsgRole();
		receMsgRole.setContent("这只是一个测试按钮，亲~");
		receMsgRole.setFromUserName(reqMsgRole.getToUserName());
		receMsgRole.setToUserName(reqMsgRole.getFromUserName());
		receMsgRole.setCreateTime(String.valueOf(new Date().getTime()));
		receMsgRole.setMsgType("text");
		return XmlUtil.msgRoleToXml(receMsgRole);
	}

	public String excuteSub(String subUser, String wechatDev) {
		WechatRespMsgRole receMsgRole = new WechatRespMsgRole();
		receMsgRole.setContent("终于等到你，还好我没放弃。感谢你关注了一个这么一个器不粗，活不好，没有干爹，无颜值，还不任性的账号，辛苦了~");
		receMsgRole.setFromUserName(wechatDev);
		receMsgRole.setToUserName(subUser);
		receMsgRole.setCreateTime(String.valueOf(new Date().getTime()));
		receMsgRole.setMsgType("text");
		return XmlUtil.msgRoleToXml(receMsgRole);
	}

	public String excuteunSub(String subUser, String wechatDev) {
		// TODO 自动生成的方法存根
		return null;
	}

}
