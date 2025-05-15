package com.BMS.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.BMS.Service.TransactionService;
import com.BMS.database.DBConnection;
import com.BMS.pojo.Account;
import com.BMS.pojo.Transactions;

public class TransactionControl implements TransactionService {
	Scanner sc = new Scanner(System.in);
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	Transactions t= new Transactions();
	Account a = new Account();
	int i;
	double amount;
	double newBalance ;
	public Account CheckBalance(String account_number, String pin) throws ClassNotFoundException, SQLException {
	    
	    String findQuery = "SELECT account_number, balance, pin, user_id FROM accounts WHERE pin = ? AND account_number = ?";
	    String insertTra = "INSERT INTO transactions(user_id, transaction_type, amount, transaction_date, account_number) SELECT accounts.user_id, ?, accounts.balance, ?, ? FROM accounts WHERE accounts.account_number = ?";

	    conn = DBConnection.estamblishConn();

	    // Step 1: Check Account and Balance
	    ps = conn.prepareStatement(findQuery);
	    ps.setString(1, pin);
	    ps.setString(2, account_number);
	    rs = ps.executeQuery();

	    if (rs.next()) {
	        a.setAccount_number(rs.getString("account_number"));
	        a.setPin(rs.getString("pin"));
	        a.setBalance(rs.getDouble("balance"));

	        // Step 2: Insert Transaction
	        ps = conn.prepareStatement(insertTra); // Ensure we get the user_id from the result set
	        ps.setString(1, "balance_inquiry");
	        ps.setTimestamp(2,DBConnection.getTime()); // Make sure t is an actual Transaction object
	        ps.setString(3, account_number);
	        ps.setString(4, account_number);
	        ps.executeUpdate();
	    } else {
	        System.out.println("Account not found or wrong credentials.");
	    }

	    return a;
	}


	
	@Override
	public Account withrawMoney(String account_number,String pin) throws ClassNotFoundException, SQLException {
	    String findQuery = "SELECT account_number, balance, pin, user_id FROM accounts WHERE pin = ? AND account_number = ?";
	    String updateBalQuery = "UPDATE accounts SET balance = ? WHERE account_number = ?";
	    String insertTra = "INSERT INTO transactions(user_id, transaction_type, amount, transaction_date, account_number) " +
	                       "SELECT accounts.user_id, ?, ?, ?, accounts.account_number FROM accounts WHERE accounts.account_number = ?";

	    // Establish database connection
	    conn = DBConnection.estamblishConn();

	    // Check account and retrieve current balance
	    ps = conn.prepareStatement(findQuery);
	    ps.setString(1, pin);
	    ps.setString(2, account_number);
	    rs = ps.executeQuery();

	    if (rs.next()) {
	        double currentBalance = rs.getDouble("balance");
	        int userId = rs.getInt("user_id");

	        // Ensure 'amount' is provided before deposit logic
	        System.out.println("Enter the amount to deposit: ");
	         amount = sc.nextDouble();

	        if (amount <= 0) {
	            System.out.println("Amount should be greater than zero.");
	        } else {
	            double newBalance = currentBalance - amount;

	            // Update balance
	            ps = conn.prepareStatement(updateBalQuery);
	            ps.setDouble(1, newBalance);
	            ps.setString(2, account_number);

	            int rowsUpdated = ps.executeUpdate();
	            if (rowsUpdated > 0) {
	                // Insert transaction
	                ps = conn.prepareStatement(insertTra);
	                ps.setString(1, "debit");
	                ps.setDouble(2, amount);
	                ps.setTimestamp(3, DBConnection.getTime());
	                ps.setString(4, account_number);
	                ps.executeUpdate();

	                // Set account details for return
	                a.setAccount_number(account_number);
	                a.setPin(pin);
	                a.setBalance(newBalance);

	                System.out.println("Deposit successful. Your new balance is: " + newBalance);
	            } else {
	                System.out.println("Error updating balance.");
	            }
	        }
	    } else {
	        System.out.println("Account not found or wrong credentials.");
	    }

	    return a;
	}




	@Override
	public Account depositeMoney(String account_number, String pin) throws ClassNotFoundException, SQLException {
	    String findQuery = "SELECT account_number, balance, pin, user_id FROM accounts WHERE pin = ? AND account_number = ?";
	    String updateBalQuery = "UPDATE accounts SET balance = ? WHERE account_number = ?";
	    String insertTra = "INSERT INTO transactions(user_id, transaction_type, amount, transaction_date, account_number) " +
	                       "SELECT accounts.user_id, ?, ?, ?, accounts.account_number FROM accounts WHERE accounts.account_number = ?";

	    conn = DBConnection.estamblishConn();

	    ps = conn.prepareStatement(findQuery);
	    ps.setString(1, pin);
	    ps.setString(2, account_number);
	    rs = ps.executeQuery();

	    if (rs.next()) {
	        double currentBalance = rs.getDouble("balance");
	        int userId = rs.getInt("user_id");

	        System.out.println("Enter the amount to deposit: ");
	         amount = sc.nextDouble();

	        if (amount <= 0) {
	            System.out.println("Amount should be greater than zero.");
	        } else {
	            double newBalance = currentBalance + amount;

	            ps = conn.prepareStatement(updateBalQuery);
	            ps.setDouble(1, newBalance);
	            ps.setString(2, account_number);

	            int rowsUpdated = ps.executeUpdate();
	            if (rowsUpdated > 0) {
	                // Insert transaction
	                ps = conn.prepareStatement(insertTra);
	                ps.setString(1, "debit");
	                ps.setDouble(2, amount);
	                ps.setTimestamp(3, DBConnection.getTime());
	                ps.setString(4, account_number);
	                ps.executeUpdate();

	                a.setAccount_number(account_number);
	                a.setPin(pin);
	                a.setBalance(newBalance);

	                System.out.println("Deposit successful. Your new balance is: " + newBalance);
	            } else {
	                System.out.println("Error updating balance.");
	            }
	        }
	    } else {
	        System.out.println("Account not found or wrong credentials.");
	    }

	    return a;
	}



	@Override
	public boolean ChangeAndUpdatePin(String account_number, String Pin) throws ClassNotFoundException, SQLException {
	    String findQuery = "SELECT account_number FROM accounts WHERE pin = ? AND account_number = ?";
	    String updatePinQuery = "UPDATE accounts SET pin = ? WHERE account_number = ?";

	    
	    conn = DBConnection.estamblishConn();

	    ps = conn.prepareStatement(findQuery);
	    ps.setString(1, Pin);
	    ps.setString(2, account_number);
	    rs = ps.executeQuery();

	    if (rs.next()) {
	        System.out.println("Enter the new PIN: ");
	        String newPin = new Scanner(System.in).nextLine();

	        System.out.println("Enter the confirm new PIN: ");
	        String confirmNewPin = new Scanner(System.in).nextLine();

	        if (newPin.equals(confirmNewPin)) {
	            // Update the PIN
	            ps = conn.prepareStatement(updatePinQuery);
	            ps.setString(1, newPin);
	            ps.setString(2, account_number);

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
	        else
	        {
	            System.out.println("New PIN and confirmation PIN do not match.");
	            return false;
	        }
	    } 
	    else 
	    {
	        
	        System.out.println("Wrong account number or PIN.");
	        return false;
	    }
	}




	}



