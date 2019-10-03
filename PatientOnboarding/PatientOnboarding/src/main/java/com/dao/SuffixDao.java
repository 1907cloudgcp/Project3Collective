package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Suffix;

@Transactional
@Repository("suffixDao")
public class SuffixDao {

	private SessionFactory sf;
	
	public SuffixDao() {}
	
	@Autowired
	public SuffixDao(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public void insert(Suffix obj) {
		sf.getCurrentSession().save(obj);
	}

	public List<Suffix> selectAll() {
		List<Suffix> list = sf.getCurrentSession().createQuery("from suffix", Suffix.class).list();
		
		return list;
	}
	
	public Suffix select(int id) {
		
		Suffix obj = (Suffix) sf.getCurrentSession().get(Suffix.class, id);
		
		return obj;
		
	}
	
}
