package main.java.com.revature.HiberBranch;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Manager {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY,generator="teq")
    private int id;
    private String name;
    private String password="";

    public Manager(){}
    
    public Manager(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public String print(){
    	String s = "id: " +id+ "\tName: " + name+"\tpassword: "+password;
    	System.out.println(s);
    	return s;
    }
    

}
