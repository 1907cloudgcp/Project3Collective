import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';

@Injectable({
  providedIn: 'root'
})
export class TransferService {

  constructor(
    private router: Router,
  ) { }

  private user: User;

  setUser(data: User) {
    this.user = data;
  }

  getUser() {
    return this.user;
  }

  clearUser() {
    this.user = undefined;
  }
}
