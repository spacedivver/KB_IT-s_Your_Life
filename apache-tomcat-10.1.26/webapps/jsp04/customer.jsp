<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>고객 관리</title>
</head>
<body>
<h1>Add Customer</h1>
<form action="customers" method="get">
    <input type="hidden" name="action" value="add">
    Customer ID: <input type="text" name="customerId"><br>
    Name: <input type="text" name="customerName"><br>
    Email: <input type="text" name="customerEmail"><br>
    <input type="submit" value="Add">
</form>

<h1>Delete Customer</h1>
<form action="customers" method="get">
    <input type="hidden" name="action" value="delete">
    Customer ID: <input type="text" name="customerId"><br>
    <input type="submit" value="Delete">
</form>
</body>
</html>
