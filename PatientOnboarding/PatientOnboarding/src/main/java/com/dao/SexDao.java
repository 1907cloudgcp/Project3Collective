package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Sex;

@Transactional
@Repository("sexDao")
public class SexDao {

	private SessionFactory sf;
	
	public SexDao() {}
	
	@Autowired
	public SexDao(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public void insert(Sex obj) {
		sf.getCurrentSession().save(obj);
	}

	public List<Sex> selectAll() {
		List<Sex> list = sf.getCurrentSession().createQuery("from sex", Sex.class).list();
		
		return list;
	}
	
	public Sex select(int id) {
		
		Sex obj = (Sex) sf.getCurrentSession().get(Sex.class, id);
		
		return obj;
		
	}
	
}
