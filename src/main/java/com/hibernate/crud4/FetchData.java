package com.hibernate.crud4;

import java.util.List;

import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchData {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Customer> query = cb.createQuery(Customer.class);
		Root<Customer> root = ((AbstractQuery<Customer>)query).from(Customer.class);
		query.select(root);
		
		Query<Customer> cq = session.createQuery(query);
		List<Customer> list = cq.getResultList();
		for(Customer cs:list) {
			System.out.println(cs.getEmail());
			System.out.println(cs.getName());
		}
	}
}
