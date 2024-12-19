package com.jobmarket.client.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.jobmarket.File_name;
import com.jobmarket.client.model.DB_helper_employee;
import com.jobmarket.company.model.Job_wrapper;


public class Employee_homepage extends HttpServlet implements File_name{
	private static final long serialVersionUID = 1L;
       
    
    public Employee_homepage() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		//this parameter is brought from Employee_update_account to display message in employee Homepage.
		String account_update_message="";
		if(request.getParameter("account_update_message")!=null) {
			account_update_message = request.getParameter("account_update_message");
		}
		
		
		
		DB_helper_employee db= new DB_helper_employee();
		Connection db_connection = null;
		List<Job_wrapper> job_list = new ArrayList<Job_wrapper>();
		boolean is_job_list_displayed = false;
		
		
		
		try {
			
				db_connection = db.connect_db();
				//getting list of all jobs with job_wrapper because Job class only contains FK of category,address etc.
				job_list = db.get_all_job_information(db_connection);
					
				is_job_list_displayed= true;
				
				
				
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		finally {
				if (db_connection!=null) {
					db.disconnect(db_connection);
				}
				
				if(is_job_list_displayed==true) {
				request.setAttribute("attr_job_list", job_list);
				request.getRequestDispatcher(EMPLOYEE_HOME_JSP+"?account_update_message="+account_update_message).forward(request, response);
				}
				else {
					response.sendError(500, "Error getting job list for Employee homepage");
				}
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
