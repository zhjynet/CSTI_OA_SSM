<%--
  Created by IntelliJ IDEA.
  User: zhangjingyu
  Date: 2018/3/6
  Time: 下午6:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default navbar-fixed-top navbar-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-expand-toggle">
                <i class="fa fa-bars icon"></i>
            </button>
            <ol class="breadcrumb navbar-breadcrumb">
                <li class="active">首页</li>
            </ol>
            <button type="button" class="navbar-right-expand-toggle pull-right visible-xs">
                <i class="fa fa-th icon"></i>
            </button>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <button type="button" class="navbar-right-expand-toggle pull-right visible-xs">
                <i class="fa fa-times icon"></i>
            </button>
            <li class="dropdown ${danger}" >
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-comments-o"></i></a>
                <ul class="dropdown-menu animated fadeInDown">
                    <li class="title">
                        通知 <span class="badge pull-right"></span>
                    </li>
                    <li class="message">
                        <fmt:formatDate value="${notice_content.gmtModified }" pattern="yyyy-MM-dd"/><br>
                        ${notice_content.configValue}
                    </li>
                </ul>
            </li>

            <li class="dropdown profile">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">${user.name}<span class="caret"></span></a>
                <ul class="dropdown-menu animated fadeInDown">
                    <li class="profile-img">
                        <img src="${user.imagePath}" class="profile-img" data-toggle="modal" data-target="#myInformation"style="cursor: pointer">
                    </li>
                    <li>
                        <div class="profile-info">
                            <h4 class="username" data-toggle="modal" data-target="#myInformation"style="cursor: pointer">${user.name}</h4>
                            <p>${user.studentNumber}@s.hlju.edu.cn</p>
                            <div class="btn-group margin-bottom-2x" role="group">
                                <button type="button" class="btn btn-default"><i class="fa fa-user"></i> ${group}</button>
                                <a href="/logout"><button type="button" class="btn btn-default"><i class="fa fa-sign-out"></i> Logout</button></a>
                            </div>
                        </div>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</nav>


