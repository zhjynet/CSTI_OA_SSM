<%--
  Created by IntelliJ IDEA.
  User: zhangjingyu
  Date: 2018/3/6
  Time: 下午6:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal fade" id="myInformation" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    修改个人信息
                </h4>
            </div>
            <form action="/updateUser" method="post" enctype="multipart/form-data" id="updateMyInfo"  target="hidden_frame" >
                <div class="modal-body" >
                    <label for="upload" style="cursor: pointer;text-align: center;width: 100%">
                        <img src="${user.imagePath}" class="profile-img" id="imagesrc" style="width: 100%; height: 100%;margin:0 auto">
                    </label>
                    <input type="file" id="upload" name="image"style="opacity: 0;position: absolute;z-index: 10;" value="${user.imagePath}" accept="image/*"/>
                    <script type="text/javascript">
                        var x=new FileReader;
                        document.forms[0].elements[0].onchange=function(){
                            x.readAsDataURL(this.files[0]);
                        }
                        x.onloadend=function(){
                            document.images[0].src=this.result;
                        }
                    </script>
                    <label for="userName">姓名:</label><input type="text" class="form-control" name="name" id="userName" value="${user.name}">
                    <label for="studentNumber">学号:</label><input type="text" class="form-control" id="studentNumber" value="${user.studentNumber}" readonly="readonly" >
                    <label for="password">密码:</label><input type="password" class="form-control" name="password" id="password" >
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="submit" class="btn btn-primary" id="submitbtn" onclick="updateMyInformation()" >
                        提交更改
                    </button>
                </div>

            </form>
            <iframe name='hidden_frame' id="hidden_frame" style='display:none'></iframe>

        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script>
    function updateMyInformation() {
        $('#myInformation').modal('hide');
        window.location.reload();
        // var ajax_option={
        //     dataType: 'json',           //html(默认), xml, script, json...接受服务端返回的类型
        //     timeout: 3000,               //限制请求的时间，当请求大于3秒后，跳出请求
        //     success:function () {
        //         $('#myInformation').modal('hide');
        //         window.location.reload();
        //     }
        // };
        // $("#updateMyInfo").ajaxSubmit(ajax_option);
    }

</script>