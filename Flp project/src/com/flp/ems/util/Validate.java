package com.flp.ems.util;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class Validate {
	private String Email_id;
	//public static String Name;
	private static String Phone_no;
	private String Address;
	private static int Project_id, Role_id;
	private static String number;
	private static String newname;
	private static String Dateofjoining;
	private String Dateofbirth;
	private static int Dept_id;
	private static int countofemp;
	private static String dept, proj, role;
	private static boolean flag;
	private static int Data;
	private static int Empployeeid, Kin_id;
	private static Pattern pattern;
	private static Matcher matcher;

	/*public Validate() {
		
		pattern = Pattern.compile(EMAIL_PATTERN);
		
		//super();
	}*/

/*	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

*/
	public static  boolean isvalidname(String name) {
		
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9].$");
		Matcher matcher = pattern.matcher(name);
		
		
		if(name.equals(""))//&& !matcher.matches()) 
			return false;
		//System.out.println("Name must be alphanumeric");
return true;
		
	}

	static boolean isvalidkin() {

		
		
		return true;

	}

	public static boolean isvalidPhone(String phone) {

		//isInt(phone);

		if (phone.equals("")) {
			System.out.println("plz enter number");
		} else if (phone.length() > 10) {
			return false;

		} else if (phone.length() < 10) {
			return false;
		} else {

		return true;
		}

		return false;

	}

	/*public static boolean isInt(String phones) {

		try {
			long i = Long.parseLong(phones);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}

	}*/

	public static boolean isvalidEmail(String mail) {
		
		 String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
			java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
			java.util.regex.Matcher m = p.matcher(mail);
			return m.matches();
	}
	
	public static boolean isvalidDate(String dat)
	{
	
		if (dat.matches("\\d{2}-\\d{2}-\\d{4}")) {
		    
			return true;
			
		}else
		{
			return false;
		}
		
	}
	
	
	
	
	
	
}
