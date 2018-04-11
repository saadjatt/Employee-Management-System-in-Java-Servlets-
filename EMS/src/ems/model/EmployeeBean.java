package ems.model;

public class EmployeeBean {
private int empId;
private String empName;
private String deptName;
private String empDob;
private String empGender;
private String empEmail;

//id empname deptname empgender empdob empemail emppass
public EmployeeBean(int empId, String empName, String deptName, String empGender,
		String empDob, String empEmail, String empPass) {
	//super();
	this.empId = empId;
	this.empName = empName;
	this.deptName = deptName;
	this.empDob = empDob;
	this.empGender = empGender;
	this.empEmail = empEmail;
	this.empPass = empPass;
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
public String getDeptName() {
	return deptName;
}
public void setDeptName(String deptName) {
	this.deptName = deptName;
}
public String getEmpDob() {
	return empDob;
}
public void setEmpDob(String empDob) {
	this.empDob = empDob;
}
public String getEmpGender() {
	return empGender;
}
public void setEmpGender(String empGender) {
	this.empGender = empGender;
}
public String getEmpEmail() {
	return empEmail;
}
public void setEmpEmail(String empEmail) {
	this.empEmail = empEmail;
}
public String getEmpPass() {
	return empPass;
}
public void setEmpPass(String empPass) {
	this.empPass = empPass;
}
private String empPass;




}
