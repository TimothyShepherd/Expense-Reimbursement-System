package com.revature.Servlets;

import com.revature.HiberBranch.Request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ApproveRequest extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("managerportal.html").include(request, response);

        int id = Integer.parseInt(request.getParameter("id2"));

        Request.approveRequest(id);

        out.print("<h2>Request Approved Successfully</h2>");


    }
}