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

<h1><c:out value="${product.name}"/></h1>
<c:out value="${product.description}"/>
<c:out value="${product.price}"/>

<h2>Categories</h2>
<ul>
<c:forEach items="${product.categories}" var="cat">
<li>${cat.name}</li>
</c:forEach>
</ul>

<form method="POST" action="/products/addCategories/${product.id}" >
		<select name="cats">
		<c:forEach items="${notInProd}" var="cat">
			<option value="${cat.id}">${cat.name}</option>
		</c:forEach>
	</select>
	<button>Add Category</button>
</form>

</body>
</html>