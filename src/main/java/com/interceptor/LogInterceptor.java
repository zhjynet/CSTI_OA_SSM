package com.interceptor;

import com.pojo.LogWithBLOBs;
import com.pojo.User;
import com.service.LogService;
import com.service.impl.LogServiceImpl;
import com.util.GetIPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Map;

/**
 * @author zhangjingyu
 */
public class LogInterceptor implements HandlerInterceptor {

    // before the actual handler will be executed

    @Autowired
    LogService logService;

    LogWithBLOBs logWithBLOBs = new LogWithBLOBs();
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        if (handler instanceof HandlerMethod) {
            StringBuilder sb = new StringBuilder(1000);

            sb.append("-----------------------").append(new Timestamp(System.currentTimeMillis()))
                    .append("-------------------------------------\n");
            HandlerMethod h = (HandlerMethod) handler;
            sb.append("Controller: ").append(h.getBean().getClass().getName()).append("\n");
            sb.append("Method    : ").append(h.getMethod().getName()).append("\n");
            sb.append("Params    : ").append(getParamString(request.getParameterMap())).append("\n");
            sb.append("URI       : ").append(request.getRequestURL()).append("\n");
            logWithBLOBs.setLogIp(GetIPUtils.getIpAddr(request));
            logWithBLOBs.setLogUrl(String.valueOf(request.getRequestURL()));
            logWithBLOBs.setLogUa(request.getHeader("user-agent"));
            logWithBLOBs.setGmtCreate(new Timestamp(System.currentTimeMillis()));
            logWithBLOBs.setGmtModified(null);
            if(request.getSession().getAttribute("user") == null){
                sb.append("User      : ").append("未登录");
                logWithBLOBs.setLogUserName("未登录");

            }else{
                sb.append("User      : ").append(((User)request.getSession().getAttribute("user")).getName());
                logWithBLOBs.setLogUserName(((User)request.getSession().getAttribute("user")).getName());
            }
            System.out.println(sb.toString());
        }
        return true;
    }

    // after the handler is executed
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;
        if(handler instanceof HandlerMethod){
            StringBuilder sb = new StringBuilder(1000);
            sb.append("CostTime  : ").append(executeTime).append("ms").append("\n");
            sb.append("-------------------------------------------------------------------------------");
            logWithBLOBs.setLogCostTime((int) executeTime);
            logService.add(logWithBLOBs);
            System.out.println(sb.toString());
        }
    }

    private String getParamString(Map<String, String[]> map) {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String,String[]> e:map.entrySet()){
            sb.append(e.getKey()).append("=");
            String[] value = e.getValue();
            if(value != null && value.length == 1){
                sb.append(value[0]).append("\t");
            }else{
                sb.append(Arrays.toString(value)).append("\t");
            }
        }
        return sb.toString();
    }

    @Override
    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {

    }
}
