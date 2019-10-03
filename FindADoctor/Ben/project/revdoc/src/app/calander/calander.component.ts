import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { IDoctor } from '../Doctor';
import { SetValuesService } from '../setValues/set-values.service';
import dayGridPlugin from '@fullcalendar/daygrid';


@Component({
  selector: 'app-calander',
  templateUrl: './calander.component.html',
  styleUrls: ['./calander.component.css']
})
export class CalanderComponent implements OnInit {
  calendarPlugins = [dayGridPlugin]; // important!
  currentDoc = 'no name';
  theDoc: IDoctor;

  constructor(private route: ActivatedRoute, private setValues: SetValuesService) { }

  ngOnInit() {
    this.currentDoc = this.route.snapshot.paramMap.get('docname');
    this.theDoc = this.setValues.selectDoctorByName(this.currentDoc);
  }

}

