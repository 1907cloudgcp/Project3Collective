package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value= {"patients"})
@Entity
@Table(name="doctor")
public class Doctor {

	@Id
	@Column(name="doctor_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name", nullable=false)
	private String lastName;
	
	@Column(name="username", nullable=false, unique=true)
	private String username;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@Column(name="specialty", nullable=false)
	private String specialty;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Hospital hospital;
	
	@ManyToMany(mappedBy="doctors", fetch = FetchType.EAGER)
	private List<Patient> patients;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_role")
	private UserRole role;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return password;
	}

	public void setPass(String password) {
		this.password = password;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public Doctor(int id, String firstName, String lastName, String username, String password, String specialty,
			Hospital hospital, List<Patient> patients, UserRole role) {
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.specialty = specialty;
		this.hospital = hospital;
		this.patients = patients;
		this.role = role;
	}

	public Doctor(String firstName, String lastName, String username, String password, String specialty, Hospital hospital,
			List<Patient> patients, UserRole role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.specialty = specialty;
		this.hospital = hospital;
		this.patients = patients;
		this.role = role;
	}
	
	public Doctor(String firstName, String lastName, String username, String password, String specialty,
			UserRole role, Hospital hospital) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.specialty = specialty;
		this.role = role;
		this.hospital = hospital;
	}

	public Doctor() {}

	@Override
	public String toString() {
		return "Doctor [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", specialty=" + specialty + ", hospital=" + hospital.getName() + ", role=" + role + "]";
	}
	
}
