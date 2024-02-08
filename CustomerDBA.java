package com.bank.db;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.bank.model.Customer;
import com.bank.model.CustomerDTO;
import com.bank.model.LoginUser;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDBA {
	
	public static int createCustomer(Connection connection, Customer customer) {
		String id = null;
		
		String query = "INSERT INTO BANK.CUSTOMER(F_NAME,L_NAME,ADDRESS,CITY,BRANCH,ZIP,"
						+ "USERNAME,PASSWORD,ROLE,PHONE,EMAIL)" 
						+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		int result = -1;
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, customer.getFirstName());
			stmt.setString(2, customer.getLastName());
			stmt.setString(3, customer.getAddress());
			stmt.setString(4, customer.getCity());
			stmt.setString(5, customer.getBranch());
			stmt.setString(6, customer.getZip());
			stmt.setString(7, customer.getUserName());
			stmt.setString(8, customer.getPassword());
			stmt.setString(9, customer.getRole());
			stmt.setString(10, customer.getPhone());
			stmt.setString(11, customer.getEmail());
			result = stmt.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		}
		
		public static Customer getCustomer(Connection connection, String id) {
			LoginUser user = null;
			Customer customer = null;

			try {
			Statement stmt = connection.createStatement();
			String query= "SELECT F_NAME, L_NAME, PASSWORD, ROLE ,CUSTOMER_ID FROM CUSTOMER WHERE USERNAME = '" + id + "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
			String fName = rs.getString("F_NAME");
			String lName = rs.getString("L_NAME");
			String password = rs.getString("PASSWORD");
			String role = rs.getString("ROLE");
			String customerid = rs.getString("CUSTOMER_ID");
			user = new LoginUser(id,password,role,fName,lName,customerid);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
			}
			return customer;
		}
		
		public static ArrayList<CustomerDTO> getCustomerWithFewAccounts(Connection connection) {
			ArrayList<CustomerDTO> customers = new ArrayList();	
			
			try {
				Statement stmt = connection.createStatement();
				String query= "SELECT CUSTOMER_ID, F_NAME, L_NAME FROM CUSTOMER WHERE ROLE ='CUSTOMER'";
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
				String id = rs.getString("CUSTOMER_ID");
				String fName = rs.getString("F_NAME");
				String lName = rs.getString("L_NAME");
				CustomerDTO c = new CustomerDTO(id,fName,lName);
				customers.add(c);
				} 
			} catch (SQLException e) {
				e.printStackTrace();
				}
				return customers;
			}
			
		}