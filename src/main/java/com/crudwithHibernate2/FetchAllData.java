package com.crudwithHibernate2;

import java.util.List;

import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class FetchAllData {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure();
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		try {
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<MobileApp> query = cb.createQuery(MobileApp.class);
			Root<MobileApp> root = ((AbstractQuery<MobileApp>)query).from(MobileApp.class);
			query.select(root);
			Query<MobileApp> cq = session.createQuery(query);
			List<MobileApp> list = cq.getResultList();
			for(MobileApp emp:list) {
				System.out.println(emp.getId());
				System.out.println(emp.getDescription());
				System.out.println(emp.getPrice());
				System.out.println(emp.getRating());
				System.out.println(emp.getName());
			}
		}catch(Exception e) {
			System.out.println("Something is wrong!!!!");
			e.printStackTrace();
		}
	}

}
