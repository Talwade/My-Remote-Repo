package com.flp.ems.domain;

public class Employee {
	private int Employee_Id;
	private String Name;
	private int Kin_Id;
	private String Email_Id;
	private String Phone_No;
	private String DOB;
	private String DOJ;
	private String Address;
	private String Department_Id;
	private String address;
	public String getDepart_Name() {
		return Depart_Name;
	}

	public void setDepart_Name(String depart_Name) {
		Depart_Name = depart_Name;
	}

	private String Depart_Name;
	private String Project_Id;
	private String Roles_Id;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name=name;

	}

	public int getKin_Id() {
		return Kin_Id;
	}

	public int setKin_Id(int kin_Id) {
		return Kin_Id = kin_Id;
	}

	public String getEmail_Id() {
		return Email_Id;
	}

	public String setEmail_Id(String email_Id) {
		return Email_Id = email_Id;
	}

	public String getPhone_No() {
		return Phone_No;
	}

	public void setPhone_No(String phone_No) {
		Phone_No = phone_No;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getDOJ() {
		return DOJ;
	}

	public void setDOJ(String dOJ) {
		DOJ = dOJ;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getDepartment_Id() {
		return Department_Id;
	}

	public void setDepartment_Id(String department_Id) {
		Department_Id = department_Id;
	}

	public int getEmployee_Id() {
		return Employee_Id;
	}

	public void setEmployee_Id(int employee_Id) {
		Employee_Id = employee_Id;
	}

	public String getProject_Id() {
		return Project_Id;
	}

	public void setProject_Id(String project_Id) {
		Project_Id = project_Id;
	}

	public String getRoles_Id() {
		return Roles_Id;
	}

	public void setRoles_Id(String roles_Id) {
		Roles_Id = roles_Id;
	}

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Email_Id == null) ? 0 : Email_Id.hashCode());
		result = prime * result+Kin_Id;
		return result;
		System.out.println("in hash code");
		
		int result=1;
		result=prime*result+((Email_Id==null) ? 0: Email_Id.hashCode());
		result=prime*result+Kin_Id;
		//Systprime.out.println(" hash value is "+ 31+Kin_Id);
		return result;
	}
*/
	/*@Override
	public String toString() {
		return "Employee [Employee_Id=" + Employee_Id + ", Name=" + Name + ", Kin_Id=" + Kin_Id + ", Email_Id="
				+ Email_Id + ", Phone_No=" + Phone_No + ", DOB=" + DOB + ", DOJ=" + DOJ + ", Address=" + Address
				+ ", Department_Id=" + Department_Id + ", Project_Id=" + Project_Id + ", Roles_Id=" + Roles_Id + "]";
	}*/

	/*@Override
	public boolean equals(Object obj) {
		
		System.out.println("in equals");
		Employee em=(Employee)obj;
		System.out.println("1st"+getKin_Id());
		System.out.println("2nd"+em.getKin_Id());
		if(this.getKin_Id()==em.getKin_Id())
		{
			System.out.println("same");
			return true;
		}
		
		return false;
	
		if(obj instanceof Employee)
		{
			
			Employee ep=(Employee)obj;
			if(this.getKin_Id()==ep.getKin_Id() || this.getEmail_Id().equals(ep.getEmail_Id()))
			{
				System.out.println("same kin_id found and email found");
				return true;
			}
			
		}
		//System.out.println("add some record first");
		return false;
	}*/

	@Override
	public String toString() {
		return "Employee [Name=" + Name + ",Phone="+ Phone_No+",Kin_id="+Kin_Id+",Emailid="+ Email_Id+",DOB="+ DOB+",DOJ="+ DOJ+",Employee_id="+ Employee_Id+",Department="+ Department_Id+",Project="+ Project_Id+",Role="+ Roles_Id+"]";
	}
	


}
