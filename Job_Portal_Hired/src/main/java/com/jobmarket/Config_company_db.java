package com.jobmarket;

public interface Config_company_db {
	//COMPANY DATABASE CONFIG:
	String DB_DRIVER = "com.mysql.jdbc.Driver";
	String DB_NAME = "hired_company_database" ;
	String USERNAME = "root" ;
	String PASSWORD = "550463";
	String DB_SOURCE = "jdbc:mysql://localhost:3306/" + DB_NAME ;
	
	
	//COLUMN NAME OF --"COMPANY_INFORMATION"-- TABLE: 
	String COMPANY_ID = "company_id";
	String COMPANY_NAME = "company_name";
	String COMPANY_EMAIL = "company_email";
	String COMPANY_TELEPHONE_1 = "company_telephone_1";
	String COMPANY_TELEPHONE_2 = "company_telephone_2";
	String COMPANY_PASSWORD = "company_password";
	String COMPANY_REPEAT_PASSWORD = "company_repeat_password";
	String COMPANY_COUNTRY = "company_country";
	String COMPANY_CITY = "company_city";

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

	//COMPANY INFORMATION STORED PROCEDURE:
	String SP_INSERT_COMPANY_INFORMATION = "call sp_insert_company_information(?,?,?,?,?,?,?,?)";
	String SP_DISPLAY_COMPANY_INFORMATION ="call sp_display_employee_information()";
	String SP_DISPLAY_COMPANY_INFORMATION_BY_ID = "call sp_display_employee_information_by_id(?)";
	String SP_UPDATE_COMPANY_INFORMATION_BY_ID = "call sp_update_employee_information_by_id(?)";
	String SP_DELETE_COMPANY_INFORMATION_BY_ID = "call sp_delete_employee_information_by_id(?)";
	String SP_DISPLAY_COMPANY_EMAIL_PASSWORD = "call sp_display_company_by_email_password (?,?)";
	
	//JOB INFORMATION STORED PROCEDURE:
	String SP_INSERT_JOB_INFORMATION = "call sp_insert_job_information(?,?,?,?,?,?,?,?,?)";
	String SP_DISPLAY_JOB_INFORMATION = "call sp_display_job_information()";
	String SP_DISPLAY_JOB_INFORMATION_BY_COMPANY = "call sp_display_job_information_by_company(?)";
	
	
	
	
}//ends interface.
