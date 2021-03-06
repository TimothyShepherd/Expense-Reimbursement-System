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


public class TicketDaoImplementation {

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

	public void addTicket(float reimbursment, String status, String date, int employeeId,String reason){
		System.out.println("Adding Ticket...");

		// open the session
		Session session = factory.openSession();
		// begin the transaction
		Transaction t = session.beginTransaction();

		// create employee
		EmployeeDaoImplementation eDao = DaoFactory.getEmployeeDao();
		Employee employee = eDao.getEmployeebyID(employeeId);
		Ticket ticket = new Ticket(reimbursment, status, date, employee,reason);


		// save the employee
		ticket.print();
		session.save(ticket);
		// commit the transaction
		t.commit();
		// close the connection
		session.close();

	}

	public void addTicketObject(Ticket ticket){
		System.out.println("Adding Ticket Object started...");

		// open the session
		Session session = factory.openSession();
		// begin the transaction
		Transaction t = session.beginTransaction();



		// save the employee
		ticket.print();
		session.save(ticket);
		// commit the transaction
		t.commit();
		// close the connection
		session.close();

	}


	public List<Ticket> getPendingTickets(){
		Session session = factory.openSession();
		// begin the transaction
		Criteria query = session.createCriteria(Ticket.class);
		query.add(Restrictions.eq("status", "pending"));
		//Cast is mine
		List<Ticket> results = query.list();
		//model.setAttribute("person", me);
		//model.setAttribute("books", myTickets);

		System.out.println(results);
		session.close();
		return results;
	}

	//get ONLY PENDING tickets
	public List<Ticket> getPendingTicketsEmployeesId(int id){
		// open the session
		Session session = factory.openSession();
		// begin the transaction
		Criteria query = session.createCriteria(Ticket.class);
		query.add(Restrictions.eq("employee.id", id));
		query.add(Restrictions.eq("status", "pending"));
		List<Ticket> results = query.list();

		System.out.println(results);
		session.close();
		return results;
	}

	public Ticket getTicketbyID(int id){
		// open the session
		Session session = factory.openSession();
		// begin the transaction
		Transaction t = session.beginTransaction();
		Ticket e = session.get(Ticket.class, id);
		session.close();
		return e;
	}

	public boolean isPending(Ticket ticket){
		boolean answer = ticket.getStatus().equals("pending");
		System.out.println(answer);
		return answer;
	}

	public void approveTicket(int id){
		// open the session
		Session session = factory.openSession();

		// begin the transaction
		Transaction t = session.beginTransaction();
		//evict first
		Ticket ticket = getTicketbyID(id);
		if(isPending(ticket)){
			session.evict(ticket);
			//change
			ticket.setStatus("approved");
			// update
			session.update(ticket);
			// commit the transaction
			t.commit();}

		// close the connection
		session.close();
	}

	public void rejectTicket(int id){
		// open the session
		Session session = factory.openSession();

		// begin the transaction
		Transaction t = session.beginTransaction();
		//evict first
		Ticket ticket = getTicketbyID(id);
		if(isPending(ticket)){
			session.evict(ticket);
			//change
			ticket.setStatus("rejected");
			// update
			session.update(ticket);
			// commit the transaction
			t.commit();
		}
		// close the connection
		session.close();
	}



}