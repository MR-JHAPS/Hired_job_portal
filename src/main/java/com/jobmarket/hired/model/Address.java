package com.jobmarket.hired.model;

public class Address {

	private int address_id=0;
	private String address_name = "";
	private int fk_city = 0;
	
//Constructors
	public Address(int address_id, String address, int fk_city) {
		super();
		this.address_id = address_id;
		this.address_name = address;
		this.fk_city = fk_city;
	}
	
	public Address() {
		super();
		this.address_id = 0;
		this.address_name = "";
		this.fk_city = 0;
	}

	
//getters and setters:	
	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getAddress_name() {
		return address_name;
	}

	public void setAddress_name(String address) {
		this.address_name = address;
	}

	public int getFk_city() {
		return fk_city;
	}

	public void setFk_city(int fk_city) {
		this.fk_city = fk_city;
	}

	
//toString method:	
	@Override
	public String toString() {
		return "Address [id=" + address_id + ", address_name=" + address_name + ", fk_city=" + fk_city + "]";
	}
	
	
	
	
	
	
}
