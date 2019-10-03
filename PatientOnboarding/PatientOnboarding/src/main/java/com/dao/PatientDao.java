package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Patient;

@Transactional
@Repository("patientDao")
public class PatientDao {

	private SessionFactory sf;
	
	public PatientDao() {}
	
	@Autowired
	public PatientDao(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public void insert(Patient obj) {
		sf.getCurrentSession().save(obj);
	}

	public List<Patient> selectAll() {
		List<Patient> list = sf.getCurrentSession().createQuery("from Patient", Patient.class).list();
		
		return list;
	}
	
	public Patient select(int id) {
		
		Patient obj = (Patient) sf.getCurrentSession().get(Patient.class, id);
		
		return obj;
		
	}
	
	public Patient selectByUsername(String username) {
		
		try {
			List<Patient> list = sf.getCurrentSession().createQuery("from Patient where username='"+username+"'", Patient.class).list();

			return list.get(0);
		} catch (Exception e) {
			return null;
		}
		
	}
	
	public void update(Patient obj) {
		
		sf.getCurrentSession().merge(obj);
		
	}
	
	public Patient selectByEmail(String email) {
		try {
			List<Patient> list = sf.getCurrentSession().createQuery("from Patient where email='"+email+"'", Patient.class).list();
			
			return list.get(0);
		} catch (Exception e) {
			return null;
		}
		
	}
	
}
