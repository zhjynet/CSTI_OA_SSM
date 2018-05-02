<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2018/1/31
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%
    if (session.getAttribute("user") == null){
        session.setAttribute("123","123");
        String code = request.getParameter("code");//用request得到
        if(code == null){
            response.sendRedirect("login");
        }else {
            session.setAttribute("code",code);
            System.out.println(code);
            response.sendRedirect("userLoginByYiban");
        }
    }
    else {
        response.sendRedirect("index");
    }

%>