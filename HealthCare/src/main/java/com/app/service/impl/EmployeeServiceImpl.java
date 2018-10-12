package com.app.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IEmployeeDao;
import com.app.model.Employee;
import com.app.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private IEmployeeDao dao;

	@Override
	@Transactional
	public Integer saveEmployee(Employee employee) {
		return dao.saveEmployee(employee);
	}//saveEmployee(-)

	@Override
	@Transactional
	public void updateEmployee(Employee employee) {
		
	}

	@Override
	@Transactional
	public void deleteEmployee(Integer empId) {
		dao.deleteEmployee(empId);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Employee getOneEmployee(Integer empId) {
		return dao.getOneEmployee(empId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Employee> getAllEmployees() {
		List<Employee> listEmps=dao.getAllEmployees();
		//sorting desc order
		Collections.sort(listEmps,(o1,o2)->o2.getEmpId()-o1.getEmpId());
		return listEmps;
	}

}
