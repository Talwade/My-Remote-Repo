package com.flp.ems.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.flp.ems.domain.Employee;
import com.flp.ems.service.EmployeeServiceImpl;
import com.flp.ems.util.Validate;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class UserInteraction {

	// Validate valid = new Validate();

	private static int Empployeeid;
	private int Kin_id;
	private static String myemp;
	private static String mykin;
	private static Pattern pat = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
	 
	private static String Email_id;
	private static String Name;
	private static String Phone_no;
	private static boolean namevalid;
	private String Address;
	private static int Project_id, Role_id;
	//private static String number;

	private static String Dateofjoining;
	private String Dateofbirth;
	private static int Dept_id;
	private static int countofemp;
	static Map<String, Object> mapStudent = new HashMap<String, Object>();
	private static String dept, proj, role;
	//private static int Data;
	private boolean flag = false;
	private static String names,emails;
	private int kids;
	private static boolean loopAgain = true;
	private int choice;
	Scanner scan = new Scanner(System.in);
	// EmployeeServiceImpl eservice=new EmployeeServiceImpl();
	static EmployeeServiceImpl emp = new EmployeeServiceImpl();

	public Employee AddEmployee() {
		

		// loop while user not entering no
		do {
			System.out.print("Enter Name of employee");
			Name = scan.next();
			System.out.println("Enter kin id");
			Kin_id = scan.nextInt();
			// mykin = String.valueOf(Kin_id);
			System.out.println("Enter email id of employee");
			Email_id = scan.next();
			System.out.println("Enter phone number");
			Phone_no = scan.next();
			System.out.println("Enter employee dob dd/mm/yyyy");
			Dateofbirth = scan.next();
			System.out.println("Enter the doj dd/mm/yyyy");
			Dateofjoining = scan.next();
			Random r = new Random();
			Empployeeid = r.nextInt(9999 - 1000) + 1000;
			//myemp = String.valueOf(Empployeeid);
			System.out.println("Select  department  \n1.Financial department \n2.Non-financial \n3.Exit ");

			int choice;
			char opt, opt1 ;
			System.out.println("enter your choice");
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("In Financial dept");
				dept = "Financial Department";
				System.out.println("Enter your project from FS \na.Banking Sector \nb. Capital Markets");
				System.out.println("enter option");
				opt = scan.next().charAt(0);

				switch (opt) {
				case 'a':

					proj = "Banking Sector";
					System.out.println("Employee project is\n" + proj);
					System.out.println("Enter your role");
					role = scan.next();

					break;

				case 'b':
					System.out.println("");
					proj = "Capital Market";
					System.out.println("Employee project" + proj);
					System.out.println("Enter your role");
					role = scan.next();
					System.out.println("" + role);
					break;

				}

				break;
			case 2:

				System.out.println("Nonfinancial dept \na.SAP \nb. ORACLE \nc. Exit");
				dept = "Nonfinancial Department";
				System.out.println("enter option ");
				opt1 = scan.next().charAt(0);
				switch (opt1) {
				case 'a':

					System.out.println("SAP dept selected");

					break;
				case 'b':
					System.out.println("ORACLE");
					break;

				case 'c':
					break;

				}

				break;

			}

			System.out.print("Enter more info (y/n)?");
			String answer = scan.next();

			// condition to satisfy in order to loop again
			if (answer.contains("y") || answer.contains("Y")) {

				// printhashmap();
				continue;
			} else if (answer.contains("n") || answer.equals("N")) {

				validdate(Dateofjoining);
				showmap();

			}

			break;
		} while (loopAgain);
		return emp.AddEmployee((HashMap)mapStudent);

		/*
		 * System.out.println("\n**********************************");
		 * System.out.println("EMS"); System.out.println( "   KINID  " +
		 * "     EMAILID " + "	NAME " + "   DEPARTMENT  " + "		PROJECT  "+
		 * "        ROLE "); for (int id : mapStudent.keySet()) {
		 * System.out.println("   " + kinid + "     " + mapStudent.get(kinid) +
		 * "   " +mailid +mapStudent.get(mailid) +"   " +name+
		 * mapStudent.get(name) +"  "+dept+mapStudent.get(dept)+"  "
		 * +proj+mapStudent.get(proj)+ "   "+role+mapStudent.get(role)); }
		 * System.out.println("\n**********************************");
		 */

	}

	private boolean validdate(String doj) {

		Matcher mtch = pat.matcher(doj);
		if (mtch.matches()) {
			System.out.println("valid date");
			
			return true;
		}
		System.out.println("invalid date enter again");
		loopAgain = true;

		return false;

	}

	private void showmap() {

		mapStudent.put("Employeeid", Empployeeid);
		mapStudent.put("Kinid", Kin_id);
		mapStudent.put("Name", Name);
		mapStudent.put("Phone", Phone_no);
		mapStudent.put("Emailid", Email_id);
		mapStudent.put("DOJ", Dateofjoining);
		mapStudent.put("DOB", Dateofbirth);
		mapStudent.put("Dept", dept);
		mapStudent.put("Project", proj);
		mapStudent.put("Role", role);
		System.out.println(" " + mapStudent + " ");

		emp.AddEmployee((HashMap) mapStudent);

	}

	public Employee ModifyEmployee() {
		String name,emailid;
		System.out.println("enter name");
		name=scan.next();
		System.out.println("enter email");
		emailid=scan.next();
		System.out.println("enter kin id");
		kids=scan.nextInt();
		
		Employee e=emp.SearchEmployee(name,emailid,kids);
		if(e!=null)
		{
			
				Map<String,Object> modify=new HashMap<String,Object>();
				System.out.println("modify employee");
				System.out.println("1.modify name \n2.modify email" );
				
				System.out.println("enter your choice");
				int ch=scan.nextInt();
				switch(ch)
				{
				case 1:
					System.out.println("enter name");
					modify.put("Name",scan.next());
					emp.ModifyEmployee(modify,name,emailid,kids,ch);
					break;
					
				case 2:
					System.out.println("enter email");
					modify.put("Email_Id", scan.next());
					emp.ModifyEmployee(modify,name,emailid,kids,ch);
					break;
					
				
			}
		}
		return null;
		
/*System.out.println("enter kinid");
int empid;
empid=scan.nextInt();
Employee e=emp.SearchEmployee(empid);

if(e!=null){
	
		Map<String,Object> empModifiedDetails=new HashMap<String,Object>();
		System.out.println("Enter the option to modify");
		System.out.println("1.Modify By Name:");
		System.out.println("2.Modify By Email:");
		System.out.println("Enter ur choice:"); 	
		
		choice=scan.nextInt();
		switch(choice)
		{
	
		case 1:System.out.println("Enter The name");
		empModifiedDetails.put("Name", scan.next());
		emp.ModifyEmployee(empModifiedDetails,empid,choice);
		break;
	case 2:
		System.out.println("Enter The email");
		empModifiedDetails.put("Emailid", scan.next());
		emp.ModifyEmployee(empModifiedDetails,empid,choice);
		break;		
		}
 
	}

return null;
		
	}
*/
	
		
	}
	boolean RemoveEmployee() {

		
		System.out.println("enter the kin to remove");
		kids=scan.nextInt();
		return emp.RemoveEmployee(kids);
	}

	/*public Employee SearchEmployee() {

		System.out.println("enter the id to search");
		int empid = scan.nextInt();
		//return emp.SearchEmployee(names);

		return emp.SearchEmployee(empid);
	}
*/
	public Employee  SearchEmployee() {
		System.out.println("Enter option \n 1.name only \n2.email id \n3.kinid  \n4.name & email \n5.name & kinid \n6.email and kinid \n7.name email and kinid three");
		int opt = scan.nextInt();
		switch(opt)
		{
		case 1:
			
			System.out.println("Enter Name to be searched");
			names=scan.next();
			return emp.SearchEmployee(names,"*",0);
			
	
		case 2:
			System.out.println("enter email to be searched");
		emails =scan.next();
		 return emp.SearchEmployee("*",emails,0);
		 
		
		case 3:
			
			System.out.println("enter kin id to be searched");
			 kids=scan.nextInt();
			 return emp.SearchEmployee("*","*",kids);
		
		
		
		case 4:
			System.out.println("enter email and name to be searched");
			System.out.println("Enter Name to be searched");
			names=scan.next();
			System.out.println("enter email to be searched");
			emails=scan.next();
			
			return emp.SearchEmployee(names,emails,0);
			
		
		case 5:
			System.out.println("enter  name  and kin id to be searched");
			System.out.println("Enter Name to be searched");
			names=scan.next();
			System.out.println("enter email to be searched");
			kids=scan.nextInt();
			
			return emp.SearchEmployee(names,"*",kids);
			
			
			
		case 6:
			System.out.println("enter email and kinidto be searched");
			System.out.println("Enter email to be searched");
			emails=scan.next();
			System.out.println("enter kinid to be searched");
			kids=scan.nextInt();
			
			return emp.SearchEmployee("*",emails,kids);
			 
			
		case 7:
			System.out.println("enter name, email id and kinid to be searched");
			System.out.println("Enter name to be searched");
			names=scan.next();
			System.out.println("Enter email to be searched");
			emails=scan.next();
			System.out.println("enter kinid to be searched");
			kids=scan.nextInt();
			
			return emp.SearchEmployee(names,emails,kids);
			
			
		}	
		return null;
		
	}
	public void getAll() {
		boolean val;
		if (val = mapStudent.isEmpty()) {
			/* System.out.println("Empty"); */
			System.out.println("Map empty " + val);
		} 
		//return emp.getAllEmployee();

		// printhashmap();

	}
}
