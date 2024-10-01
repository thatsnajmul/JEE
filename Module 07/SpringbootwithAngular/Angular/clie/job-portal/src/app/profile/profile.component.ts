import { Component, OnInit } from '@angular/core';
import { AuthService } from '../service/auth/auth.service';
import { User } from '../model/user.model';
import { Role } from '../model/role.model';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent implements OnInit{

  user: User | null = null; // To hold the user data
  errorMessage: string | null = null; // To hold any error message

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    this.loadUserProfile();
  }

  loadUserProfile(): void {
    const email = this.authService.getCurrentUserEmail();
    if (email) {
      this.authService.getUserByEmail(email).subscribe(
        (user: User) => {
          this.user = user; // Set the user data if retrieved successfully
        },
        (error) => {
          console.error('Error fetching user data: ', error);
          this.errorMessage = 'Error fetching user data.';
        }
      );
    } else {
      this.errorMessage = 'User is not logged in or email not found.';
    }
  }

  

}
