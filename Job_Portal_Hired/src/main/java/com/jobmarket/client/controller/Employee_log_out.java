package com.jobmarket.client.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.jobmarket.File_name;
import com.jobmarket.Session_constants;


public class Employee_log_out extends HttpServlet implements File_name,Session_constants {
	private static final long serialVersionUID = 1L;
   
    public Employee_log_out() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		HttpSession session = request.getSession(false);
			
		
		
		if(session != null) {
			 
			 System.out.println("session about to end" + session.getAttribute(EMPLOYEE_SESSION_EMAIL));
			 session.invalidate();
			 System.out.println("session ended");
			 request.getRequestDispatcher(INDEX_JSP).forward(request, response);
		}
		else {
			System.out.println("There is no session to end .");
			request.getRequestDispatcher(INDEX_JSP).forward(request, response);
		}
		
		
		
		request.getRequestDispatcher(INDEX_JSP).forward(request, response);

		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
