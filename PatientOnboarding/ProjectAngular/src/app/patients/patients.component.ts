import { Component } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user/user.service';

@Component({
  selector: 'app-patients',
  templateUrl: './patients.component.html',
  styleUrls: ['./patients.component.css']
})
export class PatientsComponent {
  patients: User[];
  user: User;

  constructor(private userService: UserService) {
      this.userService.selectAll().subscribe(data => {
        this.patients = data;
      });
      this.patients = this.patients;
  }

}
