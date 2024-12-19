package com.jobmarket.company.model;

public class Job{

	private int job_id = 0;
	private String job_name ="";
	private String job_descripcion ="";
	private String job_vacancy ="";
	private int fk_company =0;
	private int fk_address = 0;
	private int fk_contract = 0;
	private int fk_salary = 0;
	private int fk_category = 0;
	
	
//constructors:	
	public Job(int job_id, String job_name, String job_descripcion, String job_vacancy, int fk_company, int fk_address,
			int fk_contract, int fk_salary, int fk_category) {
		super();
		this.job_id = job_id;
		this.job_name = job_name;
		this.job_descripcion = job_descripcion;
		this.job_vacancy = job_vacancy;
		this.fk_company = fk_company;
		this.fk_address = fk_address;
		this.fk_contract = fk_contract;
		this.fk_salary = fk_salary;
		this.fk_category = fk_category;
	}

	public Job() {
		super();
		this.job_id = 0;
		this.job_name = "";
		this.job_descripcion = "";
		this.job_vacancy = "";
		this.fk_company = 0;
		this.fk_address = 0;
		this.fk_contract = 0;
		this.fk_salary = 0;
		this.fk_category = 0;
	}
	
	
	
	
//getters and setters:
	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}

	public String getJob_name() {
		return job_name;
	}

	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}

	public String getJob_descripcion() {
		return job_descripcion;
	}

	public void setJob_descripcion(String job_descripcion) {
		this.job_descripcion = job_descripcion;
	}

	public String getJob_vacancy() {
		return job_vacancy;
	}

	public void setJob_vacancy(String job_vacancy) {
		this.job_vacancy = job_vacancy;
	}

	public int getFk_company() {
		return fk_company;
	}

	public void setFk_company(int fk_company) {
		this.fk_company = fk_company;
	}

	public int getFk_address() {
		return fk_address;
	}

	public void setFk_address(int fk_address) {
		this.fk_address = fk_address;
	}

	public int getFk_contract() {
		return fk_contract;
	}

	public void setFk_contract(int fk_contract) {
		this.fk_contract = fk_contract;
	}

	public int getFk_salary() {
		return fk_salary;
	}

	public void setFk_salary(int fk_salary) {
		this.fk_salary = fk_salary;
	}

	public int getFk_category() {
		return fk_category;
	}

	public void setFk_category(int fk_category) {
		this.fk_category = fk_category;
	}

	
	
//toString method:
	@Override
	public String toString() {
		return "Job [job_id=" + job_id + ", job_name=" + job_name + ", job_descripcion=" + job_descripcion
				+ ", job_vacancy=" + job_vacancy + ", fk_company=" + fk_company + ", fk_address=" + fk_address
				+ ", fk_contract=" + fk_contract + ", fk_salary=" + fk_salary + ", fk_category=" + fk_category + "]";
	}
	
	
	
	
	

	
	
	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
}//ends class
