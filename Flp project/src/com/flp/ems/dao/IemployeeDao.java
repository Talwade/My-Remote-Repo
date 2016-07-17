package com.flp.ems.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flp.ems.domain.Employee;

public interface IemployeeDao {

	void ModifyEmployee(Map empModifiedDetails,String val,String val1,int empId,int val2);
	//void RemoveEmployee(String value);
	boolean RemoveEmployee(int empids);
	Employee SearchEmployee(String val,String val1,int val2);
	void getAllEmployee();
	Employee AddEmployee(Employee e);
}
