<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <span style="font-size: 20px;margin: 100px;">查看库存:</span>&nbsp;&nbsp;
        <div style="text-align: center">
            <%--@elvariable id="product" type="com.feitian.model.Product"--%>
            <form:form modelAttribute="product" method="post">
                <label>商品名称：</label>
                <select id="pid" name="id"  >
                    <option value="0">--请选择商品--</option>
                    <c:forEach var="pd" items="${sessionScope.products }">
                        <option value="${pd.id }" ${pd.id eq requestScope.product.id ? "selected" : ""} >${pd.productName }</option>
                    </c:forEach>
                </select>&nbsp;&nbsp;
                <button type="submit" onclick="fun()" >查询</button> </br></br>
                <c:if test="${requestScope.msg != '-1' and requestScope.msg != null}">
                    <span style="font-size: 20px">该商品的库存数量是：${requestScope.msg} </span>
                </c:if>
                <c:if test="${requestScope.msg = '-1'}">
                    <span style="font-size: 20px">该商品没有库存！</span>
                </c:if>
            </form:form>
        </div>
        </br> </br>

    </div>
    <div class="clearfix"></div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/logout.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/showQuantity.js" type="text/javascript"></script>
</body>
</html>