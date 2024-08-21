package com.jobmarket.company.model;

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
import com.jobmarket.hired.model.Address;
import com.jobmarket.hired.model.City;
import com.jobmarket.hired.model.Country;
import com.jobmarket.hired.model.Job_category;
import com.jobmarket.hired.model.Job_contract;
import com.jobmarket.hired.model.Job_salary;

public class DB_helper_company implements DB_config {

	public Connection connect_db() {
		Connection db_connection = null;
		try {
			Class.forName(DB_DRIVER);// not necessary.
			db_connection = DriverManager.getConnection(DB_SOURCE, USERNAME, PASSWORD);
			System.out.println("Connected to the database successfully.");

		} catch (Exception e) {
			System.out.println("Error while connecting to the database : " + e);
		}

		return db_connection;
	}// ends connection method

//-----------------------------------------------------------------------------------------------------------------------------------------------

	public void disconnect(Connection db_connection) {
		try {
			db_connection.close();
			System.out.println("Database Disconnected successfully.");
		} catch (Exception e) {
			System.out.println("Error while disconnecting the database : " + e);
		}
	}// ends disconnection method.

//-----------THIS CODES ARE FOR SIGNING UP THE COMPANY USER  -----------------------------------------------------------------------------

	// Inserting Company Information:
	public boolean insert_company_information(Connection db_connection, Company_wrapper company_wrapper_object) {

		// Every class Company, Address, City and Country is wrapped inside the
		// Company_wrapper.
		// this one is for the city. We start from city because we need its id for
		// address and we need address id for company.
		try {
			String sql_query_city = SP_INSERT_CITY;

			CallableStatement prepare_city = db_connection.prepareCall(sql_query_city);
			prepare_city.setString("sp_city_name", company_wrapper_object.getCity().getCity_name());
			prepare_city.setInt("sp_FK_country", company_wrapper_object.getCountry().getId());
			// we have created a OUT parameter in Stored procedure of city for obtaining
			// cityID.
			prepare_city.registerOutParameter("sp_city_id", Types.INTEGER);
			prepare_city.execute();

			int city_id = prepare_city.getInt("sp_city_id");
			System.out.println("city inserted successfully" + city_id);

			// this is for address
			String sql_query_address = SP_INSERT_ADDRESS;
			CallableStatement prepare_address = db_connection.prepareCall(sql_query_address);
			prepare_address.setString("sp_address", company_wrapper_object.getAddress().getAddress_name());
			prepare_address.setInt("sp_city_id", city_id);
			prepare_address.registerOutParameter("sp_address_id", Types.INTEGER);
			prepare_address.execute();

			int address_id = prepare_address.getInt("sp_address_id");
			System.out.println("address inserted successfully" + address_id);

			// this one is for the company:
			String sql_query_company = SP_INSERT_COMPANY;
			CallableStatement prepare_company = db_connection.prepareCall(sql_query_company);
			prepare_company.setString("sp_company_name", company_wrapper_object.getCompany().getName());
			prepare_company.setString("sp_telephone", company_wrapper_object.getCompany().getTelephone());
			prepare_company.setString("sp_email", company_wrapper_object.getCompany().getEmail());
			prepare_company.setString("sp_password", company_wrapper_object.getCompany().getPassword());
			prepare_company.setInt("sp_address_id", address_id);
			prepare_company.execute();
			System.out.println("Company inserted successfully");

			return true;

		} catch (SQLIntegrityConstraintViolationException e) {
			e.getMessage();
		} catch (SQLException e) {
			for (StackTraceElement element : e.getStackTrace()) {
				System.out.println(element);
			}
		} catch (Exception e) {
			for (StackTraceElement element : e.getStackTrace()) {
				System.out.println("OTHER ERROR WHILE INSERTING COMPANY_INFORMATION " + element);
			}
		}

		return false;
	}

//-----------GETTING ALL COMPANY INFORMATION USING EMAIL AND PASSWORD ----> FOR SIGN IN VERIFICATION -----------------------------------------

