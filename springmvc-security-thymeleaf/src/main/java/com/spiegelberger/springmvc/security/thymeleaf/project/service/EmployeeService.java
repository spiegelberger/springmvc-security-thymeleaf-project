package com.spiegelberger.springmvc.security.thymeleaf.project.service;

import java.util.List;

import com.spiegelberger.springmvc.security.thymeleaf.project.entity.Employee;


public interface EmployeeService {

	public List<Employee>showAll();
	
	public void save(Employee employee);
	
	public void delete(int id);
	
	public Employee findById(int id);
	
}
