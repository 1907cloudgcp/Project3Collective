package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value= {"patient"})
@Entity
@Table(name="health_record")
public class HealthRecord {

	@Id
	@Column(name="record_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Patient patient;
	
	@Column(name="high_blood_pressure", nullable=false)
	private boolean bloodpressure;
	
	@Column(name="heart_disease", nullable=false)
	private boolean heartDisease;
	
	@Column(name="stroke", nullable=false)
	private boolean stroke;
	
	@Column(name="diabetes", nullable=false)
	private boolean diabetes;
	
	@Column(name="digestive_problems", nullable=false)
	private boolean digestive;
	
	@Column(name="lung_problems", nullable=false)
	private boolean lung;
	
	@Column(name="visual_impairment", nullable=false)
	private boolean visual;
	
	@Column(name="back_or_joint_problems", nullable=false)
	private boolean joint;
	
	@Column(name="depression_or_severe_anxiety", nullable=false)
	private boolean depression;
	
	@Column(name="cancer", nullable=false)
	private boolean cancer;
	
	@Column(name="liver_problems", nullable=false)
	private boolean liver;
	
	@Column(name="thyroid_problems", nullable=false)
	private boolean thyroid;
	
	@Column(name="hearing_problems", nullable=false)
	private boolean hearing;
	
	@Column(name="smoke", nullable=false)
	private boolean smoke;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="smoke_freq")
	private Frequency smokefreq;
	
