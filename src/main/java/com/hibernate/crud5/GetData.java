package com.hibernate.crud5;

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
			Student student = session.get(Student.class, 2);
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getField());
		}catch(Exception e) {
			System.out.println("id is not found");
			e.printStackTrace();
		}
	}

}
