package main.java.com.revature;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("project started...");

        // create a configuration object
        Configuration cfg = new Configuration();

        // read the configuration and load in the object
        cfg.configure("main/resources/hibernate.cfg.xml");

        // create factory
        SessionFactory factory = cfg.buildSessionFactory();
        // open the session
        Session session = factory.openSession();
        // begin the transaction
        Transaction t = session.beginTransaction();

        // create employee
        EmployeePrevious employee = new EmployeePrevious();
        employee.setId(5);
        employee.setName("gab");
        employee.setEmail("m@gmail.com");
        employee.setGender("male");
        employee.setCountry("USA");

        // save the employee
        session.save(employee);
        // commit the transaction
        t.commit();
        // close the connection
        session.close();
    }
}
