package com.flp.ems.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flp.ems.domain.Employee;

public interface IEmployeeService {

	public void  ModifyEmployee(Map empModifiedDetails,String name,String email,int empId,int kid) throws ClassNotFoundException, SQLException;
	//void RemoveEmployee();
	Employee SearchEmployee(String name,String email,int  kinid) throws ClassNotFoundException, SQLException;
	void getAllEmployee() throws ClassNotFoundException, SQLException;
	//Employee AddEmployee(HashMap hm);
	void AddEmployee(HashMap hm) throws ClassNotFoundException, SQLException;
	boolean RemoveEmployee(int empid,Employee e) throws ClassNotFoundException, SQLException;
	
	
}
