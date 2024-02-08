package com.bank.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import com.bank.db.AccountsDBA;
import com.bank.db.DBConnector;
import com.bank.model.Account;
import com.bank.model.LoginUser;


public class ViewAccountsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ViewAccountsServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		LoginUser loginuser =(LoginUser)session.getAttribute("user");
		String customerId = loginuser.getCustomerId();
		
		Connection connection = DBConnector.getConnection();
		ArrayList<Account> accounts =AccountsDBA.getAccounts(connection,customerId);
		DBConnector.closeConnection();
		
		request.setAttribute("accounts", accounts);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("home_customer.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
