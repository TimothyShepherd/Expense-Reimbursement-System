package com.revature;

public class EmployeeDaoFactory {
	
private static EmployeeDaoImplementation dao;
	
public static EmployeeDaoImplementation getEmployeeDao(){
		if(dao==null){
			dao = new EmployeeDaoImplementation();
			System.out.println("Instantiated");
		}
		return dao;
	}
	
}