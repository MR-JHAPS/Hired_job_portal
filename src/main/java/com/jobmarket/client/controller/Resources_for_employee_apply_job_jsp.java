package com.jobmarket.client.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.jobmarket.File_name;
import com.jobmarket.client.model.Cv_file;
import com.jobmarket.client.model.DB_helper_employee;


public class Resources_for_employee_apply_job_jsp extends HttpServlet implements File_name {
	private static final long serialVersionUID = 1L;
       
  
    public Resources_for_employee_apply_job_jsp() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	//this data will be sent to the apply for job page and will include the CV_ID.
		
		
		HttpSession session = request.getSession(false);
		if(session==null) {
			response.sendRedirect(INDEX_JSP);
			return;// this ends he code here and won't go further from here if true.
		}
		
		
		int employee_id = (Integer) session.getAttribute("attr_employee_id");
		
		int job_id= 0;
		int company_id = 0;
		
		try {
				job_id = Integer.parseInt(request.getParameter("job_id"));
		}catch (NumberFormatException e) {
			    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid job ID.");
			    return;
		}
		
		try {
				company_id = Integer.parseInt(request.getParameter("company_id"));
		}catch (NumberFormatException e) {
		    	response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid company ID.");
		    	return;
		}
		
		
		
		DB_helper_employee db = new DB_helper_employee();
		Connection db_connection = null;
		
		boolean is_cv_by_id_displayed = false;
		
		try {
				
				db_connection = db.connect_db();
				List<Cv_file> cv_list_by_id = db.get_cv_list_by_id(db_connection,employee_id);
				is_cv_by_id_displayed = true;
				session.setAttribute("attr_employee_cv_list", cv_list_by_id);
				
				
				
				
				request.setAttribute("attr_job_id", job_id);
				request.setAttribute("attr_company_id", company_id);
				System.out.println("THIS IS JOB ID: " + job_id);
				request.getRequestDispatcher(EMPLOYEE_APPLY_JOB_JSP).forward(request, response);
			
			
		}catch(Exception e) {
				e.printStackTrace();
				System.out.println("error in the catch catcch");
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}finally {
				//disconnecting the connection.
				if(db_connection!=null) {
					db.disconnect(db_connection);
				}//ends if
			
			System.out.println("Is CV by ID displayed : " + is_cv_by_id_displayed);
		}//ends finally
	
	
	
	
	
	
	
	
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
