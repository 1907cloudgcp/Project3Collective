package com;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.AdminDao;
import com.dao.DoctorDao;
import com.dao.EmergencyContactDao;
import com.dao.EthnicityDao;
import com.dao.FrequencyDao;
import com.dao.HealthRecordDao;
import com.dao.HospitalDao;
import com.dao.InsuranceDao;
import com.dao.InsuranceNameDao;
import com.dao.MaritalStatusDao;
import com.dao.MedicationsDao;
import com.dao.PatientDao;
import com.dao.PaymentDao;
import com.dao.RaceDao;
import com.dao.SalutationDao;
import com.dao.SexDao;
import com.dao.SuffixDao;
import com.dao.UserRoleDao;
import com.model.Admin;
import com.model.Doctor;
import com.model.Ethnicity;
import com.model.Frequency;
import com.model.Hospital;
import com.model.MaritalStatus;
import com.model.Race;
import com.model.Salutation;
import com.model.Sex;
import com.model.Suffix;
import com.model.UserRole;

//@SuppressWarnings("unused")
public class Driver {

	public static ApplicationContext appContext=
			new ClassPathXmlApplicationContext("applicationContext.xml");
	
	public static EthnicityDao ethDao = appContext.getBean("ethDao", EthnicityDao.class);
	public static MaritalStatusDao msd = appContext.getBean("MSD",MaritalStatusDao.class);
	public static PatientDao pDao = appContext.getBean("patientDao",PatientDao.class);
	public static RaceDao raceDao = appContext.getBean("raceDao",RaceDao.class);
	public static SalutationDao salDao = appContext.getBean("salutationDao",SalutationDao.class);
	public static SexDao sexDao = appContext.getBean("sexDao",SexDao.class);
	public static SuffixDao suffDao = appContext.getBean("suffixDao",SuffixDao.class);
	public static AdminDao adminDao = appContext.getBean("adminDao",AdminDao.class);
	public static DoctorDao doctorDao = appContext.getBean("doctorDao",DoctorDao.class);
	public static EmergencyContactDao emDao = appContext.getBean("emergencyContactDao",EmergencyContactDao.class);
	public static FrequencyDao freqDao = appContext.getBean("frequencyDao",FrequencyDao.class);
	public static HealthRecordDao healthDao = appContext.getBean("healthRecordDao", HealthRecordDao.class);
	public static HospitalDao hospitalDao = appContext.getBean("hospitalDao",HospitalDao.class);
	public static InsuranceDao insuranceDao = appContext.getBean("insuranceDao",InsuranceDao.class);
	public static InsuranceNameDao inNameDao = appContext.getBean("insuranceNameDao",InsuranceNameDao.class);
	public static MedicationsDao medDao = appContext.getBean("medicationsDao",MedicationsDao.class);
	public static PaymentDao paymentDao = appContext.getBean("paymentDao",PaymentDao.class);
	public static UserRoleDao roleDao = appContext.getBean("userRoleDao",UserRoleDao.class);
	
	public static void main(String[] args) {
		
		insertInitialValues();
//		System.out.println(selectAll());
		
	}

