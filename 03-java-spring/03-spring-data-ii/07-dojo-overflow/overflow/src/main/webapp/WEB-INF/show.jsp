<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Answer</title>
</head>
<body>
	<h1>${question.qtext}</h1>
	<c:forEach items="${question.qtags}" var="tag">
	${tag.subject},
	</c:forEach>
	<h2>Answers</h2>
	<ul>
	<c:forEach items="${question.answers}" var="answer">
	<li>${answer.atext}</li>
	</c:forEach>
	</ul>
	
	<h3>Add an Answer</h3>
	<form:form method="post" action="/addAnswer" modelAttribute="answer">
	<form:label path="atext">Answer:</form:label>
	<form:errors path="atext"/>
	<form:input path="atext"/>
	<form:hidden path="quest" value="${answer.id}"/>
	<button>Add Answer</button>
	</form:form>
</body>
</html>