package com.BMS.pojo;

public class TransactionHistory {
	private String transaction_type,transaction_date,account_number,pin;
	private int user_id;
	private double amount;
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public String getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
