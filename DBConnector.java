package com.bank.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import com.bank.model.LoginUser;

public class DBConnector {
	
	private static Connection connection;
	private static final String DB_URL = "jdbc:mysql://localhost:3306/bank2";
	private static final String USER = "bankuser";
	private static final String PASSWORD = "bankuser";
	
	public static Connection getConnection() {
		if(connection == null) {
			try {
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
	
	public static void closeConnection() {
		if( connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			connection = null;
		}
		
	}
}