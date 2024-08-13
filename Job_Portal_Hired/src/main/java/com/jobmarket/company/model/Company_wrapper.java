package com.jobmarket.company.model;

import com.jobmarket.hired.model.Address;
import com.jobmarket.hired.model.City;
import com.jobmarket.hired.model.Country;

public class Company_wrapper {

	private Company company = new Company();
	private Address address = new Address();
	private City city = new City();
	private Country country = new Country();
	
	
//Constructors:	
	public Company_wrapper(Company company, Address address, City city, Country country) {
		super();
		this.company = company;
		this.address = address;
		this.city = city;
		this.country = country;
	}
	
	public Company_wrapper() {
		super();
		this.company = new Company();;
		this.address = new Address();
		this.city = new City();
		this.country = new Country();
	}
	
	
	
	
	
	

	
//Getters and Setters:	


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

	
	

//toString Method:	
	@Override
	public String toString() {
		return "Company_wrapper [company=" + company + ", address=" + address + ", city=" + city + ", country="
				+ country + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//ends class.
