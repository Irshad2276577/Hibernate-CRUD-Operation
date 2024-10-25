package com.crudWithHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateData {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		
		try {
			Employee employee = session.get(Employee.class, 4);
			employee.setEmail("babu@gmail.com");
			employee.setName("love");
			employee.setPassword("raj");
			employee.setSalary(50000.00);
			session.update(employee);
			transaction.commit();
		}catch(Exception e) {
			System.out.println("Data is not present!!!");
			e.printStackTrace();
		}
	}

}
