package com.flp.ems.dao;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.flp.ems.domain.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveEmployee(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
		
	}
	@Override
	public Employee findById(int id){
		Employee emp=(Employee)sessionFactory.getCurrentSession().get(Employee.class, id);
	    return emp; 
	}
	@Override
	public void updateEmployee(Employee emp){
		sessionFactory.getCurrentSession().update(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
	
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	@Override
	public void deleteEmployee(int employeeId) {
		Employee emp=(Employee)sessionFactory.getCurrentSession().get(Employee.class, employeeId);
		if(emp!=null)
			sessionFactory.getCurrentSession().delete(emp);
		 
	}
	@Override
	public Employee getEmployee(int empid) {
		// TODO Auto-generated method stub
		
		
		return (Employee)sessionFactory.getCurrentSession().get(Employee.class, empid);
	}

}
