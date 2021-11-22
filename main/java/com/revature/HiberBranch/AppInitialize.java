package main.java.com.revature.HiberBranch;
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
public class AppInitialize 
{
    public static void main( String[] args ){
        startup();
        
    }
    
    public static void startup(){
    	System.out.println("Initialization started...");
        EmployeeDaoImplementation dao = DaoFactory.getEmployeeDao();
        TicketDaoImplementation tdao = DaoFactory.getTicketDao();
        ManagerDaoImplementation mdao = DaoFactory.getManagerDao();
        String name = "George";
        String password ="Jungle";
        String name1 = "Luisa";
        String password1 ="Jimenez";
        String name2 = "Cadence";
        String password2 ="Smith";
        String name3 = "Otaku";
        String password3 ="Jones";
        dao.addEmployee(name, password);
        dao.addEmployee(name1, password1);
        dao.addEmployee(name2, password2);
        dao.addEmployee(name3, password3);
        
        
        tdao.addTicket(1330f, "approved", "03/09/2019", 1,"Ate some cake");
        tdao.addTicket(2250f, "pending", "03/08/2019", 2,"Made a mistake");
        tdao.addTicket(125f, "approved", "03/02/2019", 3,"Fender the bender");
        tdao.addTicket(1740f, "pending", "05/09/202021", 4,"Car issues with the snowman event");
        
        String mname = "Ruben";
        String mpassword ="Rodriguez";
        String mname1 = "Jack";
        String mpassword1 ="Hughman";
        String mname2 = "Ernest";
        String mpassword2 ="Heisenberg";
       
        mdao.addManager(mname, mpassword);
        mdao.addManager(mname1, mpassword1);
        mdao.addManager(mname2, mpassword2);
    }
}
