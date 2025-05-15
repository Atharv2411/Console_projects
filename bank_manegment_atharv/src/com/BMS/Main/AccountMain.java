package com.BMS.Main;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.BMS.Controller.AccountControl;
import com.BMS.Controller.CardController;
import com.BMS.Controller.LinkedController;
import com.BMS.Controller.TransactionControl;
import com.BMS.Controller.TransactionHistoryConrtol;
import com.BMS.Service.AccountService;
import com.BMS.Service.TransactionHistoryService;
import com.BMS.database.DBConnection;
import com.BMS.pojo.Account;
import com.BMS.pojo.Card;
import com.BMS.pojo.Link;
import com.BMS.pojo.TransactionHistory;
import com.BMS.pojo.Transactions;

public class AccountMain {
	public static void main(String[] args) throws ClassNotFoundException,SQLException 
	{
		
		Scanner sc = new Scanner(System.in);
		List<TransactionHistory> transactionList = new ArrayList<>();
		
		Date currentDate = new Date(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
		
		Account a = new Account();
		Card c = new Card();
		AccountControl ac = new AccountControl();	
		TransactionControl tc = new TransactionControl();
		Transactions t = new Transactions();
		TransactionHistoryConrtol th = new TransactionHistoryConrtol();
		TransactionHistory ts = new TransactionHistory();
		CardController cc = new CardController();
		Link l = new Link();
		LinkedController lc = new LinkedController();
		
		java.util.Date expiryDate = null;
		
		int ch;
		boolean flag;
		double am;
		String chooseTransection;
		
		
		 
		 String card_type,card_number,cvv,confirmCVVx;
		String account_number = null,name,contact_number,email,password,cpassword,gender,address,upi_id,mpin;
		int age;
		String account_type,branch_name,internet_banking,pin,cpin,aadharcard_number;
		double balance = 0.00;
		
		//transaction
		 String transaction_type,transaction_date;
		 int user_id;
		 double amount;
		
		 //otp generator
		 int[] otpArray = {1111, 2222, 3333, 4444};
	        Random random = new Random();
	        int randomIndex = random.nextInt(otpArray.length); // Random index from 0 to length-1
	        int selectedOTP = otpArray[randomIndex];

	  
		do
		{
			System.out.println("Enter the activity: ");
			ch = sc.nextInt();
			
			switch(ch)
			{
			case 1:
			{
				System.out.println("Enter the account number ");
				account_number=sc.next();
				
				System.out.println("Enter the Name: ");
				name=sc.next();
				
				System.out.println("Enter the age: ");
				age=sc.nextInt();
				
				System.out.println("Enter the contact number: ");
				contact_number=sc.next();
				
				System.out.println("Enter the email: ");
				email=sc.next();
				
				System.out.println("Enter the aadharcard number: ");
				aadharcard_number=sc.next();
				
				System.out.println("Enter the password: ");
				password=sc.next();
				
				System.out.println("Enter the confirm password: ");
				cpassword=sc.next();
				
				System.out.println("Enter the gender: ");
				gender=sc.next();
				
				System.out.println("Enter the address: ");
				address=sc.next();
				
				System.out.println("Enter the account type(savings/current/student): ");
				account_type=sc.next();
				
				System.out.println("Enter the branch name: ");
				branch_name=sc.next();
				
				System.out.println("is you want your account connect to internet banking(yes/no): ");
				internet_banking=sc.next();
				
				System.out.println("Enter the pin");
				pin=sc.next();
				
				System.out.println("Enter the confirm pin");
				cpin=sc.next();
				
				
				a.setAccount_number(account_number);
				a.setName(name);
				a.setContact_number(contact_number);
				a.setEmail(email);
				
				if(cpassword.equals(password))
				{
					a.setPassword(cpassword);
					System.out.println("password save successfully!!!");
				}
				else
				{
					System.out.println("invalid password!!!");
				}
				
				a.setGender(gender);
				a.setAddress(address);
				a.setAge(age);
				a.setAccount_type(account_type);
				
				
				if(age>=18 && account_type.equals("savings"))
				{
					a.setBalance(balance = 1000);
				}
				else if(age>=18 && account_type.equals("current"))
				{
					a.setBalance(balance = 2000);
				}
				else if(age<=10 && age>=25 && account_type.equals("student") )
				{
					a.setBalance(balance = 500);
				}
				else
				{
					System.out.println("no other option");
				}
				
		        String[] city = {"thane", "bhandup", "nahur", "vashi"};
		        int[] ifsc = {1, 2, 3, 4};
		      
				int ifscCode = -1;
	            for (int k = 0; k < city.length; k++) {
	                if (branch_name.equals(city[k])) {
	                    ifscCode = ifsc[k];
	                    break;
	                }
	            }
				
				a.setIfsc_code(ifscCode);
				a.setBranch_name(branch_name);
//				a.setInternet_banking(internet_banking);
				
				if(internet_banking.equals("yes"))
				{
					a.setInternet_banking(internet_banking="enabled");
				}
				else if(internet_banking.equals("no"))
				{
					a.setInternet_banking(internet_banking="disabled");
				}
				else
				{
					System.out.println("invalid input!!!!");
				}
				
			

				
				if(cpin.equals(pin))
				{
					a.setPin(cpin);
					System.out.println("pin save successfully!!!");
				}
				else
				{
					System.out.println("invalid pin!!!");
				}
				
				a.setAadharcard_number(aadharcard_number);
				
				
			
				  System.out.println("Generated OTP: " + selectedOTP); 
			        System.out.print("Enter OTP to verify: ");
			        int userInput = sc.nextInt();
			        
			             if (userInput == selectedOTP)
			             {
			            	 System.out.println("OTP is valid. Authentication successful!");
			            	 flag = ac.AddService(a);
			            	 if(flag)
			     				{
			            		 	
			     					System.out.println("account successfully created!!!!");
			     				}
			     				else
			     				{
			     					System.out.println("something went wrong");
			     				}
			            	 
			             } 
			             else 
			             {
			            	 System.out.println("Invalid OTP. Authentication failed.");
			             }
				
				break;
			}
			case 2:
			{
				System.out.println("Enter the Account number: ");
				account_number=sc.next();
				
				a = ac.displayAccountDetails(account_number);
				
				 System.out.println("Generated OTP: " + selectedOTP); 
			        System.out.print("Enter OTP to verify: ");
			        int userInput = sc.nextInt();
			        
			             if (userInput == selectedOTP)
			             {
			            	 System.out.println("\t\t\t"+"ACCOUNT DETAIL OF"+a.getName()+"IS");
			 				System.out.println(a.getAccount_number()+"\t"+a.getName()+"\t"+a.getContact_number()+"\t"+a.getEmail()+"\t"+a.getAadharcard_number()+"\t"+a.getGender()+"\t"+a.getAge()+"\t"+a.getAddress()+"\t"+a.getAccount_type()+"\t"+a.getIfsc_code()+"\t"+a.getBranch_name()+"\t"+a.getBalance()+"\t"+a.getInternet_banking());
			 				break;
			             }
			             else
			             {
			            	 System.out.println("Invalid OTP. Authentication failed.");
			             } 
			             break;
			}
			
			
		//TRANSACTION 
			
			case 3:
			{
				
				System.out.println("enter the Transactions(balance_inquiry/credit/ChangePin/Generate Pin): ");
				chooseTransection = sc.next();
				
				switch(chooseTransection)
				{
				case "balance_inquiry": 
				{
				    System.out.println("Enter the account number: ");
				    account_number = sc.next();

				    System.out.println("Enter the pin: ");
				    pin = sc.next();

				    a = tc.CheckBalance(account_number, pin);

				    if (a != null && pin.equals(a.getPin()) && account_number.equals(a.getAccount_number())) 
				    {
				        System.out.println("Your balance is: " + a.getBalance());
				    } 
				    else
				    {
				        System.out.println("Account not found or wrong credentials.");
				    }
				    break;
				}//check balance close

				case "credit": 
				{
					System.out.println("Enter the account number: ");
					account_number = sc.next();

					System.out.println("Enter the PIN: ");
					pin = sc.next();

					a = tc.withrawMoney(account_number, pin);

					if (a != null && account_number.equals(a.getAccount_number()) && pin.equals(a.getPin())) {
					    System.out.println("Your new balance is: " + a.getBalance());
					} 
					else {
					    System.out.println("Wrong account number or PIN.");
					}

				    break;
				}//credit close

				case "debit":
				{
					System.out.println("Enter the account number: ");
					account_number = sc.next();

					System.out.println("Enter the PIN: ");
					pin = sc.next();

					a = tc.depositeMoney(account_number, pin);

					if (a != null && account_number.equals(a.getAccount_number()) && pin.equals(a.getPin())) {
					    System.out.println("Your new balance is: " + a.getBalance());
					} 
					else {
					    System.out.println("Wrong account number or PIN.");
					}


				    break;
				}//debit close
				
				case "ChangePin":
				{
					System.out.println("Enter the account number: ");
					 account_number = sc.next();

					System.out.println("Enter the PIN: ");
					pin = sc.next();

					 System.out.println("Generated OTP: " + selectedOTP); 
				        System.out.print("Enter OTP to verify: ");
				        int userInput = sc.nextInt();
				        
				             if (userInput == selectedOTP)
				             {
					flag = tc.ChangeAndUpdatePin(account_number, pin);

					 
					if (flag)
					{
					    System.out.println("PIN changed successfully!");
					} 
					else
					{
					    System.out.println("Invalid account number, PIN, or update failed.");
					}
				             }
				             else 
				             {
				            	 System.out.println("Invalid OTP. Authentication failed.");
				             }			        
					
				}//close change pin
				
				}
				

			}
			case 4:
			{
				System.out.println("Enter the account number: ");
				account_number = sc.next();

				System.out.println("Enter the PIN: ");
				pin = sc.next();

				
				    List<TransactionHistory> transactions =  th.getTransactionHistory(account_number, pin);

				    if (!transactions.isEmpty()) {
				        System.out.println("Transaction History:");
				        for (TransactionHistory ths : transactions) {
				        	System.out.println(ths.getAccount_number()+ths.getTransaction_type()+ths.getAmount()+ths.getTransaction_date());
				        }
				    } else {
				        System.out.println("No transactions found or invalid account number/PIN.");
				    }

			}//case 4 close
			
			case 5:
			{
				System.out.println("Enter the account number: ");
				account_number = sc.next();

				System.out.println("Enter the PIN: ");
				pin = sc.next();

				
				

				if (a != null && account_number.equals(a.getAccount_number()) && pin.equals(a.getPin())) 
				{
				    System.out.println("Enter the card type ('debit', 'credit'): ");
				    card_type = sc.next();

				    System.out.println("Enter the card number: ");
				    card_number = sc.next();

				    System.out.println("Enter the CVV: ");
				    cvv = sc.next();

				    System.out.println("Confirm the CVV: ");
				    confirmCVVx = sc.next();

				    
				    if (!cvv.equals(confirmCVVx)) {
				        System.out.println("CVV mismatch! Please try again.");
				        
				    }

				    // Set card details
				    c.setCard_type(card_type);
				    c.setCard_number(card_number);
				    c.setCvv(confirmCVVx);
				    c.setCreatedat(DBConnection.getTime());

				    System.out.println("Do you want to set the expiry date? (yes/no)");
				    String want = sc.next();

				    if (want.equalsIgnoreCase("yes")) 
				    {
				        System.out.println("Enter the card validity period in years (e.g., 5 for 5 years): ");
				        int validityYears = sc.nextInt();

				        // Calculate the expiry date
				        
				        calendar.setTime(currentDate);
				        calendar.add(Calendar.YEAR, validityYears); 
				         expiryDate = new Date(calendar.getTimeInMillis());

				        // Set the expiry date and validate it
				        c.setExpiry_date(expiryDate);
				        System.out.println("Expiry date set to: " + expiryDate);

				        if (expiryDate.before(currentDate))
				        {
				            System.out.println("The card is expired."); 
				        }
				        else 
				        {
				            System.out.println("The card is valid.");
				        }
				    }
				    else 
				    {
				        System.out.println("Expiry date skipped.");
				    }
				    
				}
				else {
				    System.out.println("Invalid account number or PIN.");
				}

				    
				    flag = cc.addCard(c, account_number, pin);
				    if (flag) {
				        System.out.println("Card information added successfully!");
				    } else {
				        System.out.println("Something went wrong. Please try again.");
				    }
				}//case 5 close	
			
			case 6:
			{
				System.out.println("Enter the account number: ");
		        account_number = sc.next();
		        System.out.println("Enter the PIN: ");
		        pin = sc.next();

		        a.setAccount_number(account_number);
		        a.setPin(pin);
		        if (a != null && account_number.equals(a.getAccount_number()) && pin.equals(a.getPin())) {
		            System.out.println("Account validated successfully. Choose how you want to link the account:");

		            System.out.println("1. Link via mobile \n 2. link via aadharcard number");
		            String LinkChoice = sc.next();

		            System.out.println("Generated OTP: " + selectedOTP); 
			        System.out.print("Enter OTP to verify: ");
			        int userInput = sc.nextInt();
			        
			             if (userInput == selectedOTP)
			             {
			            	 
			            	 System.out.println("OTP is valid. Authentication successful!");
			            	 if (LinkChoice.equals("mobile")) {
					                l.setLinked_via(LinkChoice);
					                lc.LinkedAccount(l,a);
					                } 
			            	 
			            	 if (LinkChoice.equals("aadharcard")) {
					                l.setLinked_via(LinkChoice);
					                lc.LinkedAccount(l,a);
					                }            	 
			             } 
			             else 
			             {
			            	 System.out.println("Invalid OTP. Authentication failed.");
			             }
		        } 
		        else
		        {
		        	System.out.println("something went wrong!!!!");
		        }
		        } 
			
		    }
		}
		while(ch!=4);
	}
}
