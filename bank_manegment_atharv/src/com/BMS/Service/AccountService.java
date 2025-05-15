package com.BMS.Service;

import java.sql.SQLException;

import com.BMS.pojo.Account;

public interface AccountService {
	boolean AddService(Account a) throws SQLException, ClassNotFoundException;
	Account displayAccountDetails(String account_number) throws ClassNotFoundException, SQLException;
}
