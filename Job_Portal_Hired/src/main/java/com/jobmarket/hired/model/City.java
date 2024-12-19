package com.jobmarket.hired.model;

public class City {

	private int city_id = 0;
	private String city_name= "";
	private int fk_country = 0;
	
//Constructors	
	public City(int city_id, String city_name, int fk_country) {
		super();
		this.city_id = city_id;
		this.city_name = city_name;
		this.fk_country = fk_country;
	}
	
	public City() {
		super();
		this.city_id = 0;
		this.city_name = "";
		fk_country = 0;
	}
	
	
	
//getters and Setters:	
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public int getFk_country() {
		return fk_country;
	}
	public void setFk_country(int FK_country) {
		this.fk_country = FK_country;
	}
	
	
//toString method:	
	@Override
	public String toString() {
		return "City [city_id=" + city_id + ", city_name=" + city_name + ", FK_country=" + fk_country + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//ends class
