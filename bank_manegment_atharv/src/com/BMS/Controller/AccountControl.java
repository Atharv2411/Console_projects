package com.BMS.Controller;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.BMS.Service.AccountService;
import com.BMS.database.DBConnection;
import com.BMS.pojo.Account;

public  class AccountControl implements AccountService {

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	int i;
	Timestamp ts = DBConnection.getTime();
	
	@Override
	public boolean AddService(Account a) throws SQLException, ClassNotFoundException {
		conn = DBConnection.estamblishConn();
		String addQuery = "INSERT INTO accounts (account_number, name, contact_number, email, password, gender, age, address, upi_id, mpin,created_at, account_type, ifsc_code, branch_name, balance, internet_banking, pin, aadharcard_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
		ps=conn.prepareStatement(addQuery);
		
		
		ps.setString(1,a.getAccount_number());
		ps.setString(2,a.getName());
		ps.setString(3,a.getContact_number());
		ps.setString(4,a.getEmail());
		ps.setString(5,a.getPassword());
		ps.setString(6,a.getGender());
		ps.setInt(7,a.getAge());
		ps.setString(8,a.getAddress());
		ps.setString(9,null);
		ps.setString(10,null);
		ps.setTimestamp(11,ts);
		ps.setString(12,a.getAccount_type());
		ps.setInt(13,a.getIfsc_code());
		ps.setString(14,a.getBranch_name());
		ps.setDouble(15,a.getBalance());
		ps.setString(16,a.getInternet_banking());
		ps.setString(17,a.getPin());
		ps.setString(18,a.getAadharcard_number());
		
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

	@Override
	public Account displayAccountDetails(String account_number) throws ClassNotFoundException, SQLException {
		String displayQuery="select account_number,name,contact_number,email,aadharcard_number,gender,age,address,account_type,ifsc_code,branch_name,balance,internet_banking,created_at from accounts where account_number=?";
		conn = DBConnection.estamblishConn();
		ps = conn.prepareStatement(displayQuery);
		ps.setString(1, account_number);
		rs =ps.executeQuery();
		Account a1 = new Account();
		while(rs.next())
		{
			a1.setAccount_number(rs.getString("account_number"));
			a1.setName(rs.getString("name"));
			a1.setContact_number(rs.getString("contact_number"));
			a1.setEmail(rs.getString("email"));
			a1.setAadharcard_number(rs.getString("aadharcard_number"));
			a1.setGender(rs.getString("gender"));
			a1.setAge(rs.getInt("age"));
			a1.setAddress(rs.getString("address"));
			a1.setAccount_type(rs.getString("account_type"));
			a1.setIfsc_code(rs.getInt("ifsc_code"));
			a1.setBranch_name(rs.getString("branch_name"));
			a1.setInternet_banking(rs.getString("internet_banking"));
			a1.setBalance(rs.getDouble("balance"));
			a1.setAccount_number(rs.getString("created_at"));
			
			
		}
		return a1;
	}

}
