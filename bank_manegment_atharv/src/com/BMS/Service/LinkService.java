package com.BMS.Service;

import java.sql.SQLException;

import com.BMS.pojo.Account;
import com.BMS.pojo.Link;

public interface LinkService {
	Link LinkedAccount(Link l,Account a) throws ClassNotFoundException, SQLException;
}
