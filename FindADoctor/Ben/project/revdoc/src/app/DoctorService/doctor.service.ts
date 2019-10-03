import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { IDoctor } from '../Doctor';
import { Page1Component } from '../page1/page1.component';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {
  private url = 'http://localhost:9005/RevatureDoctor/Doctor.json';
  Credentails: string[];

  constructor(private httpCli: HttpClient) { }
  retrieveDoctor(email: string, password: string): Observable<IDoctor> {
    this.Credentails = [email, password];
    return this.httpCli.post<IDoctor>(this.url, JSON.stringify(this.Credentails));

  }
}
