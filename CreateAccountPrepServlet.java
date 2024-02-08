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

import com.bank.db.CustomerDBA;
import com.bank.db.DBConnector;
import com.bank.model.Account;
import com.bank.model.CustomerDTO;

public class CreateAccountPrepServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;

 public CreateAccountPrepServlet() {
 }

 protected void doGet(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
  Connection connection = DBConnector.getConnection();
  ArrayList<CustomerDTO> customerDTOS = CustomerDBA.getCustomerWithFewAccounts(connection);
  DBConnector.closeConnection();

  HttpSession session = request.getSession();
  session.setAttribute("customer_dtos", customerDTOS);

  RequestDispatcher dispatcher = request.getRequestDispatcher("create_account.jsp");
  dispatcher.forward(request, response);
 }

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
  *      response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
// TODO Auto-generated method stub
  doGet(request, response);
 }

}