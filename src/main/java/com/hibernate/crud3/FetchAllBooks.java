package com.hibernate.crud3;

import java.util.List;

import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class FetchAllBooks {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Book> query = cb.createQuery(Book.class);
			Root<Book> root = ((AbstractQuery<Book>)query).from(Book.class);
			query.select(root);
			
			Query<Book> cq = session.createQuery(query);
			List<Book> list = cq.getResultList();
			for(Book book:list) {
				System.out.println(book.getId());
				System.out.println(book.getBookname());
				System.out.println(book.getIsAvailable());
			}
		}catch(Exception e) {
				e.printStackTrace();
			}
		
		}
	}

