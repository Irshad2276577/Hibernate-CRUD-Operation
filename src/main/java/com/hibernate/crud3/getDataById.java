package com.hibernate.crud3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class getDataById {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		try {
			Book book = session.get(Book.class, 1);
			System.out.println(book.getBookname());
			System.out.println(book.getIsAvailable());
			
		}catch(Exception e) {
			System.out.println("id is not found");
		}
		
	}

}
