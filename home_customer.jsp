<%@ page import="com.bank.model.Account,java.util.ArrayList"
language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<%@ include file ="Header.jsp" %>
<% String customerId = (String)session.getAttribute("customer_id");
	if(customerId != null){
%>
<div class="dashboard">
<div style= "color:blue">
Customer CRN: <%=customerId %> 
</div>

<% String result = (String) request.getAttribute("result");
	if (result != null) out.println("<span class='error' >" + result + "</span>");
%><br><br>

<%
ArrayList<Account> accounts = (ArrayList<Account>)request.getAttribute("accounts");
if(accounts!= null){
for ( Account a: accounts){
%>
<div style="color:blue">
<%= a.getAccountID() %> 
<%=a.getAccountType() %>
							<% String amount = String.format("Rs.+9.2f" , a.getAmount() );%>
							<%=amount %>
						</div>
				<%		} %>
			</div>
			<%		}
		}	%>
</body>
</html>