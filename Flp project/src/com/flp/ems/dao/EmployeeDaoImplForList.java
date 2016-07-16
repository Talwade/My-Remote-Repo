
package com.flp.ems.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;

import com.flp.ems.domain.Employee;

public class EmployeeDaoImplForList implements IemployeeDao {
	List<Employee> employees = new ArrayList<Employee>();
	Employee e = new Employee();

	private static String name, kinid, empid;

	Scanner scan = new Scanner(System.in);

	
	public Employee AddEmployee(Employee e) {
		// TODO Auto-generated method stub
		employees.add(e);
		System.out.println("List-> " + employees);
		return e;

	}

	@Override
	public void ModifyEmployee(Map empdetails,String name,String email,int kinid,int empid) {

		Employee emp = SearchEmployee(name,email,kinid);
		
		int index = employees.indexOf(emp);

		RemoveEmployee(kinid);
		switch (empid) {

		case 1:
			emp.setName((String) empdetails.get("Name"));
			employees.add(index, emp);
			break;
		case 2:
			emp.setEmail_Id((String) empdetails.get("Emailid"));
			employees.add(index, emp);
			break;
		}

	}

	public boolean RemoveEmployee(int empid) {
		for (Employee e : employees) {

			if (e.getEmployee_Id() == empid) {
				employees.remove(e);			
				return true;
			}

		}
		/*
		 * employees.remove(e); System.out.println("Data removed");
		 * System.out.println(employees);
		 */
		return false;

	}


/*public Employee SearchEmployee(int empid) {

		for (Employee e : employees) {

			if (e.getKin_Id() == empid) {
System.out.println("in search dao");
				return e;
			} 

		}

		return null;

	}*/
	@Override
	public Employee SearchEmployee(String name,String email,int kinid) {
		for(Employee e:employees)
		{
			 if(e.getName().equals(name))
			{
				System.out.println("match found for name provided");
			
				return e;
				
			}
			  
			  else if( e.getEmail_Id().equals(email))
				{
					System.out.println("match found for email id provided ");
					return e;
					
				}
			  else if( e.getKin_Id()==kinid)
				{
					System.out.println(" match found for kin id provided");
				return e;
				}	
				
				else if(e.getName().equals(name) && e.getEmail_Id().equals(email) && e.getKin_Id()==kinid)
			{
				System.out.println("match found for name,email id and kin id provided");
			
				return e;
				
			}
			 else if(e.getName().equals(name) && e.getEmail_Id().equals(email))
				{
					System.out.println("match found for name,email id provided");
				return e;
				
					
				}
			 else if( e.getEmail_Id().equals(email) && e.getKin_Id()==kinid)
				{
					System.out.println("match found for email id and kin id provided");
				
				return e;
					
				}
			 else if(e.getName().equals(name)  && e.getKin_Id()==kinid)
				{
					System.out.println("match found for name and kin id provided");
				
				return e;
					
				}
			
			
			 
			  
			
			
			
		}
		
		System.out.println("Searching done.........");
		
		return null;
	}


	/*for (Object list : employees) {
			System.out.println(list);
		}
		*/
		 
		@Override
		public void getAllEmployee() {
			// TODO Auto-generated method stub
			Iterator<Employee> itr = employees.iterator();
		    while (itr.hasNext()) {
		      Object element = itr.next();
		      System.out.print(element + " ");
		    }
		    System.out.println();
		}


	

	

	/*
	 * @Override public void AddEmployee() { // TODO Auto-generated method stub
	 * 
	 * }
	 */

}
