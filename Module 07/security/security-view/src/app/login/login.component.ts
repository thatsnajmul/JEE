import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  credentials = {
    username: '',
    password: '',
  };
  errorMessage = '';

  constructor(private authService: AuthService, private router: Router) {}

  login(): void {
    this.authService.login(this.credentials).subscribe(
      (response: any) => {
        this.authService.saveToken(response.token); // Save JWT to local storage
        this.router.navigate(['/dashboard']); // Redirect after login
      },
      (error) => {
        this.errorMessage = 'Invalid credentials';
      }
    );
  }




}
