<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>主页</title>
    <link href="${pageContext.request.contextPath}/js/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
    <p>
        <span>欢迎：${sessionScope.currUser.userName} ,</span>
        <a id="logout" href="javascript:;">退出登录</a>
    </p>
    <%@ include file="../common/menu.jsp" %>
    <div class="main">
        <h1 class="text-center">欢迎使小型进销存系统</h1>
    </div>
    <div class="clearfix"></div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/logout.js" type="text/javascript"></script>
</body>
</html>