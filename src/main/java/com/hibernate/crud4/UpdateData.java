package com.hibernate.crud4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateData {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Customer customer = session.get(Customer.class, 1);
			customer.setEmail("raj@gmail.com");
			customer.setName("raj");
			session.update(customer);
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println("id is not found");
		}
	}
}
