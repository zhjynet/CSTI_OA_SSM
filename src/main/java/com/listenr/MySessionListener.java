package com.listenr;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashSet;

/**
 * @author zhang
 */
public class MySessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session=event.getSession();
        ServletContext context=session.getServletContext();
        //用set集合来存储session对象
        HashSet<HttpSession> sessionSet=(HashSet<HttpSession>) context.getAttribute("sessionSet");
        if(sessionSet==null){
            sessionSet=new HashSet<HttpSession>();
            context.setAttribute("sessionSet", sessionSet);
        }
        //这里主要是为了检验用户是否登录，登录的话强制移除该session，加入新session
        for(HttpSession s : sessionSet){
            if(session.getAttribute("user")==s.getAttribute("user")){
                sessionSet.remove(s);
            }
        }
            sessionSet.add(session);

        //存储在线人数，利用了set集合不重复的特性，避免了重复登录
        context.setAttribute("lineCount", sessionSet.size());

    }

    //session的销毁监听
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        ServletContext context = event.getSession().getServletContext();
        if (context.getAttribute("lineCount") == null) {
            context.setAttribute("lineCount", 0);
        } else {
            int lineCount = (Integer) context.getAttribute("lineCount");
            if (lineCount < 1) {
                lineCount = 1;
            }
            context.setAttribute("lineCount", lineCount - 1);
        }
        HttpSession session = event.getSession();
        HashSet<HttpSession> sessionSet = (HashSet<HttpSession>)context.getAttribute("sessionSet");
        if(sessionSet!=null){
            sessionSet.remove(session);
        }

    }
//        public void sessionCreated(HttpSessionEvent event) {
//            HttpSession session = event.getSession();
//            ServletContext application = session.getServletContext();
//
//            // 在application范围由一个HashSet集保存所有的session
//            HashSet sessions = (HashSet) application.getAttribute("sessions");
//            if (sessions == null) {
//                sessions = new HashSet();
//                application.setAttribute("sessions", sessions);
//            }
//
//            // 新创建的session均添加到HashSet集中
//            sessions.add(session);
//            // 可以在别处从application范围中取出sessions集合
//            // 然后使用sessions.size()获取当前活动的session数，即为“在线人数”
//            application.setAttribute("lineCount", sessions.size());
//        }
//
//        public void sessionDestroyed(HttpSessionEvent event) {
//            System.out.println("减少");
//            HttpSession session = event.getSession();
//            ServletContext application = session.getServletContext();
//            HashSet sessions = (HashSet) application.getAttribute("sessions");
//
//            // 销毁的session均从HashSet集中移除
//            sessions.remove(session);
//        }
}
