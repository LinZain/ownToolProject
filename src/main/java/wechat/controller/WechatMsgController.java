//package wechat.controller;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import wechat.role.WechatReqMsgRole;
//import wechat.service.WechatExcuteMsgService;
//import wechat.util.WechatUtil;
//import wechat.util.XmlUtil;
//
//@RestController
//@RequestMapping(value = "/msg")
//public class WechatMsgController {
//    @Autowired
//    private WechatExcuteMsgService wechatExcuteMsgService;
//
//    @RequestMapping(value = "/getMsg", method = { RequestMethod.GET })
//    public void TestConn(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        boolean validate = WechatUtil.verificaWechatMsg(request);
//        if (validate) {
//            response.getWriter().write(request.getParameter("echostr"));
//            response.getWriter().close();
//        }
//    }
//
//    @RequestMapping(value = "/getMsg", method = { RequestMethod.POST })
//    public String getMsg(@RequestBody String msg) {
//        System.out.println(msg);
//        WechatReqMsgRole msgRole = XmlUtil.xmlToMsgRole(msg);
//
//        return executeReqMsg(msgRole);
//    }
//
//    private String executeReqMsg(WechatReqMsgRole reqMsgRole) {
//        String msgType = reqMsgRole.getMsgType();
//        String event = reqMsgRole.getEvent();
//        String toUserName = reqMsgRole.getToUserName();
//        String toFromUserName = reqMsgRole.getFromUserName();
//        String result = "";
//        switch (msgType) {
//        case "event":
//            switch (event) {
//            case "subscribe":
//                result = wechatExcuteMsgService.excuteSub(toFromUserName, toUserName);
//                break;
//            case "unsubscribe":
//                result = wechatExcuteMsgService.excuteunSub(toFromUserName, toUserName);
//                break;
//            case "CLICK":
//                result = wechatExcuteMsgService.excuteClick(reqMsgRole);
//                break;
//            default:
//                break;
//            }
//            break;
//        default:
//            break;
//        }
//        return result;
//    }
//}