	private static void insertInitialValues() {
		
		Ethnicity e1 = new Ethnicity(1,"Hispanic or Latino or Spanish Origin");
		Ethnicity e2 = new Ethnicity(2,"Not Hispanic or Latino or Spanish Origin");
		
		ethDao.insert(e1);
		ethDao.insert(e2);
		
		Race r1 = new Race(1,"American Indian or Alaska Native");
		Race r2 = new Race(2,"Asian");
		Race r3 = new Race(3,"Black or African American");
		Race r4 = new Race(4,"Native Hawaiian or Other Pacific Islander");
		Race r5 = new Race(5,"White");
		
		raceDao.insert(r1);
		raceDao.insert(r2);
		raceDao.insert(r3);
		raceDao.insert(r4);
		raceDao.insert(r5);
		
		MaritalStatus m1 = new MaritalStatus(1,"Married");
		MaritalStatus m2 = new MaritalStatus(2,"Widowed");
		MaritalStatus m3 = new MaritalStatus(3,"Divorced");
		MaritalStatus m4 = new MaritalStatus(4,"Separated");
		MaritalStatus m5 = new MaritalStatus(5,"Never Married");
		
		msd.insert(m1);
		msd.insert(m2);
		msd.insert(m3);
		msd.insert(m4);
		msd.insert(m5);
		
		Sex s1 = new Sex(1,"Female");
		Sex s2 = new Sex(2,"Male");
		Sex s3 = new Sex(3,"Other");
		
		sexDao.insert(s1);
		sexDao.insert(s2);
		sexDao.insert(s3);
		
		Salutation l1 = new Salutation(1,"Mr.");
		Salutation l2 = new Salutation(2,"Mrs.");
		Salutation l3 = new Salutation(3,"Miss.");
		Salutation l4 = new Salutation(4,"Ms.");
		Salutation l5 = new Salutation(5,"Dr.");
		
		salDao.insert(l1);
		salDao.insert(l2);
		salDao.insert(l3);
		salDao.insert(l4);
		salDao.insert(l5);
		
		Suffix f1 = new Suffix(1,"Sr.");
		Suffix f2 = new Suffix(2,"Jr.");
		
		suffDao.insert(f1);
		suffDao.insert(f2);
		
		Frequency freq1 = new Frequency(1,"Never");
		Frequency freq2 = new Frequency(2,"Sometimes");
		Frequency freq3 = new Frequency(3,"Often");
		
		freqDao.insert(freq1);
		freqDao.insert(freq2);
		freqDao.insert(freq3);
		
		UserRole role1 = new UserRole(1,"Patient");
		UserRole role2 = new UserRole(2,"Doctor");
		UserRole role3 = new UserRole(3,"Admin");
		
		roleDao.insert(role1);
		roleDao.insert(role2);
		roleDao.insert(role3);
		
		Hospital h1 = new Hospital("Newlife Hospital", "67 Constitution Dr.", "Reynoldsburg, OH", 43068);
		List<Doctor> h1docs = new ArrayList<>();
		Hospital h2 = new Hospital("Care & Cure Hospital","828 Depot Court","Hilliard, OH", 43062);
		List<Doctor> h2docs = new ArrayList<>();
		Hospital h3 = new Hospital("Medwin Cares", "51 Sunbeam Dr.", "Elizabethtown, PA", 17022);
		List<Doctor> h3docs = new ArrayList<>();
		Hospital h4 = new Hospital("Rejuvenate","502 W. Fairway St.","Canonsburg, PA", 15317);
		List<Doctor> h4docs = new ArrayList<>();
		Hospital h5 = new Hospital("Mankind Medicare", "1 Bayberry Drive", "Aiken, SC", 29803);
		List<Doctor> h5docs = new ArrayList<>();
		
		UserRole adminRole = roleDao.select(3);
		UserRole docRole = roleDao.select(2);
		
		Admin a1 = new Admin(adminRole,"Aditya", "Nolan", "panicjustice", "newjax");
		Admin a2 = new Admin(adminRole,"Aimee", "Kane", "bikezany", "cheelriverside");
		Admin a3 = new Admin(adminRole,"Abigail", "Salazar", "noeabject", "ussafe");
		Admin a4 = new Admin(adminRole,"Aliya", "Carlson", "oldtall", "zodiacalvegetable");
		
		adminDao.insert(a1);
		adminDao.insert(a2);
		adminDao.insert(a3);
		adminDao.insert(a4);
		
		Doctor d1 = new Doctor("Jamarcus","Randall","clothingshrug","realrowdy","Addiction",docRole,h1);
		h1docs.add(d1);
		Doctor d2 = new Doctor("Mikayla","Whitaker","sunresale","sporesfall","Orthotics",docRole,h2);
		h2docs.add(d2);
		Doctor d3 = new Doctor("Kasey","Gross","boxlikerose","heelwhoosh","Pediatrics",docRole,h1);
		h1docs.add(d3);
		Doctor d4 = new Doctor("Cecelia","Simpson","Technography","scrumpy","Allergy",docRole,h3);
		h3docs.add(d4);
		Doctor d5 = new Doctor("Selah","Hebert","Malliot","Abderian","Emergency Medicine",docRole,h4);
		h4docs.add(d5);
		Doctor d6 = new Doctor("Stephanie","Khan","telpherage","lobcock","Family",docRole,h5);
		h5docs.add(d6);
		Doctor d7 = new Doctor("Dominique","Eaton","pannose","nephalism","Sports Medicine",docRole,h4);
		h4docs.add(d7);
		Doctor d8 = new Doctor("Kymani","Tucker","abattoir","tubicornous","General Surgery",docRole,h2);
		h2docs.add(d8);
		Doctor d9 = new Doctor("Yareli","Maynard","filoselle","ametropia","Radiologist",docRole,h3);
		h3docs.add(d9);
		Doctor d10 = new Doctor("Ean","Krueger","firkinja5580","radiology","Family",docRole,h5);
		h5docs.add(d10);
		Doctor d11 = new Doctor("Taniyah","Morton","doldrums","hoosegow","Geriatric",docRole,h2);
		h2docs.add(d11);
		Doctor d12 = new Doctor("Elliot","Hendricks","luminous","gimbals","Family",docRole,h1);
		h1docs.add(d12);
		Doctor d13 = new Doctor("Evelyn","Watts","cribriform","postface","Family",docRole,h2);
		h2docs.add(d13);
		
		h1.setDoctors(h1docs);
		h2.setDoctors(h2docs);
		h3.setDoctors(h3docs);
		h4.setDoctors(h4docs);
		h5.setDoctors(h5docs);
		
		hospitalDao.insert(h1);
		hospitalDao.insert(h2);
		hospitalDao.insert(h3);
		hospitalDao.insert(h4);
		hospitalDao.insert(h5);
		
		
//		Salutation s = SalutationDao.select(1);
//		Suffix sx = SuffixDao.select(1);
//		MaritalStatus m = MaritalStatusDao.select(1);
//		Ethnicity e = EthnicityDao.select(2);
//		Race r = RaceDao.select(2);
//		Sex sex = SexDao.select(2);
//		
//		Patient p1 = new Patient("Sparta", 'S', "Spartans", "sparta", "pass", s, sx, "This is sparta", "state of sparta",
//				28791, 555_555_5555L, "sparta@sparta.com", m, e, r, sex);
//		
//		PatientDao.insert(p1);
		
	}
	
	public static String selectAll() {
		String frequencies = freqDao.selectAll().toString();
		return frequencies;
	}
	
}
