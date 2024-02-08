package com.bank.model;

public class Customer {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String branch;
	private String zip;
	private String userName;
	private String password;
	private String role;
	private String phone;
	private String email;
	
	
	
	public Customer(String firstName, String lastName, String address, String city, String branch , String zip, String userName,String password, String role, String phone, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.branch = branch;
		this.zip = zip;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.phone = phone;
		this.email = email;
	}
	public String getFirstName() { 
		return firstName; 
		}
	public String getLastName() { 
		return lastName; 
		}
	public String getAddress() { 
		return address; 
		}
	public String getCity() { 
		return city; 
		}
	public String getBranch() { 
		return branch; 
		}
	public String getZip() { 
		return zip; 
		}
	public String getUserName() { 
		return userName; 
		}
	public String getPassword() { 
		return password; 
		}
	public String getRole() { 
		return role; 
		}
	public String getPhone() { 
		return phone; 
		}
	public String getEmail() { 
		return email; 
		}
}