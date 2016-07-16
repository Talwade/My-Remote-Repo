package com.flp.ems.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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

	
	


	public Employee AddEmployee(HashMap mapStudent) {
		Employee e = new Employee();
		/*
		 * if(mapStudent.get("Name")==" ") { System.out.println(
		 * "invalid null name");
		 * 
		 * }
		 */
		boolean f1, f2, f3;

		// f3 = Validate.isvalidEmail((String) mapStudent.get("Emailid"));
		f1 = Validate.isvalidname((String) mapStudent.get("Name"));
		f2 = Validate.isvalidPhone((String) mapStudent.get("Phone"));
		// f3 = Validate.isvalidEmail((String) mapStudent.get("Emailid"));
		if (f1 && f2) {
			System.out.println("valid details(Name,Phone,Email_id)");
		} else {
			System.out.println("invalid details.....");
			// System.exit(0);
		}
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
		edmp.AddEmployee(e);
		// BootClass.menuSelection();
		return edmp.AddEmployee(e);

	}

	@Override
	public void ModifyEmployee(Map omap, String name,String email,int kinid,int id) {

		edmp.ModifyEmployee(omap, name,email,kinid,id);
		// TODO Auto-generated method stub

	}

	@Override
	public boolean RemoveEmployee(int kinid) {

		// String opt;
		return edmp.RemoveEmployee(kinid);
		// edmp.AddEmployee(e);
		// edmp.RemoveEmployee();
		/*
		 * for (Iterator<String> iter = employees.listIterator();
		 * iter.hasNext(); ) { String a = iter.next();
		 * 
		 * iter.remove();
		 * 
		 * }
		 */
		/*
		 * System.out.println(
		 * "Enter the detail to remove \n1.Kin_id \n2. Name \n3.Email  \n4. Date of Birth  \n5.  Date of Joining  \n6.Department \n7. Project_Id \n8. Role_Id  "
		 * ); ch=scan.nextInt(); //System.out.println(
		 * "press yes/no to remove kin_id"); //opt=scan.next(); switch(ch) {
		 * case 1:
		 * 
		 * employees.remove(1); System.out.println("removed kinid from list");
		 * break;
		 * 
		 * case 2: employees.remove(2); System.out.println("Name removed");
		 * break;
		 * 
		 * case 3: employees.remove(3); System.out.println("Email removed");
		 * break;
		 * 
		 * case 4: employees.remove(4); System.out.println("DOB  removed");
		 * break;
		 * 
		 * case 5: employees.remove(5); System.out.println("DOJ removed");
		 * break; case 6: employees.remove(6); System.out.println(
		 * "Department removed"); break;
		 * 
		 * 
		 * case 7: employees.remove(7); System.out.println("Project removed");
		 * break; case 8: employees.remove(8); System.out.println(
		 * "Role_id removed"); break;
		 * 
		 * default:break; }
		 */

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
