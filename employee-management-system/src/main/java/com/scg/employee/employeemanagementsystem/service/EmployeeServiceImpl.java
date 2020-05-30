package com.scg.employee.employeemanagementsystem.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scg.employee.employeemanagementsystem.dto.EmployeeTaxDetails;
import com.scg.employee.employeemanagementsystem.model.EmployeeModel;
import com.scg.employee.employeemanagementsystem.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repo;

	public EmployeeModel save(EmployeeModel save) {
		return repo.save(save);
	}

	public EmployeeTaxDetails taxDetails(Long code) {
		EmployeeModel details = repo.findByCode(code);
		EmployeeTaxDetails tax = new EmployeeTaxDetails();
		if (details != null) {
			tax.setCode(details.getCode());
			tax.setFirstName(details.getFirstName());
			tax.setLastName(details.getLastName());
			Map<String, Double> calculatetax = taxCalculation(details.getSalary(), details.getDateOfJoin());
			tax.setYearlySalary(calculatetax.get("yearlySalary"));
			tax.setCess(calculatetax.get("cess"));
			tax.setTaxAmount(calculatetax.get("taxAmount"));
		}

		return tax;
	}

	public Map<String, Double> taxCalculation(Double monthlySalary, Date doj) {
		Map<String, Double> map = new HashMap<>();

	//	LocalDate date = LocalDate.of(doj.getYear(), doj.getMonth()+1, doj.getDay());

	//	int days = date.getMonth().length(true);
		
		int days = getMonthDays(doj.getMonth() , doj.getYear());

		int joinedMonth = doj.getMonth() + 1;

		int remainingDays = days - doj.getDate();

		float temp_days = (float) remainingDays / days;

		double salaryOfFirstMonth = monthlySalary * temp_days;

		double totalSalary = 0.0;

		int remainMonth = 12 - joinedMonth;

		if (joinedMonth >= 4) {

			for (int i = 0; i < remainMonth; i++) {
				if (i == 0) {
					totalSalary += salaryOfFirstMonth;
				} else {
					totalSalary = totalSalary + monthlySalary;
				}
			}

			for (int i = 0; i <= 3; i++) {
				totalSalary = totalSalary + monthlySalary;
			}
		}

		if (joinedMonth <= 3) {

			for (int i = joinedMonth; i <= 3; i++) {
				if (i == joinedMonth) {
					totalSalary = salaryOfFirstMonth;
				} else {
					totalSalary = totalSalary + monthlySalary;
				}
			}

		}
		float taxFormula = 0.0f;

		if (totalSalary <= 250000.00) {
			map.put("taxAmount", 0.0);
			map.put("yearlySalary", totalSalary);
		}

		else if (totalSalary > 250000.00 && totalSalary <= 500000.00) {
			double final_salary = totalSalary - 250000.00;
			taxFormula = (float) 5 / 100;
			System.out.println("tax :" + taxFormula + ",final" + final_salary);
			map.put("taxAmount", (double) final_salary * taxFormula);
			map.put("yearlySalary", totalSalary);
		}

		else if (totalSalary > 500000.00 && totalSalary <= 1000000.00) {
			double slab = totalSalary - 250000.00; // 7,50,000
			double taxAmount = 0.0;
			int tax_perc = 5;
			double reducing_amount = 0.0;
			double slab_temp = slab;
			int max = (int) slab;
			for (int i = 0; i <= max;) {
				double amount_temp = 0.0;

				if(i == 0 && slab_temp > 250000)
				{
					i =  i + 250000;
				}
				if (slab_temp > 250000.00) {
					reducing_amount = slab_temp = slab_temp - 250000.00; // 500000
					amount_temp = 250000.00;
				} else {
					amount_temp = reducing_amount;
				}

				taxFormula = (float) tax_perc / 100;
				taxAmount =taxAmount + amount_temp * taxFormula;

				if (reducing_amount > 250000.00) {
					i = i + 250000;
				}

				else {
					i = (int) (i + reducing_amount);
				}
				
				tax_perc = tax_perc + 5;
			}

			map.put("taxAmount", taxAmount);
			map.put("yearlySalary", totalSalary);

		} else {
			
			
			double slab = totalSalary - 250000.00; // 7,50,000
			double taxAmount = 0.0;
			int tax_perc = 5;
			double reducing_amount = 0.0;
			double slab_temp = slab;
			int max = (int) slab;
			for (int i = 0; i <= max;) {
				double amount_temp = 0.0;

				if(i == 0 && slab_temp > 250000)
				{
					i =  i + 250000;
				}
				if (slab_temp > 250000.00) {
					reducing_amount = slab_temp = slab_temp - 250000.00; // 500000
					amount_temp = 250000.00;
				} else {
					amount_temp = reducing_amount;
				}

				taxFormula = (float) tax_perc / 100;
				taxAmount =taxAmount + amount_temp * taxFormula;

				if (reducing_amount > 250000.00) {
					i = i + 250000;
				}

				else {
					i = (int) (i + reducing_amount);
				}
				
				tax_perc = tax_perc + 5;
			}

			map.put("taxAmount", taxAmount);
			map.put("yearlySalary", totalSalary);
			
		}
		if (totalSalary > 2500000.00) {
			double remaing_amount = totalSalary - 2500000.00;
			float cess = (float) 2 / 100;
			map.put("cess", remaing_amount * cess);
		} else {
			map.put("cess", 0.0);
		}

		return map;
	}
	
	
	
	public static int getMonthDays(int month, int year) {
		int daysInMonth;
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			daysInMonth = 30;
		} else {
			if (month == 2) {
				daysInMonth = (year % 4 == 0) ? 29 : 28;
			} else {
				daysInMonth = 31;
			}
		}
		return daysInMonth;
	}

}
