 package com.crudWithHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class StoreData 
{
    public static void main( String[] args )
    {
    	
       /*
        * Save the data into database
        */
    	
    	Employee emp=new Employee();
    	emp.setName("harry");
    	emp.setEmail("harry@gmail.com");
    	emp.setCity("Kashmir");
    	emp.setSalary(29000.00);
    	emp.setPassword("harry");
    	
    	Configuration cfg=new Configuration();
    	cfg.configure("hibernate.cfg.xml");
    	
    	SessionFactory sf=cfg.buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction transaction = session.beginTransaction();
    	
    	try {
    		session.save(emp);
    		transaction.commit();
    		System.out.println("Data is saved into into database!!");
    	}catch(Exception e) {
    		System.out.println("Data is not saved into database");
    		e.printStackTrace();
    	}
    }
}
