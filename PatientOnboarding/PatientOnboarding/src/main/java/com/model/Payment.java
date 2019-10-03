package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {

	@Id
	@Column(name="payment_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Patient patient;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Hospital hospital;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Doctor doctor;
	
	@Column(name="amount")
	private double amount;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Payment(int id, Patient patient, Hospital hospital, Doctor doctor, double amount) {
		super();
		Id = id;
		this.patient = patient;
		this.hospital = hospital;
		this.doctor = doctor;
		this.amount = amount;
	}

	public Payment(Patient patient, Hospital hospital, Doctor doctor, double amount) {
		super();
		this.patient = patient;
		this.hospital = hospital;
		this.doctor = doctor;
		this.amount = amount;
	}
	
	public Payment() {}

	@Override
	public String toString() {
		return "Payment [Id=" + Id + ", patient=" + patient + ", hospital=" + hospital + ", doctor=" + doctor
				+ ", amount=" + amount + "]";
	}
	
}
