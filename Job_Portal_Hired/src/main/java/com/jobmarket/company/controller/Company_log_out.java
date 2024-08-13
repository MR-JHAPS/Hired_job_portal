package com.jobmarket.company.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.jobmarket.File_name;


public class Company_log_out extends HttpServlet implements File_name{
	private static final long serialVersionUID = 1L;
       
   
    public Company_log_out() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		session.invalidate();
		System.out.println("Company session ended");
		
		
		request.getRequestDispatcher(INDEX_JSP).forward(request, response);
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
