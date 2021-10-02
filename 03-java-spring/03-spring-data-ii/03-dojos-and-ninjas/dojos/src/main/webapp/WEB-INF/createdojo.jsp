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
	<h1>New Dojo</h1>
	<form:form method = "POST" action ="/dojo/createDojo"  modelAttribute="dojo">
	<form:label path="name">Name</form:label>
	<input name="name" type="text">
	<button>Create</button>
	</form:form>
	
</body>
</html>