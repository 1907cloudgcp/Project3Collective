package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.EmergencyContact;

@Transactional
@Repository("emergencyContactDao")
public class EmergencyContactDao {
	
	private SessionFactory sf;
	
	public EmergencyContactDao() {}
	
	@Autowired
	public EmergencyContactDao(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public void insert(EmergencyContact obj) {
		sf.getCurrentSession().save(obj);
	}

	public List<EmergencyContact> selectAll() {
		List<EmergencyContact> list = sf.getCurrentSession().createQuery("from emergency_contact", EmergencyContact.class).list();
		
		return list;
	}
	
	public EmergencyContact select(int id) {
		
		EmergencyContact obj = (EmergencyContact) sf.getCurrentSession().get(EmergencyContact.class, id);
		
		return obj;
		
	}

}
