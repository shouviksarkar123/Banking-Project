<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/styles.css">
<title>Withdraw Amount</title>
</head>
<body>
  <%@include file="Header.jsp" %>

  <form  method="post" action="AmountWithdrawServlet" >
  <div class="form">
  	Withdraw Amount<br><br>
	<% String result = (String)request.getAttribute("result");
	   if(result != null) out.println("<div class='error' >" + result + "</div>");
	%>
  	<input type="radio" name="account_type" value="Savings Account" >Savings Account
  	<br>
  	<input type="radio"  name="account_type" value="Current Account" >Current Account
  	<br>
  	Amount: <input type="text"  name="amount" size="10" >
  	<br>
	<input type="submit" value="Submit" >
  </div>
  </form>
 
</body>
</html>