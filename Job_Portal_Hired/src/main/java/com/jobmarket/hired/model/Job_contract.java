package com.jobmarket.hired.model;

public class Job_contract {

	

		private int contract_id = 0;
		private String contract_name = "";
		
		//constructors with parameters
		public Job_contract(int contract_id, String contract_name) {
			super();
			this.contract_id = contract_id;
			this.contract_name = contract_name;
		}
		
		//constructors without parameters
		public Job_contract() {
			super();
			this.contract_id = 0;
			this.contract_name = "";
		}

		
		//getters and setters
		public int getContract_id() {
			return contract_id;
		}

		public void setContract_id(int contract_id) {
			this.contract_id = contract_id;
		}

		public String getContract_name() {
			return contract_name;
		}

		public void setContract_name(String contract_name) {
			this.contract_name = contract_name;
		}
		
		
		@Override
		public String toString() {
			return "Job_contract [contract_id=" + contract_id + ", contract_name=" + contract_name
					+ "]";
		}
		
		
		
		
	}//ends class


