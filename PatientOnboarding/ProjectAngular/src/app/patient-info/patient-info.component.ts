import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Patients } from '../patients/patients';
import { PatientsComponent } from '../patients/patients.component';
import { FormControl, FormGroup } from '@angular/forms';
import { User } from '../user';
import { UserService } from '../user/user.service';
import { TransferService } from '../transfer/transfer.service';
import { HealthRecord } from '../user-health-record/healthrecord';
import { Frequency } from '../frequency';

declare var $: any;

@Component({
  selector: 'app-patient-info',
  templateUrl: './patient-info.component.html',
  styleUrls: ['./patient-info.component.css']
})
export class PatientInfoComponent implements OnInit {

  currentPatient = 'no name';
  curPatient: User;
  user: User;
  img = 'assets/user2.jpeg';
  healthRecord = new HealthRecord();

  constructor(private route: ActivatedRoute, private userService: UserService, private freq: Frequency) {
                this.user = new User();
                const bool = false;
                this.healthRecord.bloodpressure = bool;
                this.healthRecord.heartDisease = bool;
                this.healthRecord.stroke = bool;
                this.healthRecord.diabetes = bool;
                this.healthRecord.digestive = bool;
                this.healthRecord.lung = bool;
                this.healthRecord.visual = bool;
                this.healthRecord.joint = bool;
                this.healthRecord.depression = bool;
                this.healthRecord.cancer = bool;
                this.healthRecord.liver = bool;
                this.healthRecord.thyroid = bool;
                this.healthRecord.hearing = bool;
                this.healthRecord.drugs = bool;
                this.healthRecord.sexually = bool;
                this.healthRecord.exercise = bool;
                this.healthRecord.livingWill = bool;
                this.healthRecord.smoke = bool;
                this.healthRecord.tobacco = bool;
                this.healthRecord.alcohol = bool;
                this.healthRecord.caffeinated = bool;
                this.freq.frequency = 'empty';
                this.healthRecord.smokefreq = this.freq;
                this.healthRecord.tobaccofreq = this.freq;
                this.healthRecord.caffeinatedfreq = this.freq;
                this.healthRecord.alcoholfreq = this.freq;
               }

  userEdit = new FormGroup({
    firstname: new FormControl(''),
    lastname: new FormControl(''),
    middlename: new FormControl(''),
    salutation: new FormControl(''),
    suffix: new FormControl(''),
    streetaddress: new FormControl(''),
    state: new FormControl(''),
    zipcode: new FormControl(''),
    contactnum: new FormControl(''),
    email: new FormControl(''),
    marital: new FormControl(''),
    ethnicity: new FormControl(''),
    username: new FormControl(''),
    password: new FormControl(''),
    race: new FormControl(''),
    sex: new FormControl(''),
  });

  ngOnInit() {
    this.currentPatient = this.route.snapshot.paramMap.get('userId');
    this.user.id = parseInt(this.currentPatient, 10);
    this.userService.findByPatientId(this.user).subscribe(data => {
      this.curPatient = data;
      this.img = `assets/user${this.curPatient.username}.jpeg`;
      this.userService.getHealth(this.curPatient).subscribe(record => {
        if (record !== null) {
          this.healthRecord = record;
        }
      });
      return this.curPatient;
    });

  }

  edit(): void {
    this.curPatient.firstName = this.userEdit.value.firstname;
    this.curPatient.lastName = this.userEdit.value.lastname;
   // this.user.username = this.userEdit.value.username;
   // this.user.password = this.userEdit.value.password;
    $('.modal').removeClass('in');
    $('.modal').attr('aria-hidden', 'true');
    $('.modal').css('display', 'none');
    $('.modal-backdrop').remove();
    $('body').removeClass('modal-open');
    this.userService.update(this.user).subscribe(data => {
    });
  }
}
