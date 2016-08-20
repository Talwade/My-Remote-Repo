package com.flp.ems.dao;

import java.util.List;

import com.flp.ems.domain.Employee;





public interface EmployeeDao {

	public void saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee findById(int id);
	public void updateEmployee(Employee emp); 
	public void deleteEmployee(int employeeId);
	public Employee getEmployee(int empid);
}
