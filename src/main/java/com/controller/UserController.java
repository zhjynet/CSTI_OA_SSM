package com.controller;

import com.pojo.Group;
import com.pojo.User;
import com.service.GroupService;
import com.service.MessageService;
import com.service.SigninService;
import com.service.UserService;
import com.util.ExcleUtils;
import com.util.MD5Utils;
import com.util.RSAUtils;
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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
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
    @Autowired
    MessageService messageService;
    @Autowired
    SigninService signinService;

    @Value("#{ActivationCodeRSA['privatekey']}")
    private String privatekey;

    //*
    // 登录界面
    // */

    @RequestMapping("login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    //*
    // 登录
    // */

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
            } else if("".equals(user.getActivationCode())||user.getActivationCode() == null){
                mav.addObject("msg","账号未激活，请联系管理员激活账号");
                mav.setViewName("login");
            }else{
                Group group = groupService.get(user.getGroupId());
                session.setAttribute("user",user);
                session.setAttribute("group",group.getGroupName());
                mav.setViewName("redirect:index");
            }
        }

        return mav;
    }

    //*
    // 重置密码、激活账号界面
    // */

    @RequestMapping("resetPassword")
    public ModelAndView resetPassword(){
        return new ModelAndView("resetpassword");
    }

    //*
    // 重置密码、激活账号
    // */

    @RequestMapping("userResetPassword")
    @ResponseBody
    public String userResetPassword(String studentNumber,String password,String activationCode) throws InvalidKeySpecException, NoSuchAlgorithmException {
        User user = userService.get(studentNumber);
        JSONObject result = new JSONObject();
        if(user != null){
            String realCode = RSAUtils.privateDecrypt(activationCode,RSAUtils.getPrivateKey(privatekey));
            JSONObject realCodeJson = JSONObject.fromObject(realCode);
            Integer generationTime = (Integer) realCodeJson.get("generationTime");
            Integer failureTime = (Integer) realCodeJson.get("failureTime");
            Integer nowTime = Math.toIntExact(System.currentTimeMillis() / 1000);
            if (nowTime>generationTime&&nowTime<failureTime){
                user.setPassword(MD5Utils.getPwd(password));
                user.setActivationCode(activationCode);
                user.setGmtModified(null);
                userService.update(user);
                result.put("msg","OK");
            }else {
                result.put("msg","activationCodeExpired");
            }
        }else {
            result.put("msg","accountDoesNotExist"); }
        return result.toString();
    }

    //*
    // 退出登录
    // */

    @RequestMapping("logout")
    public ModelAndView logout(HttpSession session){
        ModelAndView mav = new ModelAndView();
        session.invalidate();
        mav.setViewName("redirect:login");
        return mav;
    }

    //*
    // 更新个人资料（包括上传照片）
    // */

    @RequestMapping("updateUser")
    @ResponseBody
    public String updateUser(HttpSession session, String name, String password, MultipartFile image, HttpServletRequest request) throws IOException {
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
        JSONObject ajaxResult = new JSONObject();
        ajaxResult.put("result","OK");
        return ajaxResult.toString();
    }


    //*
    // 通过姓名查找账号
    // */

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


    //*
    // 通过ID查找账号
    // */

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

    //*
    // 管理员更改用户信息
    // */

    @ResponseBody
    @RequestMapping("updateUserInfoAdmin")
    public String updateUserInfoAdmin( int id, String userNameC ,String studentNumberC, int group,String configPermission,String resetPassword){
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
        JSONObject result = new JSONObject();
        result.put("result","OK");
        return result.toString();
    }

    //*
    // 删除用户
    // */

    @ResponseBody
    @RequestMapping("deleteUser")
    public String deleteUser(int id){
        User user = userService.get(id);
        JSONObject result = new JSONObject();
        if(user.getConfigPermission() == 0){
            userService.delete(id);
            messageService.delete(id);
            signinService.delete(id);
            result.put("result","OK");
        }else {
            result.put("result","NO");
        }
        System.out.println(result);
        return result.toString();
    }


    //*
    // 添加用户（excle操作）
    // */

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
