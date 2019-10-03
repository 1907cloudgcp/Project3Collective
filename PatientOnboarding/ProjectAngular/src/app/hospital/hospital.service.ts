import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Hospital } from './hospital';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Doctor } from './doctor';
import { Myobj } from '../hospital-info/docandpat';

@Injectable({
  providedIn: 'root'
})
export class HospitalService {

  private urlselect: string;
  private urlHospId: string;
  private urlHospDoc: string;
  private urlSetDoc: string;

  constructor(private http: HttpClient) {
    this.urlselect = 'http://34.68.184.228/PatientOnboarding/api/selecthospital.app';
    this.urlHospId = 'http://34.68.184.228/PatientOnboarding/api/selecthospitalid.app';
    this.urlHospDoc = 'http://34.68.184.228/PatientOnboarding/api/hospitaldocs.app';
    this.urlSetDoc = 'http://34.68.184.228/PatientOnboarding/api/setdoctorpatient.app';
  }

  public selectAll(): Observable<Hospital[]> {
    return this.http.get<Hospital[]>(this.urlselect);
  }

  public findByHospId(hospital: Hospital): Observable<Hospital> {
    return this.http.post<Hospital>(this.urlHospId, hospital);
  }

  public findHospDoc(hospital: Hospital): Observable<Doctor[]> {
    return this.http.post<Doctor[]>(this.urlHospDoc, hospital);
  }

  public setUserToDoc(obj: Myobj): Observable<string> {
    return this.http.post<string>(this.urlSetDoc, obj);
  }

}
