package com.BMS.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.BMS.Service.LinkService;
import com.BMS.database.DBConnection;
import com.BMS.pojo.Account;
import com.BMS.pojo.Link;

public class LinkedController implements LinkService {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	Account a = new Account();
	Link l = new Link();
	int i;
	@Override
	public Link LinkedAccount(Link l,Account a) throws ClassNotFoundException, SQLException{
	conn = DBConnection.estamblishConn();


	    // Step 1: Check if the account exists with the provided PIN and account number
	    String findQuery = "SELECT pin, account_number FROM accounts WHERE pin = ? AND account_number = ?";
	    ps = conn.prepareStatement(findQuery);
	    ps.setString(1, a.getPin());
	    ps.setString(2, a.getAccount_number());
	    rs = ps.executeQuery();

	    if (rs.next()) {
	        // Account found, proceed with linking
	        String linkedQuery = "INSERT INTO link (user_id, linked_via, linked_date, account_number) "
	                            + "SELECT accounts.user_id, ?, ?, ? FROM accounts WHERE accounts.account_number = ?";
	        ps = conn.prepareStatement(linkedQuery);
	        ps.setString(1, l.getLinked_via());  // How it was linked (e.g., app, website)
	        ps.setTimestamp(2, DBConnection.getTime());  // Current timestamp
	        ps.setString(3, a.getAccount_number());  // Account number being linked
	        ps.setString(4, a.getAccount_number());  // Account number being used to find user_id

	        i = ps.executeUpdate();
	        if (i > 0) {
	            System.out.println("Account successfully linked.");
	        } else {
	            System.out.println("Failed to link the account.");
	        }

	    } else {
	        System.out.println("Account not found or invalid PIN.");
	    }

	    // Close resources
	    if (rs != null) rs.close();
	    if (ps != null) ps.close();
	    if (conn != null) conn.close();

	    return l;  // Returning the Link object after operation
	}
}