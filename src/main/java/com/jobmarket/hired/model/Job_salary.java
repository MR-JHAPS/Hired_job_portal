package com.jobmarket.hired.model;

public class Job_salary {



		private int salary_id = 0;
		private String salary_amount = "";
		
		//constructors with parameters
		public Job_salary(int salary_id, String salary_amount) {
			super();
			this.salary_id = salary_id;
			this.salary_amount = salary_amount;
		}
		
		//constructors without parameters
		public Job_salary() {
			super();
			this.salary_id = 0;
			this.salary_amount = "";
		}

		
		//getters and setters
		public int getSalary_id() {
			return salary_id;
		}

		public void setSalary_id(int salary_id) {
			this.salary_id = salary_id;
		}

		public String getSalary_amount() {
			return salary_amount;
		}

		public void setSalary_amount(String salary_amount) {
			this.salary_amount = salary_amount;
		}
		
		
		@Override
		public String toString() {
			return "Job_salary [salary_id=" + salary_id + ", salary_amount=" + salary_amount
					+ "]";
		}
		
		
		
		
	}//ends class

	

