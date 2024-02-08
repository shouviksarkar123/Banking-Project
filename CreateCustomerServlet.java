package com.bank.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import com.bank.db.CustomerDBA;
import com.bank.db.DBConnector;
import com.bank.db.LoginDBA;
import com.bank.model.Customer;
import com.bank.model.LoginUser;

/**
 * Servlet implementation class CreateCustomerServlet
 */
public class CreateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCustomerServlet() {
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
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String branch = request.getParameter("branch");
		String zip = request.getParameter("zip");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String role = "CUSTOMER";
		
		
		
		Customer customer = new Customer(firstname,lastname,address,city,branch,zip,name,pass,role,phone,email);
		Connection connection = DBConnector.getConnection();
		int success = CustomerDBA.createCustomer(connection, customer);
		DBConnector.closeConnection();
		
		if(success == 1) {
			request.setAttribute("result", "Customer created successfully." + success );
		}
		else request.setAttribute("result", " Could not create Customer." + success );

		RequestDispatcher dispatcher = null;
		if(success == 1)
			dispatcher =request.getRequestDispatcher("home.jsp");
		else
			dispatcher = request.getRequestDispatcher("create_customer.jsp");
	    dispatcher.forward(request, response);
	}

}