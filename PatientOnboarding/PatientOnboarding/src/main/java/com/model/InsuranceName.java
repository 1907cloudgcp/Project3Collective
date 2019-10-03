package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="insurance_name")
public class InsuranceName {

	@Id
	@Column(name="insurance_name_id")
	private int Id;
	
	@Column(name="insurance_name")
	private String name;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public InsuranceName(int id, String name) {
		super();
		Id = id;
		this.name = name;
	}

	public InsuranceName(String name) {
		super();
		this.name = name;
	}
	
	public InsuranceName() {}

	@Override
	public String toString() {
		return "InsuranceName [Id=" + Id + ", name=" + name + "]";
	}
	
}
