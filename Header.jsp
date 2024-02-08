<center><h1 class="banner">Green Bank</h1></center> 
<hr>
<div class="nav_bar">
	<%  String m = (String)session.getAttribute("message");
		String n = (String)session.getAttribute("account_name");
		String r = (String)session.getAttribute("role"); %>
		
		<%	if(m != null && m.equals("CORRECT PASSWORD")) {
			if(r != null && r.equals("ADMIN")) {  %>
			<a class="menu-item" href="create_customer.jsp" >Create Customer</a>
			<a class="menu-item" href="CreateAccountPrepServlet" >Create Account</a>
			
		<%	}else if(r != null && r.equals("CUSTOMER")) {   %>
		
			<a class="menu-item" href="ViewAccountsServlet" >Dashboard</a>
			<a class="menu-item" href="amount_deposit.jsp">Deposit Amount</a>
			<a class="menu-item" href="amount_withdraw.jsp" >Wthdraw Amount</a>
			<a class="menu-item" href="amount_transfer.jsp" >Transfer Amount</a>
			
		<%  }
		}
		%>
		
		<div class="toright">
		<%	if(m != null && m.equals("CORRECT PASSWORD")) {   %>
		<%=n %>
		<a class="menu-item" href="LogoutServlet" >Logout</a>
		
		<%	}else{ %>
		<a class="menu-item" href="login.jsp" >login</a>
		<%	}	 %>
		</div>
</div>
<hr>