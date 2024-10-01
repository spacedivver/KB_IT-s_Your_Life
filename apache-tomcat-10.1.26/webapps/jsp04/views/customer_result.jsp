<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>고객 결과</title>
</head>
<body>
<h1>Customer Result</h1>
<p>${message}</p>
<h2>Customer List</h2>
<ul>
    <c:forEach var="customer" items="${customers}">
        <li>ID: ${customer.customerId}, Name: ${customer.customerName}, Email: ${customer.customerEmail}</li>
    </c:forEach>
</ul>
<a href="customer.jsp">Back to Customer Management</a>
</body>
</html>
