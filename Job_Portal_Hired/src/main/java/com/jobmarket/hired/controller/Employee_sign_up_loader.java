package com.jobmarket.hired.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.jobmarket.File_name;
import com.jobmarket.hired.model.Country;
import com.jobmarket.hired.model.DB_connection;

public class Employee_sign_up_loader extends HttpServlet implements File_name {
	private static final long serialVersionUID = 1L;
       
    public Employee_sign_up_loader() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DB_connection db = null;
		Connection db_connection = null;
		
	try {	
			db = new DB_connection();
			db_connection = db.connect_db();
			
			List<Country> country_list = db.display_all_country(db_connection);
			
			request.setAttribute("attr_country_list", country_list);
		
			request.getRequestDispatcher(EMPLOYEE_SIGN_UP_JSP).forward(request, response);
	}finally {
			if(db_connection!=null) {
				db.disconnect(db_connection);
			}
	}//ends finally
			
			
			
			
	}//ends method.


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
