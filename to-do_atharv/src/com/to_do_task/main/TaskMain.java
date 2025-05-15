package com.to_do_task.main;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.to_do_task.implement.ImplementTask;
import com.to_do_task.pojo.Task;

public class TaskMain {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		Scanner sc = new Scanner(System.in);
		Task t = new Task();
		Timestamp tk = new Timestamp(System.currentTimeMillis());
		ImplementTask it = new ImplementTask();
		Date d = new Date();
		Date currentDate = new Date();
		List<Task> tl = new ArrayList<>();
		
		 int task_id;
		 String Task_name,status,created_date = null,numberOfDay,complition_date,remaining_date;
		long numberofdays;
		 
		int ch;
		boolean flag;
		
		
		System.out.println("Enter the activity add/update/delete:");
		ch = sc.nextInt();
		
//		do
//		{
			switch(ch)
			{
			case 1:
			{
				  System.out.println("Enter the task name: ");
	              Task_name = sc.next();
	              System.out.println("Enter the completion date (YYYY-MM-DD): ");
	              String completionDateStr = sc.next();

	              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	              Date completionDate = sdf.parse(completionDateStr);



	              long diffInMillies = completionDate.getTime() - currentDate.getTime();

	              if (diffInMillies < 0) 
	              {
	                  System.out.println("The completion date has already passed.");
	              } 
	              else 
	              {
	            	  //direct calculate karaycha millseconds to day
	                  long diffInSeconds = diffInMillies / 1000;
	                  long diffInMinutes = diffInSeconds / 60;
	                  long diffInHours = diffInMinutes / 60;
	                  long diffInDays = diffInHours / 24;


	                  long remainingHours = diffInHours % 24;
	                  long remainingMinutes = diffInMinutes % 60;
	                  long remainingSeconds = diffInSeconds % 60;

	                  
	                  remaining_date = String.format("%d days", diffInDays);

	                  System.out.println("Remaining time: " + remaining_date);

	                  t.setTask_name(Task_name);
	                  t.setStatus("pending");
	                  t.setDate(currentDate);
	                  t.setComplition_date(completionDateStr);
	                  t.setNumberofdays((int) diffInDays); 
	                  t.setRemaining_time(remaining_date); 
	                  t.setCreated_date(new SimpleDateFormat("yyyy-MM-dd").format(currentDate));



	                  flag = it.addTask(t);
	                  if (flag) 
	                  {
	                      System.out.println("Task added successfully!");
	                  } 
	                  else
	                  {
	                      System.out.println("Something went wrong!");
	                  }
	                  break;
				
			}
	              
			}//close case1
			case 2:
			{
				System.out.println("Enter the task id for upate  ");
	            task_id = sc.nextInt();
	            System.out.println("Enter the taskname  ");
	            Task_name= sc.next();
	            System.out.println("enter the stetus to update: ");
	            status = sc.next();
	            System.out.println("Enter the completion date (YYYY-MM-DD): ");
	            String completionDateStr = sc.next();

	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            Date completionDate = sdf.parse(completionDateStr);

	            

	            long diffInMillies = completionDate.getTime() - currentDate.getTime();

	            if (diffInMillies < 0) 
	            {
	                System.out.println("The completion date has already passed.");
	            } 
	            else 
	            {
	          	  //direct calculate karaycha millseconds to day
	                long diffInSeconds = diffInMillies / 1000;
	                long diffInMinutes = diffInSeconds / 60;
	                long diffInHours = diffInMinutes / 60;
	                long diffInDays = diffInHours / 24;


	                long remainingHours = diffInHours % 24;
	                long remainingMinutes = diffInMinutes % 60;
	                long remainingSeconds = diffInSeconds % 60;

	                
	                remaining_date = String.format("%d days", diffInDays);

	                System.out.println("Remaining time: " + remaining_date);

	                t.setTask_id(task_id);
	                t.setTask_name(Task_name);
	                t.setStatus(status);
	                t.setDate(currentDate);
	                t.setComplition_date(completionDateStr);
	                t.setNumberofdays((int) diffInDays); 
	                t.setRemaining_time(remaining_date); 
	                t.setCreated_date(new SimpleDateFormat("yyyy-MM-dd").format(currentDate));


	                
	                flag = it.updateTask(t);
	                if (flag) 
	                {
	                    System.out.println("Task updeted  successfully!");
	                } 
	                else
	                {
	                    System.out.println("Something went wrong!");
	                }
	                break;
				
	              
			}
		}//close case 2
			
			case 3:
			{
				
				System.out.println("Enter the task id for upate  ");
	            task_id = sc.nextInt();


	                t.setTask_id(task_id);
	                
	                flag = it.deletetask(t);
	                if (flag) 
	                {
	                    System.out.println("Task updeted  successfully!");
	                } 
	                else
	                {
	                    System.out.println("Something went wrong!");
	                }
	                break;
				
	              
			}//close case 3
			
			case 4:
			{	
				System.out.println("Enter the task id: ");
				task_id=sc.nextInt();
				
				tl = it.DisplayTask(t, task_id);
				if(tl.isEmpty())
				{
					System.out.println("nothing found!!!");
				}
				else
				{
					for(Task tastList : tl)
					{
						System.out.println(t.getTask_name()+t.getStatus()+t.getCreated_date()+t.getComplition_date()+t.getNumberofdays()+t.getRemaining_time());
					}
				}
				
			}//case 4 close
			case 5:
			{	
				System.out.println("Enter the task name: ");
				Task_name=sc.next();
				
				tl = it.DisplayTaskByName(t, Task_name);
				if(tl.isEmpty())
				{
					System.out.println("nothing found!!!");
				}
				else
				{
					for(Task tastList : tl)
					{
						System.out.println(t.getTask_id()+t.getTask_name()+t.getStatus()+t.getCreated_date()+t.getComplition_date()+t.getNumberofdays()+t.getRemaining_time());
					}
				}
				break;
				
			}//case 5 close
			case 6:
			{
				System.out.println("Enter the task name: ");
				status=sc.next();
				
				tl = it.DisplayTaskByStatus(t, status);
				if(tl.isEmpty())
				{
					System.out.println("nothing found!!!");
				}
				else
				{
					for(Task tastList : tl)
					{
						System.out.println(t.getTask_id()+t.getTask_name()+t.getStatus()+t.getCreated_date()+t.getComplition_date()+t.getNumberofdays()+t.getRemaining_time());
					}
				}
				break;
				
			}//case 6 close
			case 7:
			{
	            System.out.println("Enter the completion date (YYYY-MM-DD): ");
	            created_date = sc.next();
	            
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            currentDate = sdf.parse(created_date); 

	      
				tl = it.DisplayTaskByDate(t, currentDate);
				if(tl.isEmpty())
				{
					System.out.println("nothing found!!!");
				}
				else
				{
					for(Task tastList : tl)
					{
						System.out.println(t.getTask_id()+t.getTask_name()+t.getStatus()+t.getCreated_date()+t.getComplition_date()+t.getNumberofdays()+t.getRemaining_time());
					}
				}
				break;
				
			}//case 7 close
			
			default:
			{
				System.out.println("Invalid input!!!!");
				break;
			}
		}
//			
//		}while(ch!=8);
}
}
