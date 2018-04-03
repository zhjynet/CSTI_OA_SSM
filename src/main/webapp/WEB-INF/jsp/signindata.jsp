<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2018/2/3
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>科协OA-签到记录汇总</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <!-- Fonts -->
    <%--<link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:300,400' rel='stylesheet' type='text/css'>--%>
    <%--<link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900' rel='stylesheet' type='text/css'>--%>
    <!-- CSS Libs -->
    <link rel="stylesheet" type="text/css" href="../../lib/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../../lib/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="../../lib/css/animate.min.css">
    <link rel="stylesheet" type="text/css" href="../../lib/css/bootstrap-switch.min.css">
    <link rel="stylesheet" type="text/css" href="../../lib/css/checkbox3.min.css">
    <link rel="stylesheet" type="text/css" href="../../lib/css/jquery.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="../../lib/css/dataTables.bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../../lib/css/select2.min.css">
    <!-- CSS App -->
    <link rel="stylesheet" type="text/css" href="../../css/style.css">
    <link rel="stylesheet" type="text/css" href="../../css/themes/flat-blue.css">
    <script type="text/javascript" src="../../lib/js/jquery.form.js"></script>

</head>

<body class="flat-blue">
<%@include file="include/changeinfo.jsp"%>
<div class="app-container">
    <div class="row content-container">
        <%@include file="include/header.jsp"%>
        <div class="side-menu sidebar-inverse">
            <nav class="navbar navbar-default" role="navigation">
                <div class="side-menu-container">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">
                            <div class="icon fa fa-paper-plane"></div>
                            <div class="title">科协OA</div>
                        </a>
                        <button type="button" class="navbar-expand-toggle pull-right visible-xs">
                            <i class="fa fa-times icon"></i>
                        </button>
                    </div>
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="/index">
                                <span class="icon fa fa-tachometer"></span><span class="title">首页</span>
                            </a>
                        </li>
                        <li class="panel panel-default dropdown active">
                            <a data-toggle="collapse" href="#dropdown-table">
                                <span class="icon fa fa-table"></span><span class="title">签到管理</span>
                            </a>
                            <!-- Dropdown level 1 -->
                            <div id="dropdown-table" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul class="nav navbar-nav">
                                        <li><a href="/listAllSignin">签到记录</a>
                                        </li>
                                        <li><a href="/listSigninByGroup">今日签到情况</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </li>
                        <li>
                            <a href="/activationCode">
                                <span class="icon fa fa-key"></span><span class="title">生成激活码</span>
                            </a>
                        </li>
                        <li >
                            <a href="/downloadCenter">
                                <span class="icon fa fa-download"></span><span class="title">下载中心</span>
                            </a>
                        </li>
                        <li >
                            <a href="/systemConfig">
                                <span class="icon fa fa-desktop"></span><span class="title">系统设置</span>
                            </a>
                        </li>
                        <li>
                            <a href="/operationLog">
                                <span class="icon fa fa-book"></span><span class="title">操作日志</span>
                            </a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </nav>
        </div>
        <!-- Main Content -->
        <div class="container-fluid">
            <div class="side-body">
                <div class="page-title">
                    <span class="title">签到记录汇总</span>
                    <%--<div class="description">with jquery Datatable for display data with most usage functional. such as search, ajax loading, pagination, etc.</div>--%>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <div class="card">

                            <div class="card-body">
                                <table class="datatable table table-striped" cellspacing="0" width="100%">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th style="min-width: 27px">组别</th>
                                        <th class=" hidden-xs">学号</th>
                                        <th style="min-width: 27px">姓名</th>
                                        <th style="min-width: 27px">时间</th>
                                        <th class=" hidden-xs">IP</th>
                                        <th class="hidden-sm hidden-xs">UA</th>
                                    </tr>
                                    </thead>
                                    <tfoot>
                                    <tr>
                                        <th>#</th>
                                        <th>组别</th>
                                        <th class=" hidden-xs">学号</th>
                                        <th >姓名</th>
                                        <th  >时间</th>
                                        <th class=" hidden-xs">IP</th>
                                        <th class="hidden-sm hidden-xs">UA</th>
                                    </tr>
                                    </tfoot>
                                    <tbody>
                                    <c:forEach items="${signins}" var="signin" varStatus="st">


                                    <tr>
                                        <td>${signin.id}</td>
                                        <td>${groups[st.count-1].groupName}</td>
                                        <td class=" hidden-xs">${users[st.count-1].studentNumber}</td>
                                        <td >${users[st.count-1].name}</td>
                                        <%--<td style="min-width:90px" ><ue=fmt:formatDate val"${signin.time}" pattern="yyyy-MM-dd     HH:mm:ss"/></td>--%>
                                        <td><fmt:formatDate value="${signin.signinTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                        <td  class=" hidden-xs">${signin.signinIp}</td>
                                        <td  class="hidden-sm hidden-xs">${signin.signinUa}</td>
                                    </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <footer class="app-footer">
        <div class="wrapper">
            <span class="pull-right">v2.0 <a href="#"><i class="fa fa-long-arrow-up"></i></a></span>Powered by<a href="http://www,.zhjynet.cn"> JingyuZhang!</a>            </div>
        </div>
    </footer>
    <div>
        <!-- Javascript Libs -->
        <script type="text/javascript" src="../../lib/js/jquery.min.js"></script>
        <script type="text/javascript" src="../../lib/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="../../lib/js/Chart.min.js"></script>
        <script type="text/javascript" src="../../lib/js/bootstrap-switch.min.js"></script>

        <script type="text/javascript" src="../../lib/js/jquery.matchHeight-min.js"></script>
        <script type="text/javascript" src="../../lib/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="../../lib/js/dataTables.bootstrap.min.js"></script>
        <script type="text/javascript" src="../../lib/js/select2.full.min.js"></script>
        <script type="text/javascript" src="../../lib/js/ace/ace.js"></script>
        <script type="text/javascript" src="../../lib/js/ace/mode-html.js"></script>
        <script type="text/javascript" src="../../lib/js/ace/theme-github.js"></script>
        <!-- Javascript -->
        <script type="text/javascript" src="../../js/app.js"></script>
</body>


</html>
