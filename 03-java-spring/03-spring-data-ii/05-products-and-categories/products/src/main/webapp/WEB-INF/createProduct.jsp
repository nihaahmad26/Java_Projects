<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Dojo</title>
</head>
<body>
	<h1>New Product</h1>
	<form:form method = "POST" action ="/createProduct"  modelAttribute="product">
	
	<form:label path="name">Name:</form:label>
	<form:errors path="name"/>
	<form:input type="text" path="name"/>
	
	<form:label path="description">Description:</form:label>
	<form:errors path="description"/>
	<form:input type="text" path="description"/>
	
	<form:label path="price">Price:</form:label>
	<form:errors path="price"/>
	<form:input type="text" path="price"/>
	
	<button>Create</button>
	</form:form>
	
</body>
</html>