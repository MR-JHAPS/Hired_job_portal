package com.jobmarket.hired.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.jobmarket.File_name;
import com.jobmarket.client.model.DB_helper_employee;
import com.jobmarket.company.model.Job_wrapper;


public class Index_selected_job extends HttpServlet implements File_name{
	private static final long serialVersionUID = 1L;
       
    
    public Index_selected_job() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
int job_id = Integer.parseInt(request.getParameter("job_id"));
		
		
		
		DB_helper_employee db = new DB_helper_employee();
		Connection db_connection = db.connect_db();
		
		List<Job_wrapper> index_selected_job_info =  db.get_job_information_by_id(db_connection , job_id);

		db.disconnect(db_connection);
		
		//setting attributes and sending to guest jobs:
		request.setAttribute("attr_employee_selected_job_info", index_selected_job_info);
		
				
		//Dispatcher:
		request.getRequestDispatcher(INDEX_SELECTED_JOB_JSP).forward(request, response);

		
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
