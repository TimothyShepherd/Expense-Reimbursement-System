package com.revature.HiberBranch;

public class DaoFactory {
	
private static EmployeeDaoImplementation eDao;
private static TicketDaoImplementation tDao;
private static ManagerDaoImplementation mDao;
	
public static EmployeeDaoImplementation getEmployeeDao(){
		if(eDao==null){
			eDao = new EmployeeDaoImplementation();
			System.out.println("Instantiated Employee");
		}
		return eDao;
	}


public static ManagerDaoImplementation getManagerDao(){
	if(mDao==null){
		mDao = new ManagerDaoImplementation();
		System.out.println("Instantiated Manager");
	}
	return mDao;
}

public static TicketDaoImplementation getTicketDao(){
	if(tDao==null){
		tDao = new TicketDaoImplementation();
		System.out.println("Instantiated Ticket");
		
	}
	return tDao;
}


	
}