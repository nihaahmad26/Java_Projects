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
		<h1>Categories</h1>
		<table>
			<thead>
				<tr>
					<th>Name</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${allCategories}" var="category">
				<tr>
				<td> <a href="/categories/${category.id}">${category.name}</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
</body>
</html>
