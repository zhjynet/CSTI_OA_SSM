package com.controller;

import com.pojo.Config;
import com.service.ConfigService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


/**
 * @author zhang
 */
@Controller
@RequestMapping("")
public class ConfigController {



    @Autowired
    ConfigService configService;



    //*
    // 权限检查
    // */

    @RequestMapping("systemConfig")
    public ModelAndView systemConfig(HttpSession session){
        ModelAndView mav = new ModelAndView();
        Config noticeSwitch = configService.get("notice_switch");
        Config noticeContent = configService.get("notice_content");
        session.setAttribute("configPermission","0");
        mav.addObject("noticeSwitch",noticeSwitch);
        mav.addObject("noticeContent",noticeContent);
        mav.setViewName("systemconfig");
        return mav;
    }

    //*
    // 通知部分
    // */

    @RequestMapping("notice")
    public ModelAndView notice(String noticeSwitchValue, String noticeContentValue, HttpSession session){
        ModelAndView mav = new ModelAndView();
        Config noticeSwitch = configService.get("notice_switch");
        Config noticeContent = configService.get("notice_content");
        String on = "on";
        if (on.equals(noticeSwitchValue)){
            noticeSwitchValue ="1";
        }else {
            noticeSwitchValue ="0";
            session.setAttribute("danger","");
        }
        noticeSwitch.setGmtModified(null);
        noticeSwitch.setConfigValue(noticeSwitchValue);
        noticeContent.setGmtModified(null);
        noticeContent.setConfigValue(noticeContentValue);
        configService.update(noticeSwitch);
        configService.update(noticeContent);
        session.setAttribute("notice_content",noticeContent);
        mav.setViewName("redirect:systemConfig");
        return mav;
    }



}
