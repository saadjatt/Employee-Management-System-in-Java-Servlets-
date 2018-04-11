package ems.model;

public class DepartmentBean {
private int deptId;
private String deptName;

public DepartmentBean(int deptId,String deptName) {
	// TODO Auto-generated constructor stub
	this.deptId=deptId;
	this.deptName=deptName;
}
public int getDeptId() {
	return deptId;
}
public void setDeptId(int deptId) {
	this.deptId = deptId;
}
public String getDeptName() {
	return deptName;
}
public void setDeptName(String deptName) {
	this.deptName = deptName;
}
}
