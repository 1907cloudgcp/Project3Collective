package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="emergency_contact")
public class EmergencyContact {

	@Id
	@Column(name="contact_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name", nullable=false)
	private String lastName;
	
	@Column(name="contact_number", nullable=false)
	private long num;
	
	@Column(name="relationship_to_patient", nullable=false)
	private String relation;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Patient patient;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public EmergencyContact() {}

	public EmergencyContact(int id, String firstName, String lastName, long num, String relation, Patient patient) {
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.num = num;
		this.relation = relation;
		this.patient = patient;
	}

	public EmergencyContact(String firstName, String lastName, long num, String relation, Patient patient) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.num = num;
		this.relation = relation;
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "EmergencyContact [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", num=" + num
				+ ", relation=" + relation + ", patient=" + patient + "]";
	}
	
}
