package com.jobmarket.client.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.jobmarket.DB_config;
import com.jobmarket.company.model.Company;
import com.jobmarket.company.model.Job;
import com.jobmarket.company.model.Job_wrapper;
import com.jobmarket.hired.model.Address;
import com.jobmarket.hired.model.City;
import com.jobmarket.hired.model.Country;
import com.jobmarket.hired.model.Job_category;
import com.jobmarket.hired.model.Job_contract;
import com.jobmarket.hired.model.Job_salary;

public class DB_helper_employee implements DB_config{
//Connecting to DB---------------------------------------------------------------------------------------------------------------------------------

	public Connection connect_db() {
		Connection db_connection = null;
		try {
			Class.forName(DB_DRIVER);//not necessary.
			db_connection = DriverManager.getConnection(DB_SOURCE, USERNAME, PASSWORD);
			
		} catch (Exception e) {
			System.out.println("Error while connecting to the database : " + e);
		}
		
		return db_connection;
}//ends connection method

//Disconnecting DB-------------------------------------------------------------------------------------------------------------------------------


	public void disconnect(Connection db_connection) {
			try {
				db_connection.close();
			} catch (Exception e) {
				System.out.println("Error while disconnecting the database : " + e);
			}
	}//ends disconnection method.

	


	
//GETTING EMPLOYEE BY EMAIL_PASSWORD for SIGN IN VERIFICATION:	
	public List<Employee_wrapper> get_employee_email_password(Connection db_connection, String employee_email, String employee_password) {
		
		List<Employee_wrapper> employee_list = new ArrayList<Employee_wrapper>();
		try {
			String sql_query = SP_DISPLAY_EMPLOYEE_BY_EMAIL_PASSWORD;
			CallableStatement prepare = db_connection.prepareCall(sql_query);
			prepare.setString("sp_employee_email", employee_email);
			prepare.setString("sp_employee_password", employee_password);
			prepare.execute();
			ResultSet rs = prepare.getResultSet();
			while(rs.next()) {
				
				Employee employee_row = new Employee();
					employee_row.setId(rs.getInt(EMPLOYEE_ID));
					employee_row.setFirst_name(rs.getString("first_name"));
					employee_row.setLast_name(rs.getString("last_name"));
					employee_row.setTelephone(rs.getString("telephone"));
					employee_row.setEmail(rs.getString("email"));
					employee_row.setPassword(rs.getString("employee_password"));
					employee_row.setDate_of_birth(rs.getString("date_of_birth"));
					employee_row.setFk_address(rs.getInt("FK_address"));
					
				Address	address_row = new Address();
					//address_row.setAddress_id(rs.getInt("address_id"));
					address_row.setAddress_name(rs.getString("address"));
					address_row.setFk_city(rs.getInt("FK_city"));
					
					
				City city_row = new City();
					//city_row.setCity_id(rs.getInt("city_id"));
					city_row.setCity_name(rs.getString("city_name"));
					city_row.setFk_country(rs.getInt("FK_country"));
				
				Country country_row = new Country();
					country_row.setId(rs.getInt("FK_country"));
					country_row.setCountry_name(rs.getString("country_name"));
					Employee_wrapper employee_wrapper_row = new Employee_wrapper(employee_row, address_row, city_row, country_row);
					//OR 
											
						//				Employee_wrapper employee_wrapper_row = new Employee_wrapper();
						//				employee_wrapper_row.getEmployee().setId(rs.getInt(EMPLOYEE_ID));
						//				employee_wrapper_row.getEmployee().setFirst_name(rs.getString(EMPLOYEE_FIRST_NAME));
						//				employee_wrapper_row.getEmployee().setLast_name(rs.getString(EMPLOYEE_LAST_NAME));
						//				employee_wrapper_row.getEmployee().setEmail(rs.getString(EMPLOYEE_EMAIL));
						//				employee_wrapper_row.getEmployee().setTelephone(rs.getString(EMPLOYEE_TELEPHONE));
						//				employee_wrapper_row.getEmployee().setPassword(rs.getString(EMPLOYEE_PASSWORD));
						//				employee_wrapper_row.getEmployee().setDate_of_birth(rs.getString(EMPLOYEE_DATE_OF_BIRTH));
						//				employee_wrapper_row.getEmployee().setFk_address(rs.getInt(EMPLOYEE_FK_ADDRESS));
						//				
						//				employee_wrapper_row.getAddress().setAddress_name(rs.getString(ADDRESS_NAME));
						//				employee_wrapper_row.getAddress().setFk_city(rs.getInt(ADDRESS_FK_CITY));
						//				
						//				employee_wrapper_row.getCity().setCity_name(rs.getString(CITY_NAME));
						//				employee_wrapper_row.getCity().setFk_country(rs.getInt(CITY_FK_COUNTRY));
						//				
						//				employee_wrapper_row.getCountry().setCountry_name(rs.getString(COUNTRY_NAME));
		
				employee_list.add(employee_wrapper_row);
			}
			System.out.println("Employee Sign in verification user_list displayed Successfully");
			return employee_list;
			
		}catch (SQLException e) {
				for(StackTraceElement element: e.getStackTrace()) {
					System.out.println("SQL Error getting the Employee sign in verification from db: " + element);
				}
		}//ends catch
		catch (Exception e) {
			for(StackTraceElement element: e.getStackTrace()) {
				System.out.println("Other Error getting the Employee sign in verification from db: " + element);
			}
	}//ends catch
		
		return new ArrayList<Employee_wrapper>();
	}//ends method

