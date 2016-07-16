package com.flp.ems.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flp.ems.domain.Employee;

public interface IEmployeeService {

	public void  ModifyEmployee(Map empModifiedDetails,String name,String email,int empId,int kid);
	//void RemoveEmployee();
	Employee SearchEmployee(String name,String email,int  kinid);
	void getAllEmployee();
	Employee AddEmployee(HashMap hm);
	boolean RemoveEmployee(int empid);
	
	
}
