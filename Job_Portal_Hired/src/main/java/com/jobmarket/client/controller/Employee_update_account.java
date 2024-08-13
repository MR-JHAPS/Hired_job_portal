package com.jobmarket.client.controller;

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
import com.jobmarket.client.model.DB_helper_employee;
import com.jobmarket.client.model.Employee;


public class Employee_update_account extends HttpServlet implements File_name{
	private static final long serialVersionUID = 1L;

    public Employee_update_account() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			HttpSession session = request.getSession(false);
			
			Integer employee_id = (Integer) session.getAttribute("attr_employee_id");
			String employee_name = request.getParameter("e_name");
			String employee_email =  request.getParameter("e_email");
			String employee_password =  request.getParameter("e_password");
			String employee_country =  request.getParameter("e_country");
			String employee_city =  request.getParameter("e_city");
			String employee_telephone_1 =  request.getParameter("e_telephone_1");
			String employee_telephone_2 =  request.getParameter("e_telephone_2");
			
//			String employee_name = (String) session.getAttribute("attr_employee_name");
//			String employee_email = (String) session.getAttribute("attr_employee_email");
//			String employee_password = (String) session.getAttribute("attr_employee_password");
//			String employee_country = (String) session.getAttribute("attr_employee_country");
//			String employee_city = (String) session.getAttribute("attr_employee_city");
//			String employee_telephone_1 = (String) session.getAttribute("attr_employee_telephone_1");
//			String employee_telephone_2 = (String) session.getAttribute("attr_employee_telephone_2");
	
			//connecting to DB:
			DB_helper_employee db = new DB_helper_employee();
			Connection db_connection = db.connect_db();
			
			//Updating the DB---Employee Account Information.
			Boolean is_updated = db.update_employee_information(db_connection, employee_name, employee_email, employee_password, employee_country,
																employee_city, employee_id, employee_telephone_1, employee_telephone_2);
			
			//this new list is to obtain the newly updated employee information to assign the new email/password in active session.
			List<Employee> user_list = db.get_employee_by_id(db_connection, employee_id);
			
			//Disconnecting the db:
			db.disconnect(db_connection);
	
	
			if(is_updated == true) {
				System.out.println("before for loop.");
				for(Employee element : user_list) {
					session.setAttribute("attr_employee_email", element.getEmail());
					session.setAttribute("attr_employee_password", element.getPassword());
					System.out.println("inside for loop");
				
				String employee_update_success = "Done! Your account is updated Successfully";
				request.setAttribute("attr_employee_update_success", employee_update_success);
				request.getRequestDispatcher(EMPLOYEE_HOMEPAGE).forward(request, response);
				
				}//ends for loop
			}//ends if
			System.out.println("after for loop");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
