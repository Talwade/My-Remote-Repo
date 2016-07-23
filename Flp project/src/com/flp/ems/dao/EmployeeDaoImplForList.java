package com.flp.ems.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.flp.ems.domain.Department;
import com.flp.ems.domain.Employee;
import com.flp.ems.domain.Project;
import com.flp.ems.domain.Role;
import com.flp.ems.util.Validate;

public class EmployeeDaoImplForList implements IemployeeDao {
	List<Employee> employees = new ArrayList<Employee>();
	/*
	 * List<Department> department=new ArrayList<Department>(); List<Project>
	 * projects=new ArrayList<Project>(); List<Role> role=new ArrayList<Role>();
	 */
	Set<Employee> hs = new HashSet<Employee>();

	Employee e = new Employee();

	private static String name, kinid, empid;

	Scanner scan = new Scanner(System.in);

	public void AddEmployee(Employee e) {
		// TODO Auto-generated method stub

		employees.add(e);
		/*
		 * department.addAll(e.getDepartment_Id());
		 * projects.add(e.getProject()); role.add(e.getRole());
		 */
		System.out.println("List-> " + employees);
		// return e;

	}

	@Override
	public Employee ModifyEmployee(Map empdetails, String name, String email, int kinid, int empid) {

		boolean flags;
		Employee emp = SearchEmployee(name, email, kinid);

		int index = employees.indexOf(emp);

		RemoveEmployee(kinid);
		switch (empid) {

		case 1:
			String value;

			emp.setName((String) empdetails.get("Name"));
			value = emp.getName();

			if (Validate.isvalidname(value)) {
				System.out.println("valid name");
				employees.add(index, emp);
				flags = true;

			}

			flags = false;
			System.out.println("invalid name or not found..");
			// if(emp.getName((String) empdetails.get("Name"))

			break;
		case 2:
			emp.setEmail_Id((String) empdetails.get("Emailid"));
			employees.add(index, emp);
			break;
		}
		return e;

	}

	public boolean RemoveEmployee(int empid) {

		if (employees.isEmpty()) {
			System.out.println("no data to remove");

		}
		Iterator<Employee> it = employees.iterator();
		while (it.hasNext()) {
			Employee inte = it.next();
			if (inte.getKin_Id() == empid) {

				it.remove();

				System.out.println("\nData removed..Select getAllEmployee.. to see the changes");
				employees.clear();
				// System.out.println(employees);
				break;
			}

			System.out.println("something wrong");
		}

		
		return false;

	}

	
	@Override
	public Employee SearchEmployee(String name, String email, int kinid) {
		if (employees.isEmpty()) {
			System.out.println("no data to search..first add record ");
		}

		for (Employee e : employees) {
			if (e.getName().equals(name)) {
				System.out.println("match found for name provided");
                  return e;
				
			//	return e;

			}

				else if (e.getEmail_Id().equals(email)) {
				System.out.println("match found for email id provided ");
				return e;

			} else if (e.getKin_Id() == kinid) {
				System.out.println(" match found for kin id provided");
				return e;
			}

			else if (e.getName().equals(name) && e.getEmail_Id().equals(email) && e.getKin_Id() == kinid) {
				System.out.println("match found for name,email id and kin id provided");

				return e;

			} else if (e.getName().equals(name) && e.getEmail_Id().equals(email)) {
				System.out.println("match found for name,email id provided");
				return e;

			} else if (e.getEmail_Id().equals(email) && e.getKin_Id() == kinid) {
				System.out.println("match found for email id and kin id provided");

				return e;

			} else if (e.getName().equals(name) && e.getKin_Id() == kinid) {
				System.out.println("match found for name and kin id provided");

				return e;

			}

			System.out.println("Not found");
			break;
		}

		return null;
	}

	/*
	 * for (Object list : employees) { System.out.println(list); }
	 */

	@Override
	public void getAllEmployee() {
		// TODO Auto-generated method stub

		hs.addAll(employees);
		employees.clear();
		employees.addAll(hs);
		Iterator<Employee> itr = employees.iterator();
		while (itr.hasNext()) {
			Object element = itr.next();
			// Employee element=itr.next();
			System.out.print(element + " ");
		}
		System.out.println("");
		// System.out.println("Empty List returned");
		// System.out.println("Kin_id =null,Phone=null,Name: null, Email:null,
		// DOB=null,
		// DOJ=null,Employee_id=null,Department=null,Project=null,Role=null");
	}

	@Override
	public boolean RemoveEmployee(int id, Employee e) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * @Override public void AddEmployee() { // TODO Auto-generated method stub
	 * 
	 * }
	 */

}
