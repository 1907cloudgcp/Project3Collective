import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Hospital } from '../hospital/hospital';
import { HospitalService } from '../hospital/hospital.service';
import { Doctor } from '../hospital/doctor';
import { TransferService } from '../transfer/transfer.service';
import { User } from '../user';
import { Myobj } from './docandpat';

@Component({
  selector: 'app-hospital-info',
  templateUrl: './hospital-info.component.html',
  styleUrls: ['./hospital-info.component.css']
})
export class HospitalInfoComponent implements OnInit {

  currentHospital: Hospital;
  currentHospitalId = 'no id';
  hospital: Hospital;
  doctors: Doctor[];
  obj: Myobj;

  constructor(private route: ActivatedRoute, private hospService: HospitalService,
              private transferService: TransferService, private user: User) {
    this.hospital = new Hospital();
    this.obj = new Myobj();
  }

  ngOnInit() {
    this.currentHospitalId = this.route.snapshot.paramMap.get('id');
    this.hospital.id = parseInt(this.currentHospitalId, 10);
    this.user = this.transferService.getUser();
    this.hospService.findByHospId(this.hospital).subscribe(data => {
      this.currentHospital = data;
      return this.currentHospital;
    });
    this.hospService.findHospDoc(this.hospital).subscribe(data => {
      this.doctors = data;
    });

  }

  usertodoc(curdoctorid: number) {
    alert('We\'ll contact you soon to make an appointment');
    this.user = this.transferService.getUser();
    this.obj.docid = curdoctorid;
    this.obj.patiendid = this.user.id;
    this.hospService.setUserToDoc(this.obj).subscribe(data => {
    });
  }

}
