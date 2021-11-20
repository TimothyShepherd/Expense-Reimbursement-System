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
public class AppPending 
{
    public static void main( String[] args ){
        pendingTickets();
       
    }
    
    public static void pendingTickets(){
    	System.out.println("Pending Tickets started...");
        TicketDaoImplementation tdao = DaoFactory.getTicketDao();
        
        List<Ticket> L = tdao.getPendingTickets();
        
        //This one fails:
        //List<Ticket> L = tdao.getTicketsEmployeesId(3);
        for(Ticket t : L){
        	t.print();
        	//System.out.print("\t Employee: "+t.getEmployee().getName());
        }
    }
}
