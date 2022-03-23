<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF" crossorigin="anonymous">
</head>
<body>
	<h1>Welcome, <c:out value="${user.name}" /></h1>
	<a href="/logout">Logout</a>
	
<table>
<tr>
<th>Task</th>
<th>Creator</th>
<th>Assignee</th>
<th>Priority</th>
</tr>
<c:forEach items="${alltasks}" var="task">
<tr>
<td><a href= "/tasks/${task.id}">${task.taskName}</a></td>
<td>${task.user.name}</td>
<td>${task.assignee}</td>
<td>${task.priority}</td>
</tr>
</c:forEach>
</table> 
<hr>
<a class="btn btn-secondary" href="/tasks/new">Create Task</a>
</body>
</html>
