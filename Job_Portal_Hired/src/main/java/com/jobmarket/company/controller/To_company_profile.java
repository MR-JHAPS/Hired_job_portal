package com.jobmarket.company.controller;

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

public class To_company_profile extends HttpServlet implements File_name {
	private static final long serialVersionUID = 1L;
       
    
    public To_company_profile() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			HttpSession session = request.getSession(false);
			
			if(session==null) {
				response.sendRedirect("error.jsp");
				return;
			}
			
			
			DB_helper_employee db = null;
			Connection db_connection = null;
			try {
				 db = new DB_helper_employee();
				 db_connection = db.connect_db();
				
				 request.getRequestDispatcher(COMPANY_PROFILE_JSP).forward(request, response);
				
			}finally{
				//disconnecting db.
				db.disconnect(db_connection);
			}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
