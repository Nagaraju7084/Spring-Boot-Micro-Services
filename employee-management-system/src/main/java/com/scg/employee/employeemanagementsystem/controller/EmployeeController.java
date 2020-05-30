package com.scg.employee.employeemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.scg.employee.employeemanagementsystem.dto.EmployeeTaxDetails;
import com.scg.employee.employeemanagementsystem.model.EmployeeModel;
import com.scg.employee.employeemanagementsystem.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	
	
	
	@PostMapping(value="create-employee")
	public EmployeeModel saveEmployee(@RequestBody EmployeeModel save)
	{
		return empService.save(save);
	}
	
	
	@GetMapping(value="/tax-details/{code}")
	public EmployeeTaxDetails taxDetails(@PathVariable String code)
	{
		return empService.taxDetails(Long.valueOf(code));
	}
	
	
	
}
