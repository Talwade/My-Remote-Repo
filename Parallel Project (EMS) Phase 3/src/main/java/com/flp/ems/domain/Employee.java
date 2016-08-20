package com.flp.ems.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="Employees")
public class Employee {
	@Id
	@GeneratedValue
	private int empId;
	
	@NotEmpty(message="* Please enter a Name.")
	private String empName;
	private String phone;
	@NotEmpty(message="* Please enter a E-Mail ID.")
	@Email(message="* Please enter a valid E-Mail ID")
	private String emailid;
	@NotEmpty(message="* Please enter a Kin-ID.")
	private String kinid;
	private String addr;
	@Past(message="* Please Enter a past date.")
	private Date empDob;
	private Date empDoj;
	private String department;
	private String project;
	private String role;
	
public Employee(){
	this.empId=-1;
}
	
	public Employee(int empId, String empName, String kinid, String addr, String emailid, String phone, Date empDob, Date empDoj) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.kinid = kinid;
		this.addr = addr;
		this.emailid = emailid;
		this.phone = phone;
		this.empDob = empDob;
		this.empDoj = empDoj;
	}
	
	
	public Employee(int empId, String empName, String kinid, String addr,String emailid, String phone, Date empDob, Date empDoj,
			String department, String project, String role) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.kinid = kinid;
		this.addr = addr;
		this.emailid = emailid;
		this.phone = phone;
		this.empDob = empDob;
		this.empDoj = empDoj;
		this.department = department;
		this.project=project;
		this.role=role;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getKinid() {
		return kinid;
	}

	public void setKinid(String kinid) {
		this.kinid = kinid;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Date getEmpDob() {
		return empDob;
	}

	public void setEmpDob(Date empDob) {
		this.empDob = empDob;
	}

	public Date getEmpDoj() {
		return empDoj;
	}

	public void setEmpDoj(Date empDoj) {
		this.empDoj = empDoj;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", phone=" + phone + ", emailid=" + emailid
				+ ", kinid=" + kinid + ", addr=" + addr + ", empDob=" + empDob + ", empDoj=" + empDoj + ", department="
				+ department + ", project=" + project + ", role=" + role + "]";
	}
	

}
