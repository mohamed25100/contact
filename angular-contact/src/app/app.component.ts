import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-contact';
  isLoggedIn = false;

  constructor(private router: Router) {
  }

  toggleAuth() {
    this.isLoggedIn = !this.isLoggedIn;
  }
  Contacts() {
    this.router.navigateByUrl('contacts');
  }
  Home() {
    this.router.navigateByUrl('');
  }
}
