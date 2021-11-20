package main.java.com.revature.HiberBranch;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionFactory {

	public static SessionFactory factory;
	public static SessionFactory getSession(){
		// create a configuration object
		if(factory ==null){
        Configuration cfg = new Configuration();

        // read the configuration and load in the object
        cfg.configure("main/resources/hibernate.cfg.xml");

        // create factory
        factory = cfg.buildSessionFactory();}
		
		return factory;
	}
}
