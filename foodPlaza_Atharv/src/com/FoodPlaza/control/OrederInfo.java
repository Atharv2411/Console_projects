		package com.FoodPlaza.control;

import java.sql.SQLException;
import java.util.List;

import com.FoodPlaza.pojo.Orders;

public interface OrederInfo {
	
	boolean placeOrder(String customerEmail) throws SQLException;
	
	List<Orders> showOrders() throws SQLException;
	
	List<Orders> showOrders(String customerEmail) throws SQLException;
	
	boolean cancelOrder(String customerEmail) throws SQLException;
	
	String checkOrderStatus(String customerEmail) throws SQLException;


	boolean updateOrderStatus(Orders o) throws SQLException;
}
