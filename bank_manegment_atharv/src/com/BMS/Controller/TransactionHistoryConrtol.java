package com.BMS.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BMS.Service.TransactionHistoryService;
import com.BMS.database.DBConnection;
import com.BMS.pojo.Transactions;
import com.BMS.pojo.TransactionHistory;

public class TransactionHistoryConrtol implements TransactionHistoryService{
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	List<TransactionHistory> transactionList = new ArrayList<>();
	
	TransactionHistory th = new TransactionHistory();
	int i;
	
	
	@Override
	public List<TransactionHistory> getTransactionHistory(String account_number, String pin) throws ClassNotFoundException, SQLException {
	    conn = DBConnection.estamblishConn(); // Assuming DBConnection is correctly implemented
	    String showQuery = "SELECT a.account_number, a.pin, t.transaction_id, t.transaction_type, t.amount, t.transaction_date " +
	                       "FROM accounts a " +
	                       "JOIN transactions t ON a.account_number = t.account_number " +
	                       "WHERE a.account_number = ? AND a.pin = ?";

	    ps = conn.prepareStatement(showQuery);
	    ps.setString(1, account_number);
	    ps.setString(2, pin);

	    rs = ps.executeQuery();
	    
	    
	    
	    while (rs.next()) {
	        TransactionHistory th = new TransactionHistory();
	        th.setAccount_number(rs.getString("account_number"));
	        th.setTransaction_type(rs.getString("transaction_type"));
	        th.setAmount(rs.getDouble("amount"));
	        th.setTransaction_date(rs.getString("transaction_date"));
	        
	        transactionList.add(th);
	    }
	    
	    return transactionList;
	}


}
