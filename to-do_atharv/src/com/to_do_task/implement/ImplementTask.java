package com.to_do_task.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.to_do_task.DBandTime.DbandTime;
import com.to_do_task.pojo.Task;
import com.to_do_task.service.TaskService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImplementTask implements TaskService {

	List<Task> tlist = new ArrayList<>();
	Connection conn ;
	PreparedStatement ps;
	ResultSet rs;
	int i;
	Date d = new Date();
	Task t = new Task();

	@Override
	public boolean addTask(Task t) throws ClassNotFoundException, SQLException {
	    String addQuery = "INSERT INTO Task (Name, Date, Status, completionDate, noOfDays, createdAt,remainDate) VALUES (?, ?, ?, ?, ?, ?,?)";
	    conn = DbandTime.estamblishedConnection();
	    ps = conn.prepareStatement(addQuery);

	    ps.setString(1, t.getTask_name());
	    ps.setTimestamp(2, new java.sql.Timestamp(t.getDate().getTime()));
	    ps.setString(3, t.getStatus());
	    ps.setString(4, t.getComplition_date());
	    ps.setInt(5, t.getNumberofdays()); 
	    ps.setTimestamp(6, new java.sql.Timestamp(System.currentTimeMillis()));
	    ps.setString(7, t.getRemaining_time());

	    int i = ps.executeUpdate();
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
	public boolean updateTask(Task t) throws ClassNotFoundException, SQLException {
			String updateQuery="update Task set Name=?,Status=?,completionDate=?,noOfDays=?,remainDate=?,createdAt=? where id=?";
			conn = DbandTime.estamblishedConnection();
		    ps = conn.prepareStatement( updateQuery);

		    ps.setString(1, t.getTask_name());
		    ps.setString(2, t.getStatus());
		    ps.setString(3, t.getComplition_date());
		    ps.setInt(4, t.getNumberofdays()); 
		    ps.setString(5, t.getRemaining_time());
		    ps.setTimestamp(6, new java.sql.Timestamp(System.currentTimeMillis()));
		    ps.setInt(7, t.getTask_id());
		    

		    int i = ps.executeUpdate();
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
	public boolean deletetask(Task t) throws ClassNotFoundException, SQLException {
		String deleteQuery = "delete from Task where id = ?";
		conn = DbandTime.estamblishedConnection();
	    ps = conn.prepareStatement( deleteQuery);


	    ps.setInt(1, t.getTask_id());
	    

	    int i = ps.executeUpdate();
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
	public List<Task> DisplayTask(Task t, int task_id) throws ClassNotFoundException, SQLException {
		String displayQuery="select * from Task where id = ?";
		conn=DbandTime.estamblishedConnection();
		ps = conn.prepareStatement(displayQuery);
		ps.setInt(1, task_id);
		rs = ps.executeQuery();
		
		while(rs.next())
		{
			t.setTask_id(task_id);
			t.setTask_name(rs.getString("Name"));
			t.setStatus(rs.getString("Status"));
			t.setCreated_date(rs.getString("createdAt"));
			t.setComplition_date(rs.getString("completionDate"));
			t.setNumberofdays(rs.getInt("noOfDays"));
			t.setRemaining_time(rs.getString("remainDate"));
			
			tlist.add(t);
			
		}
		
		return tlist;
	}

	@Override
	public List<Task> DisplayTaskByName(Task t, String Task_name) throws ClassNotFoundException, SQLException {
		String displayQuery="select * from Task where Name = ?";
		conn=DbandTime.estamblishedConnection();
		ps = conn.prepareStatement(displayQuery);
		ps.setString(1, Task_name);
		rs = ps.executeQuery();
		
		while(rs.next())
		{
			t.setTask_id(rs.getInt("id"));
			t.setTask_name(Task_name);
			t.setStatus(rs.getString("Status"));
			t.setCreated_date(rs.getString("createdAt"));
			t.setComplition_date(rs.getString("completionDate"));
			t.setNumberofdays(rs.getInt("noOfDays"));
			t.setRemaining_time(rs.getString("remainDate"));
			
			tlist.add(t);
			
		}
		
		return tlist;
	}

	@Override
	public List<Task> DisplayTaskByStatus(Task t, String status) throws ClassNotFoundException, SQLException {
		String displayQuery="select * from Task where Status = ?";
		conn=DbandTime.estamblishedConnection();
		ps = conn.prepareStatement(displayQuery);
		ps.setString(1, status);
		rs = ps.executeQuery();
		
		while(rs.next())
		{
			t.setTask_id(rs.getInt("id"));
			t.setTask_name(rs.getString("Name"));
			t.setStatus(rs.getString("Status"));
			t.setCreated_date(rs.getString("createdAt"));
			t.setComplition_date(rs.getString("completionDate"));
			t.setNumberofdays(rs.getInt("noOfDays"));
			t.setRemaining_time(rs.getString("remainDate"));
			
			tlist.add(t);
			
		}
		
		return tlist;
	}

	@Override
	public List<Task> DisplayTaskByDate(Task t, Date date) throws ClassNotFoundException, SQLException {
		String displayQuery="select * from Task where Date = ?";
		conn=DbandTime.estamblishedConnection();
		ps = conn.prepareStatement(displayQuery);
		 java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	      ps.setDate(1, sqlDate);
		rs = ps.executeQuery();
		
		while(rs.next())
		{
			t.setTask_id(rs.getInt("id"));
			t.setTask_name(rs.getString("Name"));
			t.setStatus(rs.getString("Status"));
			t.setCreated_date(rs.getString("createdAt"));
			t.setComplition_date(rs.getString("completionDate"));
			t.setNumberofdays(rs.getInt("noOfDays"));
			t.setRemaining_time(rs.getString("remainDate"));
			
			tlist.add(t);
			
		}
		
		return tlist;
	}

	

		 
		 
		 

	

}
