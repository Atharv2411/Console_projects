package com.FoodPlaza.dbImplements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.FoodPlaza.control.CustomerInfo;
import com.FoodPlaza.dbconn.DBConnection;
import com.FoodPlaza.pojo.Customer;
import com.FoodPlaza.pojo.Food;

public class CustomerServices implements  CustomerInfo {

	Connection conn;
	PreparedStatement ps;
	Statement s;
	ResultSet rs;
	int i;
	Customer c = new Customer();
	
	List<Customer>cr = new ArrayList<>();
	
	
	@Override
	public boolean addCustomer(Customer c) throws ClassNotFoundException, SQLException {
		conn = DBConnection.estamblishConn();
		String insertQuery ="insert into customer(customerName,customerAddress,customerEmail,password,customerContact) values(?,?,?,?,?)" ;
		ps = conn.prepareStatement(insertQuery);
		
		ps.setString(1,c.getCustomerName());
		ps.setString(2,c.getCustomerAddress());
		ps.setString(3,c.getCustomerEmail());
		ps.setString(4,c.getPassword());
		ps.setLong(5, c.getCustomerContact());
		
		i = ps.executeUpdate();
		
		if(i>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean updateCustomer(Customer c) throws ClassNotFoundException, SQLException {
		
		conn = DBConnection.estamblishConn();
		String updateQuery = "update customer set customerName=?,customerAddress=?,customerEmail=?,password=?,customerContact=? where customerId=?";
		ps = conn.prepareStatement(updateQuery);
		
		ps.setString(1,c.getCustomerName());
		ps.setString(2,c.getCustomerAddress());
		ps.setString(3,c.getCustomerEmail());
		ps.setString(4,c.getPassword());
		ps.setLong(5, c.getCustomerContact());
		ps.setInt(6,c.getCustomerID());
		
		i = ps.executeUpdate();
		
		if(1>0)
		{
			return true;
			
		}
		else
		{
			return false;
		}
		
	}

	@Override
	public boolean deleteCustomer(Customer c) throws ClassNotFoundException, SQLException {
		
		conn = DBConnection.estamblishConn();
		String deleteQuery = "delete from customer where customerId=?"; 
		ps = conn.prepareStatement(deleteQuery);
		
		ps.setInt(1,c.getCustomerID());
		i = ps.executeUpdate();
		
		if(i>0)
		{
			return true;
		}
		else 
		{
			return false;
		}
		
	}

	@Override
	public List<Customer> DisplayCustomer() throws ClassNotFoundException, SQLException {
		cr.clear();
		conn = DBConnection.estamblishConn();
		String DisplayQuery = "select * from customer";
		s = conn.createStatement();
		rs = s.executeQuery(DisplayQuery);
		
		while(rs.next())
		{
			Customer c1 = new Customer();
			c1.setCustomerID(rs.getInt("customerId"));
			c1.setCustomerName(rs.getString("customerName"));
			c1.setCustomerAddress(rs.getString("customerAddress"));
			c1.setCustomerContact(rs.getLong("customerContact"));
			
			cr.add(c1);
		}
		return cr ;
	}

	@Override
	public Customer DisplayCustomerbyId(int customerId) throws ClassNotFoundException, SQLException {
		conn = DBConnection.estamblishConn();
		String DisplayQuery = "select * from customer where customerId=?";
		ps = conn.prepareStatement(DisplayQuery);
		ps.setInt(1,customerId);
		rs = ps.executeQuery();
		Customer c1 = new Customer();
		
		while(rs.next())
		{
			c1.setCustomerID(rs.getInt("customerId"));
			c1.setCustomerName(rs.getString("customerName"));
			c1.setCustomerAddress(rs.getString("customerAddress"));
			c1.setCustomerContact(rs.getLong("customerContact"));
		}
		return c1;
		
		
	}

	@Override
	public List<Customer> DisplayCustomerbyAddress(String customerAddress) throws ClassNotFoundException, SQLException {
		cr.clear();
		conn = DBConnection.estamblishConn();
		String displayquery = "select * from customer where customerAddress=?";
		ps = conn.prepareStatement(displayquery);
		ps.setString(1, customerAddress);
		rs = ps.executeQuery();
		
		
		while(rs.next())
		{
			Customer c2= new Customer();
			c2.setCustomerID(rs.getInt("customerId"));
			c2.setCustomerName(rs.getString("customerName"));
			c2.setCustomerContact(rs.getInt("customerContact"));
			c2.setCustomerAddress(rs.getString("customerAddress"));
			c2.setCustomerEmail(rs.getString("customerEmail"));
			

			cr.add(c2);
		}
		return cr;
	}

//	@Override
//	public List<Customer> DisplayCustomerbyCity(String city) throws ClassNotFoundException, SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Customer DisplayCustomerbyemail(String customerEmail) throws ClassNotFoundException, SQLException {
		
		conn = DBConnection.estamblishConn();
		String DisplayQuery = "select  customerId,customerName,customerAddress,customerContact from customer where customerEmail=?";
		ps = conn.prepareStatement(DisplayQuery);
		ps.setString(1,customerEmail);
		rs = ps.executeQuery();
		Customer c1 = new Customer();
		
		while(rs.next())
		{
			
			c1.setCustomerID(rs.getInt("customerId"));
			c1.setCustomerName(rs.getString("customerName"));
			c1.setCustomerAddress(rs.getString("customerAddress"));
			c1.setCustomerContact(rs.getLong("customerContact"));
		}
		return c1;
	}

	@Override
	public Customer DisplayCustomer(int customerId) throws ClassNotFoundException, SQLException {
		conn = DBConnection.estamblishConn();
		String DisplayQuery = "select * from customer where customerId=?";
		ps = conn.prepareStatement(DisplayQuery);
		ps.setInt(1,customerId);
		rs = ps.executeQuery();
		Customer c1 = new Customer();
		
		while(rs.next())
		{
			
//			c1.setCustomerID(rs.getInt("customerId"));
			c1.setCustomerName(rs.getString("customerName"));
			c1.setCustomerAddress(rs.getString("customerAddress"));
			c1.setCustomerEmail(rs.getString("customerEmail"));
			c1.setCustomerContact(rs.getLong("customerContact"));
			
		}
		return c1;
	}

	@Override
	public List<Customer> DisplayCustomerbyCity(String city) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	
}
