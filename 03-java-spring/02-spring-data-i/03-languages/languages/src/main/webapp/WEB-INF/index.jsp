<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<hr>
	<table class="table table-striped">
	<thead>
		<tr>
			<th>Name</th>
			<th>Creator</th>
			<th>Version</th>
			<th>action</th>
		</tr>
		
		<c:forEach items="${allLangs}" var="language">
		<tr>
		<td> <a href="/language/${language.id}">${language.languageName}</a></td>
		<td>${language.creator}</td>
		<td>${language.version}</td>
		<td>
		<a href="/delete/${language.id}">Delete</a>
 		<a href="/language/edit/${language.id}">Edit</a>
    	</td>
		</tr>
		</c:forEach>
		
	</thead>
	</table>

	<form:form method ="POST" action="/language" modelAttribute = "language">
	<form:label path="languageName">Name</form:label>
	<form:errors path="languageName"/>
	<form:input type="text" path="languageName"/>
	
	<form:label path="creator">Creator</form:label>
	<form:errors path="creator"/>
	<form:input type="text" path="creator"/>
	
	<form:label path="version">Version</form:label>
	<form:errors path="version"/>
	<form:input type="text" path="version"/>
	<p>
	<button>Submit</button>
	</p>
	</form:form>
		
	</div>
</body>
</html>