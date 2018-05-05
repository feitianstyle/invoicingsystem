<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <%@ include file="/WEB-INF/common/menu.jsp" %>
    <div class="main">
        <span style="font-size: 20px;margin: 100px;">销售信息查询:</span>&nbsp;&nbsp;
        <div style="text-align: center">
            <%--@elvariable id="sort" type="com.feitian.model.Sort"--%>
            <form:form modelAttribute="sort" method="post">
                <span style="text-align: right">排序方式:</span>
                <select id="label" name="label" >
                    <option value="saleDate" ${"saleDate" eq sessionScope.sort? "selected":""}>销售日期</option>
                    <option value="totalPrice" ${"totalPrice" eq sessionScope.sort? "selected":""}>单笔总价</option>
                </select>
                <button type="submit" >提交</button>
            </form:form>
        </div>


        </br> </br>
        <c:if test="${empty requestScope.list }">
            暂时没有销售记录
        </c:if>
        <c:if test="${!empty requestScope.list}">
            <table border="1" cellspacing="0" cellpadding="10" class="table1" style="margin: 100px">
                <thead>
                <tr>
                    <td>ID</td>
                    <td>商品</td>
                    <td>单价</td>
                    <td>数量</td>
                    <td>总价</td>
                    <td>销售日期</td>
                    <td>销售员</td>
                </tr>
                </thead>
                <c:forEach items="${requestScope.list}" var="u">
                    <tr>
                        <th>${u.id }</th>
                        <th>${u.productName }</th>
                        <th>${u.price }</th>
                        <th>${u.quantity }</th>
                        <th>${u.totalPrice }</th>
                        <th>${u.saleDate }</th>
                        <th>${u.saleName}</th>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <table  border="0" cellspacing="0" cellpadding="0"  width="900px" style="margin-left: 200px">
            <tr>
                <td>
                    <span>
                       <c:if test="${requestScope.pageInfo.currentPage != 1}">
                           <a style="font-size: 15px"  href="${pageContext.request.contextPath}/saleInfo?currentPage=1&order=${sessionScope.sort}" >[首页]</a>&nbsp;&nbsp;
                           <a style="font-size: 15px"  href="${pageContext.request.contextPath }/saleInfo?currentPage=${requestScope.pageInfo.currentPage-1}&order=${sessionScope.sort}">[上一页]</a>&nbsp;&nbsp;
                       </c:if>

                       <c:if test="${requestScope.pageInfo.currentPage != requestScope.pageInfo.totalPage}">
                           <a style="font-size: 15px" href="${pageContext.request.contextPath }/saleInfo?currentPage=${requestScope.pageInfo.currentPage+1}&order=${sessionScope.sort}">[下一页]</a>&nbsp;&nbsp;
                           <a style="font-size: 15px" href="${pageContext.request.contextPath }/saleInfo?currentPage=${requestScope.pageInfo.totalPage}&order=${sessionScope.sort}">[尾页]</a>&nbsp;&nbsp;
                       </c:if>

                        <span style="font-size: 15px">第${requestScope.pageInfo.currentPage }页/ 共${requestScope.pageInfo.totalPage}页</span>&nbsp;&nbsp;
                        <span style="font-size: 15px">(${requestScope.pageInfo.totalCount }条记录)&nbsp;&nbsp;</span>&nbsp;&nbsp;
                    </span>
                </td>
            </tr>
        </table>
    </div>
    <div class="clearfix"></div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/logout.js" type="text/javascript"></script>
</body>
</html>