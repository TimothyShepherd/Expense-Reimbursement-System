package com.revature;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Iterator;
import java.util.List;

public class ViewServlet extends HttpServlet {
	EmployeeDaoImplementation dao = EmployeeDaoFactory.getEmployeeDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("viewForm.html").include(request, response);
		List<EmployeePrevious> employees = dao.getEmployees();
		out.print(" <table id=\"table1\" ><tr><th>User Id</th><th>Name</th><th>Email</th><th>Gender</th><th>Country</th></tr>");
		for(EmployeePrevious employee : employees){
			out.print("<tr>");
			
			out.print("<td>"+employee.getId()+"</td><td>"+employee.getName()+"</td><td>"+employee.getEmail()+"</td><td>"+
			employee.getGender()+"</td><td>"+employee.getCountry()+"</td>");
			
			out.print("</tr>");
			out.print("<br>");

		}//end for
		out.println("</table>");
	}//End Get
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//request.getRequestDispatcher("viewForm.html");
		String command = request.getParameter("drone");
		int id;
		try{
		id = Integer.parseInt(request.getParameter("Id"));
		System.out.println(command+id);
		if(command.equals("delete")){
			System.out.println("Deleting " + id);
			dao.deleteEmployee(id);	
			response.sendRedirect("viewServlet");
		}
		
		
		if(command.equals("update")){
			Cookie cookie = new Cookie("id", ""+id);
			response.addCookie(cookie);
			System.out.println("cookie added: "+id);
			response.sendRedirect("EmployeeUpdate.html");
		}
		
		}
		catch(Exception e){
			response.sendRedirect("viewServlet");
		}
		
	}
	
	
	
}
