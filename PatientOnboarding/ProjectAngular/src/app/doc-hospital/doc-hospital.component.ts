import { Component, OnInit } from '@angular/core';
import { TransferService } from '../transfer/transfer.service';
import { User } from '../user';
import { Hospital } from '../hospital/hospital';
import { Doctor } from '../hospital/doctor';

@Component({
  selector: 'app-doc-hospital',
  templateUrl: './doc-hospital.component.html',
  styleUrls: ['./doc-hospital.component.css']
})
export class DocHospitalComponent implements OnInit {
  hospital: Hospital;
  doctor: Doctor;

  constructor(private transferService: TransferService, private user: User) {
    this.hospital = new Hospital();
    this.doctor = new Doctor();
  }

  ngOnInit() {
    this.user = this.transferService.getUser();
   // this.doctor = this.user;
  }

}
