package wechat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import wechat.service.WechatTemplateService;
import wechat.service.impl.WechatTemplateServiceImpl;

@RestController
@RequestMapping(value = "/template")
public class WechatTemplateController {
    @RequestMapping(value = "/sendMsg", method = { RequestMethod.POST, RequestMethod.GET })
    public String sendMsg(@RequestBody String msg, HttpServletRequest request, HttpServletResponse response) {
        WechatTemplateService wechatTemplateService = new WechatTemplateServiceImpl();
        return wechatTemplateService.sendMsg(msg);
    }

    @RequestMapping(value = "/setIndustry", method = { RequestMethod.POST, RequestMethod.GET })
    public String setIndustry(@RequestBody String msg, HttpServletRequest request, HttpServletResponse response) {
        WechatTemplateService wechatTemplateService = new WechatTemplateServiceImpl();
        return wechatTemplateService.setIndustry(msg);
    }

    @RequestMapping(value = "/getIndustry", method = { RequestMethod.POST, RequestMethod.GET })
    public String getIndustry(HttpServletRequest request, HttpServletResponse response) {
        WechatTemplateService wechatTemplateService = new WechatTemplateServiceImpl();
        return wechatTemplateService.getIndustry();
    }

    @RequestMapping(value = "/getTemplateID", method = { RequestMethod.POST, RequestMethod.GET })
    public String getTemplateID(@RequestBody String msg, HttpServletRequest request, HttpServletResponse response) {
        WechatTemplateService wechatTemplateService = new WechatTemplateServiceImpl();
        return wechatTemplateService.getTemplateID(msg);
    }

    @RequestMapping(value = "/getTemplateList", method = { RequestMethod.POST, RequestMethod.GET })
    public String getTemplateList(@RequestBody String msg, HttpServletRequest request, HttpServletResponse response) {
        WechatTemplateService wechatTemplateService = new WechatTemplateServiceImpl();
        return wechatTemplateService.getTemplateList(msg);
    }

    @RequestMapping(value = "/deleteTemplate", method = { RequestMethod.POST, RequestMethod.GET })
    public String deleteTemplate(@RequestBody String msg, HttpServletRequest request, HttpServletResponse response) {
        WechatTemplateService wechatTemplateService = new WechatTemplateServiceImpl();
        return wechatTemplateService.deleteTemplate(msg);
    }
}
