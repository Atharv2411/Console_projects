package com.FoodPlaza.dbImplements;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.FoodPlaza.control.FoodInfo;
import com.FoodPlaza.dbconn.DBConnection;
import com.FoodPlaza.pojo.Food;

public class Service implements FoodInfo{
	
	Connection conn;
	PreparedStatement ps;
	Statement s;
	ResultSet rs;
	int i;
	String displayfood = "select * from Food";
	Food f = new Food();
	List<Food>fl = new ArrayList<>();
	
	
	@Override
	public boolean addFood(Food f) throws ClassNotFoundException, SQLException {
		
		conn = DBConnection.estamblishConn();
		Food set = new Food();
		String insertquery="insert into Food(foodname,foodcategory,foodprice,foodtype) values (?,?,?,?)";
		ps = conn.prepareStatement(insertquery);
		ps.setString(1,f.getFoodname());
		ps.setString(2, f.getFoodcatagory());
		ps.setDouble(3,f.getFoodprice());
		ps.setString(4, f.getFoodtype());
		
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
	public boolean updateFood(Food f) throws ClassNotFoundException, SQLException{
		
		conn = DBConnection.estamblishConn();
		String updatequery = "update Food set foodname =?,foodcategory=?,foodprice=?,foodtype=? where foodid = ?";
		ps = conn.prepareStatement(updatequery);
		
		ps.setString(1,f.getFoodname());
		ps.setString(2, f.getFoodcatagory());
		ps.setDouble(3,f.getFoodprice());
		ps.setString(4, f.getFoodtype());
		ps.setInt(5,f.getFoodid());
		
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
	public boolean deleteFood(Food f) throws ClassNotFoundException, SQLException {
		conn = DBConnection.estamblishConn();
		String deletequery = "delete from Food where foodid = ?";
		ps = conn.prepareStatement(deletequery);
		
		ps.setInt(1,f.getFoodid());
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
	public List<Food> DisplayFood() throws ClassNotFoundException, SQLException {
		fl.clear();
		conn = DBConnection.estamblishConn();
		 displayfood = "select * from Food";
		s = conn.createStatement();
		rs = s.executeQuery(displayfood);
		
		
		while(rs.next())
		{
			Food fs = new Food();
			fs.setFoodid(rs.getInt("foodid"));
			fs.setFoodname(rs.getString("foodname"));
			fs.setFoodprice(rs.getDouble("foodprice"));
			fs.setFoodcatagory(rs.getString("foodcategory"));
			fs.setFoodtype(rs.getString("foodtype"));
			
			fl.add(fs);
		}
		return fl;
		
	}
	@Override
	public Food displayFood(int foodId) throws ClassNotFoundException, SQLException {
		
		conn = DBConnection.estamblishConn();
		String displaybyid = "select * from Food where foodid = ?";
		ps = conn.prepareStatement(displaybyid);
		ps.setInt(1, foodId);
		rs = ps.executeQuery();
		Food f3 =new Food();
		while(rs.next())
		{
			f3.setFoodid(rs.getInt("foodid"));
			f3.setFoodname(rs.getString("foodname"));
			f3.setFoodprice(rs.getDouble("foodprice"));
			f3.setFoodcatagory(rs.getString("foodcategory"));
			f3.setFoodtype(rs.getString("foodtype"));
		}
		
		return f3;
	}
	@Override
	public Food displayFood(String foodName) throws ClassNotFoundException, SQLException {
		conn = DBConnection.estamblishConn();
		String displaybyid = "select * from Food where foodname= ?";
		ps = conn.prepareStatement(displaybyid);
		ps.setString(1, foodName);
		rs = ps.executeQuery();
		Food f3 =new Food();
		while(rs.next())
		{
			f3.setFoodid(rs.getInt("foodid"));
			f3.setFoodname(rs.getString("foodname"));
			f3.setFoodprice(rs.getDouble("foodprice"));
			f3.setFoodcatagory(rs.getString("foodcategory"));
			f3.setFoodtype(rs.getString("foodtype"));
		}
		
		return f3;
	}
	@Override
	public List<Food> displayFood(double foodPrice) throws ClassNotFoundException, SQLException {
		fl.clear();
		conn = DBConnection.estamblishConn();
		String displayfood = "select * from Food where foodprice = ?";
		ps = conn.prepareStatement(displayfood);
		ps.setDouble(1, foodPrice);
		rs = ps.executeQuery();
		
		
		while(rs.next())
		{
			Food fs = new Food();
			fs.setFoodid(rs.getInt("foodid"));
			fs.setFoodname(rs.getString("foodname"));
			fs.setFoodprice(rs.getDouble("foodprice"));
			fs.setFoodcatagory(rs.getString("foodcategory"));
			fs.setFoodtype(rs.getString("foodtype"));
			
			fl.add(fs);
		}
		return fl;
	}
	@Override
		public List<Food> DisplayFoodByRange(double initialRange, double finalRange) throws ClassNotFoundException, SQLException {
		    List<Food> f2 = new ArrayList<>();
		    conn = DBConnection.estamblishConn();
		    s = conn.createStatement();
		    rs = s.executeQuery(displayfood);
		    while (rs.next()) {
		    	double foodPrice = rs.getDouble("foodprice");
		        if (foodPrice >= initialRange && foodPrice <= finalRange) {
		            Food fs = new Food();
		            fs.setFoodprice(foodPrice);
		            fs.setFoodid(rs.getInt("foodid"));
					fs.setFoodname(rs.getString("foodname"));
					fs.setFoodprice(rs.getDouble("foodprice"));
					fs.setFoodcatagory(rs.getString("foodcategory"));
					fs.setFoodtype(rs.getString("foodtype"));
		            f2.add(fs);
		        }
		    }
		    return f2;
		}

	
	
}
