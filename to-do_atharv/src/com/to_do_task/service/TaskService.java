package com.to_do_task.service;

import java.util.Date;
import java.sql.SQLException;
import java.util.List;

import com.to_do_task.pojo.Task;

public interface TaskService {
	boolean addTask(Task t) throws ClassNotFoundException, SQLException;
	boolean updateTask(Task t) throws ClassNotFoundException, SQLException;
	boolean deletetask(Task t) throws ClassNotFoundException, SQLException;
	List<Task>DisplayTask(Task t,int task_id) throws ClassNotFoundException, SQLException;
	List<Task>DisplayTaskByName(Task t,String Task_name) throws ClassNotFoundException, SQLException;
	List<Task>DisplayTaskByStatus(Task t,String status) throws ClassNotFoundException, SQLException;
	List<Task>DisplayTaskByDate(Task t,Date date) throws ClassNotFoundException, SQLException;
	
	


	
	
	
	
}
