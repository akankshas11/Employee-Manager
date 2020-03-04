package com.employeemanag876.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.employeemanag876.model.Employee;

public class EmployeeDatabase {
	public int insert(Employee employee) {
		int i = 0;
		try (Connection c = EmployeeConnection.getEmployeeConnection()) {
			PreparedStatement p = c.prepareStatement("insert into Employe values(?,?,?,?,?,?,?,?)");
			p.setString(1, employee.getName());
			p.setString(2, employee.getPositionTitle());
			p.setString(3, employee.getGender());
			p.setString(4, employee.getDOB());
			p.setString(5, employee.getEmail());
			p.setInt(6, employee.getPhone());
			p.setString(7, employee.getAddress());
			p.setString(8, employee.getJoinDate());

			i = p.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public List<Employee> getAllEmployee()
	{
		List<Employee> list=new ArrayList<>();
				{
			       try(Connection c=EmployeeConnection.getEmployeeConnection();)
			       {
			    	PreparedStatement p=c.prepareStatement("Select * from Employe");   
			    	ResultSet rs=p.executeQuery();
			    	while(rs.next())
			    	{
			    		Employee e=new Employee();
			    		e.setName(rs.getString(1));
			    		e.setPositionTitle(rs.getString(2));
			    		e.setGender(rs.getString(3));
			    		e.setDOB(rs.getString(4));
			    		e.setEmail(rs.getString(5));
			    		e.setPhone(rs.getInt(6));
			    		e.setAddress(rs.getString(7));
			    		e.setJoinDate(rs.getString(8));
			    		
			    		list.add(e);
			    		}
			    	
			       }
			       catch(Exception e)
			       {
			    	   System.out.println(e);
			       }
			       return list;
				}
	}
}
