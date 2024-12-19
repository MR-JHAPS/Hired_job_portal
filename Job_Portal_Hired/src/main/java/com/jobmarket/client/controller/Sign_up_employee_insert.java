package com.jobmarket.client.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

public class Sign_up_employee_insert extends HttpServlet implements File_name {
	private static final long serialVersionUID = 1L;
       
   
    public Sign_up_employee_insert() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//phase 1 : Getting parameters from employee_sign_up form:-------------------------------------------------------------------------------------------------
		
				String employee_first_name = "";
				if(request.getParameter("first_name")!=null) {
					employee_first_name =  request.getParameter("first_name");
				}
		
				String employee_last_name = "";
				if(request.getParameter("last_name")!=null) {
					employee_last_name =  request.getParameter("last_name");
				}
				
				String employee_telephone = "";
				if(request.getParameter("telephone")!=null) {
					employee_telephone =  request.getParameter("telephone");
				}
				
				String employee_email = "";
				if(request.getParameter("email")!=null) {
					employee_email =  request.getParameter("email");
				}
			
				int employee_country_id = 0;
				if(request.getParameter("country")!=null) {
					employee_country_id = Integer.parseInt(request.getParameter("country"));
				}
				
				String employee_city = "";
				if(request.getParameter("city")!=null) {
					employee_city =  request.getParameter("city");
				}
				
				String employee_address = "";
				if(request.getParameter("address")!=null) {
					employee_address =  request.getParameter("address");
				}
				
				String employee_password = "";
				if(request.getParameter("password")!=null) {
					employee_password =  request.getParameter("password");
				}
				
				String employee_password_repeat = "";
				if(request.getParameter("password_repeat")!=null) {
					employee_password_repeat =  request.getParameter("password_repeat");
				}
				
				String employee_date_of_birth = "";
				if(request.getParameter("date_of_birth")!=null) {
					employee_date_of_birth =  request.getParameter("date_of_birth");
				}

				
				
				
				
			//THIS IS CONDTION FOR PASSWORD and PASSOWORD_REPEAT VALIDATION------------------------------------------------------------------------
			if(!employee_password.equals(employee_password_repeat)) {
				String password_error = "Your Password doesn't match with repeat password";
				request.setAttribute("attr_password_error", password_error);
				request.getRequestDispatcher("Employee_sign_up_loader").forward(request, response);
			}
			else {
					// Creating a connection with database---------------------------------------------------------------------------------------				
					DB_helper_employee db = new DB_helper_employee();
					Connection db_connection = db.connect_db();					
				
					//Inserting Employee_user parameters in respective Class object:-------------------------------------------------------------
					Employee employee_object = new Employee(0, employee_first_name, employee_last_name, employee_email,
													employee_telephone, employee_password, employee_date_of_birth, 0);
					Address address_object = new Address(0, employee_address, 0);
					City city_address_object = new City(0, employee_city, employee_country_id);
					Country country_object = new Country(employee_country_id, "");
					
					//Wrapping every objects of class Employee, Address, City and Country inside the object of Employee_wrapper.	
					Employee_wrapper employee_wrapper_object = new Employee_wrapper(employee_object, address_object, 
																					city_address_object, country_object);
					boolean is_employee_inserted = db.insert_employee_information(db_connection, employee_wrapper_object);
					
					try {	
							//if result return true then first condition ,if false then second condition	
							if(is_employee_inserted==true) {
								String employee_signed_up_message ="Congratulations You Are Signed Up.";
								request.setAttribute("attr_employee_signed_up_message", employee_signed_up_message);
								request.getRequestDispatcher(INDEX_JSP).forward(request, response);
							}
							else {
								String employee_not_signed_up_message ="Sorry Something Went Wrong.";
								request.setAttribute("attr_employee_not_signed_up_message", employee_not_signed_up_message);
								request.getRequestDispatcher(INDEX_JSP).forward(request, response);
							}
					}finally {
						//Disconnecting database-------------------------------------------------------------------------------------------------
						db.disconnect(db_connection);
					}//ends finally

			}//ends else condition
			
	
	
	}//ends doGet

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
