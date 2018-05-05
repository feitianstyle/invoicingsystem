<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@  taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><%@ page pageEncoding="UTF-8" %>
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
    <div class="main" style="text-align: center">
        <h1 style="text-align: center">添加销售</h1>
        <p class="text-center text-warning">${requestScope.msg}</p>
        <%--@elvariable id="sale" type="com.feitian.model.Sale"--%>
        <form:form modelAttribute="sale">
            <label>商品名称：</label>
            <select id="productId" name="productId" >
                <option value="">请选择商品</option>
                <c:forEach var="pd" items="${sessionScope.products }">
                    <option value="${pd.id }"  ${pd.id eq sale.productId ? " selected": "" }>${pd.productName }</option>
                </c:forEach>
            </select></br>
            <label for="price" style="text-align: center">销售单价：</label>
            <form:input path="price"  cssClass="form-control" placeholder="请输入销售单价"  autocomplete="off" /> </br>
            <label for="quantity">销售数量：</label>
            <form:input path="quantity"  cssClass="form-control"  placeholder="请输入销售数量"  autocomplete="off" /> </br>
            <button type="submit" id="ck" onclick="fun()">保存</button>
        </form:form>

    </div>
    <div class="clearfix"></div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/logout.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/sale.js" type="text/javascript"></script>
</body>
</html>

