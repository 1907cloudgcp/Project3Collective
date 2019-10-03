package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value= {"patients","insurances","doctors","admins"})
@Entity
@Table(name="hospital")
public class Hospital {

	@Id
	@Column(name="provider_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	
	@Column(name="provider_name", nullable=false)
	private String name;
	
	@Column(name="street_address", nullable=false)
	private String address;
	
	@Column(name="state", nullable=false)
	private String state;
	
	@Column(name="zip_code", nullable=false)
	private int zip;
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="hospitals")
	private List<Patient> patients;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<InsuranceName> insurances;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Doctor> doctors;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Admin> admins;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public List<InsuranceName> getInsurances() {
		return insurances;
	}

	public void setInsurances(List<InsuranceName> insurances) {
		this.insurances = insurances;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public List<Admin> getAdmins() {
		return admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}

	public Hospital(int id, String name, String address, String state, int zip, List<Patient> patients,
			List<InsuranceName> insurances, List<Doctor> doctors, List<Admin> admins) {
		super();
		Id = id;
		this.name = name;
		this.address = address;
		this.state = state;
		this.zip = zip;
		this.patients = patients;
		this.insurances = insurances;
		this.doctors = doctors;
		this.admins = admins;
	}

	public Hospital(String name, String address, String state, int zip, List<Patient> patients,
			List<InsuranceName> insurances, List<Doctor> doctors, List<Admin> admins) {
		super();
		this.name = name;
		this.address = address;
		this.state = state;
		this.zip = zip;
		this.patients = patients;
		this.insurances = insurances;
		this.doctors = doctors;
		this.admins = admins;
	}
	
	public Hospital(String name, String address, String state, int zip) {
		super();
		this.name = name;
		this.address = address;
		this.state = state;
		this.zip = zip;
	}

	public Hospital() {}

	@Override
	public String toString() {
		return "Hospital [Id=" + Id + ", name=" + name + ", address=" + address + ", state=" + state + ", zip=" + zip
				+"]";
	}
	
}
