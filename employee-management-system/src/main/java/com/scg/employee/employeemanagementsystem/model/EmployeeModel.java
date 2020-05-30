package com.scg.employee.employeemanagementsystem.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@Entity
	@Table(name = "employee")
	@JsonIgnoreProperties
	public class EmployeeModel implements Serializable {
		private static final long serialVersionUID = 3764895233942257301L;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long code;

	    private String firstName;

	    private String lastName;
	    
	    private String email;
	    
	    private ArrayList<String> phoneNo;
	    
	    private Double salary;
	    
	    private Date dateOfJoin;

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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public ArrayList<String> getPhoneNo() {
			return phoneNo;
		}

		public void setPhoneNo(ArrayList<String> phoneNo) {
			this.phoneNo = phoneNo;
		}

		public Double getSalary() {
			return salary;
		}

		public void setSalary(Double salary) {
			this.salary = salary;
		}

		public Date getDateOfJoin() {
			return dateOfJoin;
		}

		public void setDateOfJoin(Date dateOfJoin) {
			this.dateOfJoin = dateOfJoin;
		}
	    
	    
	    

}
