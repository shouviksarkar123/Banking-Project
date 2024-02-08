package com.bank.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bank.db.AccountsDBA;
import com.bank.db.DBConnector;
import com.bank.model.Account;
import com.bank.model.LoginUser;

public class AmountTransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AmountTransferServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
	String fromAccountType = request.getParameter("from_account");
	String toAccountType = request.getParameter("to_account");
	String amount = (String)request.getParameter("amount");
	double amountD = Double.parseDouble(amount);
	HttpSession session = request.getSession();
	LoginUser user = (LoginUser)session.getAttribute("user");
	String customerId = user.getCustomerId();
	
	Connection connection = DBConnector.getConnection();
	double fromCurrentAmount = AccountsDBA.getAmount(connection, customerId, fromAccountType);
	boolean enoughBalance =  fromCurrentAmount > amountD;
	int rowCount = 0;
	if( enoughBalance ) {
	double toCurrentAmount = AccountsDBA.getAmount(connection, customerId, toAccountType);

	
	
	rowCount = AccountsDBA.depositAmount(connection, customerId, fromAccountType, fromCurrentAmount-amountD);
	if(rowCount != 0)
	 rowCount = AccountsDBA.depositAmount(connection, customerId, toAccountType, toCurrentAmount + amountD);
	}	
	
	
	
/*	
try {
connection.setAutoCommit(false);
rowCount = AccountsDBA.depositAmount(connection, customerId, fromAccountType, fromCurrentAmount - amountD);
if(rowCount != 0)
  rowCount = AccountsDBA.depositAmount(connection, customerId+"'", toAccountType, toCurrentAmount + amountD);
if(rowCount == 0) 
  connection.rollback();
else
	connection.commit();
} catch (SQLException e) {
	e.printStackTrace();
}finally {
	try {
		connection.setAutoCommit(true);
	} catch (SQLException e) {
		e.printStackTrace();
	}
}*/
	
	
	
	
	
	
	
	
	ArrayList<Account> accounts = AccountsDBA.getAccounts(connection, customerId);
	DBConnector.closeConnection();
	request.setAttribute("accounts", accounts);
	
	if( !enoughBalance ) {
		request.setAttribute("result", "Amount in from account Rs." + fromCurrentAmount 
				+ " is less than Transfer amount, Rs." + amountD );
	}
	else if( rowCount == 1) {
		request.setAttribute("result", "Amount Transferred." );
	}
	else request.setAttribute("result", "Could not Transfer amount.");
	
	RequestDispatcher dispatcher = null;
	if( !enoughBalance || rowCount == 1 ) 
		dispatcher = request.getRequestDispatcher("home.jsp");
	else
		dispatcher = request.getRequestDispatcher("amount_withdraw.jsp");
	dispatcher.forward(request, response);
}

}