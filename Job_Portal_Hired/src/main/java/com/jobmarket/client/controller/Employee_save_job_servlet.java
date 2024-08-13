package com.jobmarket.client.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;

import com.jobmarket.File_name;
import com.jobmarket.client.model.DB_helper_employee;


public class Employee_save_job_servlet extends HttpServlet implements File_name{
	private static final long serialVersionUID = 1L;
       
    public Employee_save_job_servlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		int job_id = 0;
		if(request.getParameter("job_id")!=null) {
			job_id= Integer.parseInt(request.getParameter("job_id"));
		}
		System.out.println("job_id is okay in save button" + job_id);
		
		HttpSession session = request.getSession(false);
		int employee_id = (Integer) session.getAttribute("attr_employee_id");
		System.out.println("employee_id is okay in save button" + employee_id);
		
		Connection db_connection = null;
		DB_helper_employee db = new DB_helper_employee();
		
		try {
			
			db_connection = db.connect_db();
			
			boolean is_saved_job_inserted = db.insert_saved_job(db_connection,employee_id, job_id);
			
			
			request.getRequestDispatcher(EMPLOYEE_HOMEPAGE).forward(request, response);
			
		}
		finally {
			//disconnecting the DB.
			if(db_connection!=null) {
				db.disconnect(db_connection);
			}
		}
		
		
		
		
		
		
		
	}//ends doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
