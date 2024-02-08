package com.bank.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import com.bank.model.Account;

public class AccountsDBA {
 
 public static boolean doesAccountExist(Connection connection, String customerId, String accountType) {
  String query = "select * from BANK.ACCOUNT " + "where CUSTOMER_ID = '" + customerId + "' " + "and ACCOUNT_TYPE = '" + accountType + "'";
  boolean result = false;
  try {
   Statement stmt =connection.createStatement() ;
   ResultSet resultSet = stmt.executeQuery(query);
   while(resultSet.next()) {
    result = true ;
    break;
    }
   } catch (SQLException e) {
    e.printStackTrace();
   }
   return result;
   }
  
  public static int createAccount(Connection connection, String customerId, String accountType) {
      String id = null;
      
      String query = "Insert into BANK.ACCOUNT (CUSTOMER_ID, ACCOUNT_TYPE, AMOUNT) " + " VALUES (?,?,?)";
      int result = -1;
      try {
       PreparedStatement stmt = connection.prepareStatement(query);
       stmt.setString(1,  customerId);
       stmt.setString(2,  accountType);
       stmt.setDouble(3,  10000);
       result = stmt.executeUpdate();
      } catch (SQLException e) {
       e.printStackTrace();
      }
      return result;
 }
  
  public static ArrayList<Account> getAccounts(Connection connection, String customerId)  {
		ArrayList<Account> accounts = new ArrayList<>();
		
		String query = "select ACCOUNT_ID, ACCOUNT_TYPE, AMOUNT from BANK.ACCOUNT " + "Where CUSTOMER_ID = '" + customerId + "'";
		
		try {
			Statement stmt= connection.createStatement() ;
			ResultSet resultSet = stmt.executeQuery(query);
			while(resultSet.next()) {
				String account_id = resultSet.getString(1);
				String account_type = resultSet.getString(2);
				double ammount = resultSet.getDouble(3);
				Account account = new Account(account_id, account_type, ammount);
				accounts.add(account);
			}
		}catch (SQLException e) {
			   e.printStackTrace();
		   }
		   return accounts;
}
  
  
 public static double getAmount(Connection connection, String customerId, String accountType) {
	 double amountD = 0;
   
   String query = "select  AMOUNT from BANK.ACCOUNT " + "Where CUSTOMER_ID = '" + customerId + "' and ACCOUNT_TYPE ='"+ accountType + "'";
   
   try {
    Statement stmt= connection.createStatement() ;
    ResultSet resultSet = stmt.executeQuery(query);
    while(resultSet.next()) {
     String Amount = resultSet.getString(1);
     amountD = Double.parseDouble(Amount);
    }
    
   } catch (SQLException e) {
	   e.printStackTrace();
   }
   return amountD;
 }
 
 public static int depositAmount (Connection connection, String customerId, String accountType, double amount) {

		 String id=null;

		 String query = "UPDATE BANK2.ACCOUNT SET AMOUNT = ?"

		+" where CUSTOMER_ID =? and ACCOUNT_TYPE = ?";

		 int result = 0;

		 try {

		 PreparedStatement stmt= connection. prepareStatement(query);

		 stmt.setDouble(1, amount);


		 stmt.setString(2, customerId);

	

		 stmt.setString(3, accountType);
		 
		 result = stmt. executeUpdate();
		

		 }catch (SQLException e) {
e.printStackTrace();
		 }
	

		
		return result;
 }


}
 
  