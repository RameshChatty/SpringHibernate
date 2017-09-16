package com.bank.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bank.entity.CustomersData;

@Repository
public class BankDaoImpl implements BankDao{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public void addCustomer(CustomersData customersdata) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(customersdata);
		System.out.println("data added suucess fully");
		
	}

}
