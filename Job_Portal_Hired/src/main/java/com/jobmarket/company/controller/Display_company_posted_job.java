package com.jobmarket.company.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.jobmarket.File_name;
import com.jobmarket.company.model.DB_helper_company;
import com.jobmarket.company.model.Job;
import com.jobmarket.company.model.Job_wrapper;


public class Display_company_posted_job extends HttpServlet implements File_name {
	private static final long serialVersionUID = 1L;
       
    
    public Display_company_posted_job() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		int company_id = (Integer) session.getAttribute("attr_company_id");
		
		if(session==null || session.getAttribute("attr_company_id") == null) {
			response.sendRedirect(COMPANY_SIGN_IN_JSP);
			return; //this return ends the method after redirection
		}
		
		DB_helper_company db = new DB_helper_company();
		Connection db_connection = null;
		
		try {
				//connecting to DB:
				db_connection = db.connect_db();
				System.out.println("company_id in servlet : " + company_id);
				
				//Getting the list of job Information from the DB:  to display on the company home page.
				List<Job_wrapper> job_list_by_company_id =  db.get_all_job_information_by_company_id(db_connection , company_id);
				
				
				
				request.setAttribute("attr_job_list_by_company_id", job_list_by_company_id);
				request.getRequestDispatcher(COMPANY_HOME_JSP).forward(request, response);
			
		}
		finally{
				if(db_connection!= null) {
					db.disconnect(db_connection);	
				}//ends if
			
		}//ends finally
	
		
	}//Ends doGet method.

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
