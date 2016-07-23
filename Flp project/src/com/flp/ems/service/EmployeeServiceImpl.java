package com.flp.ems.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.flp.ems.dao.EmployeeDaoImplForDB;
import com.flp.ems.dao.EmployeeDaoImplForList;
import com.flp.ems.dao.IemployeeDao;
import com.flp.ems.domain.Department;
import com.flp.ems.domain.Employee;
import com.flp.ems.domain.Project;
import com.flp.ems.domain.Role;
import com.flp.ems.util.Validate;
import com.flp.ems.view.BootClass;
import com.flp.ems.view.UserInteraction;

public class EmployeeServiceImpl implements IEmployeeService {
	EmployeeDaoImplForList edmp = new EmployeeDaoImplForList();
	EmployeeDaoImplForDB edb = new EmployeeDaoImplForDB();
	// EmployeeDao edmp = new EmployeeDaoImplForList();
	// EmployeeServiceImpl eservice=new EmployeeServiceImpl();

	private static String name;
	private static String type;
	private static int ch = 0;
	private static Scanner scan = new Scanner(System.in);

	static UserInteraction uii = new UserInteraction();

	static Set<Integer> hashkin = new HashSet<Integer>();
	static Set<String> hashem = new HashSet<String>();

	@Override
	public void AddEmployee(HashMap mapStudent) throws ClassNotFoundException, SQLException {
		Employee e = new Employee();
		Department d = new Department();
		Project pro = new Project();
		Role role = new Role();

		int val = (int) mapStudent.get("Kinid");
		int eid = (int) mapStudent.get("Employeeid");
		String emls = (String) mapStudent.get("Emailid");
		String dobs = (String) mapStudent.get("DOB");
		String dojs = (String) mapStudent.get("DOJ");
		String depts = (String) mapStudent.get("Dept");
		String projs = (String) mapStudent.get("Project");
		// Employee e1=new Employee();
		/*
		 * if(mapStudent.get("Name")==" ") { System.out.println(
		 * "invalid null name");
		 * 
		 * }
		 */
		boolean f1, f2, f3, flag = false;

		// f3 = Validate.isvalidEmail((String) mapStudent.get("Emailid"));
		f1 = Validate.isvalidname((String) mapStudent.get("Name"));
		f2 = Validate.isvalidPhone((String) mapStudent.get("Phone"));
		f3 = Validate.isvalidEmail((String) mapStudent.get("Emailid"));

		if (f1 && f2 && f3) {
			System.out.println("valid details(Name,Phone,Email_id)");

		} else {
			System.out.println("invalid details plz check (name,phone,email)");

			BootClass.menuSelection();
		}
		if (hashkin.contains(val)) {
			System.out.println("same kin_Id found");
			System.out.println(hashkin);
			return;
		} else {
			System.out.println("plz add more records..");
			hashkin.add(val);
			// System.out.println(hashkin);
			// hashkin.add(e.setKin_Id((int)mapStudent.get("Kinid")));
		}
		if (hashem.contains(emls)) {
			System.out.println("same email id found");
			return;
		} else {
			hashem.add(emls);
			System.out.println(hashem);
		}

		e.setEmployee_Id((int) mapStudent.get("Employeeid"));
		e.setKin_Id((int) mapStudent.get("Kinid"));
		e.setName((String) mapStudent.get("Name"));
		e.setPhone_No((String) mapStudent.get("Phone"));

		e.setEmail_Id((String) mapStudent.get("Emailid"));

		e.setDOB((String) mapStudent.get("DOB"));
		e.setDOJ((String) mapStudent.get("DOJ"));
		e.setAddress((String)mapStudent.get("add"));
		d.setDepartmentid((int) mapStudent.get("Dept_id"));
		pro.setProj_id((int) mapStudent.get("Project_id"));
		role.setRoleid((int) mapStudent.get("Roleid"));

		
		 /* d.setDepartmentname((String)mapStudent.get("Dept"));
		  d.setDepartmentid((int)mapStudent.get("Dept_id"));
		  pro.setProject_name((String)mapStudent.get("Project"));
		 pro.setProj_id((int)mapStudent.get("Project_id"));
		// pro.setDepartmentid((int)mapStudent.get("Dept_id"));
		  role.setRole_name((String)mapStudent.get("Role"));
		  role.setRoleid((int)mapStudent.get("Role_id"));
		  */

		System.out.println(e.toString());
		
		 System.out.println(d.toString());
		 System.out.println(pro.toString());
		 System.out.println(role.toString());
		 

		// hash.add(e.setKin_Id((int)mapStudent.get("Employeeid"));
		// hash.add(e1.setKin_Id((int)mapStudent.get(""));

		// edmp.AddEmployee(e);
		edb.AddEmployee(e,d,pro,role);

	}

	@Override
	public void ModifyEmployee(Map omap, String name, String email, int kinid, int id)
			throws ClassNotFoundException, SQLException {

		// edmp.ModifyEmployee(omap, name,email,kinid,id);
		edb.ModifyEmployee(omap, name, email, kinid, id);
		// TODO Auto-generated method stub

	}

	public boolean RemoveEmployee(int kinid,Employee e) throws ClassNotFoundException, SQLException {

		
		// String opt;
		// return edmp.RemoveEmployee(kinid);
		return edb.RemoveEmployee(kinid,e);

	}

	public Employee SearchEmployee(String name, String email, int kinid) throws ClassNotFoundException, SQLException {
		//try {

			// return edmp.SearchEmployee(name,email,kinid);
			return edb.SearchEmployee(name, email, kinid);

	//	} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
	//	return null;
	}

	@Override
	public void getAllEmployee() throws ClassNotFoundException, SQLException {
		/*
		 * hs.addAll(employees); employees.clear(); employees.addAll(hs);
		 */

		// edmp.getAllEmployee();
		edb.getAllEmployee();
		// return edmp.getAllEmployee();

	}

}
