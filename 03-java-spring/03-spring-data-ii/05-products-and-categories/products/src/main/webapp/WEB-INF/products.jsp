<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h1>Products</h1>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Price</th>	
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${allProducts}" var="product">
				<tr>
				<td> <a href="/products/${product.id}">${product.name}</a></td>
					<td>${product.description}</td>
					<td>${product.price}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
</body>
</html>