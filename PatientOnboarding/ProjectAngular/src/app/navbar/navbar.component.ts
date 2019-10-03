import { Component, OnInit } from '@angular/core';
import { TransferService } from '../transfer/transfer.service';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from '../user/user.service';
import { User } from '../user';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private router: Router, private route: ActivatedRoute, private userService: UserService,
              private transferService: TransferService, private user: User) {
     }

  ngOnInit() {
    this.user = this.transferService.getUser();
  }
  logout() {
    this.transferService.clearUser();
  }
}

