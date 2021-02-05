<%@page import="com.qfedu.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--------------绝对路径--------------->
<%
    String path = request.getContextPath();

    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!--------------绝对路径-end--------------->
<!DOCTYPE html>
<html lang="zh-CN">
    <head>
        <base href="<%=basePath%>">
        <title>头部页面</title>

<%--        引入Bootstrap核心文件--%>
        <link rel="stylesheet" href="../bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="../bootstrap-3.3.7-dist/css/bootstrap-theme.min.css">
        <script src="../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<%--     引入jquer--%>
        <script src="../js/jquery-3.4.1.min.js"></script>
<%--        移动设备优先--%>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <div class="container-fluid" style="background: #3c3c3c">
            <div class="row">
                <div class="col-md-6"><a href="../index.jsp"><img src="img/logo.png"/></a></div>
                <div class="col-md-1" style="background: #3e8f3e"><a href="../index.jsp">首页</a></div>
                <div class="col-md-1" style="background: #3e8f3e"><a href="../index.jsp">个人</a></div>
                <div class="col-md-1" style="background: #3e8f3e"><a href="../index.jsp">关于</a></div>
                <div class="col-md-1" style="background: #3e8f3e"><a href="../index.jsp">联系</a></div>
                <c:if test="${empty user}">
                 <div class="col-md-1" style="background: #3e8f3e"><a href="../index.jsp">登陆</a></div>
                </c:if>
                <c:if test="${!empty user}" >
                    <div class="col-md-1" style="background: #3e8f3e"><li ></li><a href="myself/mycenter.jsp">个人主页</a></div>
                    <div class="col-md-1" style="background: #3e8f3e"><a href="ExitServlet">退出</a></div>
                </c:if>
            </div>
        </div>
    </body>
</html>