<%--
  Created by IntelliJ IDEA.
  User: PiemonJm
  Date: 2021/2/4
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>首页</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="Head/images/favicon.ico" mce_href="Head/images/favicon.ico" rel='icon' type='image/x-icon'/>
</head>
<body>
    <jsp:include page="head/head.jsp"></jsp:include>
    <jsp:include page="content/content.jsp"></jsp:include>
</body>
</html>
