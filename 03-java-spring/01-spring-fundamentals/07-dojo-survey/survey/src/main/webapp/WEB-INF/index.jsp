<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
 <link rel="stylesheet" href="/css/style.css">
<body>

<div class = "container">
<form action="/login" method="POST">
	<div class="form">
		<label for="name">Your Name:</label><input name = "name" type="text">
    </div>
            
    <div class="form">
         <label for="location">Dojo Location:</label>
         <select id="location" name="location">
         	<option value="Chicago">Chicago</option>
  			<option value="Seattle">Seattle</option>
  			<option value="San Jose">San Jose</option>
		</select>
    </div>
    
    <div class="form">
         <label for="language">Favorite Language:</label>
         <select id="language" name="language">
         	<option value="python">Python</option>
  			<option value="java">Java</option>
  			<option value="mern">MERN</option>
		</select>
    </div>

	<div class = "comment">

		<label for="comment">Comment (Optional):</label><input name = "comment" type="text">
	</div>
	
     <div class="form">
         <button type="submit">Button</button>
     </div>
     
        </form>
</div>
</body>
</html>