package com.controller;

import com.pojo.Config;
import com.pojo.User;
import com.service.ConfigService;


import com.service.UserService;
import com.util.ExcleUtils;
import com.util.MD5Utils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Map;


/**
 * @author zhang
 */
@Controller
@RequestMapping("")
public class ConfigController {



    @Autowired
    ConfigService configService;

    @Autowired
    UserService userService;


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


    //*
    // 添加用户（excle操作）
    // */

    @ResponseBody
    @RequestMapping("addUser")
    public String addUser(MultipartFile excle, HttpServletRequest request) throws Exception {
        String fileName = "";
        String path = "";
        if(!"".equals(excle.getOriginalFilename())){
            int dot = excle.getOriginalFilename().lastIndexOf('.');
            int nameLength = excle.getOriginalFilename().length();
            fileName = System.currentTimeMillis()+ RandomStringUtils.randomAlphanumeric(5)+ excle.getOriginalFilename().substring(dot,nameLength);
            path = request.getServletContext().getRealPath("file/excle/");
            System.out.println(path);
            File dir = new File(path,fileName);
            if(!dir.exists()){
                boolean mkdirs = dir.mkdirs();
                System.out.print(String.valueOf(mkdirs));
            }
            //MultipartFile自带的解析方法
            excle.transferTo(dir);
        }
        ExcleUtils excleUtils = new ExcleUtils(path+fileName,"Sheet1");
        JSONArray results = excleUtils.getResult();

        User user = new User();
        JSONObject ajaxResult = new JSONObject();
        StringBuilder conflictUid = new StringBuilder();
        for (Object result : results) {
            if(userService.get((String) ((Map) result).get("studentNumber")) != null){
                conflictUid.append(((Map) result).get("studentNumber")).append(" ");
            }else {
                user.setStudentNumber((String) ((Map) result).get("studentNumber"));
                user.setPassword(MD5Utils.getPwd((String) ((Map) result).get("studentNumber")));
                user.setName((String) ((Map) result).get("name"));
                user.setConfigPermission(Integer.parseInt((String) ((Map) result).get("configPermission")));
                user.setGroupId(Integer.parseInt((String) ((Map) result).get("groupID")));
                user.setImagePath("../../img/profile/picjumbo.com_HNCK4153_resize.jpg");
                userService.add(user);
            }
        }
        if("".contentEquals(conflictUid)){
            ajaxResult.put("result","OK");
        }else {
            ajaxResult.put("result",conflictUid.toString());
        }
        return ajaxResult.toString();
    }



}
