package com.jobmarket.client.model;

import com.jobmarket.hired.model.Address;
import com.jobmarket.hired.model.City;
import com.jobmarket.hired.model.Country;

public class Employee_wrapper {

	private Employee employee;
	private Address address;
	private City city;
	private Country country;
	
//constructors:	
	public Employee_wrapper(Employee employee, Address address, City city, Country country) {
		super();
		this.employee = employee;
		this.address = address;
		this.city = city;
		this.country = country;
	}
	
	public Employee_wrapper() {
		super();
		this.employee = new Employee();
		this.address = new Address();
		this.city = new City();
		this.country = new Country();
	}

	
//getters and Setters:	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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
		return "Employee_wrapper [employee=" + employee + ", address=" + address + ", city=" + city + ", country="
				+ country + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//ends class.