	public boolean insert_employee_information(Connection db_connection, Employee_wrapper employee_wrapper_object) {
		
		try {
			String sql_query_city = SP_INSERT_CITY;
			CallableStatement prepare_city = db_connection.prepareCall(sql_query_city);
				prepare_city.setString("sp_city_name", employee_wrapper_object.getCity().getCity_name());
				prepare_city.setInt("sp_FK_country", employee_wrapper_object.getCountry().getId());
				prepare_city.registerOutParameter("sp_city_id", Types.INTEGER);
				prepare_city.execute();
			int city_id = prepare_city.getInt("sp_city_id");
			
			String sql_query_address = SP_INSERT_ADDRESS;
			CallableStatement prepare_address = db_connection.prepareCall(sql_query_address);
				prepare_address.setString("sp_address", employee_wrapper_object.getAddress().getAddress_name());
				prepare_address.setInt("sp_city_id", city_id);
				prepare_address.registerOutParameter("sp_address_id", Types.INTEGER);
				prepare_address.execute();
			int address_id = prepare_address.getInt("sp_address_id");
			
			String sql_query_employee= SP_INSERT_EMPLOYEE;
			CallableStatement prepare_employee = db_connection.prepareCall(sql_query_employee);
				prepare_employee.setString("sp_first_name", employee_wrapper_object.getEmployee().getFirst_name());
				prepare_employee.setString("sp_last_name", employee_wrapper_object.getEmployee().getLast_name());
				prepare_employee.setString("sp_email", employee_wrapper_object.getEmployee().getEmail());
				prepare_employee.setString("sp_telephone", employee_wrapper_object.getEmployee().getTelephone());
				prepare_employee.setString("sp_password", employee_wrapper_object.getEmployee().getPassword());
				prepare_employee.setString("sp_date_of_birth", employee_wrapper_object.getEmployee().getDate_of_birth());
				prepare_employee.setInt("sp_address_id", address_id);
				prepare_employee.execute();
			System.out.println("Employee information inserted successfully");
			return true;
		}catch(SQLIntegrityConstraintViolationException e) {
				for(StackTraceElement element:e.getStackTrace()) {
					System.out.println("SQL Integrity Constraints violation : " + element);
				}
		}catch(SQLException e) {
				for(StackTraceElement element : e.getStackTrace()) {
					System.out.println("SQL error inserting employee_information : " + element);
				}//ends for
		}catch(Exception e){
			for(StackTraceElement element : e.getStackTrace()) {
				System.out.println("Other error inserting employee_information : " + element);
			}//ends for
		}
		
		return false;
	}

	public List<Job_wrapper> get_all_job_information(Connection db_connection) {
		List<Job_wrapper> job_list = new ArrayList<Job_wrapper>();
		try {
			String sql_query = SP_DISPLAY_JOB_INFORMATION;
			CallableStatement prepare = db_connection.prepareCall(sql_query);
			prepare.execute();
			ResultSet rs = prepare.getResultSet();
			while(rs.next()) {
				Job job_row = new Job();
	            job_row.setJob_id(rs.getInt("job_id"));
	            job_row.setJob_name(rs.getString("job_name"));
	            job_row.setJob_descripcion(rs.getString("job_descripcion"));
	            job_row.setJob_vacancy(rs.getString("vacancy"));
	            job_row.setFk_address(rs.getInt("FK_address"));
	            job_row.setFk_company(rs.getInt("FK_company"));
	            job_row.setFk_category(rs.getInt("FK_category"));
	            job_row.setFk_contract(rs.getInt("FK_contract"));
	            job_row.setFk_salary(rs.getInt("FK_salary"));
				
				 Company company_row = new Company();
		         company_row.setId(rs.getInt("FK_company"));
		         company_row.setName(rs.getString("company_name"));
		           
		         Job_category category_row = new Job_category();
		         	category_row.setCategory_name(rs.getString("job_category_name"));
		         	
	         	 Job_salary salary_row = new Job_salary();
	         	 	salary_row.setSalary_amount(rs.getString("job_salary_amount"));  	
		         	
		         Job_contract contract_row = new Job_contract();
		         	contract_row.setContract_name(rs.getString("job_contract_name"));
		         	
		         Address address_row= new Address();
	         		address_row.setAddress_name(rs.getString("address"));		         
	         		
	     		 City city_row= new City();
	         		city_row.setCity_name(rs.getString("city_name"));	
	         		
	         	 Country country_row= new Country();
	         	 	country_row.setCountry_name(rs.getString("country_name"));  
         		
         		// Job_wrapper object includes all the attributes of Job object.
            Job_wrapper job_wrapper = new Job_wrapper(job_row, category_row, salary_row, contract_row, 
            											company_row, address_row, city_row, country_row);
				
				job_list.add(job_wrapper);	
			}
			System.out.println("Job List for employee homepage displayed successfully.");
			return job_list;
			
		}catch(SQLException e) {
			for(StackTraceElement element : e.getStackTrace()) {
				System.out.println("SQL error getting all job information in employee homepage : " + element);
			}
		}catch(Exception e) {
				for(StackTraceElement element : e.getStackTrace()) {
					System.out.println("Other error getting all job information in employee homepage : " + element);
				}
		}
		
		return new ArrayList<Job_wrapper>();
	}

