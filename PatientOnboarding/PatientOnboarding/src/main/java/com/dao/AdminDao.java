package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Admin;

@Transactional
@Repository("adminDao")
public class AdminDao {
	
	private SessionFactory sf;
	
	public AdminDao() {}
	
	@Autowired
	public AdminDao(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public void insert(Admin obj) {
		sf.getCurrentSession().save(obj);
	}

	public List<Admin> selectAll() {
		List<Admin> list = sf.getCurrentSession().createQuery("from Admin", Admin.class).list();
		
		return list;
	}
	
	public Admin select(int id) {
		
		Admin obj = (Admin) sf.getCurrentSession().get(Admin.class, id);
		
		return obj;
		
	}
	
	public Admin selectByUsername(String username) {
		
		List<Admin> list = sf.getCurrentSession().createQuery("from Admin where username='"+username+"'", Admin.class).list();
		
		return list.get(0);
		
	}

}
