<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/styles.css">
<title>Green Bank - Login</title>
</head>
<body>
<%@ include file="Header.jsp"  %>
<form  name="myform" method="post" action="LoginServlet">
<div class="form">
	Login Form
<div style="color: red">	
<% String m2 = (String)session.getAttribute("message");
	if (m2 != null) out.println(m);
%>
</div>
<br>
<label for="name">USER NAME:</label>
<input type="text" size="10" name="user"></br></br>
<label for="password">PASSWORD:</label>
<input type="password" size="10" name="pass"></br></br>
<input type="submit" value="submit" >
</div>
</form>
</body>
</html>