	public List<Job_wrapper> get_job_information_by_id(Connection db_connection, int job_id) {
		List<Job_wrapper> job_list = new ArrayList<Job_wrapper>();
		try {
			String sql_query = SP_DISPLAY_JOB_INFORMATION_BY_JOB_ID;
			CallableStatement prepare = db_connection.prepareCall(sql_query);
			prepare.setInt("sp_job_id", job_id);
			prepare.execute();
			ResultSet rs = prepare.getResultSet();
			while(rs.next()) {
						Job job_row = new Job();
			            job_row.setJob_id(rs.getInt("job_id"));
			            job_row.setJob_name(rs.getString("job_name"));
			            job_row.setJob_descripcion(rs.getString("job_descripcion"));
			            job_row.setJob_vacancy(rs.getString("vacancy"));
			            job_row.setFk_address(rs.getInt("FK_address"));
			            job_row.setFk_company(rs.getInt("FK_company"));
			            job_row.setFk_category(rs.getInt("FK_category"));
			            job_row.setFk_contract(rs.getInt("FK_contract"));
			            job_row.setFk_salary(rs.getInt("FK_salary"));
						
						 Company company_row = new Company();
				         company_row.setId(rs.getInt("FK_company"));
				         company_row.setName(rs.getString("company_name"));
				           
				         Job_category category_row = new Job_category();
				         	category_row.setCategory_name(rs.getString("job_category_name"));
				         	
			         	 Job_salary salary_row = new Job_salary();
			         	 	salary_row.setSalary_amount(rs.getString("job_salary_amount"));  	
				         	
				         Job_contract contract_row = new Job_contract();
				         	contract_row.setContract_name(rs.getString("job_contract_name"));
				         	
				         Address address_row= new Address();
			         		address_row.setAddress_name(rs.getString("address"));		         
			         		
			     		 City city_row= new City();
			         		city_row.setCity_name(rs.getString("city_name"));	
			         		
			         	 Country country_row= new Country();
			         	 	country_row.setCountry_name(rs.getString("country_name"));  
		         		
			         	 	// Job_wrapper object includes all the attributes of other Class object.
			         	 	Job_wrapper job_wrapper = new Job_wrapper(job_row, category_row, salary_row, contract_row, 
            											company_row, address_row, city_row, country_row);
				
			         	 job_list.add(job_wrapper);		
			}//ends while
			System.out.println("Job List for employee homepage displayed successfully.");
			return job_list;
			
		}catch(SQLException e) {
			for(StackTraceElement element : e.getStackTrace()) {
				System.out.println("SQL error getting all job information in employee homepage : " + element);
			}
		}catch(Exception e) {
				for(StackTraceElement element : e.getStackTrace()) {
					System.out.println("Other error getting all job information in employee homepage : " + element);
				}
		}
		
		return new ArrayList<Job_wrapper>();
	}

	
	
	//THIS IS TO SHOW THE COUNTRY LIST IN EMPLOYEE ACCOUNT UPDATE TO CHANGE THE COUNTRY LATER IF NEEDED:
	public List<Country> display_all_country(Connection db_connection) {
		
		List<Country> country_list = new ArrayList<Country>();
		try {
			String sql_query= SP_DISPLAY_ALL_COUNTRY;
			CallableStatement prepare = db_connection.prepareCall(sql_query);
			prepare.execute();
			ResultSet rs = prepare.getResultSet();
			while(rs.next()) {
				Country country_row = new Country();
				country_row.setId(rs.getInt("country_id"));
				country_row.setCountry_name(rs.getString("country_name"));
				country_list.add(country_row);
			}
			System.out.println("Country displayed successfully.");
			return country_list;
			
		} catch (Exception e) {
		System.out.println("Error while displaying the country list : " + e);
		
		}
		
		return new ArrayList<Country>();
	}

