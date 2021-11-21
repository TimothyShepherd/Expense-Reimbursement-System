package com.revature.Servlets;

import com.revature.HiberBranch.Request;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class MakeTicket extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        float reimbursement = Float.parseFloat((request.getParameter("reimbursement")));

        // Gets today's date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date = (dtf.format(now));

        Cookie[] cookies = request.getCookies();

        int employeeId = 0;
        boolean flag = false;

        for(Cookie c: cookies) {
            String tname = "ID";
            if(tname.equals(c.getName())) {
                flag = true;
                employeeId = Integer.parseInt((c.getValue()));
            }
        }

        Request.submitRequest(reimbursement, date, employeeId);

    }
}
