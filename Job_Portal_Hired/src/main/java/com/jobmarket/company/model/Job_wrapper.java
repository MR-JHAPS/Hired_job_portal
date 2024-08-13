package com.jobmarket.company.model;

import java.util.Locale.Category;

import com.jobmarket.hired.model.Address;
import com.jobmarket.hired.model.City;
import com.jobmarket.hired.model.Country;
import com.jobmarket.hired.model.Job_category;
import com.jobmarket.hired.model.Job_contract;
import com.jobmarket.hired.model.Job_salary;

public class Job_wrapper {

	private Job job;
	private Job_category job_category;
	private Job_salary job_salary;
	private Job_contract job_contract;
	private Company company;
	private Address address;
	private City city;
	private Country country;
	
	
	
	
    


//Constructors:

    public Job_wrapper(Job job, Job_category job_category, Job_salary job_salary, Job_contract job_contract,
			Company company, Address address, City city, Country country) {
		super();
		this.job = job;
		this.job_category = job_category;
		this.job_salary = job_salary;
		this.job_contract = job_contract;
		this.company = company;
		this.address = address;
		this.city = city;
		this.country = country;
	}


    public Job_wrapper() {
		super();
		this.job = new Job();
		this.job_category = new Job_category();
		this.job_salary = new Job_salary();
		this.job_contract = new Job_contract();
		this.company = new Company();
		this.address = new Address();
		this.city = new City();
		this.country = new Country();
	}

    
  //getters and setters  

	public Job getJob() {
		return job;
	}


	public void setJob(Job job) {
		this.job = job;
	}


	public Job_category getJob_category() {
		return job_category;
	}


	public void setJob_category(Job_category job_category) {
		this.job_category = job_category;
	}


	public Job_salary getJob_salary() {
		return job_salary;
	}


	public void setJob_salary(Job_salary job_salary) {
		this.job_salary = job_salary;
	}


	public Job_contract getJob_contract() {
		return job_contract;
	}


	public void setJob_contract(Job_contract job_contract) {
		this.job_contract = job_contract;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
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


	
	
	
	
	@Override
	public String toString() {
		return "Job_wrapper [job=" + job + ", job_category=" + job_category + ", job_salary=" + job_salary
				+ ", job_contract=" + job_contract + ", company=" + company + ", address=" + address + ", city=" + city
				+ ", country=" + country + "]";
	}


    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}//ends class
