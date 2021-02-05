<%@ page import="com.qfedu.entity.User" %>
<%@ page import="com.qfedu.service.UserService" %>
<%@ page import="com.qfedu.service.impl.UserServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: DevilTears
  Date: 2021/2/5
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>


<%String path=request.getContextPath(); %>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>个人信息修改</title>

    <!-- Bootstrap -->
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
            rel="stylesheet">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
</head>


<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script
        src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>

<style type="text/css">
    th {
        text-align: center;
    }
</style>
<%
    String id = request.getParameter("id");
    int id1 = Integer.parseInt(id);
    UserService us = new UserServiceImpl();
    User user = us.findUserById(id1);
    request.setAttribute("user",user);
%>
<script type="text/javascript">
    function validateMail(){
        var mail= $("#mail").val();
        var regex= /^\w+@\w+.\w+$/;
        if(mail.match(regex)){
            $("#result").text("此邮箱格式正确");
            return true;
        }else{
            $("#result").text("此邮箱格式错误");
            return false;
        }
    }

    function submit(){
        if(check()==false){
            return false;
        }

    }
</script>
<body>
<div class="jumbotron" style="padding-top: 15px; padding-bottom: 15px;">
    <div class="container">
        <h2>修改个人信息</h2>
    </div>
</div>
<div class="container" style="margin-top: 20px">
    <form class="form-horizontal"
    action="${pageContext.request.contextPath}/UserUpdateServlet"
    method="post">
        <input type="hidden" name="id" value="${user.userid}">
        <div class="form-group">
            <label class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="name"
                value="${user.name}" placeholder="请输入用户名称">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">原密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" name="password" id="password"
                value="${user.password}" placeholder="请输入原密码">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">新密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" name="password1" id="password1"
                       value="" placeholder="请输入新密码">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">电子邮件</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="email" id="email"
                       value="${user.email}" placeholder="电子邮件" onblur="return validateMail()">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">居住地</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="family" id="family"
                       value="${user.family}" placeholder="请输入居住地">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">个人简介</label>
            <div class="col-sm-10">
					<textarea class="form-control" name="intro" rows="5"
                              value="${user.intro}"></textarea>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" onclick="return submit()"  class="btn btn-default">保存</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
