package com.controller;

import com.pojo.User;
import com.util.RSAUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * @author zhangjingyu
 */
@Controller
@RequestMapping("")
public class ActivationCodeController {
    @Value("#{ActivationCodeRSA['publickey']}")
    private String publickey;

    @Value("#{ActivationCodeRSA['privatekey']}")
    private String privatekey;

    @RequestMapping("activationCode")
    public ModelAndView acjtivationCode(){
        return new ModelAndView("activation-code");
    }

    //*
    // 获取激活码
    // */

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

    //*
    // 验证激活码
    // */

    @RequestMapping("getRealCode")
    @ResponseBody
    public String getRealCode(String activationCode) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return RSAUtils.privateDecrypt(activationCode,RSAUtils.getPrivateKey(privatekey));
    }

}
