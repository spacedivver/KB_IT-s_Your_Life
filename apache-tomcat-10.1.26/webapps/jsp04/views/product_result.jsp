<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>제품 결과</title>
</head>
<body>
<h1>Product Result</h1>
<p>${message}</p>
<h2>Product List</h2>
<ul>
    <c:forEach var="product" items="${products}">
        <li>ID: ${product.productId}, Name: ${product.productName}, Price: ${product.productPrice}</li>
    </c:forEach>
</ul>
<a href="product.jsp">Back to Product Management</a>
</body>
</html>
