package com.revature.Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.revature.HiberBranch.Login.loginManager;

public class LoginManager extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        int status = loginManager(name, password);

        //

        if(status != -1){
            Cookie cookie = new Cookie("Name", name);
            Cookie cookie2 = new Cookie("ID", ""+status);
            response.addCookie(cookie);
            response.addCookie(cookie2);

            request.getRequestDispatcher("managerportal.html").include(request, response);

        }else{

            request.getRequestDispatcher("loginmanager.html").include(request, response);
            out.println("Login failed.");
        }
    }
}
