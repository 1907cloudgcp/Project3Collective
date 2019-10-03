package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Frequency;

@Transactional
@Repository("frequencyDao")
public class FrequencyDao {
	
	private SessionFactory sf;
	
	public FrequencyDao() {}
	
	@Autowired
	public FrequencyDao(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public void insert(Frequency obj) {
		sf.getCurrentSession().save(obj);
	}

	public List<Frequency> selectAll() {
		List<Frequency> list = sf.getCurrentSession().createQuery("from Frequency", Frequency.class).list();
		
		return list;
	}
	
	public Frequency select(int id) {
		
		Frequency obj = (Frequency) sf.getCurrentSession().get(Frequency.class, id);
		
		return obj;
		
	}

}
