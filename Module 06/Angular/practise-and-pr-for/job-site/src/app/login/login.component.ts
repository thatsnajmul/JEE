import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent {
  email = '';
  password = '';

  constructor(private authService: AuthService, private router: Router) {}

  login() {
    this.authService.login(this.email, this.password).subscribe((users) => {
      if (users.length > 0) {
        localStorage.setItem('user', JSON.stringify(users[0]));
        this.router.navigate(['/jobs']);
      } else {
        alert('Invalid credentials');
      }
    });
  }
}
