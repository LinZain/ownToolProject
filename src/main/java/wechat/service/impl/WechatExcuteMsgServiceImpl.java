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
		receMsgRole.setContent("��ֻ��һ�����԰�ť����~");
		receMsgRole.setFromUserName(reqMsgRole.getToUserName());
		receMsgRole.setToUserName(reqMsgRole.getFromUserName());
		receMsgRole.setCreateTime(String.valueOf(new Date().getTime()));
		receMsgRole.setMsgType("text");
		return XmlUtil.msgRoleToXml(receMsgRole);
	}

	public String excuteSub(String subUser, String wechatDev) {
		WechatRespMsgRole receMsgRole = new WechatRespMsgRole();
		receMsgRole.setContent("���ڵȵ��㣬������û��������л���ע��һ����ôһ�������֣���ã�û�иɵ�������ֵ���������Ե��˺ţ�������~");
		receMsgRole.setFromUserName(wechatDev);
		receMsgRole.setToUserName(subUser);
		receMsgRole.setCreateTime(String.valueOf(new Date().getTime()));
		receMsgRole.setMsgType("text");
		return XmlUtil.msgRoleToXml(receMsgRole);
	}

	public String excuteunSub(String subUser, String wechatDev) {
		// TODO �Զ����ɵķ������
		return null;
	}

}
