package com.flp.ems.domain;



import java.util.HashSet;
import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "project")
public class Project 
{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "proj_id")	
private int Project_id;
@JoinColumn(name="dept_id")
@Column(name = "dept_id")
private int Department_id;
@Column(name = "name")
private String Name;
@Column(name = "description")
private String Description;
private Department d;
public static HashSet hsh_proj=new HashSet();
Project()
{
	int deptid;
	Department d=new Department();
	Department d1;
	/*Scanner s=new Scanner(System.in);
	System.out.println("first choose the deptid from the below list");
	System.out.println("Enter deptid 1 for proj on devops ");
	System.out.println("Enter deptid 2 for proj on Clouds");
	System.out.println("Enter deptid 3 for proj on Mainframe");
	System.out.println("Enter deptid 4 for proj on Testing");
	System.out.println("Enter deptid 5 for proj on Admjava");
	System.out.println("Enter deptid for project 1");
	deptid=s.nextInt();*/
	d1=Department.Search_dept(1);
	Project p1=new Project(1,"ADM","Proj on ADM",d1);
	hsh_proj.add(p1);
    System.out.println("Enter deptid for project 2");
	//deptid=s.nextInt();
	d1=Department.Search_dept(2);
	Project p2=new Project(2,"Cards","Prog devloped in Cards",d1);
	hsh_proj.add(p2);
	Project p3=null;
	System.out.println("Enter deptid for project 3");
	//deptid=s.nextInt();
	d1=Department.Search_dept(3);
	p3=new Project(3,"InD","InD",d1);
	hsh_proj.add(p3);
	Project p4=null;
	System.out.println("Enter deptid for project 4");
	//deptid=s.nextInt();
	d1=Department.Search_dept(4);
	p4=new Project(4,"Capital Market","Capital Market",d1);
	hsh_proj.add(p4);
	Project p5=null;
	System.out.println("Enter deptid for project 5");
	//deptid=s.nextInt();
	d1=Department.Search_dept(5);
	p5=new Project(5,"Support","Support",d1);
	hsh_proj.add(p5);
	Project p6=null;
	System.out.println("Enter deptid for project 6");
	//deptid=s.nextInt();
	d1=Department.Search_dept(6);
	p6=new Project(4,"Testing","Testing",d1);
	hsh_proj.add(p6);
	Project p7=null;
	System.out.println("Enter deptid for project 7");
	//deptid=s.nextInt();
	d1=Department.Search_dept(7);
	p7=new Project(4,"HR","HR",d1);
	hsh_proj.add(p7);
	Project p8=null;
	System.out.println("Enter deptid for project 8");
	//deptid=s.nextInt();
	d1=Department.Search_dept(8);
	p8=new Project(4,"Training","Training",d1);
	hsh_proj.add(p8);
	Project p;
	Iterator it=hsh_proj.iterator();
	while(it.hasNext())
	{
		p=(Project)it.next();
		System.out.println(p.getProject_id()+p.getDescription()+p.getName()+p.getD());
}}
	
Project(int Project_id,String Name,String Description,Department d)
{
	setProject_id(Project_id);
	setDescription(Description);
	setName(Name);
	setD(d);
}


public int getProject_id() {
	return Project_id;
}
public void setProject_id(int project_id) {
	Project_id = project_id;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public int getDepartment_id() {
	return Department_id;
}
public void setDepartment_id(int department_id) {
	Department_id = department_id;
}
public Department getD() {
	return d;
}
public void setD(Department d) {
	this.d = d;
}
public static void main(String args[])
{
	Project  p=new Project ();
}
public static Project Search_Project(int projid)
{
	Iterator it=hsh_proj.iterator();
	Project p=null;
	while(it.hasNext())
	{
		p=(Project)it.next();
		
		if (p.getProject_id()==projid)
			return p;
	}
	if(p==null)
		System.out.println("dept not found");
	return p;
}


}
