package com.controller;

import com.pojo.Group;
import com.pojo.User;
import com.service.GroupService;
import com.service.MessageService;
import com.service.SigninService;
import com.service.UserService;
import com.util.HttpUtils;
import com.util.MD5Utils;
import com.util.RSAUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.store.Directory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.wltea.analyzer.lucene.IKAnalyzer;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.*;

import static com.util.LuceneUtils.createIndex;
import static com.util.LuceneUtils.showSearchResults;


/**
 * @author zhang
 */
@SuppressWarnings("Duplicates")
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

    @Value("#{Yiban['AppID']}")
    private String clientId;

    @Value("#{Yiban['AppSecret']}")
    private String clientSecret;

    //*
    // 登录界面
    // */

    @RequestMapping("login")
    public ModelAndView login(String code){
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

    @RequestMapping("userLoginByYiban")
    public ModelAndView userLoginByYiban(HttpSession session){
        ModelAndView mav = new ModelAndView();
        String code = (String) session.getAttribute("code");
        System.out.println(code);
        String tokenString = HttpUtils.sendPost("https://oauth.yiban.cn/token/info", "code="+code+"&client_id="+clientId+"&client_secret="+clientSecret+"&redirect_uri=https://oa.csti.xyz");
        JSONObject tokenJson = JSONObject.fromObject(tokenString);
        System.out.println(tokenString);
        String token = (String) tokenJson.get("access_token");
        System.out.println(token);
        String userMeString = HttpUtils.sendGet(" https://openapi.yiban.cn/user/me", "access_token="+token);
        System.out.println(userMeString);
        JSONObject userMeJson = JSONObject.fromObject(userMeString);
        String ybUserName = (String) userMeJson.getJSONObject("info").get("yb_username");
        System.out.println(ybUserName);
        User user =  userService.getByName(ybUserName);
        if (null == user){
            mav.addObject("msg","账号不存在");
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
        session.setAttribute("user",user);
        JSONObject ajaxResult = new JSONObject();
        ajaxResult.put("result","OK");
        return ajaxResult.toString();
    }


    //*
    // 通过姓名查找账号
    // */

    @RequestMapping("searchUserByName")
    @ResponseBody
    public void searchUserByName(String keyword,HttpServletResponse response) throws Exception {
        List<User> userList = userService.list();
        List<String> userResult = new ArrayList<>();
        JSONArray json = new JSONArray();
        Map<String, Object> mapResult = new HashMap<>(16);
        for(User userTest:userList){
            mapResult.put("uid",userTest.getId());
            mapResult.put("name",userTest.getName());
            mapResult.put("studentNumber",userTest.getStudentNumber());
            mapResult.put("group",groupService.get(userTest.getGroupId()).getGroupName());
            JSONObject jsonObject = JSONObject.fromObject(mapResult);
            userResult.add(jsonObject.toString());
        }

        // 1. 准备中文分词器
        IKAnalyzer analyzer = new IKAnalyzer();
        Directory index = createIndex(analyzer,userResult);
        Query query = new QueryParser("name", analyzer).parse(keyword);
        // 4. 搜索
        IndexReader reader = DirectoryReader.open(index);
        IndexSearcher searcher = new IndexSearcher(reader);
        int numberPerPage = 5;
        System.out.printf("当前一共有%d条数据%n",userResult.size());
        System.out.printf("查询关键字是：\"%s\"%n",keyword);
        ScoreDoc[] hits = searcher.search(query, numberPerPage).scoreDocs;

        // 5. 显示查询结果
        showSearchResults(searcher, hits, query, analyzer);
        for (ScoreDoc scoreDoc : hits) {
            int docId = scoreDoc.doc;
            Document d = searcher.doc(docId);
            List<IndexableField> fields = d.getFields();
            for (IndexableField f : fields) {
                json.add(d.get(f.name()));
            }
        }
        // 6. 关闭查询
        reader.close();

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




}
