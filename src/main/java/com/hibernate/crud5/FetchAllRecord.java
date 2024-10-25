
package com.hibernate.crud5;

import java.util.List;

import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.crud4.Customer;

public class FetchAllRecord {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Student> query = cb.createQuery(Student.class);
			Root<Student> root = ((AbstractQuery<Student>)query).from(Student.class);
			query.select(root);
			
			Query<Student> cq = session.createQuery(query);
			List<Student> list = cq.getResultList();
			for(Student s1:list) {
				System.out.println(s1.getId());
				System.out.println(s1.getName());
				System.out.println(s1.getField());
			}
	}
}
