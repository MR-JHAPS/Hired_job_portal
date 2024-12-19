package com.jobmarket.company.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.jobmarket.File_name;
import com.jobmarket.Session_constants;
import com.jobmarket.client.model.DB_helper_employee;
import com.jobmarket.company.model.Applied_job;
import com.jobmarket.company.model.DB_helper_company;


public class Display_job_applicant extends HttpServlet implements File_name, Session_constants{
	private static final long serialVersionUID = 1L;
       

    public Display_job_applicant() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
			HttpSession session = request.getSession(false);
			
			int company_id = (Integer) session.getAttribute(COMPANY_SESSION_ID);
			DB_helper_company db = new DB_helper_company();
			Connection db_connection = null;
			boolean is_applied_job_displayed = false;
			List<Applied_job> display_applied_job_all_information = new ArrayList<Applied_job>();
			
			try {
				
				db_connection = db.connect_db();
				
				//we are looking for all the information of the "employee", "job" and "name of company" to show on applied job menu of Company menubar.
				display_applied_job_all_information = db.display_applied_job_information(db_connection, company_id);
				System.out.println("Applied job information successful in servlet.");
				is_applied_job_displayed= true;
				
				
				
			}catch (Exception e) {
				e.getStackTrace();
			
				
				
			}finally {
				if(db_connection!=null) {
					db.disconnect(db_connection);
				}
					//if the applicants is displayed.
				if(is_applied_job_displayed==true) {
					session.setAttribute("attr_applied_job_applicant_list", display_applied_job_all_information);
					response.sendRedirect(COMPANY_APPLICANT_JSP);	
				}
				//if the applicants is not displayed.
				else {
					response.sendError(500);
				}
				
				
				
				
				
			}//Ends finally.
			
		
		
		
		
		
		
		
		
	
	
	}//ends doGet.

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
