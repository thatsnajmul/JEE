import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';


@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrl: './logout.component.css'
})
export class LogoutComponent {


  logout() {
    if (typeof window !== 'undefined') {
      localStorage.removeItem('token');  // Perform logout
    } else {
      console.warn('localStorage is not available');
    }
  }
  

}
