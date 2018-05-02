package com.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangjingyu
 */
public class JudgeIPUtils {
    public static int isincsti(HttpServletRequest request){
        String testIp = "^192.168.[0-9]{1,3}.[0-9]{1,3}";
        String cstiIpByEducation = "^10.10.28.[0-9]{1,3}";
        String cstiIpByEducationNet= "^210.46.102.[0-9]{1,3}";
        String cstiIpByChinaTelecom= "^219.147.166.[0-9]{1,3}";
        String cstiIpByCMCC = "^111.40.7.[0-9]{1,3}";
        String cstiIpByChinaUnicom = "^221.207.153.[0-9]{1,3}";
        String cstiIPV6 = "2001:da8:b808:29";
         //  ||ipAddress.substring(0,16).equals(cstiIPV6)
        Integer inCsti = 0;
        String ipAddress = GetIPUtils.getIpAddr(request);
        if (ipAddress.matches(testIp)
                || ipAddress.matches(cstiIpByEducationNet)
                || ipAddress.matches(cstiIpByEducation)
                || ipAddress.matches(cstiIpByChinaTelecom)
                || ipAddress.matches(cstiIpByCMCC)
                || ipAddress.matches(cstiIpByChinaUnicom)){
            inCsti = 1;
        }
         return inCsti;
    }
}
