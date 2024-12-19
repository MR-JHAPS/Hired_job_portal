package com.jobmarket.client.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;




import com.jobmarket.File_name;
import com.jobmarket.Session_constants;
import com.jobmarket.client.model.DB_helper_employee;


public class Employee_delete_account extends HttpServlet implements File_name,Session_constants{
	private static final long serialVersionUID = 1L;
       
   
    public Employee_delete_account() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(false);
		//if the session is expired or the attribute value is null.
		if(session==null || session.getAttribute(EMPLOYEE_SESSION_ID)==null) {
			response.sendRedirect(INDEX_JSP);
			return;
		}
		
		
		
		
		int employee_id = (Integer) session.getAttribute(EMPLOYEE_SESSION_ID);
		
		DB_helper_employee db = new DB_helper_employee();
		Connection db_connection = null;
		boolean is_employee_account_deleted = false;
		
		try {
			//connection to DB:
			db_connection = db.connect_db();
			
			is_employee_account_deleted = db.delete_employee_information(db_connection, employee_id); 
		}catch (Exception e) {
			e.printStackTrace();
		
		
		}finally {
			if(db_connection!=null) {
				//Disconnecting DB:
				db.disconnect(db_connection);
			}
			
			if(is_employee_account_deleted==true) {
				String account_delete_message = "Your Account Is Deleted Successfully.";
				String encoded_message = URLEncoder.encode(account_delete_message , StandardCharsets.UTF_8);
				
				response.sendRedirect(INDEX_JSP +"?account_delete_message=" + encoded_message);
			}
			else {
				String message = "Cannot delete your account something went wrong.";
				response.sendError(500, message);
			}
			
		}
		
		
	
		
		
		
		
		
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