	public boolean insert_saved_job(Connection db_connection, int employee_id, int job_id) {
	
		try {
			String sql_query = SP_INSERT_SAVED_JOB;
			CallableStatement prepare = db_connection.prepareCall(sql_query);
			prepare.setInt("sp_FK_employee", employee_id);
			prepare.setInt("sp_FK_job", job_id );
			prepare.execute();
			System.out.println("Saved jobs inserted Successfully.");
			
		}catch(SQLException e) {
			for(StackTraceElement element : e.getStackTrace()) {
				System.out.println("SQL error inserting the saved jobs : " + element);
			}
		}catch(Exception e) {
			for(StackTraceElement element : e.getStackTrace()) {
				System.out.println("Other error inserting the saved jobs : " + element);
			}
		}//ends catch
		
		
		
		return false;
	}

	public List<Job_wrapper> get_saved_job_information(Connection db_connection, int employee_id) {
		List<Job_wrapper> job_list = new ArrayList<Job_wrapper>();
		try {
			String sql_query = SP_DISPLAY_SAVED_JOB;
			CallableStatement prepare = db_connection.prepareCall(sql_query);
			prepare.setInt("sp_employee_id", employee_id);
			prepare.execute();
			ResultSet rs = prepare.getResultSet();
			while(rs.next()) {
						Job job_row = new Job();
			            job_row.setJob_id(rs.getInt("job_id"));
			            job_row.setJob_name(rs.getString("job_name"));
			            job_row.setJob_descripcion(rs.getString("job_descripcion"));
			            job_row.setJob_vacancy(rs.getString("vacancy"));
			            job_row.setFk_address(rs.getInt("FK_address"));
			            job_row.setFk_company(rs.getInt("FK_company"));
			            job_row.setFk_category(rs.getInt("FK_category"));
			            job_row.setFk_contract(rs.getInt("FK_contract"));
			            job_row.setFk_salary(rs.getInt("FK_salary"));
						
						 Company company_row = new Company();
				         company_row.setId(rs.getInt("FK_company"));
				         company_row.setName(rs.getString("company_name"));
				           
				         Job_category category_row = new Job_category();
				         	category_row.setCategory_name(rs.getString("job_category_name"));
				         	
			         	 Job_salary salary_row = new Job_salary();
			         	 	salary_row.setSalary_amount(rs.getString("job_salary_amount"));  	
				         	
				         Job_contract contract_row = new Job_contract();
				         	contract_row.setContract_name(rs.getString("job_contract_name"));
				         	
				         Address address_row= new Address();
			         		address_row.setAddress_name(rs.getString("address"));		         
			         		
			     		 City city_row= new City();
			         		city_row.setCity_name(rs.getString("city_name"));	
			         		
			         	 Country country_row= new Country();
			         	 	country_row.setCountry_name(rs.getString("country_name"));  
		         		
			         	 	// Job_wrapper object includes all the attributes of other Class object.
			         	 	Job_wrapper job_wrapper = new Job_wrapper(job_row, category_row, salary_row, contract_row, 
            											company_row, address_row, city_row, country_row);
				
			         	 job_list.add(job_wrapper);		
			}//ends while
			System.out.println("Job List for employee homepage displayed successfully.");
			return job_list;
			
		}catch(SQLException e) {
			for(StackTraceElement element : e.getStackTrace()) {
				System.out.println("SQL error getting all job information in employee homepage : " + element);
			}
		}catch(Exception e) {
				for(StackTraceElement element : e.getStackTrace()) {
					System.out.println("Other error getting all job information in employee homepage : " + element);
				}
		}
		
		return new ArrayList<Job_wrapper>();
	}

	
	
	
	
	public boolean insert_cv_name(Connection db_connection, String file_name, int user_id) {

		try {
			String sql_query = SP_INSERT_EMPLOYEE_CV;
			CallableStatement prepare = db_connection.prepareCall(sql_query);
			prepare.setInt("sp_employee_id", user_id);
			prepare.setString("sp_cv_name", file_name);
			prepare.execute();
			
			System.out.println("CV name inserted successfully in the Database");
			return true;
			
		}catch(SQLException e) {
			System.err.println("SQL error inserting the CV name:");
	        System.err.println("Message: " + e.getMessage());
	        System.err.println("SQL State: " + e.getSQLState());
	        System.err.println("Error Code: " + e.getErrorCode());
	        e.printStackTrace(); // Or use a logging framework like Log4j
			
		}catch(Exception e) {
			for(StackTraceElement element : e.getStackTrace()) {
				System.out.println("Other error inserting the CV name : " + element);
			}//end for
		}
		
		return false;
	}//ends method.
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
}//ends class