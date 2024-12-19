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
import com.jobmarket.Session_constants;
import com.jobmarket.client.model.DB_helper_employee;
import com.jobmarket.hired.model.Country;


public class Employee_account_settings extends HttpServlet implements File_name,Session_constants{
	private static final long serialVersionUID = 1L;
       

    public Employee_account_settings() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(false);
		Integer employee_id = (Integer) session.getAttribute(EMPLOYEE_SESSION_ID);
		
		DB_helper_employee db = null;
		Connection db_connection = null;
		try {
				db = new DB_helper_employee();
				db_connection = db.connect_db();
				//getting country list to show on employee account settings.
				List<Country> country_list = db.display_all_country(db_connection);
		
				request.setAttribute("attr_country_list", country_list);
				request.getRequestDispatcher(EMPLOYEE_ACCOUNT_JSP).forward(request, response);
			
		}finally{
				
				if(db_connection!=null) {
					db.disconnect(db_connection);
				}
		}//ends finally.
		
		
		
	
	}//ends method

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
