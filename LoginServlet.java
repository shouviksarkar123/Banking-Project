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

import com.bank.db.DBConnector;
import com.bank.db.LoginDBA;
import com.bank.model.LoginUser;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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

		String n = request.getParameter("user");
		String p = request.getParameter("pass");
		
		Connection connection = DBConnector.getConnection();
		LoginUser user = LoginDBA.getLoginUser(connection, n);
		DBConnector.closeConnection();
		
		String p2 = user.getPassword();
		
		HttpSession session = request.getSession();
		if(p.equals(p2))
		{
			session.setAttribute("message", "CORRECT PASSWORD");
			session.setAttribute("account_name", user.getName() );
			session.setAttribute("role", user.getRole() );
			session.setAttribute("user", user);
			
		}
		else
			session.setAttribute("message","INVALID PASSWORD");
		
		RequestDispatcher dispatcher=null;
		if(p.equals(p2))
			dispatcher =request.getRequestDispatcher("home.jsp");
		else
			dispatcher = request.getRequestDispatcher("login.jsp");
	    dispatcher.forward(request, response);
		
	}

}