package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Salutation;

@Transactional
@Repository("salutationDao")
public class SalutationDao {

	private SessionFactory sf;
	
	public SalutationDao() {}
	
	@Autowired
	public SalutationDao(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public void insert(Salutation obj) {
		sf.getCurrentSession().save(obj);
	}

	public List<Salutation> selectAll() {
		List<Salutation> list = sf.getCurrentSession().createQuery("from salutation", Salutation.class).list();
		
		return list;
	}
	
	public Salutation select(int id) {
		
		Salutation obj = (Salutation) sf.getCurrentSession().get(Salutation.class, id);
		
		return obj;
		
	}
	
}
