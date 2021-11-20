package main.java.com.revature.HiberBranch;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import main.java.com.revature.EmployeePrevious;

/**
 * Hello world!
 *drop table employee;
 *drop table hibernate_sequence;
 */
public class AppLoginCheck 
{
    public static void main( String[] args ){
        loginCheck();
    }
    
    public static void loginCheck(){
    	System.out.println("Login check started...");
        EmployeeDaoImplementation dao = DaoFactory.getEmployeeDao();
        ManagerDaoImplementation mdao = DaoFactory.getManagerDao();
        
        int idE = 1;
        int idM = 1;
        
        Employee e = dao.getEmployeebyID(idE);
        Manager m = mdao.getManagerbyID(idM);
        
        String eName = "George";
        String ePass = "Jungle";
        String nName = "nadf";
        String nPass = "garf";
        String mName = "Ruben";
        String mPass = "Rodriguez";
       
        int flage =(eName.compareTo(e.getName())+ePass.compareTo(e.getPassword()));
        int flagm =(mName.compareTo(m.getName())+mPass.compareTo(m.getPassword()));
        int flagN =(nName.compareTo(e.getName())+nPass.compareTo(e.getPassword()));
        int flagP =(nName.compareTo(m.getName())+nPass.compareTo(m.getPassword()));
        boolean flagFunctionE = Login.loginEmployee(idE, eName, ePass);
        boolean flagFunctionM = Login.loginManager(idM, mName, mPass);
        boolean flagFunctionN = Login.loginEmployee(idE, nName, nPass);
        boolean flagFunctionP = Login.loginManager(idM, nName, nPass);
        System.out.println("Flage = "+flage + "\t eMethod: "+flagFunctionE);
        System.out.println("Flagm = "+flagm + "\t mMethod: "+flagFunctionM);
        System.out.println("Flagn = "+flagN + "\t NMethod: "+flagFunctionN);
        System.out.println("Flagp = "+flagP + "\t PMethod: "+flagFunctionP);
        System.out.println("eName = "+eName +"\tePass = "+ ePass);
        System.out.println("eName = "+e.getName() +"\tePass = "+ e.getPassword());
        System.out.println("mName = "+mName +"\tmPass = "+ mPass);
        System.out.println("mName = "+m.getName() +"\tmPass = "+ m.getPassword());
    }
}
