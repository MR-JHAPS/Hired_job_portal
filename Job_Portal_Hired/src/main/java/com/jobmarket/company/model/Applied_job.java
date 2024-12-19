package com.jobmarket.company.model;

import com.jobmarket.client.model.Cv_file;
import com.jobmarket.client.model.Employee;
import com.jobmarket.hired.model.Address;
import com.jobmarket.hired.model.City;
import com.jobmarket.hired.model.Country;

public class Applied_job {

	private int applied_job_id = 0;
	private String cover_letter = "";
	private Employee employee = new Employee();
	private Company company = new Company();
	private Job job = new Job();
	private Address address = new Address();
	private City city = new City();
	private Country country = new Country();
	private Cv_file cv = new Cv_file();
	
	
	//Constructors:
	public Applied_job(int applied_job_id, String cover_letter, Employee employee, Company company, Job job, Address address, City city,
			Country country, Cv_file cv) {
		super();
		this.applied_job_id = applied_job_id;
		this.cover_letter = cover_letter;
		this.employee = employee;
		this.company = company;
		this.job = job;
		this.address = address;
		this.city = city;
		this.country = country;
		this.cv = cv;
	}
	
	public Applied_job() {
		super();
		this.applied_job_id = 0;
		this.cover_letter = "";
		this.employee = new Employee();
		this.company = new Company();
		this.job = new Job();
		this.address = new Address();
		this.city = new City();
		this.country = new Country();
		this.cv = new Cv_file();
	}

	
	
//GETTERS AND SETTERS:	
	public int getApplied_job_id() {
		return applied_job_id;
	}

	public void setApplied_job_id(int applied_job_id) {
		this.applied_job_id = applied_job_id;
	}
	
	public String getCover_letter() {
		return cover_letter;
	}

	public void setCover_letter(String cover_letter) {
		this.cover_letter = cover_letter;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Cv_file getCv() {
		return cv;
	}

	public void setCv(Cv_file cv) {
		this.cv = cv;
	}

	
//toString method:
	
	@Override
	public String toString() {
		return "Applied_job [applied_job_id=" + applied_job_id + ", cover_letter=" + cover_letter + ", employee="
				+ employee + ", company=" + company + ", job=" + job + ", address=" + address + ", city=" + city
				+ ", country=" + country + ", cv=" + cv + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//ends class
