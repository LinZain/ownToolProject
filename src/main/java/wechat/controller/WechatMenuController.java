package wechat.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import wechat.service.WechatMenuService;
import wechat.service.impl.WechatMenuServiceImpl;

@RestController
@RequestMapping(value = "/menu")
public class WechatMenuController {

    @RequestMapping(value = "/addMenu", method = { RequestMethod.POST,RequestMethod.GET })
    public String addMenu(@RequestBody String param, HttpServletRequest request, HttpServletResponse response){
        WechatMenuService wechatSendService = (WechatMenuService) new WechatMenuServiceImpl();
        String result = wechatSendService.addMenu(param);
        return result;
    }
    
    @RequestMapping(value = "/queryMenu", method = { RequestMethod.POST,RequestMethod.GET })
    public String queryMenu(HttpServletRequest request, HttpServletResponse response){
        WechatMenuService wechatSendService = (WechatMenuService) new WechatMenuServiceImpl();
        String result = wechatSendService.queryMenu();
        return result;
    }
    
    @RequestMapping(value = "/deleteMenu", method = { RequestMethod.POST,RequestMethod.GET })
    public String deleteMenu(HttpServletRequest request, HttpServletResponse response){
        WechatMenuService wechatSendService = (WechatMenuService) new WechatMenuServiceImpl();
        String result = wechatSendService.deleteMenu();
        return result;
    }

}
