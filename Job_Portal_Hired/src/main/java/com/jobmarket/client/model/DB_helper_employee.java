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
import java.util.logging.Logger;


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
					//employee_row.setFk_address(rs.getInt("FK_address"));
					
				Address	address_row = new Address();
					address_row.setAddress_id(rs.getInt("address_id"));
					address_row.setAddress_name(rs.getString("address"));
					//address_row.setFk_city(rs.getInt("FK_city"));
					
					
				City city_row = new City();
					city_row.setCity_id(rs.getInt("city_id"));
					city_row.setCity_name(rs.getString("city_name"));
					//city_row.setFk_country(rs.getInt("FK_country"));
				
				Country country_row = new Country();
					country_row.setId(rs.getInt("country_id"));
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

//GETTING SAVED JOB INFORMATION:	
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

	
	
	
//INSERTING THE CV NAME IN THE DATABASE:	
	public boolean insert_cv_name(Connection db_connection, String file_name, String original_file_name, int user_id) {

		try {
			String sql_query = SP_INSERT_EMPLOYEE_CV;
			CallableStatement prepare = db_connection.prepareCall(sql_query);
			prepare.setInt("sp_employee_id", user_id);
			prepare.setString("sp_cv_name", file_name);
			prepare.setString("sp_cv_original_name", original_file_name);
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

	
	
//GETTING CV LIST BY EMPLOYEE ID:	
	public List<Cv_file> get_cv_list_by_id(Connection db_connection, int employee_id) {
		List<Cv_file> cv_list = new ArrayList<Cv_file>();
		try {
			String sql_query = SP_DISPLAY_CV_BY_EMPLOYEE_ID ;
			CallableStatement prepare = db_connection.prepareCall(sql_query);
			prepare.setInt(1, employee_id);
			prepare.execute();
			
			ResultSet rs = prepare.getResultSet();
			while(rs.next()) {
				Cv_file cv_file_row = new Cv_file();
				cv_file_row.setCv_id(rs.getInt("cv_id"));
				cv_file_row.setCv_name(rs.getString("cv_name"));
				cv_file_row.setCv_original_name(rs.getString("cv_original_name"));
				cv_file_row.setFk_employee(rs.getInt("FK_employee"));
				cv_list.add(cv_file_row);
			}
			System.out.println("Cv by Employee ID displayed successfully");
			return cv_list;
			
		}catch (SQLException e) {
			for(StackTraceElement element : e.getStackTrace()) {
				System.out.println("OTHER ERROR WHILE GETTING CV LIST BY ID: " + element);
			}
		}catch (Exception e) {
			for(StackTraceElement element : e.getStackTrace()) {
				System.out.println("OTHER ERROR WHILE GETTING CV LIST BY ID: " + element);
			}
		}
		
		return  new ArrayList<Cv_file>();
	}


	
//INSERTING THE APPLIED JOB OF EMPLOYEE:	
	public boolean insert_applied_job(Connection db_connection, int cv_id, String employee_cover_letter, int employee_id, int job_id, int company_id) {

		try {
			String sql_query = SP_INSERT_APPLIED_JOB;
			CallableStatement prepare = db_connection.prepareCall(sql_query);
			prepare.setString("sp_cover_letter", employee_cover_letter);
			prepare.setInt("sp_cv_id", cv_id);
			prepare.setInt("sp_employee_id", employee_id);
			prepare.setInt("sp_job_id", job_id);
			prepare.setInt("sp_company_id", company_id);
			prepare.execute();
			System.out.println("Applied Job inserted Successfully.");
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	
//DELETING EMPLOYEE ACCOUNT INFORMATION:	
	public boolean delete_employee_information(Connection db_connection, int employee_id) {

		try {
			String sql_query = SP_DELETE_EMPLOYEE_BY_ID;
			CallableStatement prepare = db_connection.prepareCall(sql_query);
			prepare.setInt("sp_employee_id",employee_id);
			prepare.execute();
			System.out.println("Employee account deleted successfully.");
			return true;
			
		}catch (Exception e) {
			e.getStackTrace();
		}
		
		return false;
	}

//----------------------------------------------GPT CODE---------------------------------------------------------------------------------
	
//	private static final java.util.logging.Logger logger = Logger.getLogger(DB_helper_employee.class.getName());
//
//    public boolean update_employee_information(Connection db_connection, Employee_wrapper employee_wrapper_object) {
////        CallableStatement prepare_city = null;
////        CallableStatement prepare_address = null;
//        CallableStatement prepare_employee = null;
//
//        try {
//            // Start transaction
//            db_connection.setAutoCommit(false);
//
////            // Step 1: Update City
////            String sql_query_city = SP_UPDATE_CITY;
////            prepare_city = db_connection.prepareCall(sql_query_city);
////            prepare_city.setInt("sp_city_id", employee_wrapper_object.getCity().getCity_id());
////            prepare_city.setString("sp_city_name", employee_wrapper_object.getCity().getCity_name());
////            prepare_city.setInt("sp_country_id", employee_wrapper_object.getCity().getFk_country());
////            prepare_city.execute();
////            logger.info("Employee City updated");
////
////            // Step 2: Update Address
////            String sql_query_address = SP_UPDATE_ADDRESS;
////            prepare_address = db_connection.prepareCall(sql_query_address);
////            prepare_address.setInt("sp_address_id", employee_wrapper_object.getAddress().getAddress_id());
////            prepare_address.setString("sp_address_name", employee_wrapper_object.getAddress().getAddress_name());
////            prepare_address.setInt("sp_city_id", employee_wrapper_object.getAddress().getFk_city());
////            prepare_address.execute();
////            logger.info("Employee Address updated");
//
//            // Step 3: Update Employee Information
//            String sql_query_employee = SP_UPDATE_EMPLOYEE_ACCOUNT;
//            prepare_employee = db_connection.prepareCall(sql_query_employee);
//            prepare_employee.setInt("sp_employee_id", employee_wrapper_object.getEmployee().getId());
//            prepare_employee.setString("sp_first_name", employee_wrapper_object.getEmployee().getFirst_name());
//            prepare_employee.setString("sp_last_name", employee_wrapper_object.getEmployee().getLast_name());
//            prepare_employee.setString("sp_email", employee_wrapper_object.getEmployee().getEmail());
//            prepare_employee.setString("sp_telephone", employee_wrapper_object.getEmployee().getTelephone());
//            prepare_employee.setString("sp_password", employee_wrapper_object.getEmployee().getPassword());
//            prepare_employee.setInt("sp_address_id", employee_wrapper_object.getEmployee().getFk_address());
//            prepare_employee.execute();
//            logger.info("Employee Information updated");
//
//            // Commit the transaction
//            db_connection.commit();
//            return true;
//
//        } catch (SQLException e) {
//            logger.severe("SQL error while updating employee information: " + e.getMessage());
//            try {
//                if (db_connection != null) {
//                    db_connection.rollback(); // Rollback the transaction on failure
//                    logger.info("Transaction rolled back due to error.");
//                }
//            } catch (SQLException rollbackEx) {
//                logger.severe("Error while rolling back the transaction: " + rollbackEx.getMessage());
//            }
//        } catch (Exception e) {
//            logger.severe("Other error while updating employee information: " + e.getMessage());
//        } finally {
//            try {
//                // Closing CallableStatements to prevent resource leakage
////                if (prepare_city != null) prepare_city.close();
////                if (prepare_address != null) prepare_address.close();
//                if (prepare_employee != null) prepare_employee.close();
//            } catch (SQLException e) {
//                logger.severe("Error while closing the CallableStatements: " + e.getMessage());
//            }
//        }
//
//        return false;
//    }
//	
//	
//	
	
	
	
//-----------------------------------------------------------------------------------------------------------------------------------------
	
	
//UPDATING EMPLOYEE ACCOUNT INFORMATION:	
	public boolean update_employee_information(Connection db_connection, Employee_wrapper employee_wrapper_object) {

		try {
			String sql_query_city = SP_UPDATE_CITY ;
			CallableStatement prepare_city = db_connection.prepareCall(sql_query_city);
			prepare_city.setInt("sp_city_id", employee_wrapper_object.getCity().getCity_id());
			prepare_city.setString("sp_city_name", employee_wrapper_object.getCity().getCity_name());
			prepare_city.setInt("sp_country_id", employee_wrapper_object.getCity().getFk_country());
			prepare_city.execute();
			System.out.println("Employee City updated");
			
			
			
			String sql_query_address = SP_UPDATE_ADDRESS;
			CallableStatement prepare_address = db_connection.prepareCall(sql_query_address);
			prepare_address.setInt("sp_address_id", employee_wrapper_object.getAddress().getAddress_id());
			prepare_address.setString("sp_address_name", employee_wrapper_object.getAddress().getAddress_name());
			prepare_address.setInt("sp_city_id", employee_wrapper_object.getAddress().getFk_city());
			prepare_address.execute();
			System.out.println("Employee Address updated");
			
			String sql_query_employee = SP_UPDATE_EMPLOYEE_ACCOUNT;
			CallableStatement prepare_employee = db_connection.prepareCall(sql_query_employee);
			prepare_employee.setInt("sp_employee_id", employee_wrapper_object.getEmployee().getId() );
			prepare_employee.setString("sp_first_name", employee_wrapper_object.getEmployee().getFirst_name() );
			prepare_employee.setString("sp_last_name", employee_wrapper_object.getEmployee().getLast_name() );
			prepare_employee.setString("sp_email", employee_wrapper_object.getEmployee().getEmail() );
			prepare_employee.setString("sp_telephone", employee_wrapper_object.getEmployee().getTelephone() );
			prepare_employee.setString("sp_password", employee_wrapper_object.getEmployee().getPassword() );
			prepare_employee.setInt("sp_address_id", employee_wrapper_object.getEmployee().getFk_address() );
			prepare_employee.execute();
			System.out.println("Employee Information updated");
			
			return true;
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("SQL error while updating employee Information");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Other error while updating employee Information");
		}
	
		return false;
	}//ends method
	
	

	public List<Employee_wrapper> get_employee_by_id(Connection db_connection, Integer employee_id) {
		List<Employee_wrapper> employee_list = new ArrayList<Employee_wrapper>();
		try {
				String sql_query = SP_DISPLAY_EMPLOYEE_BY_ID;
				CallableStatement prepare = db_connection.prepareCall(sql_query);
				prepare.setInt("sp_employee_id", employee_id);
				prepare.execute();
				ResultSet rs = prepare.getResultSet();
				while(rs.next()) {
					Employee_wrapper employee_wrapper_row = new Employee_wrapper();
						employee_wrapper_row.getEmployee().setId(rs.getInt(EMPLOYEE_ID));
						employee_wrapper_row.getEmployee().setFirst_name(rs.getString(EMPLOYEE_FIRST_NAME));
						employee_wrapper_row.getEmployee().setLast_name(rs.getString(EMPLOYEE_LAST_NAME));
						employee_wrapper_row.getEmployee().setEmail(rs.getString(EMPLOYEE_EMAIL));
						employee_wrapper_row.getEmployee().setTelephone(rs.getString(EMPLOYEE_TELEPHONE));
						employee_wrapper_row.getEmployee().setPassword(rs.getString(EMPLOYEE_PASSWORD));
						employee_wrapper_row.getEmployee().setDate_of_birth(rs.getString(EMPLOYEE_DATE_OF_BIRTH));
						
						employee_wrapper_row.getAddress().setAddress_id(rs.getInt(ADDRESS_ID));
						employee_wrapper_row.getAddress().setAddress_name(rs.getString(ADDRESS_NAME));
						
						employee_wrapper_row.getCity().setCity_id(rs.getInt(CITY_ID));
						employee_wrapper_row.getCity().setCity_name(rs.getString(CITY_NAME));
						
						employee_wrapper_row.getCountry().setId(rs.getInt(COUNTRY_ID));
						employee_wrapper_row.getCountry().setCountry_name(rs.getString(COUNTRY_NAME));
						employee_list.add(employee_wrapper_row);
									
				}//Ends while loop
				System.out.println("Employee by ID for updated session values done successfully");
				return employee_list;
				
		}catch(SQLException e) {
			e.printStackTrace();
			//System.out.println(" SQL Error getting employee by id for updating new session datas");
		}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Other Error getting employee by id for updating new session datas");
		}//ends catch
		
		
		return new ArrayList<Employee_wrapper>();
	}//ends method
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
}//ends class
