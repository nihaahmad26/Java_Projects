<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Question</title>
</head>
<body>

<form:form method="POST" action="/newQuestion" modelAttribute="q">

<form:label path="qtext">Question</form:label>
<form:errors path="qtext"/>
<form:input type="text" path="qtext"/>

<form:label path="tagsFromFrontEnd">tags</form:label>
<form:errors path="tagsFromFrontEnd"/>
<form:input type="text" path="tagsFromFrontEnd"/>
<button>Submit</button>
</form:form>



</body>
</html>