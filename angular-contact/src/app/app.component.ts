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
  AddContact() {
    this.router.navigateByUrl('contact/add');
  }
  Home() {
    this.router.navigateByUrl('');
  }
}
