package com.revature;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;

public class EmployeeDaoImplementation {

	private static SessionFactory factory;
	static{
		// create a configuration object
        Configuration cfg = new Configuration();

        // read the configuration and load in the object
        cfg.configure("hibernate.cfg.xml");

        // create factory
        factory = cfg.buildSessionFactory();
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
	
	public void addEmployee(String name, String email, String gender, String country){
		System.out.println("project started...");

        // open the session
        Session session = factory.openSession();
        // begin the transaction
        Transaction t = session.beginTransaction();

        // create employee
        EmployeePrevious employee = new EmployeePrevious();
        int newId = lastId();
        newId +=1;
        employee.setId(newId);
        employee.setName(name);
        employee.setEmail(email);
        employee.setGender(gender);
        employee.setCountry(country);

        // save the employee
        session.save(employee);
        // commit the transaction
        t.commit();
        // close the connection
        session.close();
		
	}
	
	public void updateEmployee(int id, String name, String email, String gender, String country){
		System.out.println("project started...");

        // open the session
        Session session = factory.openSession();
        // begin the transaction
        Transaction t = session.beginTransaction();

        // create employee
        EmployeePrevious employee = new EmployeePrevious();
        employee.setId(id);
        employee.setName(name);
        employee.setEmail(email);
        employee.setGender(gender);
        employee.setCountry(country);
        session.update(employee);
        // save the employee
        // commit the transaction
        t.commit();
        // close the connection
        session.close();
		
	}
	
	public List<EmployeePrevious> getEmployees(){
        // open the session
        Session session = factory.openSession();
        // begin the transaction
        Transaction t = session.beginTransaction();
        
		String hql = "from Employee e order by e.id asc";
		Query query = session.createQuery(hql);
		List results = query.list();
		System.out.println(results);
		
		return results;
	}
	
	public EmployeePrevious getEmployeebyID(int id){
        // open the session
        Session session = factory.openSession();
        // begin the transaction
        Transaction t = session.beginTransaction();
		EmployeePrevious e = session.get(EmployeePrevious.class, id);
        return e;
	}
	
	public void deleteEmployee(int id){
        // open the session
        Session session = factory.openSession();
        // begin the transaction
        Transaction t = session.beginTransaction();
        EmployeePrevious employee = getEmployeebyID(id);
        session.remove(employee);
        t.commit();
        // close the connection
        session.close();
	}
	
}