	public List<Company_wrapper> get_company_email_password(Connection db_connection, String company_email,
			String company_password) {
		List<Company_wrapper> company_list = new ArrayList<Company_wrapper>();
		try {
			String sql_query = SP_DISPLAY_COMPANY_BY_EMAIL_PASSWORD; // need to change this later on MYSQL.
			CallableStatement prepare = db_connection.prepareCall(sql_query);
			prepare.setString("sp_email", company_email);
			prepare.setString("sp_password", company_password);
			prepare.execute();
			ResultSet rs = prepare.getResultSet();
			while (rs.next()) {
				Company company_row = new Company();
				company_row.setId(rs.getInt(COMPANY_ID));
				company_row.setName(rs.getString(COMPANY_NAME));
				company_row.setTelephone(rs.getString(COMPANY_TELEPHONE));
				company_row.setEmail(rs.getString(COMPANY_EMAIL));
				company_row.setPassword(rs.getString(COMPANY_PASSWORD));
				company_row.setFk_address(rs.getInt(COMPANY_FK_ADDRESS));

				Address address_row = new Address();
				address_row.setAddress_name(rs.getString(ADDRESS_NAME));

				City city_row = new City();
				city_row.setCity_name(rs.getString(CITY_NAME));

				Country country_row = new Country();
				country_row.setCountry_name(rs.getString(COUNTRY_NAME));
				country_row.setId(rs.getInt(COUNTRY_ID));

				// country_row is the object of Country_wrapper that contains address, city and
				// country objects value.
				// I have joined the table company,address,city and country using FK in
				// MYSQL->StoredProcedure.
				Company_wrapper company_wrapper_row = new Company_wrapper(company_row, address_row, city_row,
						country_row);

				company_list.add(company_wrapper_row);
			} // ends while loop
			System.out.println("Company email and password obtained successfully");
			return company_list;
		} catch (Exception e) {
			System.out.println("Error getting Company email and Password : " + e);
		}
		return new ArrayList<Company_wrapper>();
	}// ends method

	
	
//GETTING ALL THE RESULTS OF JOB_INFOMATION INCLUDING CATEGORY, CONTRACTS USING WRAPPER	
	public List<Job_wrapper> get_all_job_information_by_company_id(Connection db_connection, int company_id) {
		List<Job_wrapper> job_list = new ArrayList<Job_wrapper>();

		try {
			String sql_query = SP_DISPLAY_ALL_JOB_INFORMATION_BY_COMPANY_ID;
			CallableStatement prepare = db_connection.prepareCall(sql_query);
			prepare.setInt(1, company_id);
			prepare.execute();
			ResultSet rs = prepare.getResultSet();

			while (rs.next()) {
				// Adding all the data from ResultSet Columns to respective Class objects.
				Job job_row = new Job();
				job_row.setJob_id(rs.getInt("job_id"));
				job_row.setJob_name(rs.getString("job_name"));
				job_row.setJob_descripcion(rs.getString("job_descripcion"));
				job_row.setJob_vacancy(rs.getString("vacancy"));

				Company company_row = new Company();
				company_row.setId(rs.getInt("FK_company"));
				company_row.setName(rs.getString("company_name"));
				Job_category category_row = new Job_category();
				category_row.setCategory_name(rs.getString("job_category_name"));
				Job_salary salary_row = new Job_salary();
				salary_row.setSalary_amount(rs.getString("job_salary_amount"));
				Job_contract contract_row = new Job_contract();
				contract_row.setContract_name(rs.getString("job_contract_name"));

				Address address_row = new Address();
				address_row.setAddress_name(rs.getString("address"));

				City city_row = new City();
				city_row.setCity_name(rs.getString("city_name"));

				Country country_row = new Country();
				country_row.setCountry_name(rs.getString("country_name"));

				// Job_wrapper object includes all the attributes of Job object.
				Job_wrapper job_wrapper = new Job_wrapper(job_row, category_row, salary_row, contract_row, company_row,
						address_row, city_row, country_row);
				// Add the Job_wrapper object to the list
				job_list.add(job_wrapper);
			}

			System.out.println("Job Information by Company ID displayed Successfully.");
			return job_list;
		} catch (Exception e) {
			// Print stack trace for debugging
			for (StackTraceElement element : e.getStackTrace()) {
				System.out.println("Error getting Job information by Company ID: " + element);
			}
		}

		// Return an empty list if an exception occurs
		return new ArrayList<Job_wrapper>();
	}

	
//INSERTING JOBS / JOB_POSTING:--------------------------------------------------------------------------------------------------------	
	// City parameter is just a easy parameter.
	public int insert_city(Connection db_connection, City city, int country_id) throws SQLException {
		String sql_query_city = SP_INSERT_CITY;
		CallableStatement prepare_city = db_connection.prepareCall(sql_query_city);
		prepare_city.setString("sp_city_name", city.getCity_name());
		prepare_city.setInt("sp_FK_country", country_id);
		// register out parameter means it is given out in stored procedure as
		// "last_insert_id". to use that value in FK in another table.
		prepare_city.registerOutParameter("sp_city_id", Types.INTEGER);
		prepare_city.execute();

		int city_id = prepare_city.getInt("sp_city_id");
		return city_id;
	}

