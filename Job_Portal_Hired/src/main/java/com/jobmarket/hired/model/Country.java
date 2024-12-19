package com.jobmarket.hired.model;

public class Country {

	private int id = 0;
	private String country_name = "";
	
	
//constructors.
	public Country(int id, String country_name) {
		super();
		this.id = id;
		this.country_name = country_name;
	}
	
	public Country() {
		super();
		this.id = 0;
		this.country_name = "";
	}

	
	
//getters and setters:
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	
//toString method:
	@Override
	public String toString() {
		return "Country [id=" + id + ", country_name=" + country_name + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//ends class
