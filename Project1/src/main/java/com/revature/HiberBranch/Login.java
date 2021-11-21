package com.revature.HiberBranch;

public class Login {

	
	public static int loginManager(String name,String password){

		ManagerDaoImplementation edao = DaoFactory.getManagerDao();
		return edao.getByNamePass(name, password);
	}
	
	public static int loginEmployee(String name,String password){

		EmployeeDaoImplementation edao = DaoFactory.getEmployeeDao();
		return edao.getByNamePass(name, password);
	}
}
