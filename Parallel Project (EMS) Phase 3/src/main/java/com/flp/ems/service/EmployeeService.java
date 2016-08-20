package com.flp.ems.service;

import java.util.List;

import com.flp.ems.domain.Employee;

public interface EmployeeService {
	public void saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public void deleteEmployee(int employeeId);
	public Employee findById(int id);
	public void updateEmployee(Employee emp);
	public Employee getEmployee(int empid);
}
