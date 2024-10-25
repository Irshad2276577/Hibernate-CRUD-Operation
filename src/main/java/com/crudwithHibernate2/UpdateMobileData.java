package com.crudwithHibernate2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateMobileData {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			MobileApp app = session.get(MobileApp.class, 3);
			app.setName("iphone");
			app.setPrice(124500.00);
			session.update(app);
			transaction.commit();
			System.out.println("data update Successfully!!!");
		}catch(Exception e) {
			System.out.println("id is not found");
			e.printStackTrace();
		}finally {
			session.close();
			sf.close();
		}
	}
}
