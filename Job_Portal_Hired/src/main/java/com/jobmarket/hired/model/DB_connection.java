package com.jobmarket.hired.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jobmarket.Config_hired;

//In this class only the "Connection and Disconnection" to the respective database is done.
public class DB_connection implements Config_hired{

	public Connection connect_db() {
				Connection db_connection = null;
				try {
					Class.forName(DB_DRIVER);//not necessary.
					db_connection = DriverManager.getConnection(DB_SOURCE, USERNAME, PASSWORD);
					System.out.println("Connected to the database successfully.");
					
				} catch (Exception e) {
					System.out.println("Error while connecting to the database : " + e);
				}
				
				return db_connection;
	}//ends connection method
	
	
	
	
	public void disconnect(Connection db_connection) {
				try {
					db_connection.close();
					System.out.println("Database Disconnected successfully.");
				} catch (Exception e) {
					System.out.println("Error while disconnecting the database : " + e);
				}
	}//ends disconnection method.




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
			
		}catch (SQLException e) {
				for(StackTraceElement element: e.getStackTrace()) {
					System.out.println("SQL Error while displaying the country list : " + element);
		}
		}catch (Exception e) {
				for(StackTraceElement element: e.getStackTrace()) {
					System.out.println("Other Error while displaying the country list  : " + element);
				}//ends for
		}//ends catch
		
		return new ArrayList<Country>();
	}




	public List<Job_category> display_all_job_category(Connection db_connection) {
		List<Job_category> category_list = new ArrayList<Job_category>();
		try {
			String sql_query= SP_DISPLAY_JOB_CATEGORY;
			CallableStatement prepare = db_connection.prepareCall(sql_query);
			prepare.execute();
			ResultSet rs = prepare.getResultSet();
			while(rs.next()) {
				Job_category category_row = new Job_category();
				category_row.setCategory_id(rs.getInt("category_id"));
				category_row.setCategory_name(rs.getString("category_name"));
				category_list.add(category_row);
			}
			System.out.println("Job category list displayed successfully.");
			return category_list;
			
		}catch (SQLException e) {
					for(StackTraceElement element: e.getStackTrace()) {
							System.out.println("SQL Error while displaying the Job category list : " + element);
					}
		}catch (Exception e) {
					for(StackTraceElement element: e.getStackTrace()) {
						System.out.println("Other Error while displaying the Job category list : " + element);
					}
		}//ends catch
		
		return new ArrayList<Job_category>();
	}//ends method




	public List<Job_contract> display_all_job_contract(Connection db_connection) {
		List<Job_contract> contract_list = new ArrayList<Job_contract>();
		try {
			String sql_query= SP_DISPLAY_JOB_CONTRACT;
			CallableStatement prepare = db_connection.prepareCall(sql_query);
			prepare.execute();
			ResultSet rs = prepare.getResultSet();
			while(rs.next()) {
				Job_contract contract_row = new Job_contract();
				contract_row.setContract_id(rs.getInt("contract_id"));
				contract_row.setContract_name(rs.getString("contract_name"));
				contract_list.add(contract_row);
			}
			System.out.println("Job contract list displayed successfully.");
			return contract_list;
			
		}catch (SQLException e) {
					for(StackTraceElement element: e.getStackTrace()) {
							System.out.println("SQL Error while displaying the Job contract list : " + element);
					}
		}catch (Exception e) {
					for(StackTraceElement element: e.getStackTrace()) {
						System.out.println("Other Error while displaying the Job contract list : " + element);
					}
		}//ends catch
		
		return new ArrayList<Job_contract>();	
		
	}//ends method




	public List<Job_salary> display_all_job_salary(Connection db_connection) {
		List<Job_salary> salary_list = new ArrayList<Job_salary>();
		try {
			String sql_query= SP_DISPLAY_JOB_SALARY;
			CallableStatement prepare = db_connection.prepareCall(sql_query);
			prepare.execute();
			ResultSet rs = prepare.getResultSet();
			while(rs.next()) {
				Job_salary salary_row = new Job_salary();
				salary_row.setSalary_id(rs.getInt("salary_id"));
				salary_row.setSalary_amount(rs.getString("salary_amount"));
				salary_list.add(salary_row);
			}
			System.out.println("Job contract list displayed successfully.");
			return salary_list;
			
		}catch (SQLException e) {
					for(StackTraceElement element: e.getStackTrace()) {
							System.out.println("SQL Error while displaying the Job salary list : " + element);
					}
		}catch (Exception e) {
					for(StackTraceElement element: e.getStackTrace()) {
						System.out.println("Other Error while displaying the Job salary list : " + element);
					}
		}//ends catch
		
		return new ArrayList<Job_salary>();	}
	
	
	
	
	
	
	
}//ends class
