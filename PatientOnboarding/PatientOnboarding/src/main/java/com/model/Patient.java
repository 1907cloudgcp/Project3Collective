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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value= {"hospitals","insurance","medications","doctors","salutation","suffix","marital_status","ethnicity","race","sex","emergency_contact","record"})
@Entity
@Table(name="patient")
public class Patient {

	@Id
	@Column(name="patient_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="middle_initial")
	private Character middleInit;
	
	@Column(name="last_name", nullable=false)
	private String lastName;
	
	@Column(name="username", nullable=false, unique=true)
	private String username;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="salutation")
	private Salutation salutation;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="suffix")
	private Suffix suffix;
	
	@Column(name="street_address")
	private String address;
	
	@Column(name="state")
	private String state;
	
	@Column(name="zip_code")
	private Integer zip;
	
	@Column(name="contact_number")
	private Long number;
	
	@Column(name="email", unique=true)
	private String email;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="marital_status")
	private MaritalStatus status;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="ethnicity")
	private Ethnicity ethnicity;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="race")
	private Race race;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="sex")
	private Sex sex;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Hospital> hospitals;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Insurance> insurance;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Medications> medications;
	
	@OneToOne(cascade=CascadeType.ALL)
	private EmergencyContact emergencyContact;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="user_role")
	private UserRole role;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="health_record")
	private HealthRecord record;
	
	@ManyToMany(cascade={
	        CascadeType.PERSIST,
	        CascadeType.MERGE
	    }, fetch = FetchType.EAGER)
	private List<Doctor> doctors;

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

	public char getMiddleInit() {
		return middleInit;
	}

	public void setMiddleInit(char middleInit) {
		this.middleInit = middleInit;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Salutation getSalutation() {
		return salutation;
	}

	public void setSalutation(Salutation salutation) {
		this.salutation = salutation;
	}

	public Suffix getSuffix() {
		return suffix;
	}

	public void setSuffix(Suffix suffix) {
		this.suffix = suffix;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MaritalStatus getStatus() {
		return status;
	}

	public void setStatus(MaritalStatus status) {
		this.status = status;
	}

	public Ethnicity getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(Ethnicity ethnicity) {
		this.ethnicity = ethnicity;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Hospital> getHospitals() {
		return hospitals;
	}

	public void setHospitals(List<Hospital> hospitals) {
		this.hospitals = hospitals;
	}

	public List<Insurance> getInsurance() {
		return insurance;
	}

	public void setInsurance(List<Insurance> insurance) {
		this.insurance = insurance;
	}

	public List<Medications> getMedications() {
		return medications;
	}

	public void setMedications(List<Medications> medications) {
		this.medications = medications;
	}

	public EmergencyContact getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(EmergencyContact emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public HealthRecord getRecord() {
		return record;
	}

	public void setRecord(HealthRecord record) {
		this.record = record;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Patient(String firstName, String lastName, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	public Patient(String firstName, Character middleInit, String lastName, String username, String password,
			String email) {
		super();
		this.firstName = firstName;
		this.middleInit = middleInit;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public Patient() {
		super();
	}

	@Override
	public String toString() {
		return "Patient [Id=" + Id + ", firstName=" + firstName + ", middleInit=" + middleInit + ", lastName="
				+ lastName + ", username=" + username + ", password=" + password +", role=" + role +"]";
	}

	
	
	
	
}
