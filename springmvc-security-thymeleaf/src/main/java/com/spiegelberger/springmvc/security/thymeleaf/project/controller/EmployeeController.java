package com.spiegelberger.springmvc.security.thymeleaf.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spiegelberger.springmvc.security.thymeleaf.project.entity.Employee;
import com.spiegelberger.springmvc.security.thymeleaf.project.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/list")
	public String list(Model theModel) {
		
		List<Employee>employees = employeeService.showAll();
		theModel.addAttribute("employees", employees);
				
		return "/employees/employee-list";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		theModel.addAttribute("employee", new Employee());
		
		return "/employees/employee-form";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("employee")Employee theEmployee) {
		
		employeeService.save(theEmployee);
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(Model theModel, @RequestParam("id")int theId) {
		
		Employee theEmployee = employeeService.findById(theId);
		theModel.addAttribute("employee", theEmployee);
				
		return "/employees/employee-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id")int theId) {
		employeeService.delete(theId);
		
		return "redirect:/employees/list";
	}
}
