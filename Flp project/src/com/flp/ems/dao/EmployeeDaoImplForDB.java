/*package com.flp.ems.dao;

import java.util.Map;

import com.flp.ems.domain.Employee;

public class EmployeeDaoImplForDB implements IemployeeDao{

	@Override
	public void ModifyEmployee(Map empModifiedDetails, String val, String val1, int empId, int val2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean RemoveEmployee(int empids) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee SearchEmployee(String val, String val1, int val2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getAllEmployee() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AddEmployee(Employee e) {
		// TODO Auto-generated method stub
		
	}

	
	
}*/
package com.flp.ems.dao;

import java.util.Map;
import java.sql.*;

import com.flp.ems.domain.Department;
import com.flp.ems.domain.Employee;
import com.flp.ems.domain.Project;
import com.flp.ems.domain.Role;
import com.mysql.jdbc.Connection;

public class EmployeeDaoImplForDB implements IemployeeDao {
	private String Employee_Id;
	private String Name;
	private String Kin_Id;
	private String Email_Id;
	private String Phone_No;
	private String DOB;
	private String DOJ;
	private String Address;
	private String names;
	private String dn,desc,rn,rdesc,pn,pdesc;
	Employee e = new Employee();

	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/test";
	private String s;

	@Override
	public void getAllEmployee() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		/*Class.forName(driver);
		Connection dbConnection;
		dbConnection = (Connection) DriverManager.getConnection(url);
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Employee");
		while (rs.next()) {
			s = rs.getString("");

			System.out.println(s);

		}*/
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
		 Statement stmt = con.createStatement();
		 ResultSet rs1=stmt.executeQuery("select * from Employee");
		/*ResultSet rs2=stmt.executeQuery("select * from Employee");
		 ResultSet rs3=stmt.executeQuery("select * from Employee");
		 ResultSet rs4=stmt.executeQuery("select * from Role");*/
		 while(rs1.next()){
			 System.out.println(rs1.getInt("Employeid")+"  "+rs1.getString("Kin_id")+"  "+rs1.getString("Name")+ "  " +rs1.getString("Phone_no") +" " +rs1.getString("Address")+ " " +rs1.getString("Email_id") +"  "+rs1.getString("DOJ") +" " +rs1.getString("DOB")+ " "+rs1.getInt("Dept_id")+ " "+rs1.getInt("Project_id") +" "+rs1.getInt("Role_id"));  
			 }
		 con.close(); 
	}

	public EmployeeDaoImplForDB() {
		this.e = e;
		this.names = Name;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Employee SearchEmployee(String val, String val1, int val2) throws ClassNotFoundException, SQLException {

		Class.forName(driver);
		Connection connection;
		connection = (Connection) DriverManager.getConnection(url);
		//Statement stmt = connection.createStatement();
		/*String query[] = { "SELECT * FROM employee where Kin_id=?" "select name from EMPLOYEE where name like '?'",
				"select name from EMPLOYEE where name like '?'" };
		for (String q : query) {
			ResultSet rs = stmt.executeQuery(q);
			System.out.println("Names for query " + q + " are");
			while (rs.next()) {
				String name = rs.getString("Name");
				System.out.print(name + "  ");
			}

			// TODO Auto-generated method stub
		}*/
		//PreparedStatement statement = connection.prepareStatement("SELECT * from Employee WHERE  name= ?");
		PreparedStatement statement=connection.prepareStatement("select * from Employee inner join Department on Employee.Dept_id=Department.Deptid inner join Role on Employee.role_id=Role.roleid inner join Project on Employee.projid=Project.projid where name=?");
		statement.setString(1,val);
		ResultSet rs = statement.executeQuery();
		 while (rs.next()) {
	    	 int x = rs.getInt("Employeid"); 
	    	 String y = rs.getString("kin_id"); 
	    	 String z = rs.getString("Name"); 
	    	 String m = rs.getString("Phone_no"); 
	    	String n = rs.getString("Address"); 
	    	String u = rs.getString("Email_id"); 
	    	 String v = rs.getString("DOJ"); 
	    	String l=rs.getString("DOB"); 
	    	 int h=rs.getInt("Dept_id");
	    
	    	int j=rs.getInt("Project_id");
	    	//rn=rs.getString("rolename");
	    	//rdesc=rs.getString("roledesc");
	    	
	    	
	    	 int o=rs.getInt("Role_id");
	    	 //pn=rs.getString("projname");
	    	 //pdesc=rs.getString("projdesc");
	    	// System.out.println(y);
	    	 
	    		System.out.println("empid:"+x+"\tkinid:"+y+"\tname:"+z+"\tphoneno:"+m+"\taddress:"+n+"\temailid:"+u+"\tdoj:"+v+"\tdob:"+l+"\tDepartmentid:"+h+"\tdepartmentname:"+dn+"\tdepatment descption:"+desc+"\troleidis:"+j+"\trolename:"+rn+"\troledescption:"+rdesc+"\tprojectid:"+o+"\tprojectname:"+pn+"\tprojectdescription:"+pdesc);
		 }
		return e;
	
	}

	@Override
	public Employee ModifyEmployee(Map empModifiedDetails, String val, String val1, int empId, int val2)
			throws ClassNotFoundException, SQLException { // throws
															// ClassNotFoundException,
															// SQLException {
		// TODO Auto-generated method stub
		Class.forName(driver);
		Connection dbConnection;
		dbConnection = (Connection) DriverManager.getConnection(url);
		String query = "update Employee set where name=?";
		PreparedStatement preparedStmt = dbConnection.prepareStatement(query);
		preparedStmt.setString(1, e.getName());
		preparedStmt.execute();

		return null;
	}

	@Override
	public void AddEmployee(Employee e, Department d, Project pro, Role role) throws ClassNotFoundException, SQLException {

		Class.forName(driver);
		Connection dbConnection;
		dbConnection = (Connection) DriverManager.getConnection(url);
		String query = "insert into Employee(Employeid,Kin_id,Name,Phone_no,Address,Email_id,DOJ,DOB,Dept_id,Project_id,Role_id)" + " values (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStmt = dbConnection.prepareStatement(query);
		preparedStmt.setInt(1, e.getEmployee_Id());
		preparedStmt.setInt(2, e.getKin_Id());
		preparedStmt.setString(3,e.getName());
		preparedStmt.setString(4, e.getPhone_No());
		preparedStmt.setString(5,e.getAddress());
		preparedStmt.setString(6,e.getEmail_Id());
		preparedStmt.setString(7,e.getDOJ());
		preparedStmt.setString(8, e.getDOB());
		//preparedStmt.setInt(9,d.getDepartmentname());
		preparedStmt.setInt(9, d.getDepartmentid());
		preparedStmt.setInt(10, pro.getProj_id());
		preparedStmt.setInt(11, role.getRoleid());
		preparedStmt.execute();

	}

	@Override
	public boolean RemoveEmployee(int empids,Employee e) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection dbConnection;
		dbConnection = (Connection) DriverManager.getConnection(url);
		String query = "delete from Employee where Kin_id=?";
		PreparedStatement preparedStmt = dbConnection.prepareStatement(query);
		preparedStmt.setInt(1, e.setKin_Id(empids));
		preparedStmt.execute();

		return false;
		
	
	}

}
