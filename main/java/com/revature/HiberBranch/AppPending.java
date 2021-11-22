package main.java.com.revature.HiberBranch;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import main.java.com.revature.EmployeePrevious;

/**
 * Hello world!
 *drop table employee;
 *drop table hibernate_sequence;
 */

//This class showcases functions in Request.java
public class AppPending 
{
    public static void main( String[] args ){
    		test();
          }

    public static void test(){
    	//List<Ticket> List = Request.getPendingRequests();
    	//Request.approveRequest(2);
    	//Request.rejectRequest(4);
    	Request.submitRequest(1500f, "5/5/2010", 1,"Test submission, may approve or reject");
    	Request.submitRequest(1500f, "5/5/2010", 2,"Test submission, may approve or reject");
    	List<Ticket> List = Request.getPendingForUser(2);
    	List<Ticket> List1 = Request.getAllTicketsForUser(3);
       	List<Ticket> List2 = Request.getPendingRequests();
       for(Ticket t : List){
       	t.print();
       	//System.out.print("\t Employee: "+t.getEmployee().getName());
       }
       for(Ticket t : List1){
          	t.print();
          	//System.out.print("\t Employee: "+t.getEmployee().getName());
          }
       for(Ticket t : List2){
          	t.print();
          	//System.out.print("\t Employee: "+t.getEmployee().getName());
       }
    
    
    }
    
}
    