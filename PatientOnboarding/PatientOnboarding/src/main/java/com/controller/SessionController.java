package com.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.AdminDao;
import com.dao.DoctorDao;
import com.dao.FrequencyDao;
import com.dao.HealthRecordDao;
import com.dao.HospitalDao;
import com.dao.PatientDao;
import com.dao.UserRoleDao;
import com.model.Admin;
import com.model.Doctor;
import com.model.Frequency;
import com.model.HealthRecord;
import com.model.Hospital;
import com.model.Patient;
import com.model.UserRole;

@RequestMapping
@CrossOrigin(origins = "*")
@Controller
public class SessionController {
	
	private PatientDao patientDao;
	private UserRoleDao userRoleDao;
	private AdminDao adminDao;
	private DoctorDao doctorDao;
	private HospitalDao hospitalDao;
	private FrequencyDao freqDao;
	private HealthRecordDao hrDao;

	@Autowired
	public SessionController(PatientDao patientDao, UserRoleDao userRoleDao,
			AdminDao adminDao, DoctorDao doctorDao, HospitalDao hospitalDao,
			FrequencyDao freqDao, HealthRecordDao hrDao) {
		super();
		this.patientDao = patientDao;
		this.userRoleDao = userRoleDao;
		this.adminDao = adminDao;
		this.doctorDao = doctorDao;
		this.hospitalDao = hospitalDao;
		this.freqDao = freqDao;
		this.hrDao = hrDao;
	}
	
	public SessionController() {}

//	@GetMapping(value="/insertuser.app")
//	public String login(HttpServletRequest req) {
//		HttpSession session = req.getSession();
//		System.out.println("in the login method");
//		
//		//session.
//		
//		//System.out.println("\n\n\n");
//		return "nextpage.html";
//	}
	
//	@RequestMapping(value="/api/insertuser.app")
//	void getTest(HttpServletRequest req) {
//		System.out.println("in get test");
//	}
	
//	@SuppressWarnings("unchecked")
//	@GetMapping(value="/api/insertuser.app", consumes = MediaType.ALL_VALUE)
//	public @ResponseBody Patient getTest(@RequestBody Object stuff) {
//		System.out.println("in get test");
//		
//		ArrayList<String> ang = (ArrayList<String>) stuff;
//		String firstname = ang.get(0);
//		String lastname = ang.get(1);
//		String username = ang.get(2);
//		String password = ang.get(3);
//		
//		System.out.println(firstname + " " + lastname+" "+username+" "+password);
//		
//		//Admin admin = new Admin(firstname,lastname,username,password);
//		
//		return freqDao.select(1);
//	}
	
