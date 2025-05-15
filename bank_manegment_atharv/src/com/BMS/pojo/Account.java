package com.BMS.pojo;

public class Account {
	//users table
	private String account_number,name,contact_number,email,password,gender,address,upi_id,mpin;
	private int age;
	
	//accounts table
	private String account_type,branch_name,internet_banking,pin,aadharcard_number;
	private int ifsc_code;
	private double balance;
	
	
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact_number() {
		return contact_number;
	}
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUpi_id() {
		return upi_id;
	}
	public void setUpi_id(String upi_id) {
		this.upi_id = upi_id;
	}
	public String getMpin() {
		return mpin;
	}
	public void setMpin(String mpin) {
		this.mpin = mpin;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public int getIfsc_code() {
		return ifsc_code;
	}
	public void setIfsc_code(int ifscCode) {
		this.ifsc_code = ifscCode;
	}
	public String getBranch_name() {
		return branch_name;
	}
	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}
	public String getInternet_banking() {
		return internet_banking;
	}
	public void setInternet_banking(String internet_banking) {
		this.internet_banking = internet_banking;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getAadharcard_number() {
		return aadharcard_number;
	}
	public void setAadharcard_number(String aadharcard_number) {
		this.aadharcard_number = aadharcard_number;
	}
	
	
	
	
	
}
