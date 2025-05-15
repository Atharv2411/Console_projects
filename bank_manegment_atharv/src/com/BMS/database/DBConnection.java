package com.BMS.database;

import java.sql.Timestamp;
import java.util.Random;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection estamblishConn() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_manegment_atharv","root","atharv@2411");
		return con;
	}
	public static Timestamp getTime()
	{
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		return ts;
		
	}
	

	
}
