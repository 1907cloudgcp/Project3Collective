import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../user';
import { HealthRecord } from '../user-health-record/healthrecord';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private urlsave: string;
  private urlupdate: string;
  private urlselect: string;
  private urlPatientlogin: string;
  private urlAdminlogin: string;
  private urlDoctorlogin: string;
  private urlPatientId: string;
  private urlHealthRecord: string;
  private urlGetHealth: string;
  private urlGetPatients: string;

  constructor(private http: HttpClient) {
    this.urlsave = 'http://34.68.184.228/PatientOnboarding/api/insertuser.app';
    this.urlupdate = 'http://34.68.184.228/PatientOnboarding/api/updateuser.app';
    this.urlselect = 'http://34.68.184.228/PatientOnboarding/api/selectuser.app';
    this.urlPatientlogin = 'http://34.68.184.228/PatientOnboarding/api/loginuser.app';
    this.urlAdminlogin = 'http://34.68.184.228/PatientOnboarding/api/loginadmin.app';
    this.urlDoctorlogin = 'http://34.68.184.228/PatientOnboarding/api/logindoctor.app';
    this.urlPatientId = 'http://34.68.184.228/PatientOnboarding/api/iduser.app';
    this.urlHealthRecord = 'http://34.68.184.228/PatientOnboarding/api/insertrecord.app';
    this.urlGetHealth = 'http://34.68.184.228/PatientOnboarding/api/getrecord.app';
    this.urlGetPatients = 'http://34.68.184.228/PatientOnboarding/api/doctorpatients.app';
  }

  public save(user: User): Observable<User> {
    return this.http.post<User>(this.urlsave, user);
  }

  public update(user: User): Observable<string[]> {
    return this.http.post<string[]>(this.urlupdate, user);
  }

  public selectAll(): Observable<User[]> {
    return this.http.get<User[]>(this.urlselect);
  }

  public findByPatientName(user: User): Observable<User> {
    return this.http.post<User>(this.urlPatientlogin, user);
  }

  public findByPatientId(user: User): Observable<User> {
    return this.http.post<User>(this.urlPatientId, user);
  }

  public findByAdminName(user: User): Observable<User> {
    return this.http.post<User>(this.urlAdminlogin, user);
  }

  public findByDoctorName(user: User): Observable<User> {
    return this.http.post<User>(this.urlDoctorlogin, user);
  }

  public saveHealth(healthrecord: HealthRecord): Observable<HealthRecord> {
    return this.http.post<HealthRecord>(this.urlHealthRecord, healthrecord);
  }

  public getHealth(user: User): Observable<HealthRecord> {
    return this.http.post<HealthRecord>(this.urlGetHealth, user);
  }

  public selectDocsAll(user: User): Observable<User[]> {
    return this.http.post<User[]>(this.urlGetPatients, user);
  }
}
