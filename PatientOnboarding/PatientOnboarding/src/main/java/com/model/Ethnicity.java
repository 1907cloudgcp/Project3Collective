package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ethnicity")
public class Ethnicity {
	
	@Id
	@Column(name="ethnicity_id")
	private int Id;
	
	@Column(name="ethnicity", unique=true)
	private String ethnicity;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	public Ethnicity(int id, String ethnicity) {
		super();
		Id = id;
		this.ethnicity = ethnicity;
	}

	public Ethnicity(String ethnicity) {
		super();
		this.ethnicity = ethnicity;
	}

	public Ethnicity() {
		super();
	}

	@Override
	public String toString() {
		return ethnicity;
	}
	
	

}
