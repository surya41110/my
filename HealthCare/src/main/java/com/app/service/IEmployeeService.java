package com.app.service;

import java.util.List;

import com.app.model.Employee;

public interface IEmployeeService {
	public Integer saveEmployee(Employee employee);

	public void updateEmployee(Employee employee);

	public void deleteEmployee(Integer empId);

	public Employee getOneEmployee(Integer empId);

	public List<Employee> getAllEmployees();

}
