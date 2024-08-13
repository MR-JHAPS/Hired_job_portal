package com.jobmarket;

public interface Config_employee_db {

		//hired_employee_database.
		String DB_DRIVER = "com.mysql.jdbc.Driver";
		String DB_NAME = "a_hired" ;
		String USERNAME = "root" ;
		String PASSWORD = "550463";
		String DB_SOURCE = "jdbc:mysql://localhost:3306/" + DB_NAME ;
		
		
		
		
		//inserting country:
		
		String SP_INSERT_CITY = "call sp_insert_city(?,?)";
		String SP_DISPLAY_CITY = "call sp_display_city()";
		String SP_DISPLAY_CITY_BY_NAME = "call sp_display_city_by_name(?)";
		String SP_INSERT_EMPLOYEE = "call sp_insert_employee(?,?,?,?,?,?,?)";
		
		
		
		
		
		
		
		
		
		
		
		
		
		//COLUMN NAME OF --"employee_INFORMATION"-- TABLE: 
		String EMPLOYEE_ID = "employee_id";
		String EMPLOYEE_NAME = "employee_name";
		String EMPLOYEE_EMAIL = "employee_email";
		String EMPLOYEE_TELEPHONE_1 = "employee_telephone_1";
		String EMPLOYEE_TELEPHONE_2 = "employee_telephone_2";
		String EMPLOYEE_PASSWORD = "employee_password";
		String EMPLOYEE_REPEAT_PASSWORD = "employee_repeat_password";
		String EMPLOYEE_COUNTRY = "employee_country";
		String EMPLOYEE_CITY = "employee_city";

		
		
		//STORED PROCEDURE OF EMPLOYEE IN DATABASE	
		String SP_INSERT_EMPLOYEE_INFORMATION = "call sp_insert_employee_information(?,?,?,?,?,?,?,?)";
		String SP_DISPLAY_EMPLOYEE_INFORMATION ="call sp_display_employee_information()";
		String SP_DISPLAY_EMPLOYEE_INFORMATION_BY_ID = "call sp_display_employee_information_by_id(?)";
		String SP_UPDATE_EMPLOYEE_INFORMATION_BY_ID = "call sp_update_employee_information_by_id(?,?,?,?,?,?,?,?)";
		String SP_DELETE_EMPLOYEE_INFORMATION_BY_ID = "call sp_delete_employee_information_by_id(?)";
		String SP_DISPLAY_EMPLOYEE_EMAIL_PASSWORD = "call sp_display_employee_information_by_email_password (?,?)";

		
		
//THIS TABLE IS INSIDE DB OF COMPANY:-------------------------------------------------------------------------------------------
		
		//COLUMN NAME OF --"JOB_INFORMATION"-- TABLE:
		String JOB_ID = "job_id";
		String JOB_NAME = "job_name";
		String JOB_CATEGORY = "job_category";
		String JOB_SALARY = "job_salary";
		String JOB_TIME = "job_time";
		String JOB_DESCRIPCION = "job_descripcion";
		String JOB_LOCATION = "job_location";
		String JOB_CONTRACT = "job_contract";
		String JOB_VACANCY= "job_vacancy";
		String JOB_COMPANY = "job_company";
		
		//JOB INFORMATION STORED PROCEDURE:
		String SP_INSERT_JOB_INFORMATION = "call sp_insert_job_information(?,?,?,?,?,?,?,?,?)";
		String SP_DISPLAY_JOB_INFORMATION = "call sp_display_job_information()";
		String SP_DISPLAY_JOB_INFORMATION_BY_COMPANY = "call sp_display_job_information_by_company(?)";
		String SP_DISPLAY_JOB_INFORMATION_BY_ID = "call sp_display_job_information_by_id(?)";

		
		
		
		
		
		
		
		
		
		
		
	}//ends interface.

	

