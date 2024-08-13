package com.jobmarket.company.controller;

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
import com.jobmarket.company.model.Company;
import com.jobmarket.company.model.Company_wrapper;
import com.jobmarket.company.model.DB_helper_company;
import com.jobmarket.hired.model.Address;
import com.jobmarket.hired.model.City;
import com.jobmarket.hired.model.Country;


public class Sign_in_company_verification extends HttpServlet implements File_name {
	private static final long serialVersionUID = 1L;
  
    public Sign_in_company_verification() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
// Getting Parameters from : company_sign_in.jsp form.
		String company_email = "";
		if (request.getParameter("email") != null) {
			company_email = request.getParameter("email");
		}

		String company_password = "";
		if (request.getParameter("password") != null) {
			company_password = request.getParameter("password");
		}
		
		
		DB_helper_company db = new DB_helper_company();
		Connection db_connection = null;
		
			try {
					//Connection to Database:		
					db_connection = db.connect_db();
					
					//Getting list of company with given email and password:
					List<Company_wrapper> company_list = db.get_company_email_password(db_connection , company_email , company_password );
			
					boolean is_signed_in = false;		
					
					for(Company_wrapper element : company_list ) {
							//If the credentials are correct.
							if(company_email.equals(element.getCompany().getEmail()) && company_password.equals(element.getCompany().getPassword())){
								
								is_signed_in = true;
								//creating user Session. Also,to allow the company details in Account of navigation bar:		
								HttpSession session = request.getSession(true);
								session.setAttribute("attr_company_id", element.getCompany().getId());
								session.setAttribute("attr_company_name", element.getCompany().getName());
								session.setAttribute("attr_company_email", element.getCompany().getEmail());
								session.setAttribute("attr_company_password", element.getCompany().getPassword());
								session.setAttribute("attr_company_telephone", element.getCompany().getTelephone());
								session.setAttribute("attr_company_address",element.getAddress().getAddress_name());
								session.setAttribute("attr_company_city", element.getCity().getCity_name());
								session.setAttribute("attr_company_country", element.getCountry().getId());
								
								session.setMaxInactiveInterval(1800);
								request.getRequestDispatcher("Display_company_posted_job").forward(request, response);
								System.out.println("Company session started");
							}//ends if
					}//ends for loop.
					
						
					//If the credentials are incorrect/does not match.
					if(is_signed_in == false) {
						String wrong_login_password = "The password/Email you provided does not match any user.";
						request.setAttribute("attr_wrong_password", wrong_login_password);
						request.getRequestDispatcher(COMPANY_SIGN_IN_JSP).forward(request, response);
						System.out.println(wrong_login_password);
					}
					
			}finally {
					//Disconnecting the Database:
					if(db_connection!=null) {
					db.disconnect(db_connection);	
					}
			}//ends finally.
			
		

		
		
	}//ends doGet


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
