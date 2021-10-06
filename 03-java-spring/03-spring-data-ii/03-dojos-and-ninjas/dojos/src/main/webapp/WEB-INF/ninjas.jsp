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
		<h1>Dojos and Ninjas</h1>
		<h2>All Ninjas</h2>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Age</th>
					<th>Dojo</th>	
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${allNinjas}" var="ninja">
				<tr>
					<td>${ninja.firstName} ${ninja.lastName}</td>
					<td>${ninja.age}</td>
					<td>${ninja.dojo.name}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
</body>
</html>