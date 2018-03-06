package com.controller;


import com.pojo.MessageWithBLOBs;
import com.pojo.User;
import com.service.MessageService;
import com.util.GetIPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

/**
 * @author zhang
 */
@Controller
@RequestMapping("")
public class MessageController {
    @Autowired
    MessageService messageService;

    @RequestMapping("sendMessage")
    public ModelAndView sendMessage(HttpSession session, HttpServletRequest request,String messageinfo){
        ModelAndView mav = new ModelAndView();
        MessageWithBLOBs message = new MessageWithBLOBs();
        User user = (User)session.getAttribute("user");
        message.setMessageUserId(user.getId());
        message.setMessageUa(request.getHeader("user-agent"));
        message.setMessageIp(GetIPUtils.getIpAddr(request));
        message.setMessageTime(new Timestamp(System.currentTimeMillis()));
        message.setMessageInfo(messageinfo);
        messageService.add(message);
        mav.setViewName("redirect:index");
        return mav;

    }
}
