import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { User } from '../../model/user.model';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
})
export class RegisterComponent {
  user: User = { username: '', email: '', password: '' };

  constructor(private authService: AuthService) {}

  register() {
    this.authService.register(this.user);
  }
}
