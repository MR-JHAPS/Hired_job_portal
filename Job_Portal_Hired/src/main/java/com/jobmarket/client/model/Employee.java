package com.jobmarket.client.model;

public class Employee {


		private int id = 0;
		private String first_name = "";
		private String last_name = "";
		private String email = "";
		private String telephone = "";
		private String password = "";
		private String date_of_birth ="";
		private int fk_address = 0 ;

		
//constructor with parameter:		
		public Employee(int id, String first_name, String last_name, String email, String telephone, String password,
				String date_of_birth, int fk_address) {
			super();
			this.id = id;
			this.first_name = first_name;
			this.last_name = last_name;
			this.email = email;
			this.telephone = telephone;
			this.password = password;
			this.date_of_birth = date_of_birth;
			this.fk_address = fk_address;
		}
		
//constructor without parameter:
		public Employee() {
			super();
			this.id = 0;
			this.first_name = "";
			this.last_name = "";
			this.email = "";
			this.telephone = "";
			this.password = "";
			this.date_of_birth = "";
			fk_address = 0;
		}
		
		
	
//getters and setters		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirst_name() {
			return first_name;
		}

		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}

		public String getLast_name() {
			return last_name;
		}

		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getTelephone() {
			return telephone;
		}

		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getDate_of_birth() {
			return date_of_birth;
		}

		public void setDate_of_birth(String date_of_birth) {
			this.date_of_birth = date_of_birth;
		}

		
		public int getFk_address() {
			return fk_address;
		}

		public void setFk_address(int fk_address) {
			this.fk_address = fk_address;
		}

		
		
		
//toString method
		@Override
		public String toString() {
			return "Employee [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
					+ ", telephone=" + telephone + ", password=" + password + ", date_of_birth=" + date_of_birth
					 +", FK_address=" + fk_address+ "]";
		}
		
		
		
		
		
		
		
		
		
		
		
	}//ends class.