	@SuppressWarnings("unchecked")
	@PostMapping(value="/api/insertuser.app", consumes = MediaType.ALL_VALUE)
	public @ResponseBody Patient insertUser(@RequestBody Object stuff) {
		try {
			
			LinkedHashMap<String,String> ang = (LinkedHashMap<String,String>) stuff;
			String firstname = ang.get("firstName");
			String lastname = ang.get("lastName");
			Character middleinit = ang.get("middleInit").charAt(0);
			String email = ang.get("email");
			String username = ang.get("username");
			String password = ang.get("password");
			
			Patient test = patientDao.selectByUsername(username);
			Patient test2 = patientDao.selectByEmail(email);
			if(test != null || test2 != null) {
				throw new Exception();
			}
			
			Patient p = new Patient(firstname,middleinit,lastname,username,password,email);
			UserRole role = userRoleDao.select(1);
			p.setRole(role);
			p.setMiddleInit('s');
			p.setZip(0);
			p.setNumber(0);
			patientDao.insert(p);
			
			Patient patient = patientDao.selectByUsername(username);
			
			return patient;
		} catch (Exception e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
    @PostMapping(value="/api/iduser.app", consumes = MediaType.ALL_VALUE)
    public @ResponseBody Patient findById(@RequestBody Object stuff) {
        
        LinkedHashMap<String,Integer> ang = (LinkedHashMap<String,Integer>) stuff;
        Integer id = ang.get("id");
        
        Patient patient = patientDao.select(id);
        return patient;
    }
	
	@SuppressWarnings("unchecked")
	@PostMapping(value="/api/insertrecord.app", consumes = MediaType.ALL_VALUE)
	public @ResponseBody HealthRecord insertRecord(@RequestBody Object stuff) {
		
		LinkedHashMap<String,String> ang = (LinkedHashMap<String,String>) stuff;
		String username = ang.get("username");
		Boolean b1 = Boolean.parseBoolean(ang.get("bloodpressure"));
		Boolean b2 = Boolean.parseBoolean(ang.get("heartDisease"));
		Boolean b3 = Boolean.parseBoolean(ang.get("stroke"));
		Boolean b4 = Boolean.parseBoolean(ang.get("diabetes"));
		Boolean b5 = Boolean.parseBoolean(ang.get("digestive"));
		Boolean b6 = Boolean.parseBoolean(ang.get("lung"));
		Boolean b7 = Boolean.parseBoolean(ang.get("visual"));
		Boolean b8 = Boolean.parseBoolean(ang.get("joint"));
		Boolean b9 = Boolean.parseBoolean(ang.get("depression"));
		Boolean b10 = Boolean.parseBoolean(ang.get("cancer"));
		Boolean b11 = Boolean.parseBoolean(ang.get("liver"));
		Boolean b12 = Boolean.parseBoolean(ang.get("thyroid"));
		Boolean b13 = Boolean.parseBoolean(ang.get("hearing"));
		Boolean b14 = Boolean.parseBoolean(ang.get("smoke"));
		String b15 = ang.get("smokefreq");
		Boolean b16 = Boolean.parseBoolean(ang.get("tobacco"));
		String b17 = ang.get("tobaccofreq");
		Boolean b18 = Boolean.parseBoolean(ang.get("alcohol"));
		String b19 = ang.get("alcoholfreq");
		Boolean b20 = Boolean.parseBoolean(ang.get("caffeinated"));
		String b21 = ang.get("caffeinatedfreq");
		Boolean b22 = Boolean.parseBoolean(ang.get("drugs"));
		Boolean b23 = Boolean.parseBoolean(ang.get("sexually"));
		Boolean b24 = Boolean.parseBoolean(ang.get("exercise"));
		Boolean b25 = Boolean.parseBoolean(ang.get("livingWill"));
		
		Patient patient = patientDao.selectByUsername(username);
		
		
		Frequency never = freqDao.select(1);
		Frequency sometimes = freqDao.select(2);
		Frequency often = freqDao.select(3);
		
		Frequency f1 = null;
		Frequency f2 = null;
		Frequency f3 = null;
		Frequency f4 = null;
		
		switch(b15) {
		case "Never":
			f1 = never;
			break;
		case "Sometimes":
			f1 = sometimes;
			break;
		case "Often":
			f1 = often;
			break;
		}
		
		switch(b17) {
		case "Never":
			f2 = never;
			break;
		case "Sometimes":
			f2 = sometimes;
			break;
		case "Often":
			f2 = often;
			break;
		}
		
		switch(b19) {
		case "Never":
			f3 = never;
			break;
		case "Sometimes":
			f3 = sometimes;
			break;
		case "Often":
			f3 = often;
			break;
		}
		
		switch(b21) {
		case "Never":
			f4 = never;
			break;
		case "Sometimes":
			f4 = sometimes;
			break;
		case "Often":
			f4 = often;
			break;
		}
		
		if(patient.getRecord() != null) {
			HealthRecord health = patient.getRecord();
			health.setBloodpressure(b1);
			health.setHeartDisease(b2);
			health.setStroke(b3);
			health.setDiabetes(b4);
			health.setDigestive(b5);
			health.setLung(b6);
			health.setVisual(b7);
			health.setJoint(b8);
			health.setDepression(b9);
			health.setCancer(b10);
			health.setLiver(b11);
			health.setThyroid(b12);
			health.setHearing(b13);
			health.setSmoke(b14);
			health.setSmokefreq(f1);
			health.setTobacco(b16);
			health.setTobaccofreq(f2);
			health.setAlcohol(b18);
			health.setAlcoholfreq(f3);
			health.setCaffeinated(b20);
			health.setCaffeinatedfreq(f4);
			health.setDrugs(b22);
			health.setSexually(b23);
			health.setExercise(b24);
			health.setLivingWill(b25);
			hrDao.update(health);
			return health;
		}
		
		HealthRecord hr = new HealthRecord(patient,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,f1,b16,f2,b18,f3,b20,f4,b22,b23,b24,b25);
		hrDao.insert(hr);
		patient.setRecord(hr);
		patientDao.update(patient);
		HealthRecord h2 = hrDao.selectByPatient(patient);
		
		return h2;
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping(value="/api/getrecord.app", consumes = MediaType.ALL_VALUE)
	public @ResponseBody HealthRecord getRecord(@RequestBody Object stuff) {
		
		LinkedHashMap<String,String> ang = (LinkedHashMap<String,String>) stuff;
		String username = ang.get("username");
		
		Patient patient = patientDao.selectByUsername(username);
		
		HealthRecord record = hrDao.selectByPatient(patient);
		
		return record;
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping(value="/api/loginuser.app", consumes = MediaType.ALL_VALUE)
	public @ResponseBody Patient loginPatient(@RequestBody Object stuff) {
		try {
			
			LinkedHashMap<String,String> ang = (LinkedHashMap<String,String>) stuff;
			String username = ang.get("username");
			String password = ang.get("password");
			
			Patient patient = patientDao.selectByUsername(username);
			if(!password.equals(patient.getPassword())) {
				throw new Exception();
			}
			
			return patient;
		} catch (Exception e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping(value="/api/loginadmin.app", consumes = MediaType.ALL_VALUE)
	public @ResponseBody Admin loginAdmin(@RequestBody Object stuff) {
		try {
			
			LinkedHashMap<String,String> ang = (LinkedHashMap<String,String>) stuff;
			String username = ang.get("username");
			String password = ang.get("password");
			
			Admin admin = adminDao.selectByUsername(username);
			if(!password.equals(admin.getPassword())) {
				throw new Exception();
			}
			
			return admin;
		} catch (Exception e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping(value="/api/logindoctor.app", consumes = MediaType.ALL_VALUE)
	public @ResponseBody Doctor loginDoctor(@RequestBody Object stuff) {
		try {
			
			LinkedHashMap<String,String> ang = (LinkedHashMap<String,String>) stuff;
			String username = ang.get("username");
			String password = ang.get("password");
			
			Doctor doctor = doctorDao.selectByUsername(username);
			if(!password.equals(doctor.getPass())) {
				throw new Exception();
			}
			
			return doctor;
		} catch (Exception e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping(value="/api/updateuser.app", consumes = MediaType.ALL_VALUE)
	public @ResponseBody Patient update(@RequestBody Object stuff) {
		
		LinkedHashMap<String,String> ang = (LinkedHashMap<String,String>) stuff;
		String firstName = ang.get("firstName");
		String lastName = ang.get("lastName");
		Character middleInit = ang.get("middleInit").charAt(0);
		String username = ang.get("username");
		String password = ang.get("password");
		String address = ang.get("address");
		String state = ang.get("state");
		Integer zip = Integer.parseInt(ang.get("zip"));
		Long number = Long.parseLong(ang.get("number"));
		String email = ang.get("email");
		
		Patient patient = patientDao.selectByUsername(username);
		
		patient.setFirstName(firstName);
		patient.setLastName(lastName);
		patient.setMiddleInit(middleInit);
		patient.setUsername(username);
		patient.setPassword(password);
		patient.setAddress(address);
		patient.setState(state);
		patient.setZip(zip);
		patient.setNumber(number);
		patient.setEmail(email);
		
		patientDao.update(patient);
		
		Patient p2 = patientDao.selectByUsername(username);
		
		return p2;
	}
	
	@GetMapping(value="/api/selectuser.app", consumes = MediaType.ALL_VALUE)
	public @ResponseBody List<Patient> allPatients() {
		
		List<Patient> patients = patientDao.selectAll();
		
		return patients;
	}
	
	@GetMapping(value="/api/health.app", consumes = MediaType.ALL_VALUE)
	public @ResponseBody HealthRecord health() {
		
		Patient patient = patientDao.selectByUsername("user");
		
		HealthRecord record = hrDao.selectByPatient(patient);
		
		return record;
	}
	
	@GetMapping(value="/api/selecthospital.app", consumes = MediaType.ALL_VALUE)
	public @ResponseBody List<Hospital> allHospitals() {
		
		List<Hospital> hospitals = hospitalDao.selectAll();
		
		return hospitals;
	}
	
	@SuppressWarnings("unchecked")
    @PostMapping(value="/api/selecthospitalid.app", consumes = MediaType.ALL_VALUE)
    public @ResponseBody Hospital findByHospId(@RequestBody Object stuff) {
        
        LinkedHashMap<String,Integer> ang = (LinkedHashMap<String,Integer>) stuff;
        Integer id = ang.get("id");
        
        Hospital hospital = hospitalDao.select(id);
        
        return hospital;
    }
	
	@SuppressWarnings("unchecked")
    @PostMapping(value="/api/hospitaldocs.app", consumes = MediaType.ALL_VALUE)
    public @ResponseBody List<Doctor> getHospitalDocs(@RequestBody Object stuff) {
        
        LinkedHashMap<String,Integer> ang = (LinkedHashMap<String,Integer>) stuff;
        Integer id = ang.get("id");
        
        Hospital hospital = hospitalDao.select(id);
        LinkedHashSet<Doctor> hashSet = new LinkedHashSet<>(hospital.getDoctors());
        ArrayList<Doctor> nodups = new ArrayList<>(hashSet);
        return nodups;
    }
	
	@SuppressWarnings("unchecked")
    @PostMapping(value="/api/doctorpatients.app", consumes = MediaType.ALL_VALUE)
    public @ResponseBody List<Patient> getDocPatients(@RequestBody Object stuff) {
        
        LinkedHashMap<String,Integer> ang = (LinkedHashMap<String,Integer>) stuff;
        Integer id = ang.get("id");
        
        Doctor doctor = doctorDao.select(id);
        List<Patient> patients = doctor.getPatients();
        LinkedHashSet<Patient> hashSet = new LinkedHashSet<>(patients);
        patients = new ArrayList<>(hashSet);
        
        return patients;
    }
	
	@SuppressWarnings("unchecked")
    @PostMapping(value="/api/setdoctorpatient.app", consumes = MediaType.ALL_VALUE)
    public @ResponseBody String setDocPatient(@RequestBody Object stuff) {
        
        LinkedHashMap<String,Integer> ang = (LinkedHashMap<String,Integer>) stuff;
        Integer did = ang.get("docid");
        Integer pid = ang.get("patiendid");
        
        Doctor doctor = doctorDao.select(did);
        Patient patient = patientDao.select(pid);
        List<Doctor> doctors = patient.getDoctors();
        doctors.add(doctor);
        patient.setDoctors(doctors);
        
        patientDao.update(patient);
        
        return null;
    }
	
//	@GetMapping(value="/api/selecthosp.app", consumes = MediaType.ALL_VALUE)
//	public @ResponseBody Hospital hospital() {
//		System.out.println("in hospital");
//		
//		Hospital hospitals = hospitalDao.select(1);
//		System.out.println(hospitals);
//		
//		return hospitals;
//	}
	
//	@RequestMapping(value="/api/insertuser.app")
//    public @ResponseBody String test(HttpServletRequest req) {
//        System.out.println("in post test");
//        return freqDao.selectAll().toString();
//    }
	
//	@ResponseBody
//	public Admin handle(@RequestParam(value = "user") String user,HttpServletRequest request){
//		return new Admin();
//	}

	
}
