package com.FoodPlaza.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.FoodPlaza.dbImplements.Service;
import com.FoodPlaza.pojo.Food;

public class FoodService {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		Food f = new Food();
		Service s = new Service();
		
		List<Food>foodlist = new ArrayList<>();
		boolean check;
		
		int ch,foodid;
		 String foodname,foodcatagory,foodtype;
		 double foodprice;	
		
		do {
			System.out.println("enter the activity: ");
			ch = sc.nextInt();
			
			switch(ch)
			{
				case 1:
				{
					System.out.println("enter the food name: ");
					foodname = sc.next();
					System.out.println("enter the food price: ");
					foodprice = sc.nextInt();
					System.out.println("enter the food catagory: ");
					foodcatagory = sc.next();
					System.out.println("enter the food type: ");
					foodtype = sc.next();
					
					f.setFoodname(foodname);
					f.setFoodprice(foodprice);
					f.setFoodcatagory(foodcatagory);
					f.setFoodtype(foodtype);
					
					check = s.addFood(f);
					
					if(check)
					{
						System.out.println("successfully food added.......");
					}
					else
					{
						System.out.println("spmething wents wrong........");
					}
					break;
				}
				
				case 2:
				{
					System.out.println("enter the food id: ");
					foodid = sc.nextInt();
					System.out.println("enter the food name: ");
					foodname = sc.next();
					System.out.println("enter the food price: ");
					foodprice = sc.nextInt();
					System.out.println("enter the food catagory: ");
					foodcatagory = sc.next();
					System.out.println("enter the food type: ");
					foodtype = sc.next();
					
					f.setFoodid(foodid);
					f.setFoodname(foodname);
					f.setFoodprice(foodprice);
					f.setFoodcatagory(foodcatagory);
					f.setFoodtype(foodtype);
					
					check = s.updateFood(f);
					
					if(check)
					{
						System.out.println("successfully food updated.......");
					}
					else
					{
						System.out.println("spmething wents wrong........");
					}
					break;
				}
				case 3:
				{
					System.out.println("enter the food id: ");
					foodid = sc.nextInt();
					f.setFoodid(foodid);
					
					check = s.deleteFood(f);
					
					if(check)
					{
						System.out.println("successfully food deleted.........");
					}
					else
					{
						System.out.println("spmething wents wrong........");
					}
					break;
				}
				case 4:
				{
					foodlist = s.DisplayFood();
					for(Food f1 : foodlist)
					{

						System.out.println(f1.getFoodid()+f1.getFoodname() + f1.getFoodcatagory() + f1.getFoodprice()+f1.getFoodtype());
					}
					break;
				}
				case 5:
				{
					System.out.println("Enter the food id: ");
					foodid = sc.nextInt();
					
					f = s.displayFood(foodid);
					
					System.out.println( f.getFoodid()+f.getFoodname() + f.getFoodcatagory() + f.getFoodprice()+f.getFoodtype());

					
				}
				case 6:
				{
					System.out.println("Enter the food name: ");
					foodname = sc.next();
					
					f = s.displayFood(foodname);
					
					System.out.println( f.getFoodid()+f.getFoodname() + f.getFoodcatagory() + f.getFoodprice()+f.getFoodtype());
					break;
				}
				case 7:
				{
					System.out.println("Enter the price: ");
					foodprice = sc.nextDouble();
					foodlist = s.displayFood(foodprice);
					
					for(Food f1 : foodlist)
					{

						System.out.println(f1.getFoodid()+f1.getFoodname() + f1.getFoodcatagory() + f1.getFoodprice()+f1.getFoodtype());
					}
					break;
				}
				case 8:
				{
					System.out.println("Enter the initial  price: ");
					double initialfoodprice = sc.nextDouble();
					System.out.println("Enter the final price: ");
					double finalfoodprice = sc.nextDouble();
					foodprice = sc.nextDouble();
					
					foodlist = s.DisplayFoodByRange(initialfoodprice,finalfoodprice);
					
					for(Food f1 : foodlist)
					{

						System.out.println(f1.getFoodid()+f1.getFoodname() + f1.getFoodcatagory() + f1.getFoodprice()+f1.getFoodtype());
					}
					break;
				}
				
				case 9:
				{
					System.out.println("thank you!!!!");
					break;
				}
			}
		}while(ch!=9);

	}
}
