<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link href="${pageContext.request.contextPath}/js/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="login-form">
    <h1 class="text-center">小型进销存系统</h1>
    <p class="text-center text-warning">${requestScope.msg}</p>
    <form:form modelAttribute="user" cssClass="form">
        <div class="form-group">
            <label for="userName">用户名：</label>
            <form:input path="userName" cssClass="form-control" placeholder="请输入用户名" autocomplete="off" />
            <form:errors path="userName" />
        </div>
        <div class="form-group">
            <label for="passWord">密码：</label>
            <form:password path="passWord" cssClass="form-control" showPassword="true" placeholder="请输入密码" autocomplete="off" />
            <form:errors path="passWord" />
        </div>
        <div class="form-group text-center">
            <button type="submit">登录</button>
        </div>
    </form:form>
</div>
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/login.js" type="text/javascript"></script>
</body>
</html>