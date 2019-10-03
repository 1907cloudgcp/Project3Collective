package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medications")
public class Medications {

	@Id
	@Column(name="medication_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	
	@Column(name="medication_name")
	private String meds;
	
	@Column(name="prescribed_dose")
	private String dose;
	
	@Column(name="frequency_taken")
	private String freq;
	
	@Column(name="currently_taking")
	private boolean bool;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getMeds() {
		return meds;
	}

	public void setMeds(String meds) {
		this.meds = meds;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public String getFreq() {
		return freq;
	}

	public void setFreq(String freq) {
		this.freq = freq;
	}

	public boolean isBool() {
		return bool;
	}

	public void setBool(boolean bool) {
		this.bool = bool;
	}

	public Medications(int id, String meds, String dose, String freq, boolean bool) {
		super();
		Id = id;
		this.meds = meds;
		this.dose = dose;
		this.freq = freq;
		this.bool = bool;
	}

	public Medications(String meds, String dose, String freq, boolean bool) {
		super();
		this.meds = meds;
		this.dose = dose;
		this.freq = freq;
		this.bool = bool;
	}
	
	public Medications() {}

	@Override
	public String toString() {
		return "Medications [Id=" + Id + ", meds=" + meds + ", dose=" + dose + ", freq=" + freq + ", bool=" + bool
				+ "]";
	}
	
}
