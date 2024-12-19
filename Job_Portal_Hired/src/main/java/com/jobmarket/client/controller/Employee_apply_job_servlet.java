package com.jobmarket.client.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import com.jobmarket.File_name;
import com.jobmarket.client.model.DB_helper_employee;


public class Employee_apply_job_servlet extends HttpServlet implements File_name{
	private static final long serialVersionUID = 1L;
       

    public Employee_apply_job_servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//session:
		HttpSession session = request.getSession(false);
		if(session==null) {
			response.sendRedirect(INDEX_JSP);
			return;
		}
		
		int employee_id = (Integer) session.getAttribute("attr_employee_id");
		
		
		
//PARAMETERS:
		//getting the cv_id if user want to send cv and if they don't want to send then the value is null in HTML form.
		
		int company_id = 0;
		if(request.getParameter("company_id")!=null) {
			company_id = Integer.parseInt(request.getParameter("company_id"));
		}
		
		int job_id = 0;
		if(request.getParameter("job_id")!=null) {
		 job_id = Integer.parseInt(request.getParameter("job_id"));
		}
		
		int cv_id = 0;
		if(request.getParameter("send_cv")!=null) {
			cv_id = Integer.parseInt(request.getParameter("send_cv"));
		}
		
		//cover letter from employee for Company.
		String employee_cover_letter = "";
		if(request.getParameter("cover_letter")!=null) {
			employee_cover_letter = request.getParameter("cover_letter");
		}
		
		
		DB_helper_employee db = new DB_helper_employee();
		Connection db_connection = null;
		boolean is_applied_job_inserted = false;
		
		try {
			//Connecting the database.
			db_connection = db.connect_db();
			
			System.out.println("cv_id : " + cv_id + "company_id : " + company_id +  " job_id : " + job_id + " employee_id : " + employee_id + " cover letter :" + employee_cover_letter);
			is_applied_job_inserted = db.insert_applied_job(db_connection, cv_id, employee_cover_letter,employee_id, job_id, company_id);
			
			
			
			
		}finally {
			//disconnecting the Database.
			if(db_connection!=null) {
				db.disconnect(db_connection);
			}
			
			if(is_applied_job_inserted==true) {
				String message = " Job applied successfully";
				
				String encoded_message = URLEncoder.encode(message, "UTF-8");
				response.sendRedirect(EMPLOYEE_APPLY_JOB_JSP + "?message=" + encoded_message);
			}
			else {
				response.sendError(500);
			}
		}//ends finally	
			
		
		
	
			

		
		
		
		
		
		
	
		
	
	
	}//ends doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
