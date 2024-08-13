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
import com.jobmarket.hired.model.Country;
import com.jobmarket.hired.model.DB_connection;


public class Company_sign_up_loader extends HttpServlet implements File_name{
	private static final long serialVersionUID = 1L;
       
  
    public Company_sign_up_loader() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DB_connection db = new DB_connection();
		Connection db_connection = db.connect_db();
		
		List<Country> country_list = db.display_all_country(db_connection);
		
		db.disconnect(db_connection);
		
		request.setAttribute("attr_country_list", country_list);
	
		request.getRequestDispatcher(COMPANY_SIGN_UP_JSP).forward(request, response);
		
		
		
		
		
		
		
		
	}
	
	
	
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
