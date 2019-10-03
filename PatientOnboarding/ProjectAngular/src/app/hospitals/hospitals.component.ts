import { Component, OnInit } from '@angular/core';
import { HospitalService } from '../hospital/hospital.service';
import { Hospital } from '../hospital/hospital';

@Component({
  selector: 'app-hospitals',
  templateUrl: './hospitals.component.html',
  styleUrls: ['./hospitals.component.css']
})
export class HospitalsComponent implements OnInit {

  hospitals: Hospital[];

  constructor(private hospitalService: HospitalService) {
    this.hospitalService.selectAll().subscribe(data => {
      this.hospitals = data;
    });
    this.hospitals = this.hospitals;
}

  ngOnInit() {
  }

}
