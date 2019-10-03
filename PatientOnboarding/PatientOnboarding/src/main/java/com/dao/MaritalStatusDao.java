package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.MaritalStatus;

@Transactional
@Repository("MSD")
public class MaritalStatusDao {

	private SessionFactory sf;
	
	public MaritalStatusDao() {}
	
	@Autowired
	public MaritalStatusDao(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public void insert(MaritalStatus obj) {
		sf.getCurrentSession().save(obj);
	}

	public List<MaritalStatus> selectAll() {
		List<MaritalStatus> list = sf.getCurrentSession().createQuery("from marital_status", MaritalStatus.class).list();
		
		return list;
	}
	
	public MaritalStatus select(int id) {
		
		MaritalStatus obj = (MaritalStatus) sf.getCurrentSession().get(MaritalStatus.class, id);
		
		return obj;
		
	}
	
}
