package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.UserRole;

@Transactional
@Repository("userRoleDao")
public class UserRoleDao {
	
	private SessionFactory sf;
	
	public UserRoleDao() {}
	
	@Autowired
	public UserRoleDao(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public void insert(UserRole obj) {
		sf.getCurrentSession().save(obj);
	}

	public List<UserRole> selectAll() {
		List<UserRole> list = sf.getCurrentSession().createQuery("from UserRole", UserRole.class).list();
		
		return list;
	}
	
	public UserRole select(int id) {
		
		UserRole obj = (UserRole) sf.getCurrentSession().get(UserRole.class, id);
		
		return obj;
		
	}

}
