package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Medications;

@Transactional
@Repository("medicationsDao")
public class MedicationsDao {
	
	private SessionFactory sf;
	
	public MedicationsDao() {}
	
	@Autowired
	public MedicationsDao(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public void insert(Medications obj) {
		sf.getCurrentSession().save(obj);
	}

	public List<Medications> selectAll() {
		List<Medications> list = sf.getCurrentSession().createQuery("from medications", Medications.class).list();
		
		return list;
	}
	
	public Medications select(int id) {
		
		Medications obj = (Medications) sf.getCurrentSession().get(Medications.class, id);
		
		return obj;
		
	}

}
