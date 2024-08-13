package com.jobmarket.hired.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.jobmarket.hired.model.Country;
import com.jobmarket.hired.model.DB_connection;
import com.jobmarket.hired.model.Job_category;
import com.jobmarket.hired.model.Job_contract;
import com.jobmarket.hired.model.Job_salary;


public class Company_start_job_posting extends HttpServlet implements com.jobmarket.File_name {
	private static final long serialVersionUID = 1L;
       
    
    public Company_start_job_posting() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		DB_connection db = null;
		Connection db_connection = null;
		
		try {
				// connecting to DB:
				 db = new DB_connection();
				 db_connection = db.connect_db(); 
				
				
				// Executing the Database.
				DB_connection code = new DB_connection();
				List<Country> job_country_list = code.display_all_country(db_connection);
				List<Job_category> job_category_list = code.display_all_job_category(db_connection);
				List<Job_contract> job_contract_list = code.display_all_job_contract(db_connection);
				List<Job_salary> job_salary_list = code.display_all_job_salary(db_connection);
				
				
				
				request.setAttribute("attr_job_category_list", job_category_list);
				request.setAttribute("attr_job_contract_list", job_contract_list);
				request.setAttribute("attr_job_salary_list", job_salary_list);
				request.setAttribute("attr_job_country_list", job_country_list);
				

				request.getRequestDispatcher(JOB_POSTING_JSP).forward(request, response);
		}finally {
				if(db_connection!=null) {
					//Disconnecting the database:
					db.disconnect(db_connection);
				}
		}//ends finally
		
		
		
		
		
		
	
	
	
	}//ends method

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
