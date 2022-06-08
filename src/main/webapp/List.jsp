<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 08/06/2022
  Time: 10:04 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Tim Kiem</h1>
<form method="post">
    <input type="text" name="name">
    <input type="hidden" name="act" value="searchName">
    <input type="submit" value="Tìm Kiếm">
</form>
<h2>Tìm kiếm theo giá</h2>
<form method="post">
    <input type="number" name="start" placeholder=" giá bắt đầu"> git push -u origin master

    <input type="number" name="end" placeholder=" giá kết thúc">
    <input type="hidden" name="act" value="searchPrice">
    <input type="submit" value="tìm kiếm">
</form>
<H1>Danh sách sản phẩm</H1>
<h3>mã sản phẩm, tên sản phẩm, giá, số lượng</h3>
<c:forEach var="item" items="${list}">
    <h3>${item.id}, ${item.name}, ${item.price}, ${item.quantity}
        <c:if test="${item.price > 200}">
            - Khuyễn mãi 10%
        </c:if>
        <c:if test="${item.price < 200}">
            - Khuyễn mãi 20%
        </c:if></h3>
</c:forEach>
<c:forEach var="item" items="${products}">
    <h3>${item.id}, ${item.name}, ${item.price}, ${item.quantity}
        <c:if test="${item.price > 200}">
            - Khuyễn mãi 10%
        </c:if>
        <c:if test="${item.price < 200}">
            - Khuyễn mãi 20%
        </c:if></h3>
</c:forEach>
<c:forEach var="item" items="${product}">
    <h3>${item.id}, ${item.name}, ${item.price}, ${item.quantity}
        <c:if test="${item.price > 200}">
            - Khuyễn mãi 10%
        </c:if>
        <c:if test="${item.price < 200}">
            - Khuyễn mãi 20%
        </c:if></h3>
</c:forEach>
</body>
</html>
</body>
</html>