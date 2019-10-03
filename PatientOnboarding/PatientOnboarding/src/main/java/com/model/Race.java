package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="race")
public class Race {
	
	@Id
	@Column(name="race_id")
	private int Id;
	
	@Column(name="race", unique=true)
	private String race;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public Race(int id, String race) {
		super();
		Id = id;
		this.race = race;
	}

	public Race(String race) {
		super();
		this.race = race;
	}

	public Race() {
		super();
	}

	@Override
	public String toString() {
		return race;
	}
	
	

}
