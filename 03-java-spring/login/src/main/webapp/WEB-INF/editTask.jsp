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

 <form:form method="POST" action="/task/edit/${id}" modelAttribute="task">
    <p>
        <form:label path="taskName">Task</form:label>
        <form:errors path="taskName"/>
        <form:input path="taskName"/>
    </p>
    
    <form:hidden path="user" value="${user.id}"/>
    
    <p>
 	<form:label path="assignee">Assignee:</form:label>
	<form:select path = "assignee">
   		<form:option value = "${assignee}" label = "Assignee"/>
		<c:forEach items="${allusers}" var="user">
			<option value="${user.name}">${user.name}</option>
		</c:forEach>
	</form:select> 
    </p>
    
    <p>
	<form:label path="priority">Priority:</form:label>
	<form:select path = "priority">
		<form:option value="Low">Low</form:option>
		<form:option value="Medium">Medium</form:option>
		<form:option value="High">High</form:option>
</form:select>  
    </p>
 
    <button class="btn btn-secondary">Edit</button>
</form:form>
</body>
</html>