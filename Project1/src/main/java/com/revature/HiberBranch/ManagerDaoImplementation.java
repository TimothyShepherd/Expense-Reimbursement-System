package com.revature.HiberBranch;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class ManagerDaoImplementation {

	
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
	
	public int getByNamePass(String name, String password){
        // open the session
        Session session = factory.openSession();
        // begin the transaction
       
        //Employee e = getEmployeebyID(id);
        Criteria query = session.createCriteria(Manager.class);
        query.add(Restrictions.eq("name", name));
        query.add(Restrictions.eq("password", password));
        //Cast is mine
        if(query.list().isEmpty()){
            return -1;	
            }
            
        Manager me = (Manager) query.list().get(0);
		
		session.close();
		return me.getId();
	}
	
	public void addManager(String name, String password){
		System.out.println("Adding Manager...");
		
        // open the session
        Session session = factory.openSession();
        
        // begin the transaction
        Transaction t = session.beginTransaction();

        // create employee
        Manager manager = new Manager();
        manager.setName(name);
        manager.setPassword(password);
    

        // save the employee
        session.save(manager);
        // commit the transaction
        t.commit();
        // close the connection
        session.close();
		
	}
	
	public Manager getManagerbyID(int id){
        // open the query session
        Session session = factory.openSession();
        // begin the transaction
		Manager e = session.get(Manager.class, id);
		session.close();
        return e;
	}

	
}
