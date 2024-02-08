package com.bank.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import com.bank.db.AccountsDBA;
import com.bank.db.DBConnector;
import com.bank.model.Account;

/**
 * Servlet implementation class CreateAccountServlet
 */
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateAccountServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accountType = request.getParameter("account_type");
		String customerId = request.getParameter("customer_id");

		Connection connection = DBConnector.getConnection();
		boolean accountExist = AccountsDBA.doesAccountExist(connection, customerId, accountType);
		int success = 0;
		if (!accountExist)
			success = AccountsDBA.createAccount(connection, customerId, accountType);
		ArrayList<Account> accounts = AccountsDBA.getAccounts(connection, customerId);
		DBConnector.closeConnection();
		request.setAttribute("accounts", accounts);
		request.setAttribute("customer_id", customerId);

		if (accountExist) {
			request.setAttribute("result", accountType + "already exist.");
		} else if (success == 1) {
			request.setAttribute("result", "Account created successfully." + success);
		} else
			request.setAttribute("result", "Could not create Account " + success);

		RequestDispatcher dispatcher = null;
		if (accountExist || success == 1)
			dispatcher = request.getRequestDispatcher("home.jsp");
		else
			dispatcher = request.getRequestDispatcher("create_account.jsp");
		dispatcher.forward(request, response);
	}

}