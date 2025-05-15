package com.FoodPlaza.control;

import java.sql.SQLException;
import java.util.List;

import com.FoodPlaza.pojo.Customer;

public interface CustomerInfo {
	boolean addCustomer(Customer c)throws ClassNotFoundException, SQLException;
	boolean updateCustomer(Customer c) throws ClassNotFoundException, SQLException;
	boolean deleteCustomer(Customer c)throws ClassNotFoundException, SQLException;
	
	List<Customer>DisplayCustomer()throws ClassNotFoundException, SQLException;
	Customer DisplayCustomerbyId(int customerId)throws ClassNotFoundException, SQLException;
	List<Customer>DisplayCustomerbyAddress( String customerAddress)throws ClassNotFoundException, SQLException;
	List<Customer>DisplayCustomerbyCity( String city)throws ClassNotFoundException, SQLException;
	Customer DisplayCustomerbyemail( String customerEmail)throws ClassNotFoundException, SQLException;
	Customer DisplayCustomer(int customerId)throws ClassNotFoundException, SQLException;

	//trim city from address
	
}
