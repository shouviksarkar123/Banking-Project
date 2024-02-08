<%@ page import="com.bank.model. CustomerDTO, java.util.ArrayList" language="java" contentType="tex pageEncoding="ISO-8859-1"%>

< ! DOCTYPE html>

4 <html>

 <head>

<meta charset="ISO-8859-1">

<link rel="stylesheet" href="css/styles.css">

<title>Deposit Amount</title>

</head>
<body>
 <%@ include file="Header.jsp" %>

 <form method="post" action="Amount DepositServlet">

<div class="form">

Deposit Amount<br><br>

<% String result = (String) request.getAttribute("result");
 if (result != null) out.println(result);
 %>



<input type="radio" name="account_type" value="Savings Account" >Savings Account
<br>

<input type="radio" name="account_type" value="Current Account" >Current Account

<br>
Amount: <input type="text" name="Amount" size="10">

<input type="submit" value="Submit">

</div>

</form>

</body>
 </html>