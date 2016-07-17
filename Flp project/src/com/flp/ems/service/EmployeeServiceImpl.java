package com.flp.ems.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.flp.ems.dao.EmployeeDaoImplForList;
import com.flp.ems.dao.IemployeeDao;
import com.flp.ems.domain.Employee;
import com.flp.ems.util.Validate;
import com.flp.ems.view.BootClass;
import com.flp.ems.view.UserInteraction;

public class EmployeeServiceImpl implements IEmployeeService {
	EmployeeDaoImplForList edmp=new EmployeeDaoImplForList();

	//EmployeeDao edmp = new EmployeeDaoImplForList();
	// EmployeeServiceImpl eservice=new EmployeeServiceImpl();

	private static String name;
	private static String type;
	private static int ch = 0;
	private static Scanner scan = new Scanner(System.in);

	static UserInteraction uii = new UserInteraction();

	static Set<Employee> hash=new HashSet<Employee>();
	


	public Employee AddEmployee(HashMap mapStudent) {
		Employee e = new Employee();
		
		/*
		 * if(mapStudent.get("Name")==" ") { System.out.println(
		 * "invalid null name");
		 * 
		 * }
		 */
		boolean f1, f2, f3,flag=false;

		// f3 = Validate.isvalidEmail((String) mapStudent.get("Emailid"));
		f1 = Validate.isvalidname((String) mapStudent.get("Name"));
		f2 = Validate.isvalidPhone((String) mapStudent.get("Phone"));
		// f3 = Validate.isvalidEmail((String) mapStudent.get("Emailid"));
		if (f1 && f2) {
			System.out.println("valid details(Name,Phone,Email_id)");
			
		} else {
			System.out.println("invalid");
			//discard();
	//flag=true;
	
			 //System.exit(0);
			 BootClass.menuSelection();
		}
		//mapStudent.clear();
		// Validate.isvalidname((String)mapStudent.get("Name"));
		e.setEmployee_Id((int)mapStudent.get("Employeeid"));
		e.setKin_Id((int) mapStudent.get("Kinid"));
		e.setName((String) mapStudent.get("Name"));
		e.setPhone_No((String) mapStudent.get("Phone"));
		
		e.setEmail_Id((String) mapStudent.get("Emailid"));

		e.setDOB((String) mapStudent.get("DOB"));
		e.setDOJ((String) mapStudent.get("DOJ"));
		e.setDepartment_Id((String) mapStudent.get("Dept"));
		e.setProject_Id((String) mapStudent.get("Project"));
		e.setRoles_Id((String) mapStudent.get("Role"));

		/* e.setEmail_Id((String) mapStudent.get("Emailid")); */
		System.out.println(e.toString());
		
		//hash.add("Emailid");
		
		//hasduplicates();
		
		//e.equals(mapStudent);
		hash.add(e);
		
		//e.equals(e);
		//edmp.AddEmployee(e);
	//	e.hashCode();
		//e.equals((int) mapStudent.get("Kinid"));
		// BootClass.menuSelection();
		return edmp.AddEmployee(e);

	}

	

	



	@Override
	public void ModifyEmployee(Map omap, String name,String email,int kinid,int id) {

		edmp.ModifyEmployee(omap, name,email,kinid,id);
		// TODO Auto-generated method stub

	}

	public boolean RemoveEmployee(int kinid) {

		// String opt;
		return edmp.RemoveEmployee(kinid);
		
	}

	public Employee SearchEmployee(String name,String email,int  kinid) {

		return edmp.SearchEmployee(name,email,kinid);

	}

	@Override
	public
	void  getAllEmployee() {

		edmp.getAllEmployee();
		//return edmp.getAllEmployee();

	}

	

}
