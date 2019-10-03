package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sex")
public class Sex {

	@Id
	@Column(name="sex_id")
	private int Id;
	
	@Column(name="sex", unique=true)
	private String sex;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Sex(int id, String sex) {
		super();
		Id = id;
		this.sex = sex;
	}

	public Sex(String sex) {
		super();
		this.sex = sex;
	}

	public Sex() {
		super();
	}

	@Override
	public String toString() {
		return sex;
	}
	
	
	
}
