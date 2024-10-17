package com.jobmarket;

public interface DB_config {
	//DATABASE CONFIGURATION:
	String DB_DRIVER = "com.mysql.jdbc.Driver";
	String DB_NAME = "a_hired" ;
	String USERNAME = "root" ;
	String PASSWORD = "550463";
	String DB_SOURCE = "jdbc:mysql://localhost:3306/" + DB_NAME ;
	
	
//TABLE COLUMNS:---------------------------------------------------------------------------------------------------------------------------------
	
	//COLUMN NAME OF --"EMPLOYEE"-- TABLE: 
	String EMPLOYEE_ID = "employee_id";
	String EMPLOYEE_FIRST_NAME = "first_name";
	String EMPLOYEE_LAST_NAME = "last_name";
	String EMPLOYEE_EMAIL = "email";
	String EMPLOYEE_TELEPHONE = "telephone";
	String EMPLOYEE_PASSWORD = "employee_password";
	String EMPLOYEE_DATE_OF_BIRTH = "date_of_birth";
	String EMPLOYEE_FK_ADDRESS = "FK_address";

	
	//COLUMN NAME OF --"COMPANY"-- TABLE: 
		String COMPANY_ID = "company_id";
		String COMPANY_NAME = "company_name";
		String COMPANY_EMAIL = "email";
		String COMPANY_TELEPHONE = "telephone";
		String COMPANY_PASSWORD = "company_password";
		String COMPANY_FK_ADDRESS= "FK_address";

	
	//COLUMN NAME OF  --"ADDRESS"-- TABLE:
		String ADDRESS_ID = "address_id";
		String ADDRESS_NAME = "address";
		String ADDRESS_FK_CITY = "FK_city";
		
		
	//COLUMN NAME OF  --"CITY"-- TABLE:
		String CITY_ID = "city_id";
		String CITY_NAME = "city_name";
		String CITY_FK_COUNTRY = "FK_country";	
	
		
	//COLUMN NAME OF  --"COUNTRY"-- TABLE:
		String COUNTRY_ID = "country_id";
		String COUNTRY_NAME = "country_name";
				
	
	//COLUMN NAME OF --"JOB"-- TABLE:
		String JOB_ID = "job_id";
		String JOB_NAME ="job_name";
		String JOB_DESCRIPCION ="job_descripcion";
		String JOB_VACANCY ="vacancy";
		String JOB_FK_COMPANY = "FK_company";
		String JOB_FK_ADDRESS = "FK_address";
		String JOB_FK_CATEGORY = "FK_category";
		String JOB_FK_CONTRACT = "FK_contract";
		String JOB_FK_SALARY = "FK_salary";
		
	//COLUMN NAME OF --"JOB_CATEGORY"-- TABLE:	
		String JOB_CATEGORY_ID = "category_id";
		String JOB_CATEGORY_NAME = "category_name";
		
	//COLUMN NAME OF --"JOB_CONTRACT"-- TABLE:	
		String JOB_CONTRACT_ID = "contract_id";
		String JOB_CONTRACT_NAME = "contract_name";	
		
	//COLUMN NAME OF --"JOB_SALARY"-- TABLE:	
		String JOB_SALARY_ID = "salary_id";
		String JOB_SALARY_AMOUNT = "salary_amount";
		
	//COLUMN NAME OF "EMPLOYEE APPLIED JOB" TABLE:
		String APPLIED_JOB_ID = "applied_job_id";
		String APPLIED_JOB_COVER_LETTER = "cover_letter";
		String APPLIED_JOB_FK_COMPANY = "FK_company";
		String APPLIED_JOB_FK_EMPLOYEE = "FK_employee";
		String APPLIED_JOB_FK_CV = "FK_cv";
		String APPLIED_JOB_FK_JOB = "FK_job";
		
	//COLUMN NAME OF " EMPLOYEE CV TABLE" TABLE:	
		
