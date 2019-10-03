package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Hospital;

@Transactional
@Repository("hospitalDao")
public class HospitalDao {
	
	private SessionFactory sf;
	
	public HospitalDao() {}
	
	@Autowired
	public HospitalDao(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public void insert(Hospital obj) {
		sf.getCurrentSession().save(obj);
	}

	public List<Hospital> selectAll() {
		List<Hospital> list = sf.getCurrentSession().createQuery("from Hospital", Hospital.class).list();
		
		return list;
	}
	
	public Hospital select(int id) {
		
		Hospital obj = (Hospital) sf.getCurrentSession().get(Hospital.class, id);
		
		return obj;
		
	}

}
