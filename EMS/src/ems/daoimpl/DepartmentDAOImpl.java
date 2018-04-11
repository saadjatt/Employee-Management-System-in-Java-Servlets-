package ems.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;

import ems.dao.DepartmentDAO;

public class DepartmentDAOImpl implements DepartmentDAO {
	static	Connection conn = (Connection) ems.connection.DBconnector.getDBConnection();
	public  int updateDepartment(int id , String deptName)
	{	int i=0;
		try
		{
			String query = "UPDATE dept SET deptname = ? WHERE id = ?" ;
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, deptName);
			ps.setInt(2, id);
			
		i=	ps.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}
	
	public  int delDepartment(int id )
	{	int i=0;
		try
		{
			String query = "DELETE FROM dept WHERE id = ?" ;
			PreparedStatement ps = conn.prepareStatement(query);
		
			ps.setInt(1, id);
			
		i=	ps.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}
	public  String getDeptName(int id)
	{	String name="";

	
		try
		{
			String query = "Select * from dept where id = ? " ;
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
	
			  ResultSet rs = ps.executeQuery();
			  while(rs.next()){
				name=rs.getString(2);  
			
			  
			 
			  }			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return name;
	}

public  int addDepartment(String deptName)
{	int i=0;
try
{
	String query = "INSERT INTO dept (deptname) VALUES (?)" ;
	PreparedStatement ps = conn.prepareStatement(query);
	ps.setString(1, deptName);
	
i=	ps.executeUpdate();
	
}catch(Exception e)
{
	e.printStackTrace();
}
return i;
}
public  int countAllDepartments()
{	int count=0;
try
{
	String query = "SELECT COUNT(*) AS counter FROM dept" ;
	PreparedStatement ps = conn.prepareStatement(query);

	ResultSet rs = ps.executeQuery();
	while(rs.next()){
		count=  rs.getInt("counter");
	}

	
}catch(Exception e)
{
	e.printStackTrace();
}
return count;
}	


}
