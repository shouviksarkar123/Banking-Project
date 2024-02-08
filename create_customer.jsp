<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/styles.css">
<meta charset="ISO-8859-1">
<title>Create Customer</title>
</head>
<body>
	<%@include file="Header.jsp" %>
	
	<form method="post" action="CreateCustomerServlet">
	<div class="form">
		Create Customer
		<div style="color:red">
		<% String result = (String)request.getAttribute("result");
		if(result != null) out.println(result);
		%>
		</div>
		<br>
		<label for="firstname">First Name:</label><br>
		<input type="text" name="firstname"><br>
		<label for="lastname">Last Name:</label><br>
		<input type="text" name="lastname"><br>
		<label for="address">Address:</label><br>
		<input type="text" name="address"><br>
		<label for="city">City:</label><br>
		<input type="text" name="city"><br>
		<label for="branch">Branch:</label><br>
		<input type="text" name="branch"><br>
		<label for="zip">Zip:</label><br>
		<input type="text" name="zip"><br>
		<label for="name">User Name:</label><br>
		<input type="text" name="name"><br>
		<label for="pass">Password:</label><br>
		<input type="password" name="pass"><br>
		<label for="phone">Phone</label><br>
		<input type="text" name="phone"><br>
		<label for="email">Email</label><br>
		<input type="text" name="email"><br>
		<input type="submit" value="submit">
		</div>
	</form>
</body>
</html>