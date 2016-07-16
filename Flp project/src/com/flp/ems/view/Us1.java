package com.flp.ems.view;

import java.util.HashMap;
import java.util.Scanner;

import com.flp.ems.service.EmployeeServiceImpl;
import com.flp.ems.util.Validate;

public class Us1 {

	private String Name;
	private  String Kin_Id;
	 private String Email_Id;
	 private String Phone_No;
	 private String DOB;
	 private String DOJ;
	 boolean a,b,c,d;
	 
		
	 

		Scanner sc=new Scanner(System.in);
		 HashMap<String,String> hm=new HashMap<String,String>();

		void AddEmployee() {
	    

		System.out.println("Enter name");
		Name=sc.next();
		
		System.out.println("enter phone no");
		Phone_No=sc.next();
		
		System.out.println("Enter Email_Id");
		Email_Id=sc.next();
		
		System.out.println("Enter date of joining");
		DOJ=sc.next();
		
		System.out.println("Enter date of birth");
		DOB=sc.next();
		a=Validate.isvalidname(Name);
	//	b=Validate.isvalidEmail(Email_Id);
		c=Validate.isvalidPhone(Phone_No);
	//	d=Validate.is(DOJ,"dd/MM/yyyy");
	  if(a&&b&&c)
	  {
		System.out.println("valid");  
	  }
	  else
	  {
		  System.out.println("invalid");
	  }
	   
				
	hm.put("Name",Name);
	hm.put("Phone", Phone_No);
	hm.put("Email_Id",Email_Id);
	hm.put("Date of birth",DOB);
	hm.put("Date of joining", DOJ);
	System.out.println(hm);
	EmployeeServiceImpl es=new EmployeeServiceImpl();
	es.AddEmployee(hm);





				
				
				
				
			
		}

		

		void ModifyEmployee() {

		}

		void RemoveEmployee() {

		}

		void SearchEmployee() {

		}

		void getAllEmployee() {

		

		}
	
	
	
}
