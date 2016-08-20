package com.flp.ems.service;

import java.util.List;


import com.flp.ems.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flp.ems.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl  implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;

	@Transactional
	public void saveEmployee(Employee employee) {
		
		employeeDao.saveEmployee(employee);
	}

	@Transactional
	public List<Employee> getAllEmployees() {
		
		return employeeDao.getAllEmployees();
	}

	@Transactional
	public void deleteEmployee(int employeeId) {
		
		employeeDao.deleteEmployee(employeeId);
	}
	@Transactional
	public Employee findById(int id){
		return employeeDao.findById(id);
	}
	@Transactional
	public void updateEmployee(Employee emp){
		employeeDao.updateEmployee(emp);
	}

	@Transactional
	public Employee getEmployee(int empid) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployee(empid);
	}
}
