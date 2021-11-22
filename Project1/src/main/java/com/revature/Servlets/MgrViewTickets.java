package com.revature.Servlets;

import com.revature.HiberBranch.Request;
import com.revature.HiberBranch.Ticket;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class MgrViewTickets extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //
        request.getRequestDispatcher("managerportal.html").include(request, response);

        int employeeId = Integer.parseInt(request.getParameter("id"));

        List<Ticket> listPending = Request.getAllTicketsForUser(employeeId);

        out.println("<table><thead>");
        out.print("<td>ID: </td>");
        out.print("<td>Reimbursement: </td>");
        out.print("<td>Date: </td>");
        out.print("<td>Status: </td>");
        out.print("</thead>");

        for(Ticket x : listPending){
            out.print("<tr>");
            out.print("<td>" + x.getId() + "</td>");
            out.print("<td>" + x.getReimbursment() + "</td>");
            out.print("<td>" + x.getDate() + "</td>");
            out.print("<td>" + x.getStatus() + "</td>");
            out.print("</tr>");
        }
        out.print("</table>");
    }
}