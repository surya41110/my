package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.Employee;
import com.app.service.IEmployeeService;


@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;
	@RequestMapping(value="/home")
	public String HomePage() {
		return "home";
	}
	
	@RequestMapping(value="/register")
	public String showEmployeeRegPage(ModelMap map) {
		map.addAttribute("employee",new Employee());
		return "RegisterEmployee";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String registerEmployee(@ModelAttribute Employee employee,
			ModelMap map) {
		Integer empId=service.saveEmployee(employee);
		String msg="Employee Record Saved with Id  "+empId+"....";
		map.addAttribute("message", msg);
		map.addAttribute("employee", new Employee());
		return "RegisterEmployee";
	}
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public String showEmployees(ModelMap map) {
		List<Employee> listEmps=service.getAllEmployees();
		map.addAttribute("listEmps", listEmps);
		return "AllEmployees";
	}

}