package ems.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import ems.dao.EmployeeDAO;

public class EmployeeDAOImpl implements EmployeeDAO{
static	Connection conn = (Connection) ems.connection.DBconnector.getDBConnection();
	public  int addEmployee(String name,String dept,String empdob,String empgender,String empemail,String emppass)
	{	int i=0;
		try
		{
			String query = "INSERT INTO emp (empname, deptname, empgender, empdob, empemail, emppass) VALUES (?, ?, ?, ?, ?, ?)" ;
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, dept);
			ps.setString(3, empgender);
			ps.setString(4, empdob);
			ps.setString(5, empemail);
			ps.setString(6, emppass);
		i=	ps.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}
	public  int updateEmployee(int id ,String name,String dept,String empdob,String empgender,String empemail,String emppass)
	{	int i=0;
		try
		{
			String query = "UPDATE emp SET empname =? , deptname =? , empgender =? , empdob = ? , empemail = ? , emppass = ? WHERE id = ? " ;
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, dept);
			ps.setString(3, empgender);
			ps.setString(4, empdob);
			ps.setString(5, empemail);
			ps.setString(6, emppass);
			
			
			ps.setInt(7, id);
			
		i=	ps.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}
	public  ArrayList<String> getEmployeeInfo(int id)
	
	{	
	ArrayList<String>  list= new ArrayList<>();

	
		try
		{
			String query = "Select * from emp where id = ? " ;
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
	
			  ResultSet rs = ps.executeQuery();
			  while(rs.next()){
				list.add(rs.getString(2));  
				list.add(rs.getString(3));
				list.add(rs.getString(4));
				list.add(rs.getString(5));
				list.add(rs.getString(6));
				list.add(rs.getString(7));
			
			  
			 
			  }			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public  int delEmployee(int id )
	{	int i=0;
		try
		{
			String query = "DELETE FROM emp WHERE id = ?" ;
			PreparedStatement ps = conn.prepareStatement(query);
		
			ps.setInt(1, id);
			
		i=	ps.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}
	
	public  boolean checkEmployeeEmail(String email )
	{	boolean flag = false;
		try
		{
			String query = "Select * FROM emp WHERE empemail = ?" ;
			PreparedStatement ps = conn.prepareStatement(query);
		
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			  while(rs.next()){
				flag = true;
				}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	public  ArrayList<ems.model.DepartmentBean> getDeptname()
	{	
		ArrayList<ems.model.DepartmentBean> list = new ArrayList<>();
		try
		{
			  PreparedStatement pst = conn.prepareStatement
					  ("Select * from dept");
					  ResultSet rs = pst.executeQuery();
					  while(rs.next()){
					  list.add(new ems.model.DepartmentBean(rs.getInt(1),rs.getString(2)));
					  
					 
					  }
		
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public  ArrayList<ems.model.EmployeeBean> getEmployeename()
	{	
		ArrayList<ems.model.EmployeeBean> list = new ArrayList<>();
		try
		{
			  PreparedStatement pst = conn.prepareStatement
					  ("Select * from emp");
					  ResultSet rs = pst.executeQuery();
					  while(rs.next()){
						
					  list.add(new ems.model.EmployeeBean(rs.getInt(1),rs.getString("empname"),rs.getString("deptname"),rs.getString("empgender"),rs.getString("empdob"),rs.getString("empemail"),rs.getString("emppass")));
					  
					 
					  }
		
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}

	public  int addUser(String empemail,String emppass)
	{	int i=0;
		try
		{
			String query = "INSERT INTO login (uemail, upass) VALUES ( ?, ?)" ;
			PreparedStatement ps = conn.prepareStatement(query);
	
			ps.setString(1, empemail);
			ps.setString(2, emppass);
		i=	ps.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}
	
	public  int countAllEmployees()
	{	int count=0;
		try
		{
			String query = "SELECT COUNT(*) AS counter FROM emp" ;
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
