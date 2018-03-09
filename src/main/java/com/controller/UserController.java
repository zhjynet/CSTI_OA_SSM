package com.controller;

import com.pojo.Group;
import com.pojo.User;
import com.service.GroupService;
import com.service.UserService;
import com.util.ExcleUtils;
import com.util.MD5Utils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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


    @RequestMapping("searchUserByName")
    @ResponseBody
    public void searchUserByName(String name,HttpServletResponse response) throws IOException {
        List<User> users = userService.list(name);
        //noinspection MismatchedQueryAndUpdateOfCollection
        Map<String, Object> map = new HashMap<>(16);
        JSONArray json = new JSONArray();
        for (User user : users) {
            map.put("uid",user.getId());
            map.put("name",user.getName());
            map.put("studentNumber",user.getStudentNumber());
            map.put("group",groupService.get(user.getGroupId()).getGroupName());
            json.add(map);
        }
        System.out.println(json.toString());
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(json.toString());
    }


    @RequestMapping("searchUserByID")
    @ResponseBody
    public void searchUserByID(int id,HttpServletResponse response) throws IOException {
        User user = userService.get(id);
        //noinspection MismatchedQueryAndUpdateOfCollection
        Map<String, Object> map = new HashMap<>(16);
        JSONArray json = new JSONArray();
            map.put("uid",user.getId());
            map.put("name",user.getName());
            map.put("studentNumber",user.getStudentNumber());
            map.put("groupID",user.getGroupId());
            map.put("configPermission",user.getConfigPermission());
            json.add(map);
        System.out.println(json.toString());
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(json.toString());
    }


    @RequestMapping("updateUserInfoAdmin")
    public ModelAndView updateUserInfoAdmin(int id,String userNameC ,String studentNumberC,int group,String configPermission,String resetPassword ){
        System.out.println(id+userNameC+studentNumberC+group+configPermission+resetPassword);
        User user = userService.get(id);
        user.setName(userNameC);
        user.setStudentNumber(studentNumberC);
        user.setGroupId(group);
        String on = "on";
        if(on.equals(configPermission)){
            user.setConfigPermission(1);
        }else {
            user.setConfigPermission(0);
        }
        if (on.equals(resetPassword)){
            user.setPassword(MD5Utils.getPwd(studentNumberC));
        }
        user.setGmtModified(null);
        userService.update(user);
        return new ModelAndView("redirect:systemConfig");
    }

    @ResponseBody
    @RequestMapping("1")
    public String deleteUser(int id){
        userService.delete(id);
        JSONObject success = new JSONObject();
        success.put("result","OK");
        return success.toString();
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

    @ResponseBody
    @RequestMapping("addUser")
    public String addUser(MultipartFile excle,HttpServletRequest request) throws Exception {
        String fileName = "";
        String path = "";
        if(!"".equals(excle.getOriginalFilename())){
            int dot = excle.getOriginalFilename().lastIndexOf('.');
            int nameLength = excle.getOriginalFilename().length();
            fileName = System.currentTimeMillis()+RandomStringUtils.randomAlphanumeric(5)+ excle.getOriginalFilename().substring(dot,nameLength);
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
        for (Object result : results) {
            user.setStudentNumber((String) ((Map) result).get("studentNumber"));
            user.setPassword(MD5Utils.getPwd((String) ((Map) result).get("studentNumber")));
            user.setName((String) ((Map) result).get("name"));
            user.setConfigPermission(Integer.parseInt((String) ((Map) result).get("configPermission")));
            user.setGroupId(Integer.parseInt((String) ((Map) result).get("groupID")));
            user.setImagePath("../../img/profile/picjumbo.com_HNCK4153_resize.jpg");
            userService.add(user);
        }
        JSONObject success = new JSONObject();
        success.put("result","OK");
        return success.toString();
    }
}
