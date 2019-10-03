package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="salutation")
public class Salutation {
	
	@Id
	@Column(name="salutation_id")
	private int Id;
	
	@Column(name="salutation", unique=true)
	private String salutation;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public Salutation(int id, String salutation) {
		super();
		Id = id;
		this.salutation = salutation;
	}

	public Salutation(String salutation) {
		super();
		this.salutation = salutation;
	}

	public Salutation() {
		super();
	}

	@Override
	public String toString() {
		return salutation;
	}
	
	

}
