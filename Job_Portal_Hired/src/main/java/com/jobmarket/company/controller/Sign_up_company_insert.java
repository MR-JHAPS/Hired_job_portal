package com.jobmarket.company.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.jobmarket.File_name;
import com.jobmarket.company.model.Company;
import com.jobmarket.company.model.Company_wrapper;
import com.jobmarket.company.model.DB_helper_company;
import com.jobmarket.hired.model.Address;
import com.jobmarket.hired.model.City;
import com.jobmarket.hired.model.Country;


public class Sign_up_company_insert extends HttpServlet implements File_name {
	private static final long serialVersionUID = 1L;
       
   
    public Sign_up_company_insert() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Getting parameter from form:-------------------------------------------------------------------------------------------------
		String company_name = "";
		if(request.getParameter("company_name")!=null) {
			company_name =  request.getParameter("company_name");
		}
		
		String company_email = "";
		if(request.getParameter("company_email")!=null) {
			company_email =  request.getParameter("company_email");
		}
	
		String company_telephone = "";
		if(request.getParameter("company_telephone")!=null) {
			company_telephone =  request.getParameter("company_telephone");
		}
		
		String company_address = "";
		if(request.getParameter("address")!=null) {
			company_address =  request.getParameter("address");
		}	
	
		String company_password = "";
		if(request.getParameter("company_password")!=null) {
			company_password =  request.getParameter("company_password");
		}
		
		String company_password_repeat = "";
		if(request.getParameter("company_password_repeat")!=null) {
			company_password_repeat =  request.getParameter("company_password_repeat");
		}
	
		int country_id = 0;
		if(request.getParameter("country")!=null) {
			country_id = Integer.parseInt(request.getParameter("country")) ;
		}
		
		String city_name = "";
		if(request.getParameter("city_name")!=null) {
			city_name =  request.getParameter("city_name");
		}
		
		
		
		
		
		//THIS IS CONDTION FOR PASSWORD and PASSOWORD_REPEAT VALIDATION---------------------------------------------------------------------------------------------
		if(!company_password.equals(company_password_repeat)) {
			String password_error = "Your password doesn't match.";
			request.setAttribute("attr_password_error", password_error);
			request.getRequestDispatcher("Company_sign_up_loader").forward(request, response);
		}
		else {
			// Creating a connection with database-------------------------------------------------------------------------------------------------
				DB_helper_company db = new DB_helper_company();
				Connection db_connection = db.connect_db();

			
				// Inserting Company_user parameters in respective Class objects.-----------------------------------------------------------------------------		
				Company company_object = new Company(0, company_name, company_telephone, company_email, company_password, 0); 
				Address address_object = new Address(0, company_address, 0);
				City city_address_object = new City(0, city_name, country_id);
				Country country_object = new Country(country_id, "");
				
				//Wrapping every objects of class Company, Address, City and Country inside the object of Company_wrapper.
				Company_wrapper company_wrapper_object = new Company_wrapper(company_object, address_object, city_address_object, country_object);
			
				//inserting company:
				boolean is_company_inserted = db.insert_company_information(db_connection, company_wrapper_object);
				
				
				try{
						//if result return true then first condition ,if false then second condition	
						if(is_company_inserted==true) {
							String company_signed_up ="Congratulations You Are Signed Up.";
							request.setAttribute("attr_company_signed_up", company_signed_up);
							request.getRequestDispatcher(INDEX_JSP).forward(request, response);
							
							System.out.println("company information is inserted this is servlet");
						}
						else {
							String company_not_signed_up ="Sorry Something Went Wrong.";
							request.setAttribute("attr_company_not_signed_up", company_not_signed_up);
							request.getRequestDispatcher(INDEX_JSP).forward(request, response);
							System.out.println("company information not inserted servlet");
						}
				}finally {	
						// Disconnecting database-------------------------------------------------------------------------------------------------			
						db.disconnect(db_connection);
						//request.getRequestDispatcher(INDEX_JSP).forward(request, response);
				}	
			
			
		}//ends else condition.
		
		
		
		
		
		
		
	
	}//ends doGet

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
