package wechat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import wechat.util.WechatConstants;
import wechat.util.WechatHttpReq;

@RestController
@RequestMapping(value = "/qrCode")
public class WechatQRCodeController {

    @RequestMapping(value = "/createQRCode", method = {RequestMethod.POST,RequestMethod.GET})
    public String createQRCode(@RequestBody String msg, HttpServletRequest request, HttpServletResponse response) {
        String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=" + WechatConstants.ACCESS_TOKEN;
        return WechatHttpReq.post(url, msg);
    }

    @RequestMapping(value = "/showQRCode", method = {RequestMethod.POST,RequestMethod.GET})
    public String showQRCode(@RequestBody String msg, HttpServletRequest request, HttpServletResponse response) {
        String url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=" + msg;
        return WechatHttpReq.get(url);
    }
}
