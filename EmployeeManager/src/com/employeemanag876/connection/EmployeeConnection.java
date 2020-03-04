package com.employeemanag876.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class EmployeeConnection {
	public static Connection con;
	public static Connection getEmployeeConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeManager","root","root");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}

}
