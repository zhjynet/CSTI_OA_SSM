package com.controller;

import com.pojo.Config;
import com.pojo.User;
import com.service.ConfigService;
import com.util.RSAUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * @author zhang
 */
@Controller
@RequestMapping("")
public class ConfigController {

    @Value("#{ActivationCodeRSA['publickey']}")
    private String publickey;

    @Value("#{ActivationCodeRSA['privatekey']}")
    private String privatekey;

    @Autowired
    ConfigService configService;
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

    @RequestMapping("getActivationCode")
    @ResponseBody
    public String getActivationCode(HttpSession session) throws InvalidKeySpecException, NoSuchAlgorithmException {
        JSONObject code = new JSONObject();
        User user = ((User)session.getAttribute("user"));
        String acticationCode;
        if(user.getConfigPermission()==1){
            code.put("uid",user.getId());
            code.put("generationTime",System.currentTimeMillis()/ 1000);
            code.put("failureTime",System.currentTimeMillis()/1000+86400);
            acticationCode = RSAUtils.publicEncrypt(code.toString(),RSAUtils.getPublicKey(publickey));
        }else {
            acticationCode = "Insufficient permissions";
        }
        return acticationCode;
    }

    @RequestMapping("getRealCode")
    @ResponseBody
    public String getRealCode(String activationCode) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return RSAUtils.privateDecrypt(activationCode,RSAUtils.getPrivateKey(privatekey));
    }

}
