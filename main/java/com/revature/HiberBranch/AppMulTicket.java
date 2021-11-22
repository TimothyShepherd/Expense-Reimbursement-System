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
public class AppMulTicket 
{
    public static void main( String[] args ){
        
       
    }
    
    public static void multipleTickets(){
    	System.out.println("Multiple Tickets started...");
        EmployeeDaoImplementation dao = DaoFactory.getEmployeeDao();
        TicketDaoImplementation tdao = DaoFactory.getTicketDao();
        
        tdao.addTicket(1330f, "approved", "03/09/2019", 3,"Went for a hike to meet clients");
        tdao.addTicket(1740f, "approved", "05/09/202021", 4,"I fell during business hours");
        List<Ticket> L = dao.getTicketsEmployeesId(3);
        
        //This one fails:
        //List<Ticket> L = tdao.getTicketsEmployeesId(3);
        for(Ticket t : L){
        	t.print();
        }
    }
}
