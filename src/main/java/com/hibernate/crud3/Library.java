package com.hibernate.crud3;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Library {
	public static void main(String[] args) {
		Book book=new Book();
		book.setBookname("Day Without Night");
		book.setIsAvailable("yes");
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		try {
			session.save(book);
			System.out.println("database save");
			tx.commit();
		}catch(Exception e) {
			System.out.println("not found");
		}
	}
}
