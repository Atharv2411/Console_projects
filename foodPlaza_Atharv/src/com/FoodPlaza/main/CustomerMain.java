package com.FoodPlaza.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.FoodPlaza.dbImplements.CustomerServices;
import com.FoodPlaza.pojo.Customer;


public class CustomerMain {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		Customer c =new Customer();
		CustomerServices cs = new CustomerServices();
		
		List<Customer>clist = new ArrayList<>();
		
		 int customerId;
		 String customerName,customerAddress,customerEmail,password;
		 long customerContact;
		 boolean check;
		 
		 int ch;
		 do
		 {
			 System.out.println("Enter the Activity you want: ");
			 ch = sc.nextInt();
			 
			 switch(ch)
			 {
			 case 1:
			 {
				 System.out.println("Enter the customer name: ");
				 customerName = sc.next();
				 System.out.println("Enter the customer address: ");
				 customerAddress = sc.next();
				 System.out.println("Enter the customer email: ");
				 customerEmail = sc.next();
				 System.out.println("Enter the customer password: ");
				 password = sc.next();
				 System.out.println("Enter the customer contact number: ");
				 customerContact = sc.nextLong();
				 c.setCustomerName(customerName);
				 c.setCustomerAddress(customerAddress);
				 c.setCustomerEmail(customerEmail);
				 c.setPassword(password);
				 c.setCustomerContact(customerContact);
				check = cs.addCustomer(c);
				
				if(check)
				{
					System.out.println("successfully customer added!!!!");
				}
				else
				{
					System.out.println("something went wrong!!!!");
				}
				break;
				
				 
			 }
			 case 2:
			 {
				 System.out.println("Enter the customer id: ");
				 customerId= sc.nextInt();
				 System.out.println("Enter the customer name: ");
				 customerName = sc.next();
				 System.out.println("Enter the customer address: ");
				 customerAddress = sc.next();
				 System.out.println("Enter the customer email: ");
				 customerEmail = sc.next();
				 System.out.println("Enter the customer password: ");
				 password = sc.next();
				 System.out.println("Enter the customer contact number: ");
				 customerContact = sc.nextLong();
				 
				 c.setCustomerName(customerName);
				 c.setCustomerAddress(customerAddress);
				 c.setCustomerEmail(customerEmail);
				 c.setPassword(password);
				 c.setCustomerContact(customerContact);
				 c.setCustomerID(customerId);
				check = cs.updateCustomer(c);
				
				if(check)
				{
					System.out.println("successfully customer updated!!!!");
				}
				else
				{
					System.out.println("something went wrong!!!!");
				}
				break;
				
				 
			 }
			 case 3:
			 {
				 System.out.println("Enter the customer id: ");
				 customerId= sc.nextInt();
				 
				 c.setCustomerID(customerId);
				check = cs.deleteCustomer(c);
				
				if(check)
				{
					System.out.println("successfully customer deleted!!!!");
				}
				else
				{
					System.out.println("something went wrong!!!!");
				}
				 break;
			 }
			 
			 case 4:
			 {
				 clist = cs.DisplayCustomer();
				 for(Customer cl : clist)
				 {
					 System.out.println(cl.getCustomerID()+"\t"+cl.getCustomerName()+"\t"+cl.getCustomerEmail()+"\t"+cl.getCustomerAddress()+"\t"+cl.getCustomerContact());
				 }
				 break;
				 
			 }
			 case 5:
			 {
				 System.out.println("Enter the customer id: ");
				 customerId= sc.nextInt();
				 
				c= cs.DisplayCustomerbyId(customerId);
				 System.out.println(c.getCustomerID()+"\t"+c.getCustomerName()+"\t"+c.getCustomerEmail()+"\t"+c.getCustomerAddress()+"\t"+c.getCustomerContact());
				 break;
			 }
			 case 6:
			 {
				 System.out.println("Enter the customer address: ");
				 customerAddress = sc.next();
				 
				 clist = cs.DisplayCustomerbyAddress(customerAddress);
				 for(Customer cl : clist)
				 {
					 System.out.println(cl.getCustomerID()+"\t"+cl.getCustomerName()+"\t"+cl.getCustomerEmail()+"\t"+cl.getCustomerAddress()+"\t"+cl.getCustomerContact());
				 }
				 break;
			 }
			 
			 case 7:
			 {
				 System.out.println("Enter the customer email: ");
				 customerEmail = sc.next();
				 c=cs.DisplayCustomerbyemail(customerEmail);
				 System.out.println(c.getCustomerID()+"\t"+c.getCustomerName()+"\t"+c.getCustomerAddress()+"\t"+c.getCustomerContact());
				 break;
			 }
			 case 8:
			 {
				 System.out.println("Enter the customer ID: ");
				 customerId = sc.nextInt();
				 c=cs.DisplayCustomerbyId(customerId);
				 System.out.println(c.getCustomerID()+"\t"+c.getCustomerName()+"\t"+c.getCustomerAddress()+"\t"+c.getCustomerContact()+"\t"+c.getCustomerEmail());
				 break;
			 }
			 case 9:
				 System.out.println("thanx for visite");
				 break;
			 }
			 
		 }while(ch!=9);
	}
}