	@Column(name="chewing_tobacco_snuff", nullable=false)
	private boolean tobacco;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="chewing_freq")
	private Frequency tobaccofreq;
	
	@Column(name="alcohol", nullable=false)
	private boolean alcohol;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="alcohol_freq")
	private Frequency alcoholfreq;
	
	@Column(name="caffein", nullable=false)
	private boolean caffeinated;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="caffein_freq")
	private Frequency caffeinatedfreq;
	
	@Column(name="drugs", nullable=false)
	private boolean drugs;
	
	@Column(name="sexually_active", nullable=false)
	private boolean sexually;
	
	@Column(name="exercise_regularly", nullable=false)
	private boolean exercise;
	
	@Column(name="living_will", nullable=false)
	private boolean livingWill;

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

	public boolean isBloodpressure() {
		return bloodpressure;
	}

	public void setBloodpressure(boolean bloodpressure) {
		this.bloodpressure = bloodpressure;
	}

	public boolean isHeartDisease() {
		return heartDisease;
	}

	public void setHeartDisease(boolean heartDisease) {
		this.heartDisease = heartDisease;
	}

	public boolean isStroke() {
		return stroke;
	}

	public void setStroke(boolean stroke) {
		this.stroke = stroke;
	}

	public boolean isDiabetes() {
		return diabetes;
	}

	public void setDiabetes(boolean diabetes) {
		this.diabetes = diabetes;
	}

	public boolean isDigestive() {
		return digestive;
	}

	public void setDigestive(boolean digestive) {
		this.digestive = digestive;
	}

	public boolean isLung() {
		return lung;
	}

	public void setLung(boolean lung) {
		this.lung = lung;
	}

	public boolean isVisual() {
		return visual;
	}

	public void setVisual(boolean visual) {
		this.visual = visual;
	}

	public boolean isJoint() {
		return joint;
	}

	public void setJoint(boolean joint) {
		this.joint = joint;
	}

	public boolean isDepression() {
		return depression;
	}

	public void setDepression(boolean depression) {
		this.depression = depression;
	}

	public boolean isCancer() {
		return cancer;
	}

	public void setCancer(boolean cancer) {
		this.cancer = cancer;
	}

	public boolean isLiver() {
		return liver;
	}

	public void setLiver(boolean liver) {
		this.liver = liver;
	}

	public boolean isThyroid() {
		return thyroid;
	}

	public void setThyroid(boolean thyroid) {
		this.thyroid = thyroid;
	}

	public boolean isHearing() {
		return hearing;
	}

	public void setHearing(boolean hearing) {
		this.hearing = hearing;
	}

	public boolean isSmoke() {
		return smoke;
	}

	public void setSmoke(boolean smoke) {
		this.smoke = smoke;
	}

	public Frequency getSmokefreq() {
		return smokefreq;
	}

	public void setSmokefreq(Frequency smokefreq) {
		this.smokefreq = smokefreq;
	}

	public boolean isTobacco() {
		return tobacco;
	}

	public void setTobacco(boolean tobacco) {
		this.tobacco = tobacco;
	}

	public Frequency getTobaccofreq() {
		return tobaccofreq;
	}

	public void setTobaccofreq(Frequency tobaccofreq) {
		this.tobaccofreq = tobaccofreq;
	}

	public boolean isAlcohol() {
		return alcohol;
	}

	public void setAlcohol(boolean alcohol) {
		this.alcohol = alcohol;
	}

	public Frequency getAlcoholfreq() {
		return alcoholfreq;
	}

	public void setAlcoholfreq(Frequency alcoholfreq) {
		this.alcoholfreq = alcoholfreq;
	}

	public boolean isCaffeinated() {
		return caffeinated;
	}

	public void setCaffeinated(boolean caffeinated) {
		this.caffeinated = caffeinated;
	}

	public Frequency getCaffeinatedfreq() {
		return caffeinatedfreq;
	}

	public void setCaffeinatedfreq(Frequency caffeinatedfreq) {
		this.caffeinatedfreq = caffeinatedfreq;
	}

	public boolean isDrugs() {
		return drugs;
	}

	public void setDrugs(boolean drugs) {
		this.drugs = drugs;
	}

	public boolean isSexually() {
		return sexually;
	}

	public void setSexually(boolean sexually) {
		this.sexually = sexually;
	}

	public boolean isExercise() {
		return exercise;
	}

	public void setExercise(boolean exercise) {
		this.exercise = exercise;
	}

	public boolean isLivingWill() {
		return livingWill;
	}

	public void setLivingWill(boolean livingWill) {
		this.livingWill = livingWill;
	}

	public HealthRecord(Patient patient, boolean b, boolean b1, boolean b2, boolean b3, boolean b4, boolean b5,
			boolean b6, boolean b7, boolean b8, boolean b9, boolean b10, boolean b11, boolean b12, boolean b13,
			Frequency smoke, boolean b14, Frequency chew, boolean b15, Frequency alc, boolean b16, Frequency caff,
			boolean b17, boolean b18, boolean b19, boolean b20) {
		super();
		this.patient = patient;
		this.bloodpressure = b;
		this.heartDisease = b1;
		this.stroke = b2;
		this.diabetes = b3;
		this.digestive = b4;
		this.lung = b5;
		this.visual = b6;
		this.joint = b7;
		this.depression = b8;
		this.cancer = b9;
		this.liver = b10;
		this.thyroid = b11;
		this.hearing = b12;
		this.smoke = b13;
		this.smokefreq = smoke;
		this.tobacco = b14;
		this.tobaccofreq = chew;
		this.alcohol = b15;
		this.alcoholfreq = alc;
		this.caffeinated = b16;
		this.caffeinatedfreq = caff;
		this.drugs = b17;
		this.sexually = b18;
		this.exercise = b19;
		this.livingWill = b20;
	}

	public HealthRecord(int id, Patient patient, boolean b, boolean b1, boolean b2, boolean b3, boolean b4, boolean b5,
			boolean b6, boolean b7, boolean b8, boolean b9, boolean b10, boolean b11, boolean b12, boolean b13,
			Frequency smoke, boolean b14, Frequency chew, boolean b15, Frequency alc, boolean b16, Frequency caff,
			boolean b17, boolean b18, boolean b19, boolean b20) {
		super();
		Id = id;
		this.patient = patient;
		this.bloodpressure = b;
		this.heartDisease = b1;
		this.stroke = b2;
		this.diabetes = b3;
		this.digestive = b4;
		this.lung = b5;
		this.visual = b6;
		this.joint = b7;
		this.depression = b8;
		this.cancer = b9;
		this.liver = b10;
		this.thyroid = b11;
		this.hearing = b12;
		this.smoke = b13;
		this.smokefreq = smoke;
		this.tobacco = b14;
		this.tobaccofreq = chew;
		this.alcohol = b15;
		this.alcoholfreq = alc;
		this.caffeinated = b16;
		this.caffeinatedfreq = caff;
		this.drugs = b17;
		this.sexually = b18;
		this.exercise = b19;
		this.livingWill = b20;
	}

	public HealthRecord() {
		super();
	}

	@Override
	public String toString() {
		return "HealthRecord [Id=" + Id + ", patient=" + patient + ", b=" + bloodpressure + ", b1=" + heartDisease + ", b2=" + stroke + ", b3="
				+ diabetes + ", b4=" + digestive + ", b5=" + lung + ", b6=" + visual + ", b7=" + joint + ", b8=" + depression + ", b9=" + cancer
				+ ", b10=" + liver + ", b11=" + thyroid + ", b12=" + hearing + ", b13=" + smoke + ", smoke=" + smokefreq + ", b14="
				+ tobacco + ", chew=" + tobaccofreq + ", b15=" + alcohol + ", alc=" + alcoholfreq + ", b16=" + caffeinated + ", caff=" + caffeinatedfreq
				+ ", b17=" + drugs + ", b18=" + sexually + ", b19=" + exercise + ", b20=" + livingWill + "]";
	}
	
}
