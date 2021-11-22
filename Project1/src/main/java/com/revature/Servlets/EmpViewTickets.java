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

public class EmpViewTickets extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            //
            request.getRequestDispatcher("employeeportal.html").include(request, response);

            int employeeId = 0;
            boolean flag = false;

            Cookie[] cookies = request.getCookies();

            for(Cookie c: cookies) {
                String tname = "ID";
                if(tname.equals(c.getName())) {
                    flag = true;
                    employeeId = Integer.parseInt((c.getValue()));
                }
            }

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