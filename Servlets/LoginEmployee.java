package com.revature.Servlets;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.revature.HiberBranch.Login.loginEmployee;

public class LoginEmployee extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        loginEmployee(int id, String email, String password);

        //

        if(status.equals(true)){
            Cookie cookie = new Cookie("id", ""+id);
            response.addCookie(cookie);
            System.out.println("cookie added: "+id);
            response.sendRedirect("employeeportal.html");

            out.println("Login successfull.");
        }else{


            out.println("Login failed.");
        }
    }
}
