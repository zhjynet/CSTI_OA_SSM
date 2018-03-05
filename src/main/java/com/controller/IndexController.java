package com.controller;

import com.pojo.Config;
import com.pojo.Group;
import com.pojo.Message;

import com.pojo.User;
import com.service.*;

import com.util.JudgeIPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author zhangjingyu
 */
@Controller
@RequestMapping("")
public class IndexController {
    @Autowired
    UserService userService;
    @Autowired
    SigninService signinService;
    @Autowired
    MessageService messageService;
    @Autowired
    GroupService groupService;
    @Autowired
    ConfigService configService;

    @RequestMapping("index")
    public ModelAndView index(HttpSession session, HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        //群聊区部分代码
        List<Message> messages = messageService.list();
        List<User> messageUser = new ArrayList<>();
        List<Group> messageUserGroup = new ArrayList<>();
        for (int i =0;i<messages.size();i++){
            messageUser.add(userService.get(messages.get(i).getMessageUserId()));
            messageUserGroup.add(groupService.get(messageUser.get(i).getGroupId()));
        }
        //签到区部分代码
        User user = (User)session.getAttribute("user");
        int isSigninToday = user.getIsSigninToday();
        int isInCSTI = JudgeIPUtils.isincsti(request);
        //config部分代码
        int runningTime = Integer.parseInt(configService.get("running_time").getConfigValue());
        int noticeSwitch = Integer.parseInt(configService.get("notice_switch").getConfigValue());
        Config noticeContent = new Config();
        if (noticeSwitch == 0){
            noticeContent.setConfigValue("暂无通知");
            noticeContent.setGmtModified(new Date());
        }else {
            session.setAttribute("danger","danger");
            noticeContent = configService.get("notice_content");

        }
        //值日表部分代码
        List<User> studentOnDuty = userService.list(runningTime%3,user.getGroupId());
        session.setAttribute("notice_content",noticeContent);
        mav.addObject("student_on_duty",studentOnDuty);
        mav.addObject("running_time",runningTime);
        mav.addObject("is_signin_today",isSigninToday);
        mav.addObject("is_in_CSTI",isInCSTI);
        mav.addObject("messages",messages);
        mav.addObject("message_user",messageUser);
        mav.addObject("message_user_group",messageUserGroup);
        mav.setViewName("index");
        return mav;
    }

}
