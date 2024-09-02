import { Component, OnInit} from '@angular/core';
import { JobService } from '../app/service/job/job.service';
import { UserModel } from './model/user.model';
import { AuthService } from './service/auth/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})


export class AppComponent implements OnInit{
  title = 'job';  

  userRole: string | null = '';
  currentUser: UserModel| null = null;
  
  constructor(private authService:AuthService){

  }


  ngOnInit(): void {
    this.authService.currentUser$.subscribe(user => {
      this.currentUser = user;
      this.userRole = user?.role || null;
    });
  }
}
