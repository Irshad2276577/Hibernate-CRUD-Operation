package com.crudwithHibernate2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveMobileData {
	public static void main(String[] args) {
		MobileApp mobile=new MobileApp();
		mobile.setName("Apple");
		mobile.setPrice(122000.00);
		mobile.setRating("4");
		mobile.setDescription("This mobile provide 16gb ram + 128px camera.");
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
		session.save(mobile);
		transaction.commit();
			System.out.println("Data is saved into database!!!");
		}catch(Exception e) {
			System.out.println("Data is not saved into database!!");
		}finally {
			session.close();
			sf.close();
		}
		
	}

}
