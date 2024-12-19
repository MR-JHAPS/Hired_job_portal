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
import com.jobmarket.company.model.DB_helper_company;
import com.jobmarket.company.model.Job;
import com.jobmarket.company.model.Job_wrapper;
import com.jobmarket.hired.model.Address;
import com.jobmarket.hired.model.City;
import com.jobmarket.hired.model.Country;
import com.jobmarket.hired.model.Job_category;
import com.jobmarket.hired.model.Job_contract;
import com.jobmarket.hired.model.Job_salary;


public class Job_posting extends HttpServlet implements File_name {
	private static final long serialVersionUID = 1L;
       
   
    public Job_posting() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//There is no "IF" Because the company name is preset in job posting page from the active session of login. It is never null.
		HttpSession session = request.getSession(false);
		int company_id = (Integer) session.getAttribute("attr_company_id");

		int country_id = Integer.parseInt(request.getParameter("country_id"));
		
		int job_category_id=0 ;
		if(request.getParameter("job_category")!=null) {
			job_category_id = Integer.parseInt(request.getParameter("job_category"));
		}
		
		String job_name="";
		if(request.getParameter("job_name")!=null) {
			job_name = request.getParameter("job_name");
		}
		
		String job_vacancy="";
		if(request.getParameter("job_vacancy")!=null) {
			job_vacancy = request.getParameter("job_vacancy");
		}
		
		String job_descripcion="";
		if(request.getParameter("job_descripcion")!=null) {
			job_descripcion = request.getParameter("job_descripcion");
		}
		
		String job_address="";
		if(request.getParameter("job_address")!=null) {
			job_address = request.getParameter("job_address");
		}
		
		int job_contract_id=0 ;
		if(request.getParameter("job_contract")!=null) {
			job_contract_id = Integer.parseInt(request.getParameter("job_contract"));
		}
		
		String job_city = "";
		if(request.getParameter("job_city")!=null) {
			job_city = request.getParameter("job_city");
		}
		
		int job_salary_id=0 ;
		if(request.getParameter("job_salary")!=null) {
			job_salary_id = Integer.parseInt(request.getParameter("job_salary"));
		}
		
		
		
		
		Job job_object = new Job(0, job_name, job_descripcion, job_vacancy, company_id, 0, job_contract_id, job_salary_id, job_category_id);
		Address address_object = new Address(0, job_address, 0);
		City city_object = new City(0, job_city, country_id);
		Country country_object = new Country(country_id, "");
		
		
		Connection db_connection = null;
		DB_helper_company db = new DB_helper_company();
		boolean is_job_inserted = false;
		
		try {
			//Connecting db:
			db_connection = db.connect_db();
			
			Job_wrapper job_wrapper_object = new Job_wrapper(job_object, null, null, null, 
					null, address_object, city_object, country_object);

			//inserting:
			is_job_inserted = db.insert_job_information(db_connection, job_wrapper_object);
			
			System.out.println("job inserted : " + is_job_inserted);
		}catch (Exception e) {
			
		}finally {
			//Disconnecting the DB:
			if(db_connection!=null) {
				db.disconnect(db_connection);
			}
			response.sendRedirect("Display_company_posted_job?job_inserted=" + is_job_inserted);
		}
		
		
//		request.getRequestDispatcher("Display_company_posted_job").forward(request, response);

		
		
		
		
		
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
