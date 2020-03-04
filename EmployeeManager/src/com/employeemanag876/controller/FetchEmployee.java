package com.employeemanag876.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employeemanag876.connection.EmployeeDatabase;
import com.employeemanag876.model.Employee;

public class FetchEmployee extends HttpServlet{
	
	EmployeeDatabase ed=new EmployeeDatabase();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    doPost(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	//	PrintWriter p=resp.getWriter();
		List<Employee> list=ed.getAllEmployee();
		
		/*req.setAttribute("Employee",list);
		req.getRequestDispatcher("ViewEmployee").forward(req,resp);*/
		
		/*getServletContext().setAttribute("Employee",list);
		resp.sendRedirect("ViewEmployee");*/
		
		HttpSession s=req.getSession();
		s.setAttribute("Employee",list);
		req.getRequestDispatcher("ViewEmployee").forward(req,resp);
		
	}

}
