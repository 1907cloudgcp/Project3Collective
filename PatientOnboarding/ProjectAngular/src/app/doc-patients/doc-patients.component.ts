import { Component, OnInit } from '@angular/core';
import { UserService } from '../user/user.service';
import { User } from '../user';
import { TransferService } from '../transfer/transfer.service';

@Component({
  selector: 'app-doc-patients',
  templateUrl: './doc-patients.component.html',
  styleUrls: ['./doc-patients.component.css']
})
export class DocPatientsComponent {

  patients: User[];

  constructor(private userService: UserService, private transferService: TransferService, private user: User) {
    this.user = this.transferService.getUser();
    this.userService.selectDocsAll(this.user).subscribe(data => {
        this.patients = data;
      });
  }

}
