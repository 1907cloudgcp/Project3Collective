package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="suffix")
public class Suffix {

	@Id
	@Column(name="suffix_id")
	private int Id;
	
	@Column(name="suffix", unique=true)
	private String suffix;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Suffix(int id, String suffix) {
		super();
		Id = id;
		this.suffix = suffix;
	}

	public Suffix(String suffix) {
		super();
		this.suffix = suffix;
	}

	public Suffix() {
		super();
	}

	@Override
	public String toString() {
		return suffix;
	}
	
	
	
}
