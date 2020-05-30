package com.scg.employee.employeemanagementsystem.dto;

public class EmployeeTaxDetails {
	
	 	private Long code;

	    private String firstName;

	    private String lastName;
	    
	    private Double yearlySalary;
	    
	    private Double taxAmount;
	    
	    private Double cess;

		public Long getCode() {
			return code;
		}

		public void setCode(Long code) {
			this.code = code;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Double getYearlySalary() {
			return yearlySalary;
		}

		public void setYearlySalary(Double yearlySalary) {
			this.yearlySalary = yearlySalary;
		}

		public Double getTaxAmount() {
			return taxAmount;
		}

		public void setTaxAmount(Double taxAmount) {
			this.taxAmount = taxAmount;
		}

		public Double getCess() {
			return cess;
		}

		public void setCess(Double cess) {
			this.cess = cess;
		}
	    
	    
	    

}
