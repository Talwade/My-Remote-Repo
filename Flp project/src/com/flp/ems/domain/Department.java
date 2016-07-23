package com.flp.ems.domain;

public class Department {
private String departmentname;
private String department_desc;
private int departmentid;

public String getDepartmentname() {
	return departmentname;
}
public void setDepartmentname(String departmentname) {
	this.departmentname = departmentname;
}
public int getDepartmentid() {
	return departmentid;
}
public void setDepartmentid(int i) {
	this.departmentid = i;
}

	
@Override
public String toString() {
	return "Department [Dept_Name=" + departmentname +"]";
}
}
