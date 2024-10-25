package com.crudWithHibernate;

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
	        
	        Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        
	        SessionFactory sf = cfg.buildSessionFactory();
	        Session session = sf.openSession();
	        
	        try {
	            CriteriaBuilder cb=session.getCriteriaBuilder();
	            CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
	            Root<Employee> root = ((AbstractQuery<Employee>)query).from(Employee.class);
	            query.select(root);
	            Query<Employee> qu = session.createQuery(query);
	            List<Employee> list = qu.getResultList();
	            for(Employee emp:list) {
	            	System.out.println(emp.getId());
	            	System.out.println(emp.getName());
	            	System.out.println(emp.getEmail());
	            	System.out.println(emp.getPassword());
	            	System.out.println(emp.getSalary());
	            }
	        } catch (Exception e) {
	            System.out.println("An error occurred while fetching data.");
	            e.printStackTrace();
	        } finally {
	            session.close();
	            sf.close();
	        }
	    }
	}

