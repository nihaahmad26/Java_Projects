<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Time</title>
<script>
        alert("This is the time's template");
    </script>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<p class = green> <c:out value = "${time}"/> </p>


</body>
</html>