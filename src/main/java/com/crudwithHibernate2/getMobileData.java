package com.crudwithHibernate2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class getMobileData {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session session = sf.openSession();
		try {
			MobileApp app = session.get(MobileApp.class, 1);
			System.out.println(app.getId());
			System.out.println(app.getDescription());
			System.out.println(app.getName());
			System.out.println(app.getPrice());
			System.out.println(app.getRating());
		}catch(Exception e) {
			System.out.println("Id is not found");
			e.printStackTrace();
		}
	}

}
