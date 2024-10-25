package com.crudWithHibernate;

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
			Employee employee = session.get(Employee.class, 5);
			int id = employee.getId();
			String email = employee.getEmail();
			String password = employee.getPassword();
			String name = employee.getName();
			String city = employee.getCity();
			System.out.println(id);
			System.out.println(email);
			System.out.println(name);
			System.out.println(password);
			System.out.println(city);
		}catch(Exception e) {
			System.out.println("Database Id is not found");
			e.printStackTrace();
		}
	}
}
