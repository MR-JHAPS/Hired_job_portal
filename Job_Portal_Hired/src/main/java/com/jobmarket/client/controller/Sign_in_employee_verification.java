package com.jobmarket.client.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.jobmarket.File_name;
import com.jobmarket.client.model.DB_helper_employee;
import com.jobmarket.client.model.Employee;
import com.jobmarket.client.model.Employee_wrapper;
import com.jobmarket.hired.model.Address;
import com.jobmarket.hired.model.City;
import com.jobmarket.hired.model.Country;

public class Sign_in_employee_verification extends HttpServlet implements File_name {
	private static final long serialVersionUID = 1L;

	public Sign_in_employee_verification() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
			// Getting Parameters from : employee_sign_in.jsp form.
			String employee_email = "";
			if (request.getParameter("email") != null) {
				employee_email = request.getParameter("email");
			}
	
			String employee_password = "";
			if (request.getParameter("password") != null) {
				employee_password = request.getParameter("password");
			}
	
	
			DB_helper_employee db = new DB_helper_employee();
			Connection db_connection = null;
			
			
			try{
				//Connection to Database:	
				 db_connection = db.connect_db();
		
				// Get employee information by email and password from Database.
				List<Employee_wrapper> employee_list = db.get_employee_email_password(db_connection, employee_email, employee_password);
			
				//creating boolean user_data to check if the email and password matches AND redirecting to respective pages as per TRUE or FALSE.
				boolean is_signed_in = false;
		
				for (Employee_wrapper element : employee_list) {	
						if (employee_email.equals(element.getEmployee().getEmail()) && employee_password.equals(element.getEmployee().getPassword())) {
								is_signed_in = true;
												
								//creating user Session.
								HttpSession session = request.getSession(true);
								session.setAttribute("attr_employee_id", element.getEmployee().getId());
								session.setAttribute("attr_employee_first_name", element.getEmployee().getFirst_name());
								session.setAttribute("attr_employee_last_name", element.getEmployee().getLast_name());
								session.setAttribute("attr_employee_email", element.getEmployee().getEmail());//because if the condition is true the employee_email == element.getEmail()
								session.setAttribute("attr_employee_password", element.getEmployee().getPassword());
								session.setAttribute("attr_employee_telephone", element.getEmployee().getTelephone());
								session.setAttribute("attr_employee_address", element.getAddress().getAddress_name());
								session.setAttribute("attr_employee_city", element.getCity().getCity_name());
								session.setAttribute("attr_employee_country", element.getCountry().getCountry_name());
								session.setAttribute("attr_employee_country_id", element.getCountry().getId());
								//maximum active time:
								session.setMaxInactiveInterval(1800);
					
								//request.getRequestDispatcher(EMPLOYEE_HOMEPAGE).forward(request, response);
								request.getRequestDispatcher(EMPLOYEE_HOMEPAGE).forward(request, response);
		
								System.out.println("Employee session Started");
						}//ends if
				}//ends for loop
			
				//if email or password is wrong then:		
				if (is_signed_in == false) {
					String wrong_login_password = "Invalid email/password";
					request.setAttribute("attr_wrong_login_password", wrong_login_password);
					request.getRequestDispatcher(INDEX_JSP).forward(request, response);
					System.out.println("wrong_login_password");
				}
				
			}finally {			
				// disconnecting DB:
				if(db_connection!=null) {
				db.disconnect(db_connection);
					}
			}//ends finally

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
