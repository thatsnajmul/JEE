import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  user = {
    username: '',
    password: '',
    email: '',
  };
  errorMessage = '';

  constructor(private authService: AuthService, private router: Router) {}

  register(): void {
    this.authService.register(this.user).subscribe(
      (response) => {
        this.router.navigate(['/login']); // Redirect to login after registration
      },
      (error) => {
        this.errorMessage = 'Registration failed';
      }
    );
  }

}
