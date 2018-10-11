package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IEmployeeDao;
import com.app.model.Employee;
/**
 * 
 * @author Surya Vattikuti
 * @version 1.0
 * @since 10-10-2018
 */

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {
	
	@Autowired
	private HibernateTemplate ht;
	
	//save the employee in database
	@Override
	public Integer saveEmployee(Employee employee) {
		return (Integer) ht.save(employee);
	}//saveEmployee(-)

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEmployee(Integer empId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Employee getOneEmployee(Integer empId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//get All Employee records
	@Override
	public List<Employee> getAllEmployees() {
		return ht.loadAll(Employee.class);
	}

}
