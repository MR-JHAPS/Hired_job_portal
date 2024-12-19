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

import com.jobmarket.client.model.DB_helper_employee;
import com.jobmarket.company.model.Job_wrapper;

public class Display_saved_job extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Display_saved_job() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		Connection db_connection = null;
		DB_helper_employee db = new DB_helper_employee();
		
		try {
			//Connecting the database.
			db_connection = db.connect_db();
			

			HttpSession session = request.getSession(false);
			int employee_id = (Integer) session.getAttribute("attr_employee_id");
			System.out.println(employee_id);
			
			List<Job_wrapper> saved_job_list = db.get_saved_job_information(db_connection, employee_id);
			
			request.setAttribute("attr_saved_job_list", saved_job_list);
			
			request.getRequestDispatcher("employee_saved_job.jsp").forward(request, response);
			
		}finally {
			//disconnecting the DB.
			if(db_connection!=null) {
				db.disconnect(db_connection);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
	}//ends doGet method.

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
