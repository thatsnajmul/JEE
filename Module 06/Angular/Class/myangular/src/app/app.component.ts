import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'myangular';
  

  isLoggedIn: boolean = true;

  logout() {
    this.isLoggedIn = false; // Call this method when the user logs out
  }

  login() {
    this.isLoggedIn = true;  // Call this method when the user logs in
  }
 
}
