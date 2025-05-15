package com.to_do_task.DBandTime;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

public class DbandTime {
	public static Connection estamblishedConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/to_do_atharv","root","atharv@2411");
		return con;
	}
	public static Timestamp getTime()
	{
		Timestamp t = new Timestamp(System.currentTimeMillis());
		return t;

	}
	
}
