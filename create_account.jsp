<%@ page import="com.bank.model.CustomerDTO, java.util.ArrayList"
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/styles.css">
<meta charset="ISO-8859-1">
<title>Create Account</title>
</head>
<body>
	<%@include file="Header.jsp"%>
	<form method="post" action="CreateAccountServlet">
		<div class="form">
			Create Account<br>
			<br>
			<div style="color: red">
				<%
				String result = (String) request.getAttribute("result");
				if (result != null)
					out.println(result);
				ArrayList<CustomerDTO> customerDTOS = (ArrayList<CustomerDTO>) session.getAttribute("customer_dtos");
				%>
			</div>
			<lable for="customer_id">Customer CRN:</lable>
			<select name="customer_id">
				<%
				for (int i = 0; i < customerDTOS.size(); i++) {
					String id = customerDTOS.get(i).getId();
					String name = customerDTOS.get(i).getFirstName() + " " + customerDTOS.get(i).getLastName();
				%>
				<option value="<%=id%>">
					<%=id + ": " + name%>
				</option>
				<%
				}
				%>
			</select>
			<br><br>
			What type of account do you want to create ?
			<br>
			<input type="radio" name="account_type" value="Savings Account" >Savings Account<br>
			<input type="radio" name="account_type" value="Current Account" >Current Account<br>
			<input type="submit" value="submit">
		</div>
	</form>
</body>
</html>