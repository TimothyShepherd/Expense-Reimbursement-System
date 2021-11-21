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

public class UpdateServlet extends HttpServlet {
	EmployeeDaoImplementation dao = EmployeeDaoFactory.getEmployeeDao();
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<h1>YOU HAVE UPDATED</h1>");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("drone");
		String country = request.getParameter("country");
		System.out.println(name+email+gender+country);
		 
		Cookie[] cookies = request.getCookies();
	    int id = 0;
		if (cookies != null){
	        for (Cookie cookie : cookies) {
	            cookie.setMaxAge(0);
	            response.addCookie(cookie);
	            id = Integer.parseInt(cookie.getValue());
	        }//endfor
	    	}//endif
		System.out.println("Id passed: "+id);
		if(id>0){
		dao.updateEmployee(id, name, email, gender, country);
		}
		// when user enter correct details
		
			response.sendRedirect("viewServlet");
		
	}
	
}
