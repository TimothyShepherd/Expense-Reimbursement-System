package main.java.com.revature.HiberBranch;

public class DEMO {
    public static void main( String[] args ){
    	//Requirements for running
    	//1. Hibernate.cfg.xml correctly configured
    	//This means that... the classes must be added!
    	//Also the username must be correct
    	//2. The SQL table named project1 must have been ALREADY created
    	//3. Make sure mysql is running
    	
     AppInitialize.startup();
     AppMulTicket.multipleTickets();
     AppLoginCheck.loginCheck();
     AppPending.test();
    }
}
