package com.bank.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bank.model.LoginUser;

public class LoginDBA {
	
	public static LoginUser getLoginUser(Connection connection, String username) {
		LoginUser user = null;
		
		try {
			Statement stmt = connection.createStatement();
			String query = " SELECT F_NAME, L_NAME, PASSWORD, ROLE, CUSTOMER_ID FROM CUSTOMER " + "WHERE USERNAME ='"+ username +"'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String fName = rs.getString("F_NAME");
				String lName = rs.getString("L_NAME");
				String password = rs.getString("PASSWORD");
				String customerid = rs.getString("CUSTOMER_ID");
				String role = rs.getString("ROLE");
				user = new LoginUser (username,password,role,fName,lName,customerid);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}