	public int insert_address(Connection db_connection, Address address, int city_id) throws SQLException {
		String sql_query_address = SP_INSERT_ADDRESS;
		CallableStatement prepare_address = db_connection.prepareCall(sql_query_address);
		prepare_address.setString("sp_address", address.getAddress_name());
		prepare_address.setInt("sp_city_id", city_id);
		prepare_address.registerOutParameter("sp_address_id", Types.INTEGER);
		prepare_address.execute();

		int address_id = prepare_address.getInt("sp_address_id");
		return address_id;
	}

//INSERT JOB INFORMATION:	
	public boolean insert_job_information(Connection db_connection, Job_wrapper job_wrapper_object) {
		try {
			// the value of city_id and address_id is passed from method insert city and
			// insert address.
			/*
			 * In insert city method we are using City class but in this we are using
			 * Job_wrapper so we are calling city object that is wrapped inside the
			 * Job_wrapper.
			 */
			int city_id = insert_city(db_connection, job_wrapper_object.getCity(),
					job_wrapper_object.getCountry().getId());
			int address_id = insert_address(db_connection, job_wrapper_object.getAddress(), city_id);

			String sql_query_job = SP_INSERT_JOB_INFORMATION;
			CallableStatement prepare_job = db_connection.prepareCall(sql_query_job);
			// sp_name means the parameters name in stored procedures.
			prepare_job.setString("sp_job_name", job_wrapper_object.getJob().getJob_name());
			prepare_job.setString("sp_job_descripcion", job_wrapper_object.getJob().getJob_descripcion());
			prepare_job.setString("sp_vacancy", job_wrapper_object.getJob().getJob_vacancy());
			prepare_job.setInt("sp_FK_company", job_wrapper_object.getJob().getFk_company());
			prepare_job.setInt("sp_FK_address", address_id);
			prepare_job.setInt("sp_FK_category", job_wrapper_object.getJob().getFk_category());
			prepare_job.setInt("sp_FK_contract", job_wrapper_object.getJob().getFk_contract());
			prepare_job.setInt("sp_FK_salary", job_wrapper_object.getJob().getFk_salary());
			prepare_job.execute();

			System.out.println("Job inserted successfully");
			return true;
		} catch (SQLIntegrityConstraintViolationException e) {
			e.getMessage();
		} catch (SQLException e) {
			for (StackTraceElement element : e.getStackTrace()) {
				System.out.println(element);
			}
		} catch (Exception e) {
			for (StackTraceElement element : e.getStackTrace()) {
				System.out.println("OTHER ERROR WHILE INSERTING COMPANY_INFORMATION " + element);
			}
		}

		return false;
	}

//Displaying all the applied job INFORMATION TO SHOW ON THE "APPLICANTS" menu on the company menu bar.	
	public List<Applied_job> display_applied_job_information(Connection db_connection, int company_id) {
		List<Applied_job> all_applied_job_information = new ArrayList<Applied_job>();
		try {
			String sql_query = SP_DISPLAY_APPLIED_JOB_BY_COMPANY_ID;
			CallableStatement prepare = db_connection.prepareCall(sql_query);
			prepare.setInt("sp_company_id", company_id);
			prepare.execute();
			ResultSet rs = prepare.getResultSet();
			while (rs.next()) {
				Applied_job applied_job_row = new Applied_job();
				applied_job_row.setApplied_job_id(rs.getInt(APPLIED_JOB_ID));
				applied_job_row.setCover_letter(rs.getString(APPLIED_JOB_COVER_LETTER));
				applied_job_row.getJob().setJob_name(rs.getString(JOB_NAME));
				applied_job_row.getJob().setJob_descripcion(rs.getString(JOB_DESCRIPCION));
				applied_job_row.getEmployee().setFirst_name(rs.getString(EMPLOYEE_FIRST_NAME));
				applied_job_row.getEmployee().setLast_name(rs.getString(EMPLOYEE_LAST_NAME));
				applied_job_row.getEmployee().setEmail(rs.getString(EMPLOYEE_EMAIL));
				applied_job_row.getEmployee().setTelephone(rs.getString(EMPLOYEE_TELEPHONE));
				applied_job_row.getAddress().setAddress_name(rs.getString(ADDRESS_NAME));
				applied_job_row.getCity().setCity_name(rs.getString(CITY_NAME));
				applied_job_row.getCountry().setCountry_name(rs.getString(COUNTRY_NAME));
				applied_job_row.getCompany().setName(rs.getString(COMPANY_NAME));
				applied_job_row.getCv().setCv_name(rs.getString(CV_NAME));
				applied_job_row.getCv().setCv_id(rs.getInt(CV_ID));

				all_applied_job_information.add(applied_job_row);
			} // ends while
			System.out.println("All the Applied Job displayed successfully.");
			return all_applied_job_information;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error while getting all the Applied job information/Applicants.");
		}

		return new ArrayList<Applied_job>();
	}

}// ends class
