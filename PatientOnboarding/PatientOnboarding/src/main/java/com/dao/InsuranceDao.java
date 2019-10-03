package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Insurance;

@Transactional
@Repository("insuranceDao")
public class InsuranceDao {
	
	private SessionFactory sf;
	
	public InsuranceDao() {}
	
	@Autowired
	public InsuranceDao(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public void insert(Insurance obj) {
		sf.getCurrentSession().save(obj);
	}

	public List<Insurance> selectAll() {
		List<Insurance> list = sf.getCurrentSession().createQuery("from insurance", Insurance.class).list();
		
		return list;
	}
	
	public Insurance select(int id) {
		
		Insurance obj = (Insurance) sf.getCurrentSession().get(Insurance.class, id);
		
		return obj;
		
	}

}
