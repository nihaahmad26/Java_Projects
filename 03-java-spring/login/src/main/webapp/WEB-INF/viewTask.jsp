<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Task <c:out value="${task.taskName}"/></h1>
<h3>Creator: <c:out value="${task.user.name}"/></h3>
<h3>Assignee: <c:out value="${task.assignee}"/></h3>
<h3>Priority: <c:out value="${task.priority}"/></h3>


<a class="btn btn-secondary" href="/edit/${id}">Edit</a>
<a class="btn btn-secondary" href="/delete/${id}">Delete</a>
</body>
</html>