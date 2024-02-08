package com.bank.model;

public class LoginUser {
	private String username;
	private String password;
	private String role;
	private String firstName;
	private String lastName;
	private String customerId;
	
	public LoginUser(String username, String password, String role, String firstName, String lastName,String customerId) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerId = customerId;
	}
	public String getPassword() { 
		return password; 
		}
	public String getName(){
		return firstName + " " + lastName;
	}
	public String getCustomerId()  {
		return customerId;	
	}
	public String getRole()  {
		return role;
	}
	
	public void setCustometId(String customerId) {
		this.customerId = customerId;
	}
}