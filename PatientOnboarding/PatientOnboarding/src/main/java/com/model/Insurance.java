package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="insurance")
public class Insurance {

	@Id
	@Column(name="insurance_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="insurance_name", nullable=false)
	private InsuranceName insurance;
	
	@Column(name="member_id")
	private String memberId;
	
	@Column(name="group_id")
	private String groupId;
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="insurance")
	private List<Patient> patients;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public InsuranceName getInsurance() {
		return insurance;
	}

	public void setInsurance(InsuranceName insurance) {
		this.insurance = insurance;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public Insurance(int id, InsuranceName insurance, String memberId, String groupId, List<Patient> patients) {
		super();
		Id = id;
		this.insurance = insurance;
		this.memberId = memberId;
		this.groupId = groupId;
		this.patients = patients;
	}

	public Insurance(InsuranceName insurance, String memberId, String groupId, List<Patient> patients) {
		super();
		this.insurance = insurance;
		this.memberId = memberId;
		this.groupId = groupId;
		this.patients = patients;
	}
	
	public Insurance() {}

	@Override
	public String toString() {
		return "Insurance [Id=" + Id + ", insurance=" + insurance + ", memberId=" + memberId + ", groupId=" + groupId
				+ ", patients=" + patients + "]";
	}
	
}
