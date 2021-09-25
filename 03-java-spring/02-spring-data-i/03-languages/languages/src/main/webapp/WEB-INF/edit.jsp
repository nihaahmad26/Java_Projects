<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Language</title>
</head>
<body>
<a href="/delete/${language.id}">Delete</a>
<a href="/language">Dashboard</a>

<form:form action="/language/edit" method="post" modelAttribute="language">
    <input type="hidden" name="_method" value="post">
    <p>
        <form:label path="languageName">Name</form:label>
        <form:errors path="languageName"/>
        <form:input path="languageName"/>
    </p>
    <p>
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:textarea path="creator"/>
    </p>
    <p>
        <form:label path="version">Version</form:label>
        <form:errors path="version"/>
        <form:input path="version"/>
    </p>
 
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>