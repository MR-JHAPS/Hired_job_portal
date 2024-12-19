package com.jobmarket.company.model;

public class Company {

	private int id = 0;
	private String name = "";
	private String telephone = "";
	private String email = "";	
	private String password = "";
	private int fk_address=0;

	
//constructor with parameter:
	public Company(int id, String name, String telephone, String email, String password, int fk_address) {
		super();
		this.id = id;
		this.name = name;
		this.telephone = telephone;
		this.email = email;
		this.password = password;
		this.fk_address = fk_address;
	}

	public Company() {
		super();
		this.id = 0;
		this.name = "";
		this.telephone = "";
		this.email = "";
		this.password = "";
		this.fk_address = 0;
	}


	
	

//Getters and Setters:
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getFk_address() {
		return fk_address;
	}

	public void setFk_address(int fk_address) {
		this.fk_address = fk_address;
	}
	
	
//toString method:	
@Override
	public String toString() {
		return "Company_information [id=" + id + ", name=" + name + ", telephone=" + telephone + ", email=" + email
				+ ", password=" + password + ", fk_address=" + fk_address + "]";
	}


	
	
	
	
	
	
	
	
	
	
	
}//ends class.
