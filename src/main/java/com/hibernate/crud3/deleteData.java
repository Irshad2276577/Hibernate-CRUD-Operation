package com.hibernate.crud3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class deleteData {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			Book book = session.get(Book.class, 2);
			session.delete(book);
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
			System.out.println("id is not found");
			e.printStackTrace();
		}
	}

}
