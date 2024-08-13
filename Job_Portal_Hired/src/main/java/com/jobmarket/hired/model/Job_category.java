package com.jobmarket.hired.model;

public class Job_category {

	private int category_id = 0;
	private String category_name = "";
	
	//constructors with parameters
	public Job_category(int category_id, String category_name) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
	}
	
	//constructors without parameters
	public Job_category() {
		super();
		this.category_id = 0;
		this.category_name = "";
	}

	
	//getters and setters
	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	
	@Override
	public String toString() {
		return "Job_category [category_id=" + category_id + ", category_name=" + category_name
				+ "]";
	}
	
	
	
	
}//ends class
