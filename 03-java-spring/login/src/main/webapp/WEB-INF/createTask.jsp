<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF" crossorigin="anonymous">
</head>
<body>
<h1>Create a new task</h1>

<form:form method = "POST" action ="/task/createTask" modelAttribute = "task">
	<form:label path="taskName">Name</form:label>
	<form:errors path="taskName"/>
	<form:input path="taskName"/>
	
	<form:label path="assignee">Assignee:</form:label>
	<form:select path = "assignee">
   		<form:option value = "${assignee}" label = "Assignee"/>
		<c:forEach items="${allusers}" var="user">
			<option value="${user.name}">${user.name}</option>
		</c:forEach>
	</form:select>  
	
	<form:hidden path="user" value="${user.id}"/>
	
	<form:label path="priority">Priority:</form:label>
	<form:select path = "priority">
		<form:option value="Low">Low</form:option>
		<form:option value="Medium">Medium</form:option>
		<form:option value="High">High</form:option>
	</form:select>  

	
	<button class="btn btn-secondary">Create</button>
</form:form>
</body>
</html>