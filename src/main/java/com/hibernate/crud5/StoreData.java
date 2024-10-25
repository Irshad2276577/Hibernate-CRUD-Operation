package com.hibernate.crud5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.crud4.Customer;

public class StoreData {
	public static void main(String[] args) {
		Student student=new Student();
		student.setId(1);
		student.setName("irshad");
		student.setField("Electronics and Communication Engineering");
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			session.save(student);
			transaction.commit();
			System.out.println("Data is saved into database");
		}catch(Exception e) {
			System.out.println("Data is not saved");
		}
			
	}

}
