package com.jobmarket.company.model;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;


import com.jobmarket.Config_hired;

public class DB_helper_job implements Config_hired {

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

//-----------------------------------------------------------------------------------------------------------------------------------------------


	public void disconnect(Connection db_connection) {
			try {
				db_connection.close();
				System.out.println("Database Disconnected successfully.");
			} catch (Exception e) {
				System.out.println("Error while disconnecting the database : " + e);
			}
	}//ends disconnection method.
	
	
	

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		


	
	
	
	
	
	
	
	
	
	
	
}//ends class
