package com.interceptor;

import com.pojo.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @author zhang
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * Handler执行完成之后调用这个方法
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception exc) {

    }



    /**
     * Handler执行之后，ModelAndView返回之前调用这个方法
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) {
    }

    /**
     * Handler执行之前调用这个方法
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        HttpSession session = request.getSession();
        String contextPath = session.getServletContext().getContextPath();

        String uri = request.getRequestURI();
        uri = StringUtils.remove(uri, contextPath);

        String uilEnd = "ogin";
        if (!uri.endsWith(uilEnd)) {
                User user = (User) session.getAttribute("user");
                if (null == user) {
                    response.sendRedirect("login");
                    return false;
            }
        }

        return true;
    }
}
