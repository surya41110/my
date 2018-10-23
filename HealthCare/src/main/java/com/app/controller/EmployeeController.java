package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Employee;
import com.app.service.IEmployeeService;
import com.app.view.EmployeeExcelView;
import com.app.view.EmployeePdfView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;

	@RequestMapping(value = "/home")
	public String HomePage() {
		return "home";
	}

	@RequestMapping(value = "/register")
	public String showEmployeeRegPage(ModelMap map) {
		map.addAttribute("employee", new Employee());
		return "RegisterEmployee";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String registerEmployee(@ModelAttribute Employee employee, ModelMap map) {
		Integer empId = service.saveEmployee(employee);
		String msg = "Employee Record Saved with Id  " + empId + "....";
		map.addAttribute("message", msg);
		map.addAttribute("employee", new Employee());
		map.addAttribute("empId", empId);
		return "RegisterEmployee";
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String showEmployees(ModelMap map) {
		List<Employee> listEmps = service.getAllEmployees();
		map.addAttribute("listEmps", listEmps);
		return "AllEmployees";
	}

	@RequestMapping(value = "/delete")
	public String deleteEmployee(@RequestParam("id") Integer empId, ModelMap map) {
		service.deleteEmployee(empId);
		String msg = "Employee Record Deleted with Id  " + empId + "....";
		map.addAttribute("message", msg);
		List<Employee> listEmps = service.getAllEmployees();
		map.addAttribute("listEmps", listEmps);
		return "AllEmployees";
	}


	@RequestMapping(value="/get",method=RequestMethod.GET)
	public String showEmployee(@RequestParam("id") Integer empId,ModelMap map) {
		Employee emp=service.getOneEmployee(empId);
		map.addAttribute("emp", emp);
		return "OneEmployee";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String showEmployeeEdit(@RequestParam("id") Integer empId,ModelMap map) {
		Employee emp=service.getOneEmployee(empId);
		map.addAttribute("employee", emp);
		return "EditEmployee";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateEmployeeData(@ModelAttribute Employee employee, ModelMap map) {
		List<Employee> listEmps = null;
		String msg =null;
		service.updateEmployee(employee);
		msg = "Employee Record Updated with Id  " + employee.getEmpId() + "....";
		map.addAttribute("message", msg);
		listEmps=service.getAllEmployees();
		map.addAttribute("listEmps", listEmps);
		return "AllEmployees";
	}
	
	
	@RequestMapping("/excel")
	public ModelAndView showExcel(){
		ModelAndView mav=null;
		mav =new ModelAndView();
		List<Employee> emps=service.getAllEmployees();
		mav.setView(new EmployeeExcelView());
		mav.addObject("emps", emps);
		return mav;
	}
	
	@RequestMapping("/pdf")
	public ModelAndView showPdf(){
		ModelAndView mav=null;
		mav =new ModelAndView();
		List<Employee> emps=service.getAllEmployees();
		mav.setView(new EmployeePdfView());
		mav.addObject("emps", emps);
		return mav;
	}
}
