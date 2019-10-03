package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Payment;

@Transactional
@Repository("paymentDao")
public class PaymentDao {
	
	private SessionFactory sf;
	
	public PaymentDao() {}
	
	@Autowired
	public PaymentDao(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public void insert(Payment obj) {
		sf.getCurrentSession().save(obj);
	}

	public List<Payment> selectAll() {
		List<Payment> list = sf.getCurrentSession().createQuery("from payment", Payment.class).list();
		
		return list;
	}
	
	public Payment select(int id) {
		
		Payment obj = (Payment) sf.getCurrentSession().get(Payment.class, id);
		
		return obj;
		
	}

}
