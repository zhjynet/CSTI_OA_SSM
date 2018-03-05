<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2018/1/31
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%
    if (session.getAttribute("user") == null){
        response.sendRedirect("login");
    }
    else {
        response.sendRedirect("index");
    }

%>