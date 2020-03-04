package com.employeemanag876.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employeemanag876.connection.EmployeeDatabase;
import com.employeemanag876.model.Employee;

public class AddEmployee extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
	    PrintWriter p=resp.getWriter();
	    
	    String Name=req.getParameter("name");
	    String PositionTitle=req.getParameter("position");
	    String Gender=req.getParameter("gender");
	    String DOB=req.getParameter("date");
	    String Email=req.getParameter("email");
	    String Phone=req.getParameter("number");
	    String Address=req.getParameter("address");
	    String JoinDate=req.getParameter("jdate");
	    
	    Employee e=new Employee();
	    e.setName(Name);
	    e.setPositionTitle(PositionTitle);
	    e.setGender(Gender); 
	    e.setDOB(DOB);
	    e.setEmail(Email);
	    e.setPhone(Integer.parseInt(Phone));
	    e.setAddress(Address);
	    e.setJoinDate(JoinDate);
	    
	    EmployeeDatabase em=new EmployeeDatabase();
	    int i=em.insert(e);
	    
	    if(i>0) {
    		p.print("Successfully Added");	
    	}else {
    		p.print("Added Failed");
    	}
	    
	    RequestDispatcher rd=req.getRequestDispatcher("add.html");
	    rd.include(req,resp);
	}

}
