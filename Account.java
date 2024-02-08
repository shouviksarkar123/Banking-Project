package com.bank.model;

public class Account {
 public static final String SAVINGS = "savings account";
 public static final String CURRENT = "current account";
 private String accountID;
 private String customerID;
 private String accountType;
 private double amount; 
 
 public Account (String customerID, String accountType) {
  super();
  this.customerID = customerID;
  this.accountType = accountType;
 }
 
 public Account (String customerID, String accountType, double amount) {
  super();
  this.customerID = customerID;
  this.accountType = accountType;
  this.amount = amount;
 }
 
 public String getAccountID() {
  return accountID;
 }
 public String getCustomerID() {
  return customerID;
 }
 public String getAccountType() {
  return accountType;
 } 
 public double getAmount() {
  return amount;
 }
}