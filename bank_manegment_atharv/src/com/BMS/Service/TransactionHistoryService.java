package com.BMS.Service;

import java.sql.SQLException;
import java.util.List;

import com.BMS.pojo.Account;
import com.BMS.pojo.Transactions;
import com.BMS.pojo.TransactionHistory;
public interface TransactionHistoryService {
	 List<TransactionHistory> getTransactionHistory(String account_number, String pin)throws ClassNotFoundException, SQLException;
}
