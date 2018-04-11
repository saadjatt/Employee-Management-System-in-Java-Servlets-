package ems.dao;

import java.util.ArrayList;

public interface EmployeeDAO {
	
	public  int addEmployee(String name,String dept,String empdob,String empgender,String empemail,String emppass);
	public  int updateEmployee(int id ,String name,String dept,String empdob,String empgender,String empemail,String emppass);
	public  ArrayList<String> getEmployeeInfo(int id);
	public int delEmployee(int id );
	public  boolean checkEmployeeEmail(String email );
	public ArrayList<ems.model.DepartmentBean> getDeptname();
	public  ArrayList<ems.model.EmployeeBean> getEmployeename();
	public  int addUser(String empemail,String emppass);
	public  int countAllEmployees();
}
