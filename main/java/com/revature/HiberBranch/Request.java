package main.java.com.revature.HiberBranch;
import java.util.List;

public class Request {

	
	//Get all tickets that are pending "pending"
	public static List<Ticket>getPendingRequests(){
		TicketDaoImplementation tdao = DaoFactory.getTicketDao();
		List<Ticket> tickets= tdao.getPendingTickets();
		return tickets;
	}	
}
