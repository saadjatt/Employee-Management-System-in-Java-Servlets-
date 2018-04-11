package ems.dao;

public interface DepartmentDAO {
	public  int updateDepartment(int id , String deptName);
	public  int delDepartment(int id );
	public  int addDepartment(String deptName);
	public  String getDeptName(int id);
	public int countAllDepartments();

}
