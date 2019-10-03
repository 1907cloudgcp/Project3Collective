package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="marital_status")
public class MaritalStatus {
	
	@Id
	@Column(name="marital_id")
	private int Id;
	
	@Column(name="marital_status", unique=true)
	private String status;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public MaritalStatus(int id, String status) {
		super();
		Id = id;
		this.status = status;
	}

	public MaritalStatus(String status) {
		super();
		this.status = status;
	}

	public MaritalStatus() {
		super();
	}

	@Override
	public String toString() {
		return status;
	}
	
	

}
