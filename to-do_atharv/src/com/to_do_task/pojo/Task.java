package com.to_do_task.pojo;

import java.sql.Timestamp;
import java.util.Date;

public class Task {
	private int task_id,numberofdays;
	private String Task_name,status,complition_date,created_date,remaining_time;
	Date date;
	
	public String getComplition_date() {
		return complition_date;
	}
	public void setComplition_date(String complition_date) {
		this.complition_date = complition_date;
	}
	public String getRemaining_time() {
		return remaining_time;
	}
	public void setRemaining_time(String remaining_time) {
		this.remaining_time = remaining_time;
	}
	
	

	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getTask_id() {
		return task_id;
	}

	public int getNumberofdays() {
		return numberofdays;
	}
	public void setNumberofdays(int numberofdays) {
		this.numberofdays = numberofdays;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	public String getTask_name() {
		return Task_name;
	}
	public void setTask_name(String task_name) {
		Task_name = task_name;
	}


	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}



	
}
