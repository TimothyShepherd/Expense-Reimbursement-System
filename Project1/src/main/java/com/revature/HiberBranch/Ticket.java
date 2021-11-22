package com.revature.HiberBranch;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY,generator="seq")
    private int id;
    
    private float reimbursment;
    private String status="";
    private String date="";
    
    @ManyToOne
    @JoinColumn(name="FK_employeeId")
    private Employee employee;

    public Ticket(){}
    
    public Ticket(float reimbursment, String status,String date,Employee employee) {
        this.reimbursment = reimbursment;
        this.status = status;
        this.date = date;
        this.employee=employee;
    }
    
    public Ticket(int id, float reimbursment, String status,String date) {
        this.id = id;
        this.reimbursment = reimbursment;
        this.status = status;
        this.date = date;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getReimbursment() {
        return reimbursment;
    }

    public void setName(float reimbursment) {
        this.reimbursment = reimbursment;
    }

    public String getStatus() {
        return status;
    }

    public void setPassword(String status) {
        this.status = status;
    }

   
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date= date;
    }


    
    public String print(){
    	String s = "id: " +id+ "\tReimbursment: " + reimbursment+"\tstatus: "+status+"\tdate: "+date+"\t Employee: " + employee.getName() +"\t Employee ID: "+employee.getId();
    	System.out.println(s);
    	return s;
    }
    
    public Employee getEmployee(){
    	return this.employee;
    }
    
    public void setStatus(String st){
    	this.status = st;
    }
}
