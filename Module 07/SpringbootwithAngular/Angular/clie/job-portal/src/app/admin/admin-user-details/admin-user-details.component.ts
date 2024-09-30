import { Component, OnInit } from '@angular/core';
import { UserService } from '../../service/user/user.service';
import { User } from '../../model/user.model';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from '../../service/auth/auth.service';

@Component({
  selector: 'app-admin-user-details',
  templateUrl: './admin-user-details.component.html',
  styleUrl: './admin-user-details.component.css'
})
export class AdminUserDetailsComponent implements OnInit{

  email: string | null = null;
  user: User | null = null;  // Declare the 'user' property

  constructor(private route: ActivatedRoute, private authService: AuthService) {}

  ngOnInit(): void {
    // Retrieve the email from the URL
    this.email = this.route.snapshot.paramMap.get('email');
    console.log("Email from URL: ", this.email);

    if (this.email) {
      this.authService.getUserByEmail(this.email).subscribe(
        (userData: User) => {
          console.log('User data: ', userData);
          this.user = userData;
        },
        (error) => {
          console.error('Error fetching user data: ', error);
        }
      );
    } else {
      console.error('Email is null');
    }
  }
  

}