		String CV_ID = "cv_id";
		String CV_NAME = "cv_name";
		String CV_FK_EMPLOYEE = "FK_employee";
		
		
		
		
		
		
		
		
		
		
		
		

	
//ALL Stored PROCEDURE:---------------------------------------------------------------------------------------------------------------------
	//EMPLOYEE: Stored Procedure:
	String SP_DISPLAY_EMPLOYEE_BY_EMAIL_PASSWORD = "call sp_display_employee_all_by_email_password(?,?)";
	String SP_DISPLAY_EMPLOYEE_BY_ID = "call sp_display_employee_all_by_id(?)";
	String SP_DISPLAY_ALL_EMPLOYEE = "call sp_display_all_employee()";
	String SP_INSERT_EMPLOYEE = "call sp_insert_employee(?,?,?,?,?,?,?)";
	String SP_DELETE_EMPLOYEE_BY_ID = "call sp_delete_employee_by_id(?)";
	String SP_UPDATE_EMPLOYEE_ACCOUNT= "call sp_update_employee(?,?,?,?,?,?,?)";

	
	//COMPANY: Stored Procedure:
	String SP_DISPLAY_COMPANY_BY_EMAIL_PASSWORD = "call sp_display_company_all_by_email_password (?,?)";
	String SP_DISPLAY_ALL_COMPANY ="call sp_display_all_company()";
	String SP_INSERT_COMPANY = "call sp_insert_company(?,?,?,?,?)";
	String SP_UPDATE_COMPANY_ACCOUNT = "call sp_update_company(?,?,?,?,?,?)";
	
	//COUNTRY: STORED PROCEDURE:
	String SP_DISPLAY_ALL_COUNTRY = "call sp_display_country()";
	String SP_DISPLAY_COUNTRY_BY_ID = "call sp_display_country_by_id(?)";
	
	//CITY: STORED PROCEDURE:
	String SP_INSERT_CITY = "call sp_insert_city(?,?,?)";
	String SP_DISPLAY_CITY = "call sp_display_city()";
	String SP_DISPLAY_CITY_BY_NAME = "call sp_display_city_by_name(?)";
	String SP_DISPLAY_CITY_BY_ID ="call sp_display_city_by_id(?)";
	String SP_UPDATE_CITY = "call sp_update_city(?,?,?)";
	
	//ADDRESS: SP:
	String SP_INSERT_ADDRESS = "call sp_insert_address(?,?,?)";
	String SP_DISPLAY_ADDRESS_BY_NAME = "call sp_display_address_by_name(?)";
	String SP_DISPLAY_ADDRESS_BY_ID = "call sp_display_address_by_id(?)";
	String SP_UPDATE_ADDRESS = "call sp_update_address(?,?,?)";
	
	
	//JOB_INFORMATION:
	String SP_DISPLAY_JOB_INFORMATION = "call sp_display_all_job()";
	String SP_DISPLAY_ALL_JOB_INFORMATION_BY_COMPANY_ID = "call sp_display_all_job_information_by_company_id(?)";
	String SP_DISPLAY_JOB_INFORMATION_BY_JOB_ID = "call sp_display_job_by_job_id(?)";
	String SP_INSERT_JOB_INFORMATION = "call sp_insert_job_information(?,?,?,?,?,?,?,?)";
	
	//JOB_category STORED PROCEDURE:
	String SP_DISPLAY_JOB_CATEGORY = "call sp_display_job_category()";
	String SP_DISPLAY_JOB_CATEGORY_BY_ID = "call sp_display_job_category_by_id(?)";
	
	//JOB_Contract STORED PROCEDURE:
	String SP_DISPLAY_JOB_CONTRACT = "call sp_display_job_contract()";
	String SP_DISPLAY_JOB_CONTRACT_BY_ID = "call sp_display_job_contract_by_id(?)";
	
	//JOB_salary STORED PROCEDURE:
	String SP_DISPLAY_JOB_SALARY = "call sp_display_job_salary()";
	String SP_DISPLAY_JOB_SALARY_BY_ID = "call sp_display_job_salary_by_id(?)";
	
	//SAVED JOB STORED PROCEDURE:
	String SP_INSERT_SAVED_JOB = "call sp_insert_saved_job(?,?)";
	String SP_DISPLAY_SAVED_JOB ="call sp_display_saved_job_by_employee_id(?)";

	//APPLIED JOB Stored Procedure:
	String SP_INSERT_APPLIED_JOB = "call sp_insert_applied_job(?,?,?,?,?)";
	
	// EMPLOYEE_CV Stored Procedure of:
	String SP_INSERT_EMPLOYEE_CV = "call sp_insert_employee_cv_name(?,?)";
	String SP_DISPLAY_CV_BY_EMPLOYEE_ID = "call display_cv_by_employee_id(?)";
	String SP_DISPLAY_CV_BY_CV_ID = "call sp_display_cv_by_cv_id(?)";
	
	//APPLIED JOB STORED PROCEDURE:
	String SP_DISPLAY_APPLIED_JOB_BY_COMPANY_ID = "call display_applied_job_by_company_id(?)";
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
