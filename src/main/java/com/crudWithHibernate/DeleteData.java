package com.crudWithHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteData {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Employee employee = session.get(Employee.class, 4);
			session.delete(employee);
			transaction.commit();
			System.out.println("Data deleted Successfullly");
		}catch(Exception e) {
			transaction.rollback();
			System.out.println("Id is not found");
			e.printStackTrace();
		}
	}

}
