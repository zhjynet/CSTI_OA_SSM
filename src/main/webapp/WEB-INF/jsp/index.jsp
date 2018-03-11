<%@ page import="java.util.HashSet" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2018/1/31
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>科协OA-首页</title>
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
    <script type="text/javascript" src="../../lib/js/jquery.min.js"></script>
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
                        <li class="active">
                            <a href="/index">
                                <span class="icon fa fa-tachometer"></span><span class="title">首页</span>
                            </a>
                        </li>
                        <li class="panel panel-default dropdown">
                            <a data-toggle="collapse" href="#dropdown-table">
                                <span class="icon fa fa-table"></span><span class="title">签到管理</span>
                            </a>
                            <!-- Dropdown level 1 -->
                            <div id="dropdown-table" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul class="nav navbar-nav">
                                        <li><a href="/listAllSignin">签到记录</a>
                                        </li>
                                        <li><a href="table/datatable.html">Datatable</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </li>
                        <li >
                            <a  href="/systemConfig">
                                <span class="icon fa fa-desktop"></span><span class="title">系统设置</span>
                            </a >
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </nav>
        </div>
        <!-- Main Content -->
        <div class="container-fluid">
            <div class="side-body padding-top">
                <div class="row">
                    <div class="col-lg-3 col-md-6 col-sm-6 col-xs-6">
                        <a href="#">
                            <div class="card red summary-inline">
                                <div class="card-body">
                                    <i class="icon fa fa-inbox fa-4x"></i>
                                    <div class="content">
                                        <div class="title">50</div>
                                        <div class="sub-title">New Mails</div>
                                    </div>
                                    <div class="clear-both"></div>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-6 col-xs-6">
                        <a href="#">
                            <div class="card yellow summary-inline">
                                <div class="card-body">
                                    <i class="icon fa fa-comments fa-4x"></i>
                                    <div class="content">
                                        <div class="title">${messages.size()}</div>
                                        <div class="sub-title">群聊消息数</div>
                                    </div>
                                    <div class="clear-both"></div>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-6 col-xs-6">
                        <a href="#">
                            <div class="card green summary-inline">
                                <div class="card-body">
                                    <i class="icon fa fa-tags fa-4x"></i>
                                    <div class="content">
                                        <div class="title">${running_time}</div>
                                        <div class="sub-title">系统运行天数</div>
                                    </div>
                                    <div class="clear-both"></div>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-6 col-xs-6">
                        <a href="#">
                            <div class="card blue summary-inline">
                                <div class="card-body">
                                    <i class="icon fa fa-share-alt fa-4x"></i>
                                    <div class="content">
                                        <div class="title">160</div>
                                        <div class="sub-title">Share</div>
                                    </div>
                                    <div class="clear-both"></div>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="col-sm-12 col-xs-12">
                        <div class="row">
                            <div class="col-md-3 col-sm-12">
                                <div class="card primary">
                                    <div class="card-jumbotron no-padding" style="height: 150px ;text-align: center">
                                        <%--<canvas id="jumbotron-bar-chart" class="chart no-padding"></canvas>--%>
                                            <div class="alert fresh-color "id="signin_title" role="alert">
                                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
                                                    <strong id="signin_msg"></strong>
                                            </div>
                                            <br>
                                            <button type="button" class="btn btn-success" id="signin" style="text-align: center">签到</button>
                                    </div>
                                    <div class="card-body half-padding">
                                        <h4 class="float-left no-margin font-weight-300">签到</h4>
                                        <h4 class="float-right no-margin font-weight-300" id="signinMsg"></h4>
                                        <div class="clear-both"></div>
                                    </div>
                                </div>
                            </div>
                            <script>
                                var is_in_CSTI = ${is_in_CSTI};
                                var is_sigin_today = ${is_signin_today};
                                if(is_in_CSTI == 0&&is_sigin_today == 0){
                                    $("#signin_msg").text("您不在实验室");
                                    $("#signinMsg").text("未签");
                                    $("#signin").addClass("disabled");
                                    $("#signin_title").addClass("alert-warning");

                                }
                                if(is_in_CSTI == 1&& is_sigin_today == 0){
                                    $("#signin_msg").text("签    到");
                                    $("#signinMsg").text("未签");
                                    $("#signin_title").addClass("alert-info");
                                    $("#signin").click(function () {
                                        window.location.href="/signin";
                                    })

                                }
                                if(is_sigin_today == 1){
                                    $("#signin_msg").text("今日已签到");
                                    $("#signinMsg").text("已签");
                                    $("#signin").addClass("disabled");
                                    $("#signin_title").addClass("alert-success");
                                }

                            </script>

                            <div class="col-md-3 col-sm-12">
                                <div class="card primary">
                                    <div class="card-jumbotron no-padding">
                                        <%--<canvas id="jumbotron-bar-chart" class="chart no-padding"></canvas>--%>
                                            <ul class="list-group no-margin">
                                                <c:forEach items="${student_on_duty}" var="studentOnDuty" varStatus="sod">
                                                    <li class="list-group-item" id="${studentOnDuty.id}" style="height: 50px">
                                                        <span class="badge"></span> ${studentOnDuty.name}
                                                    </li>
                                                    <script>
                                                        if(${studentOnDuty.isSigninToday} == 0){
                                                            $("#${studentOnDuty.id}").addClass("list-group-item-warning");
                                                        }else {
                                                            $("#${studentOnDuty.id}").addClass("list-group-item-success");
                                                        }
                                                    </script>
                                                </c:forEach>
                                            </ul>
                                    </div>
                                    <div class="card-body half-padding">
                                        <h4 class="float-left no-margin font-weight-300">值日表</h4>
                                        <div class="clear-both"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 col-sm-12">

                                <div class="card primary">
                                    <div class="card-jumbotron no-padding">
                                        <%--<canvas id="jumbotron-line-2-chart" class="chart no-padding"></canvas>--%>
                                            <iframe src="//www.seniverse.com/weather/weather.aspx?uid=U1731ED8A2&cid=CHHL000000&l=&p=SMART&a=1&u=C&s=3&m=0&x=1&d=5&fc=FFFFFF&bgc=&bc=&ti=0&in=0&li=" frameborder="0" scrolling="no" width="900" height="145" allowTransparency="true" style="padding-top: 20px"></iframe>
                                    </div>
                                    <div class="card-body half-padding">
                                        <h4 class="float-left no-margin font-weight-300">天气</h4>
                                        <div class="clear-both"></div>
                                    </div>
                                </div>
                            </div>

                        </div>

                        <div class="card card-success">
                            <div class="card-header">
                                <div class="card-title">
                                    <div class="title">
                                        <i class="fa fa-comments-o" ></i> 群聊区
                                        <a href="/index"><i class="fa fa-refresh" id="message" style="margin-left: 20px"></i></a>
                                    </div>
                                </div>
                                <div class="clear-both"></div>
                            </div>
                            <div class="card-body no-padding">
                                <ul class="message-list">
                                    <c:forEach items="${messages.subList(0,5)}" var="message" varStatus="st">

                                    <a href="#">
                                        <li>
                                            <img src="${message_user[st.count-1].imagePath}" class="profile-img pull-left">
                                            <div class="message-block">
                                                <div><span class="username">${message_user_group[st.count-1].groupName}--${message_user[st.count-1].name}</span> <span class="message-datetime">  <fmt:formatDate value="${message.messageTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                                                </div>
                                                <div class="message">${message.messageInfo}</div>
                                            </div>
                                        </li>
                                    </a>
                                    </c:forEach>
                                    <form action="/sendMessage" method="post">
                                                <div class="col-md-11 col-sm-11">
                                                    <input type="text" class="form-control" placeholder="留言" name="messageinfo">
                                                </div>
                                                <div class="col-md-1 col-sm-1">
                                                    <button type="submit" style="margin-top: 0px" class="btn btn-success">发送</button>
                                                </div>
                                            <%--<input type="submit">--%>
                                    </form>
                                 
                                </ul>
                            </div>
                        </div>
                    <div class="row  no-margin-bottom">


                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer class="app-footer">
            <div class="wrapper">
                <span class="pull-right">v2.0 <a href="#"><i class="fa fa-long-arrow-up"></i></a></span>Powered by<a href="http://www,.zhjynet.cn"> JingyuZhang!</a>            </div>
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
