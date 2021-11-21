package main.java.com.revature.HiberBranch;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class EmployeeDaoImplementation {

	
	private static SessionFactory factory;
	static{
		factory = ConnectionFactory.getSession();
	}
	
	
	public int lastId(){
		int id=0;
		try{
			
	        // open the session
	        Session session = factory.openSession();
	        // begin the transaction
	        String SQL_QUERY = "select max(id)from Employee";
	        Query query = session.createQuery(SQL_QUERY);
	        List list = query.getResultList();
	        //System.out.println("Id: " + list.get(0)); 
	        session.close();
	        	id = (int)list.get(0);
			
		}
		catch(Exception E){
			System.out.println("no entries");
		}
		return id;
	}
	
	public void addEmployee(String name, String password){
		System.out.println("Adding Employee...");
		
        // open the session
        Session session = factory.openSession();
        
        // begin the transaction
        Transaction t = session.beginTransaction();

        // create employee
        Employee employee = new Employee();
        employee.setName(name);
        employee.setPassword(password);
    

        // save the employee
        session.save(employee);
        // commit the transaction
        t.commit();
        // close the connection
        session.close();
	}
	
	public void addEmployeeObject(Employee employee){
		System.out.println("Adding Employee object...");
		
        // open the session
        Session session = factory.openSession();
        
        // begin the transaction
        Transaction t = session.beginTransaction();

        // save the employee
        session.save(employee);
        // commit the transaction
        t.commit();
        // close the connection
        session.close();
	}
	
	public void updateEmployeeObject(Employee employee, Ticket ticket){
        // open the session
        Session session = factory.openSession();
        
        // begin the transaction
        Transaction t = session.beginTransaction();
        //evict first
        session.evict(employee);
        //change
        employee.addTicket(ticket);
        // update the employee
        session.update(employee);
        // commit the transaction
        t.commit();
        // close the connection
        session.close();
	}
	
	
	public List<Employee> getEmployees(){
        // open the session
        Session session = factory.openSession();
        // begin the transaction
        Transaction t = session.beginTransaction();
        
		String hql = "from Employee e order by e.id asc";
		Query query = session.createQuery(hql);
		List results = query.list();
		System.out.println(results);
		session.close();
		return results;
	}
	
	//Get ALL TICKETS.
	public List<Ticket> getTicketsEmployeesId(int id){
        // open the session
        Session session = factory.openSession();
        // begin the transaction
       
        //Employee e = getEmployeebyID(id);
        Criteria query = session.createCriteria(Employee.class);
        query.add(Restrictions.eq("id", id));
        //Cast is mine
        Employee me = (Employee) query.list().get(0);
        List<Ticket> results = me.getTickets();
        //model.setAttribute("person", me);
        //model.setAttribute("books", myTickets);
        
		System.out.println(results);
		session.close();
		return results;
	}
	
	public int getByNamePass(String name, String password){
        // open the session
        Session session = factory.openSession();
        // begin the transaction
       
        //Employee e = getEmployeebyID(id);
        Criteria query = session.createCriteria(Employee.class);
        query.add(Restrictions.eq("name", name));
        query.add(Restrictions.eq("password", password));
        //Cast is mine
        if(query.list().isEmpty()){
            return -1;	
            }
            
        Employee me = (Employee) query.list().get(0);
		
		session.close();
		return me.getId();
	}
	
	public Employee getEmployeebyID(int id){
        // open the session
        Session session = factory.openSession();
        // begin the transaction
        Transaction t = session.beginTransaction();
		Employee e = session.get(Employee.class, id);
		session.close();
		return e;
	}
	
	public void deleteEmployee(int id){
        // open the session
        Session session = factory.openSession();
        // begin the transaction
        Transaction t = session.beginTransaction();
        Employee employee = getEmployeebyID(id);
        session.remove(employee);
        t.commit();
        // close the connection
        session.close();
	}
	
}
