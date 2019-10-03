package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.InsuranceName;

@Transactional
@Repository("insuranceNameDao")
public class InsuranceNameDao {
	
	private SessionFactory sf;
	
	public InsuranceNameDao() {}
	
	@Autowired
	public InsuranceNameDao(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public void insert(InsuranceName obj) {
		sf.getCurrentSession().save(obj);
	}

	public List<InsuranceName> selectAll() {
		List<InsuranceName> list = sf.getCurrentSession().createQuery("from insurance_name", InsuranceName.class).list();
		
		return list;
	}
	
	public InsuranceName select(int id) {
		
		InsuranceName obj = (InsuranceName) sf.getCurrentSession().get(InsuranceName.class, id);
		
		return obj;
		
	}

}
