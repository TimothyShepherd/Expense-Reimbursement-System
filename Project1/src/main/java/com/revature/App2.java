package com.revature;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App2 
{
    public static void main( String[] args ){
        System.out.println("project started...");
        EmployeeDaoImplementation dao = EmployeeDaoFactory.getEmployeeDao();
        dao.lastId();
        EmployeePrevious e = dao.getEmployeebyID(8);
        e.print();
    }
}
