package com.jobmarket.client.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
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

		
		
		DB_helper_employee db= new DB_helper_employee();
		Connection db_connection = null;
		
		try {
				db_connection = db.connect_db();
				//getting list of all jobs with job_wrapper because Job class only contains FK of category,address etc.
				List<Job_wrapper> job_list = db.get_all_job_information(db_connection);
				
				request.setAttribute("attr_job_list", job_list);
				request.getRequestDispatcher(EMPLOYEE_HOME_JSP).forward(request, response);
				
		}finally {
				if (db_connection!=null) {
					db.disconnect(db_connection);
				}
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
