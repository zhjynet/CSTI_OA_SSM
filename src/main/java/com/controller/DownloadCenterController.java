package com.controller;

import com.pojo.User;
import com.service.GroupService;
import com.service.UserService;
import com.util.ExcleUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;


/**
 * @author zhangjingyu
 */
@SuppressWarnings("ALL")
@Controller
@RequestMapping("")
public class DownloadCenterController {
    @Autowired
    UserService userService;
    @Autowired
    GroupService groupService;

    @RequestMapping("downloadCenter")
    public ModelAndView downloadCenter(){
        return new ModelAndView("download-center");
    }

    @RequestMapping("downloadUserInfo")
    public ResponseEntity<byte[]> downloadUserInfo(HttpServletRequest request) throws Exception {
        List<User> users = userService.list();
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for(User user:users){
            jsonObject.put("uid",user.getId());
            jsonObject.put("studentNumber",user.getStudentNumber());
            jsonObject.put("name",user.getName());
            jsonObject.put("group",groupService.get(user.getGroupId()).getGroupName());
            jsonArray.add(jsonObject);
        }
        ExcleUtils excleUtils = new ExcleUtils();
        excleUtils.exportExcle(jsonArray,request);
        String filename="科技创新协会成员名单.xlsx";
        File file = new File(request.getServletContext().getRealPath("file/excle/download/")+filename);
        InputStream in;
        ResponseEntity<byte[]> response=null ;
        try {
            in = new FileInputStream(file);
            byte[] b=new byte[in.available()];
            in.read(b);
            HttpHeaders headers = new HttpHeaders();
            filename = new String(filename.getBytes("utf8"),"iso8859-1");
            headers.add("Content-Disposition", "attachment;filename="+filename);
            HttpStatus statusCode=HttpStatus.OK;
            response = new ResponseEntity<byte[]>(b, headers, statusCode);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
