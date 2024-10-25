package com.hibernate.crud4;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class saveData {
	public static void main(String[] args) {
		Customer customer=new Customer();
		customer.setEmail("abac@gmail.com");
		customer.setName("amar");
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			session.save(customer);
			System.out.println("Data saved Successfully");
			transaction.commit();
		}catch(Exception e) {
			System.out.println("Database is not saved!!");
		}
	}

}
