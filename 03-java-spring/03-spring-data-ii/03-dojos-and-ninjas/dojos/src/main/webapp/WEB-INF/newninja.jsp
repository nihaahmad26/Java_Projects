<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Ninja</title>
</head>
<body>
	<form:form method = "POST" action ="/createNinja"  modelAttribute="ninja">
	<form:label path="firstName">First Name</form:label>
	<form:input type="text" path="firstName"></form:input>

	<form:label path="lastName">Last Name</form:label>
	<form:input type="text" path="lastName"></form:input>
	
	<form:label path="age">Age</form:label>
	<form:input type="text" path="age"></form:input>
	
	<form:label path="dojo">Select Dojo:</form:label>
	<form:select path="dojo">
			<c:forEach items="${allDojos}" var="dojo"> 
			<form:option value="${dojo.id}">${dojo.name}</form:option>
			</c:forEach>
	</form:select>
	<button>Create</button>
	</form:form>

</body>
</html>