package com.BMS.Service;

import java.sql.SQLException;

import com.BMS.pojo.Account;

public interface TransactionService {
	Account CheckBalance(String account_number,String pin) throws ClassNotFoundException, SQLException;
	Account withrawMoney(String account_number,String pin) throws ClassNotFoundException, SQLException;
	Account depositeMoney(String account_number,String pin) throws ClassNotFoundException, SQLException;
	boolean ChangeAndUpdatePin(String account_number, String Pin) throws ClassNotFoundException, SQLException;
	}
