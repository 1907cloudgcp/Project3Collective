package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Race;

@Transactional
@Repository("raceDao")
public class RaceDao {

	private SessionFactory sf;
	
	public RaceDao() {}
	
	@Autowired
	public RaceDao(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public void insert(Race obj) {
		sf.getCurrentSession().save(obj);
	}

	public List<Race> selectAll() {
		List<Race> list = sf.getCurrentSession().createQuery("from race", Race.class).list();
		
		return list;
	}
	
	public Race select(int id) {
		
		Race obj = (Race) sf.getCurrentSession().get(Race.class, id);
		
		return obj;
		
	}
	
}
