
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2018/2/18
  Time: 0:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>科协OA-系统设置</title>
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
                    <span class="title">系统设置</span>
                    <div class="description">修改系统相关项</div>

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
                                    <div class="col-sm-4">
                                        <div class="panel panel-warning">
                                            <div class="panel-heading">导入用户</div>
                                            <div class="panel-body">
                                                <p>说明：</p>

                                                <p>按模版填好后上传即可导入。务必严格按照模版填写,不要更改模版。</p>

                                                <p>新用户默认密码即为学号，请务必提醒及时更改密码。</p>

                                                <a href="../../lib/file/用户信息模版.xlsx" style="color:rgb(110,166,201)">用户信息模版</a>
                                                <input type="file" name="excle" id="user-info"  class="file-loading" multiple="multiple">
                                                <script>
                                                    $("#user-info").fileinput({
                                                        allowedFileExtensions: ['xlsx'],
                                                        uploadUrl: '/addUser',
                                                        maxFileCount: 1,
                                                        maxFileSize: 102400,
                                                        language: 'zh',
                                                        fileActionSettings: {
                                                            showZoom: false,
                                                            showDrag: false
                                                        }
                                                    }).on('fileuploaded', function (event, data, previewId, index) {
                                                        console.log(data.response.result);
                                                        if(data.response.result === 'OK'){
                                                            alert('导入成功');
                                                        }else {
                                                            alert(data.response.result+'学号重复，请检查后重试');
                                                        }
                                                    });
                                                </script>
                                            </div>
                                        </div>
                                    </div>

                                    <script>
                                        function deleteUser(uid){
                                            console.log(uid)
                                            $.ajax({
                                                url : "deleteUser",//请求地址
                                                data: {id:uid},
                                                dataType : "json",//数据格式
                                                type : "post",//请求方式
                                                scriptCharset: 'utf-8',
                                                async : false,//是否异步请求
                                                success : function(data) {   //如何发送成功
                                                    if (data.result === "OK") {
                                                        alert("删除成功");
                                                    }
                                                    if (data.result === "NO") {
                                                        alert("管理员账户不可删除");
                                                    }
                                                    searchUser();
                                                }
                                            })

                                        }
                                        function searchBeforeUpdate(uid){
                                            console.log(uid);
                                            $.ajax({
                                                url : "searchUserByID",//请求地址
                                                data: {id:uid},
                                                dataType : "json",//数据格式
                                                type : "post",//请求方式
                                                scriptCharset: 'utf-8',
                                                async : false,//是否异步请求
                                                success : function(data) {   //如何发送成功
                                                    console.log(data);
                                                    $("#id").val(data[0].uid);
                                                    $("#studentNumberC").val(data[0].studentNumber);
                                                    $("#userNameC").val(data[0].name);
                                                    var configPermission = data[0].configPermission;
                                                    console.log(configPermission);
                                                    if(1 == configPermission){
                                                        $("#config_permission").attr("checked",true).trigger("change");
                                                    }else {
                                                        $("#config_permission").attr("checked",false).trigger("change");
                                                    }
                                                    $("#group").val(data[0].groupID).trigger("change");

                                                }
                                            })

                                        }
                                        function searchUser(){
                                            var name = $("#name").val();
                                            console.log(name);
                                            $.ajax({
                                                url : "searchUserByName",//请求地址
                                                data: {name:name},
                                                dataType : "json",//数据格式
                                                type : "post",//请求方式
                                                scriptCharset: 'utf-8',
                                                async : false,//是否异步请求
                                                success : function(data) {   //如何发送成功
                                                    console.log(data)
                                                    var info = "";
                                                    for(var i=0;i<data.length;i++){    //遍历data数组
                                                        var user = data[i];
                                                        info +="                              <tr>\n" +
                                                            "                                                                <td>"+user.studentNumber+"</td>\n" +
                                                            "                                                                <td>"+user.name+"</td>\n" +
                                                            "                                                                <td>"+user.group+"</td>\n" +
                                                            "                                                                <td>\n" +
                                                            "                                                                    <div class=\"btn-group\">\n" +
                                                            "                                                                     <button data-uid="+user.uid+" data-kind=\"edit\" class=\"btn btn-xs btn-flat btn-primary update\" style=\"margin: 0\" data-toggle=\"modal\" data-target=\"#userInformation \" onclick=\"searchBeforeUpdate("+user.uid+")\" >修改</button>\n"+
                                                            "                                                                    </div>\n" +
                                                            "                                                                    <div class=\"btn-group\">\n" +
                                                            "                                                                        <button data-uid="+user.uid+" data-kind=\"edit\" class=\"btn btn-xs btn-flat btn-danger\" data-kind=\"disable\" style=\"margin: 0\" onclick=\"deleteUser("+user.uid+")\">删除</button>\n" +
                                                            "                                                                    </div>\n" +
                                                            "                                                                </td>\n" +
                                                            "                                                            </tr>"
                                                        ;
                                                    }
                                                    $("#table").addClass("table")
                                                    $("#table").html("  <thead>\n" +
                                                        "                                                        <tr>\n" +
                                                        "                                                            <th>学号</th>\n" +
                                                        "                                                            <th>姓名</th>\n" +
                                                        "                                                            <th>组别</th>\n" +
                                                        "                                                            <th>操作</th>\n" +
                                                        "                                                        </tr>\n" +
                                                        "                                                        </thead>\n" +
                                                        "                                                        <tbody id=\"info\">\n" +
                                                        "\n" +
                                                        "                                                        </tbody>")
                                                    $("#info").html(info); //在html页面id=ulul的标签里显示html内容
                                                },
                                            })
                                        }
                                        function update() {
                                            var ajax_option={
                                                dataType: 'json',           //html(默认), xml, script, json...接受服务端返回的类型
                                                timeout: 3000,               //限制请求的时间，当请求大于3秒后，跳出请求
                                                success:function () {
                                                    $('#userInformation').modal('hide');
                                                    searchUser();
                                                }
                                            };
                                            $("#updateUserInfoAdmin").ajaxSubmit(ajax_option);
                                        }
                                    </script>
                                    <div class="col-sm-4">
                                        <div class="panel panel-primary">
                                            <div class="panel-heading">通知</div>
                                            <div class="panel-body">
                                                <form action="/notice" method="post">
                                                <div>
                                                    <b>开关 </b>  <input type="checkbox" class="toggle-checkbox" name="noticeSwitchValue" id="notice_switch">
                                                </div>
                                                <script>
                                                    if(${noticeSwitch.configValue} == 0){
                                                        $("#notice_switch").attr("checked",false);
                                                    }else{
                                                        $("#notice_switch").attr("checked",true);
                                                    }

                                                </script>
                                                <br>
                                                <div>
                                                    <b>内容</b>
                                                    <textarea class="form-control" rows="5" name="noticeContentValue">${noticeContent.configValue}</textarea>
                                                </div>
                                                <br>
                                                <button type="submit" class="btn btn-default" style="float: right;"><b>提交</b></button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                        <div class="modal fade" id="userInformation"  role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
                                            <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                                                <h4 class="modal-title">修改用户信息</h4>
                                            </div>
                                            <form action="/updateUserInfoAdmin" method="post" enctype="multipart/form-data" id="updateUserInfoAdmin">
                                            <div class="modal-body">
                                                <input type="hidden" id="id" name="id" />
                                                <label for="userNameC">姓名:</label><input type="text" class="form-control" name="userNameC" id="userNameC">
                                                <label for="studentNumberC">学号:</label><input type="text" class="form-control" name="studentNumberC" id="studentNumberC">
                                                <label for="group">组别:</label><br>
                                                <select name="group" id="group" class="select2-container--open group" style="width: 100%;  z-index: 10050 !important;">
                                                    <option value=1>ACM</option>
                                                    <option value=2>ARM</option>
                                                    <option value=3>IGM</option>
                                                    <option value=4>NS</option>
                                                    <option value=5>UI</option>
                                                    <option value=6>WEB</option>
                                                </select>

                                                <div>
                                                    <br>
                                                    <b>管理员权限: </b> <input type="checkbox" class="toggle-checkbox" name="configPermission" id="config_permission">
                                                    <div class="checkbox3 checkbox-success checkbox-inline checkbox-check checkbox-round  checkbox-light"style="float: right">
                                                        <input type="checkbox" id="checkbox-fa-light-2" name="resetPassword">
                                                        <label for="checkbox-fa-light-2">
                                                            <b>重置密码</b>
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                            </form>

                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                                <button type="button" class="btn btn-primary" onclick="update()">提交更改</button>
                                            </div>
                                        </div>
                                        </div>
                                    </div>

                                    <div class="col-sm-4">
                                        <div class="panel panel-info">
                                            <div class="panel-heading">修改用户信息</div>
                                            <div class="panel-body">
                                                <div class="input-group">
                                                    <input type="text" class="form-control" placeholder="输入姓名..." name="name" id="name">
                                                    <span class="input-group-btn">
                                                            <button id="search-user" class="btn" type="submit" name="search" style="margin: 0" onclick="searchUser()">
                                                              <i class="fa fa-search"></i>
                                                            </button>
                                                        </span>
                                                </div>
                                                <br>
                                                <div>
                                                    <table id="table">

                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-sm-4">
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
                                                $("#codeDiv").html("<textarea class=\"form-control\" rows=\"6\" name=\"getActivationCode\" id=\"code\"  style=\"resize:none\" ></textarea>\n");
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
                                    <div class="col-sm-4">
                                        <div class="panel panel-success">
                                            <div class="panel-heading">验证激活码</div>
                                            <div class="panel-body">
                                                <p>说明：</p>

                                                <p>激活码有效期为24小时，过期需重新申请。</p>
                                                <textarea class="form-control" rows="6" name="verifyActivationCode" id="verifyActivationCode" style="width: 100%;"  ></textarea>

                                                <button type="button" class="btn btn-success" style="width: 100%;" onclick="verifyActivationCode()">验证激活码</button>
                                            </div>
                                        </div>

                                        <script>
                                            function verifyActivationCode() {
                                                var verifyActivationCode = $("#verifyActivationCode").val();
                                                alert(verifyActivationCode);
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
