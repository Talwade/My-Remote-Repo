package com.flp.ems.domain;

public class Role {
private int roleid;
private String role_name;
public int getRoleid() {
	return roleid;
}
public void setRoleid(int roleid) {
	this.roleid = roleid;
}
public String getRole_name() {
	return role_name;
}
public void setRole_name(String role_name) {
	this.role_name = role_name;
}
@Override
public String toString() {
	return "Role [role_name=" + role_name + "]";
} 



}
