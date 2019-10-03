package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_role")
public class UserRole {

	@Id
	@Column(name="role_id")
	private int Id;
	
	@Column(name="role")
	private String role;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserRole(int id, String role) {
		super();
		Id = id;
		this.role = role;
	}
	
	public UserRole() {}

	@Override
	public String toString() {
		return "UserRole [Id=" + Id + ", role=" + role + "]";
	}
	
}
