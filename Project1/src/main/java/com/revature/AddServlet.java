package com.revature;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AddServlet extends HttpServlet {
	EmployeeDaoImplementation dao = EmployeeDaoFactory.getEmployeeDao();
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("drone");
		String country = request.getParameter("country");
		System.out.println(name+email+gender+country);

		System.out.println(dao.lastId()); 
		dao.addEmployee(name, email, gender, country);
		// when user enter correct details
		request.getRequestDispatcher("EmployeeForm.html").include(request, response);
		out.print("<h1>Successfully added employee</h1>");
	}
	
}
