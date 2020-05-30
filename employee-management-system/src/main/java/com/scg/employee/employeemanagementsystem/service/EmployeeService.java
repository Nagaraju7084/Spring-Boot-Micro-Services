package com.scg.employee.employeemanagementsystem.service;

import com.scg.employee.employeemanagementsystem.dto.EmployeeTaxDetails;
import com.scg.employee.employeemanagementsystem.model.EmployeeModel;

public interface EmployeeService {
	
	public EmployeeModel save(EmployeeModel save);
	
	
	public EmployeeTaxDetails taxDetails(Long id);

}
