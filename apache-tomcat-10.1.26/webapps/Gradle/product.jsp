<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>제품 관리</title>
</head>
<body>
<h1>Add Product</h1>
<form action="products" method="get">
    <input type="hidden" name="action" value="add">
    Product ID: <input type="text" name="productId"><br>
    Name: <input type="text" name="productName"><br>
    Price: <input type="text" name="productPrice"><br>
    <input type="submit" value="Add">
</form>

<h1>Delete Product</h1>
<form action="products" method="get">
    <input type="hidden" name="action" value="delete">
    Product ID: <input type="text" name="productId"><br>
    <input type="submit" value="Delete">
</form>
</body>
</html>
