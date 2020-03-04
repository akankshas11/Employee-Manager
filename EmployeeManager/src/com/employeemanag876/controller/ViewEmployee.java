package com.employeemanag876.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employeemanag876.model.Employee;

public class ViewEmployee extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter p=resp.getWriter();
		
	/*	Object o=req.getAttribute("Employee");
		List<Employee> list=(List<Employee>)o;
		*/
	
	/*  Object o=req.getServletContext().getAttribute("Employee");
		List<Employee> list=(List<Employee>)o; 
		*/
	
		Object o=req.getSession(false).getAttribute("Employee");
	    List<Employee> list=(List<Employee>)o;
		
	    resp.setContentType("text/html");
		p.print("<table border=1>");
		p.print("<tr><td>Name</td><td>PositionTitle</td><td>Gender</td><td>DOB</td><td>Email</td><td>Phone</td><td>Address</td><td>JoinDate</td></tr>");
		for(Employee e:list)
		{
			p.print("<tr><td>"+e.getName()+"</td><td>"+e.getPositionTitle()+"</td><td>"+e.getGender()+"</td><td>"+e.getDOB()+"</td><td>"+e.getEmail()+"</td><td>"+e.getPhone()+"</td><td>"+e.getAddress()+"</td><td>"+e.getJoinDate()+"</td></tr>");
		}
		p.print("</table>");
	
	}

}
