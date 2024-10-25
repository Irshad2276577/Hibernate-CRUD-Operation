package com.hibernate.crud4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetData {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		try {
			Customer customer = session.get(Customer.class, 1);
			System.out.println(customer.getId());
			System.out.println(customer.getName());
			System.out.println(customer.getEmail());
		}catch(Exception e) {
			System.out.println("id is not found");
			e.printStackTrace();
		}
	}

}
