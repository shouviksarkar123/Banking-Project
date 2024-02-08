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
import java.util.ArrayList;

import com.bank.db.AccountsDBA;
import com.bank.db.DBConnector;
import com.bank.model.Account;
import com.bank.model.LoginUser;

/**
 * Servlet implementation class Amountdepositservlet
 */
public class Amountdepositservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Amountdepositservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		


				String accountType = request.getParameter("account_type");

				String amount =  request.getParameter ("amount");

				double amountD= Double.parseDouble (amount);

				HttpSession session= request.getSession(); 
				LoginUser user = (LoginUser) session.getAttribute("user");

				String customerId = user.getCustomerId();


				Connection connection = DBConnector.getConnection();

				double current_Amount = AccountsDBA.getAmount (connection, customerId, accountType); 
				int success = AccountsDBA.depositAmount (connection, customerId, accountType, current_Amount + amountD);
				ArrayList<Account> accounts = AccountsDBA.getAccounts (connection, customerId); 
				DBConnector.closeConnection();

				request.setAttribute("accounts", accounts);


				if( success == 1) {

				request.setAttribute("result", "Amount deposited.");
				}

				else request.setAttribute("result", "Could not deposit amount.");

		

				RequestDispatcher dispatcher = null;

				if( success == 1)

				dispatcher= request.getRequestDispatcher ("home.jsp");

				else

				dispatcher = request.getRequestDispatcher ("amount_deposit.jsp");
				dispatcher. forward (request, response);

		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
