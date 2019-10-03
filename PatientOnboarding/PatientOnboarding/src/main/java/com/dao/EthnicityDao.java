package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Ethnicity;

@Transactional
@Repository("ethDao")
public class EthnicityDao {

	static {
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private SessionFactory sf;
	
	public EthnicityDao() {}
	
	@Autowired
	public EthnicityDao(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public void insert(Ethnicity obj) {
		sf.getCurrentSession().save(obj);
	}

	public List<Ethnicity> selectAll() {
		List<Ethnicity> list = sf.getCurrentSession().createQuery("from ethnicity", Ethnicity.class).list();
		
		return list;
	}
	
	public Ethnicity select(int id) {
		
		Ethnicity obj = (Ethnicity) sf.getCurrentSession().get(Ethnicity.class, id);
		
		return obj;
		
	}
	
}
