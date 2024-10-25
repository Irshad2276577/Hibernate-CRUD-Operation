package com.hibernate.crud4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteData {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		try {
			Customer customer = session.get(Customer.class, 1);
			session.delete(customer);
			System.out.println("data deleted Successfully");
		}catch(Exception e) {
			System.out.println("id is not found");
		}
	}

}
