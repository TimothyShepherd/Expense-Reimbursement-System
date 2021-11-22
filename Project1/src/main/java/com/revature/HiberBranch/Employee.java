package com.revature.HiberBranch;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    private String name;
    private String password="";
    
    @OneToMany(mappedBy="employee",cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<Ticket>();

    public Employee(){}
    
    public Employee(String name, String password) {
        
        this.name = name;
        this.password = password;
    }
    
    public Employee(int id, String name, String password) {
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
    
    public void addTicket(Ticket ticket){
    	tickets.add(ticket);
    }

    public List<Ticket> getTickets(){
    	return tickets;
    }
    
    public String print(){
    	String s = "id: " +id+ "\tName: " + name+"\tpassword: "+password;
    	System.out.println(s);
    	return s;
    }
}
