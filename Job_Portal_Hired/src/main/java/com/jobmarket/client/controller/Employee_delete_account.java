package com.jobmarket.client.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import com.jobmarket.File_name;
import com.jobmarket.client.model.DB_helper_employee;


public class Employee_delete_account extends HttpServlet implements File_name{
	private static final long serialVersionUID = 1L;
       
   
    public Employee_delete_account() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int employee_id = Integer.parseInt(request.getParameter("id"));
		
		//connection to db:
		DB_helper_employee db = new DB_helper_employee();
		Connection db_connection = db.connect_db();
		
		//Executing DB:
		Boolean is_deleted = db.delete_employee_information(db_connection, employee_id); 
		
		
		//Disconnecting DB:
		db.disconnect(db_connection);
		
		
		if(is_deleted == true) {
			String delete_success = "Account deletion Successful.";
			request.setAttribute("attr_delete_success", delete_success);
			request.getRequestDispatcher(INDEX_JSP).forward(request, response);
		}
		
		else {
			System.out.println("Servlet error in deletion of employee account");
			request.getRequestDispatcher(EMPLOYEE_ACCOUNT_JSP).forward(request, response);
		}
		
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
