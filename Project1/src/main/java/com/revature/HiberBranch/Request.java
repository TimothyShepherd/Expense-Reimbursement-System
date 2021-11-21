package com.revature.HiberBranch;
import java.util.List;

public class Request {
	static TicketDaoImplementation tdao = DaoFactory.getTicketDao();
	static EmployeeDaoImplementation edao = DaoFactory.getEmployeeDao();
	
	//Get all tickets that are "pending" for all users
	public static List<Ticket>getPendingRequests(){
		List<Ticket> tickets= tdao.getPendingTickets();
		return tickets;
	}	
	//Approves the ticket with the given ID. This is the TICKET ID NOT the USER id
	public static void approveRequest(int id){
		tdao.approveTicket(id);
	}
	
	//Reject non-pending ticket
	public static void rejectRequest(int id){
		tdao.rejectTicket(id);
	}
	
	//Get all pending tickets for a user
	public static List<Ticket> getPendingForUser(int id){
		return tdao.getPendingTicketsEmployeesId(id);
	}
	
	//Get ALL tickets for a user
	public static List<Ticket> getAllTicketsForUser(int id){
		return edao.getTicketsEmployeesId(id);
	}
	
	//submit a new ticket, always as pending
	public static void submitRequest(float reimbursment, String date, int employeeId ){
		tdao.addTicket(reimbursment, "pending", date, employeeId);
	}
}
