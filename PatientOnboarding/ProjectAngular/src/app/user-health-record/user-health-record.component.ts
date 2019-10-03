import { Component, OnInit, Injectable } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../user/user.service';
import { User } from '../user';
import { TransferService } from '../transfer/transfer.service';
import { HealthRecord } from './healthrecord';
import { stringify } from 'querystring';
import { Frequency } from '../frequency';

declare var $: any;

@Component({
  selector: 'app-user-health-record',
  templateUrl: './user-health-record.component.html',
  styleUrls: ['./user-health-record.component.css']
})

export class UserHealthRecordComponent implements OnInit {

  constructor(private router: Router, private route: ActivatedRoute, private userService: UserService,
              private transferService: TransferService, private healthRecord: HealthRecord, private freq: Frequency) {
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

  userHealthRecord = new FormGroup({
    bloodpressure: new FormControl(''),
    heartDisease: new FormControl(''),
    stroke: new FormControl(''),
    diabetes: new FormControl(''),
    digestive: new FormControl(''),
    lung: new FormControl(''),
    visual: new FormControl(''),
    joint: new FormControl(''),
    depression: new FormControl(''),
    cancer: new FormControl(''),
    liver: new FormControl(''),
    thyroid: new FormControl(''),
    hearing: new FormControl(''),
    drugs: new FormControl(''),
    sexually: new FormControl(''),
    exercise: new FormControl(''),
    livingWill: new FormControl(''),
    smoke: new FormControl(''),
    smokefreq: new FormControl(''),
    tobacco: new FormControl(''),
    tobaccofreq: new FormControl(''),
    alcohol: new FormControl(''),
    alcoholfreq: new FormControl(''),
    caffeinated: new FormControl(''),
    caffeinatedfreq: new FormControl(''),
  });

  ngOnInit() {
    this.userService.getHealth(this.transferService.getUser()).subscribe(data => {
      if (data !== null) {
        this.healthRecord = data;
      }
    });
  }

  save(): void {
    this.healthRecord = this.userHealthRecord.value;
    this.healthRecord.username = this.transferService.getUser().username;
    this.userService.saveHealth(this.healthRecord).subscribe(data => {
      this.healthRecord = data;
    });
    $('.modal').removeClass('in');
    $('.modal').attr('aria-hidden', 'true');
    $('.modal').css('display', 'none');
    $('.modal-backdrop').remove();
    $('body').removeClass('modal-open');
    // this.userService.update(this.user).subscribe(data => {
    //   console.log(data);
    // });
  }

}
