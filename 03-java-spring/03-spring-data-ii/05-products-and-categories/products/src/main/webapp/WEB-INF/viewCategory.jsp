<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
</head>
<body>

<h1><c:out value="${category.name}"/></h1>

<h2>Products</h2>
<ul>
<c:forEach items="${category.products}" var="product">
<li>${product.name}</li>
</c:forEach>
</ul>

<form method="POST" action="/categories/addProducts/${category.id}" >
		<select name="prods">
		<c:forEach items="${notInCat}" var="prod">
			<option value="${prod.id}">${prod.name}</option>
		</c:forEach>
	</select>
	<button>Add Product</button>
</form>

</body>
</html>