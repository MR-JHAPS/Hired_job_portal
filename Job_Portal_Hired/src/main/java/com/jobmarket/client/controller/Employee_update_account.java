package com.jobmarket.client.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.util.List;

import com.jobmarket.File_name;
import com.jobmarket.Session_constants;
import com.jobmarket.client.model.DB_helper_employee;
import com.jobmarket.client.model.Employee;
import com.jobmarket.client.model.Employee_wrapper;
import com.jobmarket.company.model.Job_wrapper;
import com.jobmarket.hired.model.Address;
import com.jobmarket.hired.model.City;
import com.jobmarket.hired.model.Country;


public class Employee_update_account extends HttpServlet implements File_name, Session_constants{
	private static final long serialVersionUID = 1L;

    public Employee_update_account() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			HttpSession session = request.getSession(false);
			
			if(session==null || session.getAttribute(EMPLOYEE_SESSION_ID)==null) {
				response.sendRedirect(INDEX_JSP);
				return;
			}
			
			
			Integer employee_id = (Integer) session.getAttribute(EMPLOYEE_SESSION_ID);
			Integer employee_address_id = (Integer) session.getAttribute(EMPLOYEE_SESSION_ADDRESS_ID);
			Integer employee_city_id = (Integer) session.getAttribute(EMPLOYEE_SESSION_CITY_ID);
			System.out.println("employee_id :" + employee_id + "employee_address_id : "+ employee_address_id + "employee_city_id : " + employee_city_id);
			
			String employee_first_name = request.getParameter("e_first_name");
			String employee_last_name = request.getParameter("e_last_name");			
			String employee_email =  request.getParameter("e_email");
			String employee_telephone =  request.getParameter("e_telephone");			
			String employee_password =  request.getParameter("e_password");
			String employee_address =  request.getParameter("e_address");
			String employee_city =  request.getParameter("e_city");
			int  employee_country_id =  Integer.parseInt(request.getParameter("e_country"));
			
			
			System.out.println(employee_first_name + employee_last_name + employee_email + employee_telephone + employee_password + employee_address + employee_city + employee_country_id);
	
			DB_helper_employee db = new DB_helper_employee();
			Connection db_connection = null;
			boolean is_employee_account_updated = false;
			boolean is_employee_session_updated = false;
			
			try {
				//connecting to DB:
				db_connection = db.connect_db();
				
				Employee employee_object = new Employee(employee_id, employee_first_name, employee_last_name, employee_email, employee_telephone, employee_password,"",employee_address_id);
				Address address_object = new Address(employee_address_id, employee_address, employee_city_id);
				City city_object = new City(employee_city_id , employee_city, employee_country_id);
				Country country_object = new Country(employee_country_id, "");
				
				//SUMMING UP ALL THE OBJECTS IN EMPLOYEE WRAPPER:
				Employee_wrapper employee_wrapper_object = new Employee_wrapper(employee_object, address_object, city_object, country_object);

				
				
				//Updating the DB---Employee Account Information.	
				is_employee_account_updated = db.update_employee_information(db_connection, employee_wrapper_object);
				
				
				if(is_employee_account_updated==true) {
					//this new list is to obtain the newly updated employee information to assign the new email/password/datas in active session.
					List<Employee_wrapper> user_list = db.get_employee_by_id(db_connection, employee_id);
					
					for(Employee_wrapper element : user_list) {
						
						System.out.println(element);
						session.setAttribute(EMPLOYEE_SESSION_ID, element.getEmployee().getId());
						session.setAttribute(EMPLOYEE_SESSION_FIRST_NAME , element.getEmployee().getFirst_name());
						session.setAttribute(EMPLOYEE_SESSION_LAST_NAME, element.getEmployee().getLast_name());
						session.setAttribute(EMPLOYEE_SESSION_EMAIL , element.getEmployee().getEmail());//because if the condition is true the employee_email == element.getEmail()
						session.setAttribute(EMPLOYEE_SESSION_PASSWORD , element.getEmployee().getPassword());
						session.setAttribute(EMPLOYEE_SESSION_TELEPHONE , element.getEmployee().getTelephone());
						session.setAttribute(EMPLOYEE_SESSION_ADDRESS_ID , element.getAddress().getAddress_id());
						session.setAttribute(EMPLOYEE_SESSION_ADDRESS , element.getAddress().getAddress_name());
						session.setAttribute(EMPLOYEE_SESSION_CITY_ID , element.getCity().getCity_id());
						session.setAttribute(EMPLOYEE_SESSION_CITY , element.getCity().getCity_name());
						session.setAttribute(EMPLOYEE_SESSION_COUNTRY , element.getCountry().getCountry_name());
						session.setAttribute(EMPLOYEE_SESSION_COUNTRY_ID , element.getCountry().getId());
					}
						is_employee_session_updated = true;
					
				}//Ends if.
				
			}catch(Exception e) {
				e.printStackTrace();
			
				
				
				
			
			}finally {
				if(db_connection!= null) {
					//Disconnecting the db:
					db.disconnect(db_connection);
				}
				System.out.println("is_employee_session_updated : " + is_employee_session_updated + "is_employee_account_updated : " + is_employee_account_updated);
				
				if(is_employee_account_updated==true) {
					String message = "Your account is Updated Successfully";
					String encoded_message = URLEncoder.encode(message, StandardCharsets.UTF_8);
					response.sendRedirect(EMPLOYEE_HOMEPAGE+"?account_update_message="+encoded_message);
				}
				else {
					response.sendError(500, "Cannot update the Employee information and the Session information");
				}
				
			}//ends finally
			
			
			
	}//ends doGet.

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
