package main.java.com.revature.HiberBranch;

public class Login {

	public static boolean loginManager(int id,String name,String password){
		int comparison;
		boolean status;
		ManagerDaoImplementation mdao = DaoFactory.getManagerDao();
		Manager m = mdao.getManagerbyID(id);
		
		comparison =(name.compareTo(m.getName())+password.compareTo(m.getPassword()));
		
		
		if(comparison==0){
			status=true;
		}
		else{
			status = false;
		}
		
		return status;
	}
	public static boolean loginEmployee(int id,String name,String password){
		int comparison;
		boolean status;
		EmployeeDaoImplementation mdao = DaoFactory.getEmployeeDao();
		Employee m = mdao.getEmployeebyID(id);
		
		comparison =(name.compareTo(m.getName())+password.compareTo(m.getPassword()));
		
		
		if(comparison==0){
			status=true;
		}
		else{
			status = false;
		}
		
		return status;
	}
	
}
