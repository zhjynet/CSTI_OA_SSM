<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhangjingyu
  Date: 2018/3/18
  Time: 上午11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>科协OA-生成激活码</title>
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
    <link rel="stylesheet" type="text/css" href="../../lib/bootstrap-fileinput/css/fileinput.min.css">
    <!-- CSS App -->
    <link rel="stylesheet" type="text/css" href="../../css/style.css">
    <link rel="stylesheet" type="text/css" href="../../css/themes/flat-blue.css">
    <script type="text/javascript" src="../../lib/js/jquery.min.js"></script>
    <script type="text/javascript" src="../../lib/bootstrap-fileinput/js/fileinput.min.js"></script>
    <script type="text/javascript" src="../../lib/bootstrap-fileinput/themes/fa/theme.js"></script>
    <script type="text/javascript" src="../../lib/bootstrap-fileinput/js/locales/zh.js"></script>
    <script type="text/javascript" src="../../lib/js/bootstrap.min.js"></script>

</head>
<body class="flat-blue">
<%@include file="include/changeinfo.jsp"%>
<footer class="app-container">
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
                        <li class="panel panel-default dropdown ">
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
                        <li class="active">
                            <a href="/activationCode">
                                <span class="icon fa fa-key"></span><span class="title">生成激活码</span>
                            </a>
                        </li>
                        <li>
                            <a href="/downloadCenter">
                                <span class="icon fa fa-download"></span><span class="title">下载中心</span>
                            </a>
                        </li>
                        <li>
                            <a href="/systemConfig">
                                <span class="icon fa fa-desktop"></span><span class="title">系统设置</span>
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
                    <span class="title">下载中心</span>
                    <div class="description">下载相关内容</div>

                </div>
                <%--<div class="alert fresh-color alert-warning" role="alert">--%>
                <%--<strong>权限不足</strong>--%>
                <%--</div>--%>
                <div id="permission">
                    <div class="row" >
                        <div class="col-xs-12">
                            <div class="card">
                                <div class="card-body">
                                    <div class="row row-example">
                                        <div class="col-sm-6">
                                            <div class="panel panel-success">
                                                <div class="panel-heading">生成激活码</div>
                                                <div class="panel-body">
                                                    <p>说明：</p>

                                                    <p>激活码有效期为24小时，过期需重新申请。</p>
                                                    <div id="codeDiv">

                                                    </div>

                                                    <button type="button" class="btn btn-success" style="width: 100%;" onclick="getActivationCode()">生成激活码</button>
                                                </div>
                                            </div>

                                            <script>
                                                function getActivationCode() {
                                                    $("#codeDiv").html("<textarea class=\"form-control\" rows=\"4\" name=\"getActivationCode\" id=\"code\"  style=\"resize:none\" ></textarea>\n");
                                                    $.ajax({
                                                        url : "getActivationCode",//请求地址
                                                        dataType : "text",//数据格式
                                                        type : "post",//请求方式
                                                        scriptCharset: 'utf-8',
                                                        async : false,//是否异步请求
                                                        success : function(data) {   //如何发送成功
                                                            $("#code").val(data);
                                                        }
                                                    })

                                                }
                                            </script>


                                        </div>
                                        <div class="col-sm-6">
                                            <div class="panel panel-info">
                                                <div class="panel-heading">验证激活码</div>
                                                <div class="panel-body">
                                                    <p>说明：</p>

                                                    <p>激活码有效期为24小时，过期需重新申请。</p>
                                                    <textarea class="form-control" rows="4" name="verifyActivationCode" id="verifyActivationCode" style="width: 100%;"  ></textarea>

                                                    <button type="button" class="btn btn-info" style="width: 100%;" onclick="verifyActivationCode()">验证激活码</button>
                                                </div>
                                            </div>

                                            <script>
                                                function verifyActivationCode() {
                                                    var verifyActivationCode = $("#verifyActivationCode").val();
                                                    $.ajax({
                                                        url : "getRealCode",//请求地址
                                                        data :{"activationCode":verifyActivationCode},
                                                        dataType : "text",//数据格式
                                                        type : "post",//请求方式
                                                        scriptCharset: 'utf-8',
                                                        async : false,//是否异步请求
                                                        success : function(data) {   //如何发送成功
                                                            alert(data);
                                                        },
                                                        error:function () {
                                                            alert("激活码有误");
                                                        }
                                                    });
                                                }
                                            </script>


                                        </div>


                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <script>
                    if(${user.configPermission} != 1){
                        $("#permission").html("      <div class=\"alert fresh-color alert-warning\" role=\"alert\">\n" +
                            "                    <strong>权限不足</strong>\n" +
                            "                </div>")
                    }
                </script>
            </div>
        </div>
        <footer class="app-footer">
            <div class="wrapper">
                <span class="pull-right">v2.0 <a href="#"><i class="fa fa-long-arrow-up"></i></a></span>Powered by<a href="http://www.zhjynet.cn"> JingyuZhang!</a>
            </div>
        </footer>
        <!-- Javascript Libs -->
        <script type="text/javascript" src="../../lib/js/jquery.form.js"></script>
        <script type="text/javascript" src="../../lib/js/Chart.min.js"></script>
        <script type="text/javascript" src="../../lib/js/bootstrap-switch.min.js"></script>
        <script type="text/javascript" src="../../lib/js/fileinput.min.js"></script>
        <script type="text/javascript" src="../../lib/js/jquery.matchHeight-min.js"></script>
        <script type="text/javascript" src="../../lib/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="../../lib/js/dataTables.bootstrap.min.js"></script>
        <script type="text/javascript" src="../../lib/js/select2.full.min.js"></script>
        <script type="text/javascript" src="../../lib/js/ace/ace.js"></script>
        <script type="text/javascript" src="../../lib/js/ace/mode-html.js"></script>
        <script type="text/javascript" src="../../lib/js/ace/theme-github.js"></script>
        <!-- Javascript -->
        <script type="text/javascript" src="../../js/app.js"></script>
        <!-- Javascript -->
</body>
</html>
