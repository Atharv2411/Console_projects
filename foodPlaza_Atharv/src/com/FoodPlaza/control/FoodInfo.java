package com.FoodPlaza.control;

import java.sql.SQLException;
import java.util.List;

import com.FoodPlaza.pojo.Food;

public interface FoodInfo {
	boolean addFood(Food f)throws ClassNotFoundException, SQLException;
	boolean updateFood(Food f)throws ClassNotFoundException, SQLException;
	boolean deleteFood(Food f) throws ClassNotFoundException, SQLException;
	
	Food displayFood(int foodId) throws ClassNotFoundException, SQLException;
	Food displayFood(String foodName) throws ClassNotFoundException, SQLException;
	
	List<Food>displayFood(double foodPrice) throws ClassNotFoundException, SQLException;
	List<Food>DisplayFood() throws ClassNotFoundException, SQLException; 
	List<Food>DisplayFoodByRange(double initialRange,double finalRnge) throws ClassNotFoundException, SQLException;
	
}
		