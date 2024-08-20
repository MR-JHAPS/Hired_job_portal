package com.jobmarket.client.model;

public class Cv_file {

	private int cv_id = 0;
	private String cv_name = "";
	private int fk_employee =0;
	
	
//Constructors:	
	public Cv_file(int cv_id, String cv_name, int fk_employee) {
		super();
		this.cv_id = cv_id;
		this.cv_name = cv_name;
		this.fk_employee = fk_employee;
	}
	
	public Cv_file() {
		super();
		this.cv_id = 0;
		this.cv_name = "";
		this.fk_employee = 0;
	}

	
	
	
	
//getters and setters:	
	public int getCv_id() {
		return cv_id;
	}

	public void setCv_id(int cv_id) {
		this.cv_id = cv_id;
	}

	public String getCv_name() {
		return cv_name;
	}

	public void setCv_name(String cv_name) {
		this.cv_name = cv_name;
	}

	public int getFk_employee() {
		return fk_employee;
	}

	public void setFk_employee(int fk_employee) {
		this.fk_employee = fk_employee;
	}

	
//toString method:s	
	@Override
	public String toString() {
		return "Cv_file [cv_id=" + cv_id + ", cv_name=" + cv_name + ", fk_employee=" + fk_employee + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//ends class.
