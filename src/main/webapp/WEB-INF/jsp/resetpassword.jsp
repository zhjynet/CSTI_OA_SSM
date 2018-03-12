
<%--
  Created by IntelliJ IDEA.
  User: zhangjingyu
  Date: 2018/3/11
  Time: 下午6:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>科协OA-设置/重置密码</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
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

</head>
<body class="flat-blue login-page">
<div class="container">
    <div class="login-box">
        <div>
            <div class="login-form row">
                <div class="col-sm-12 text-center login-header">
                    <!--<i class="login-logo fa fa-connectdevelop fa-5x"></i>-->
                    <img src="../../img/csti.png" alt="" height="128" width="128">
                    <h4 class="login-title">科协OA</h4>
                </div>
                <div class="col-sm-12">
                    <div class="login-body">
                        <div class="progress hidden" id="login-progress">
                            <div class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
                                Log In...
                            </div>
                        </div>
                        <form action="/userRestPassword" method="post">
                            <div class="control">
                                <input type="text" class="form-control" placeholder="学号" name="studentNumber" id="studentNumber" />
                                <input type="password" class="form-control" value="" placeholder="密码" name="password" id="password" />
                                <input type="password" class="form-control" value="" placeholder="确认密码" name="repassword" id="repassword" />
                                <textarea class="form-control" rows="2" name="verifyActivationCode" id="verifyActivationCode" placeholder="激活码" style="resize: none"></textarea>
                            </div>

                            <div class="login-button">
                                <input type="button" class="btn btn-success text-left" value="<-返回"  style="background-color:transparent;border:0 " onclick="history.back();">

                                <input type="button" class="btn btn-primary text-right"  style="float: right" value="提交" onclick="resetPassword()">
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
<script>
    function resetPassword() {
        var studentNumber = $("#studentNumber").val();
        var password = $("#password").val();
        var repassord = $("#repassword").val();
        var verifyActivationCode = $("#verifyActivationCode").val();
        if(studentNumber === ""){
            alert("学号不能为空");
        }else if(password === ""){
            alert("密码不能为空");
        }else if(repassord === ""){
            alert("确认密码不能为空");
        }else if(password!==repassord){
            alert("两次输入密码不同，请检查后重试");
        }else if (password.length<8){
            alert("密码不能少于8位");
        }else if(verifyActivationCode === ""){
            alert("激活码不能为空");
        }else {
            $.ajax({
                url : "userResetPassword",//请求地址
                data :{"studentNumber":studentNumber,"password":password,"activationCode":verifyActivationCode},
                dataType : "json",//数据格式
                type : "post",//请求方式
                scriptCharset: 'utf-8',
                async : false,//是否异步请求
                success : function(data) {   //如何发送成功
                    if(data.msg ==='OK'){
                        alert("密码修改成功，请登录");
                        window.location.href="/login";
                    }if(data.msg ==='activationCodeExpired'){
                        alert("激活码已过期，请联系系统管理员重新获取");
                    }if(data.msg ==='accountDoesNotExist'){
                        alert("用户不存在，请重试");
                    }
                },
                error:function () {
                    alert("激活码有误,请联系系统管理员");
                }
            });
        }
    }

</script>
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
