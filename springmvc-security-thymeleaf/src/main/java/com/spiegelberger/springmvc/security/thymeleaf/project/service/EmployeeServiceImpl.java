package com.spiegelberger.springmvc.security.thymeleaf.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spiegelberger.springmvc.security.thymeleaf.project.dao.EmployeeRepository;
import com.spiegelberger.springmvc.security.thymeleaf.project.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> showAll() {

		List<Employee>employees = employeeRepository.findAllByOrderByLastName();
		return employees;
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);		
	}

	@Override
	public void delete(int id) {
		employeeRepository.deleteById(id);		
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		Employee theEmployee = result.orElseThrow(()->
				new RuntimeException("Employee not found. The id: " + id));
		return theEmployee;
	}

}
