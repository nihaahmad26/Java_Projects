<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Category</title>
</head>
<body>
	<h1>New Category</h1>
	<form:form method = "POST" action ="/createCategory"  modelAttribute="category">
	
	<form:label path="name">Name:</form:label>
	<form:errors path="name"/>
	<form:input type="text" path="name"/>
	
	<button>Create</button>
	</form:form>
	
</body>
</html>