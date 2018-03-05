package com.controller;

import com.pojo.Group;
import com.pojo.User;
import com.service.GroupService;
import com.service.UserService;
import com.util.MD5Utils;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * @author zhang
 */
@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    GroupService groupService;

    @RequestMapping("login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }
    @RequestMapping("userLogin")
    public ModelAndView userLogin(String studentNumber, String password, HttpSession session){
        ModelAndView mav = new ModelAndView();
        if(studentNumber == null|| password == null||"".equals(studentNumber) ||"".equals(password)){
            mav.setViewName("redirect:login");
        }else{
            User user = userService.get(studentNumber,MD5Utils.getPwd(password));
            if (null == user){
                mav.addObject("msg","账号密码错误");
                mav.setViewName("login");
            } else {
                Group group = groupService.get(user.getGroupId());
                session.setAttribute("user",user);
                session.setAttribute("group",group.getGroupName());
                mav.setViewName("redirect:index");
            }
        }

        return mav;
    }

    @RequestMapping("logout")
    public ModelAndView logout(HttpSession session){
        ModelAndView mav = new ModelAndView();
        session.invalidate();
        mav.setViewName("redirect:login");
        return mav;
    }
    @RequestMapping("updateUser")
    public ModelAndView updateUser(HttpSession session, String name, String password, MultipartFile image, HttpServletRequest request) throws IOException {
        ModelAndView mav = new ModelAndView();
        User user = (User) session.getAttribute("user");
        if(!"".equals(image.getOriginalFilename())){
            int dot = image.getOriginalFilename().lastIndexOf('.');
            int nameLength = image.getOriginalFilename().length();
            String fileName = RandomStringUtils.randomAlphanumeric(10)+ image.getOriginalFilename().substring(dot,nameLength);
            String path = request.getServletContext().getRealPath("image/user/"+user.getId()+"/");
            File dir = new File(path,fileName);
            if(!dir.exists()){
                boolean mkdirs = dir.mkdirs();
                System.out.print(String.valueOf(mkdirs));
            }
            //MultipartFile自带的解析方法
            image.transferTo(dir);
            user.setImagePath("../../image/user/"+user.getId()+"/"+fileName);
            user.setGmtModified(null);
        }
        if(!"".equals(name)&&!"".equals(password)){
            user.setPassword(MD5Utils.getPwd(password));
            user.setGmtModified(null);
        }
        if(!"".equals(name)){
            user.setName(name);
            user.setGmtModified(null);
        }
        userService.update(user);
        mav.setViewName("redirect:index");
        return mav;
    }
    @RequestMapping("MD5")
    public ModelAndView md5(){
        ModelAndView mav = new ModelAndView();
        List<User> users = userService.list();
        for (User user : users) {
            user.setPassword(MD5Utils.getPwd(user.getPassword()));
            user.setGmtModified(null);
            userService.update(user);
        }
        mav.setViewName("index");
        return mav;
    }
}
