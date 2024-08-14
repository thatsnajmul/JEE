import { Injectable, Inject, PLATFORM_ID } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { employeerModel } from '../../model/employeer.model';
import { jobSeekerModel } from '../../model/jobSeeker.model';
import { BehaviorSubject, catchError, map, Observable } from 'rxjs';
import { AuthResponse } from '../../model/auth-response';
import { isPlatformBrowser } from '@angular/common';

//
// import { map } from 'rxjs/operators';

//
import { CanActivate, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})


//
export class AuthService {

  private employerTokenKey = 'employeerToken';
  private jobSeekerTokenKey = 'jobSeekerToken';

  constructor(private http: HttpClient) {}

  // Employer Registration and Login
  registerEmployer(employer: employeerModel): Observable<any> {
    return this.http.post<any>('http://localhost:3000/employer-login', employer);
  }

  loginEmployer(credentials: { EmailId: string; password: string }): Observable<any> {
    if (credentials.EmailId && credentials.password) {
      return this.http.post<any>('http://localhost:3000/employer-login', credentials);
    }
    // Handle the case where credentials are invalid
    return new Observable<any>((observer) => {
      observer.error('Invalid credentials');
    });
  }
  
  

  employeerStoreToken(token: string) {
    localStorage.setItem(this.employerTokenKey, token);
  }

  getEmployerToken(): string | null {
    return localStorage.getItem(this.employerTokenKey);
  }

  // Job Seeker Registration and Login
  registerJobSeeker(jobSeeker: jobSeekerModel): Observable<any> {
    return this.http.post<any>('http://localhost:3000/job-seekers', jobSeeker);
  }

  loginJobSeeker(credentials: { EmailId: string; password: string }): Observable<any> {
    if (credentials.EmailId && credentials.password) {
      return this.http.post<any>('http://localhost:3000/job-seekers', credentials);
    }
    // Handle the case where credentials are invalid
    return new Observable<any>((observer) => {
      observer.error('Invalid credentials');
    });
  }

  jobSeekerStoreToken(token: string) {
    localStorage.setItem(this.jobSeekerTokenKey, token);
  }

  getJobSeekerToken(): string | null {
    return localStorage.getItem(this.jobSeekerTokenKey);
  }

  // Logout Methods
  logoutEmployer() {
    localStorage.removeItem(this.employerTokenKey);
  }

  logoutJobSeeker() {
    localStorage.removeItem(this.jobSeekerTokenKey);
  }

  // Common Methods
  isEmployerLoggedIn(): boolean {
    return !!this.getEmployerToken();
  }

  isJobSeekerLoggedIn(): boolean {
    return !!this.getJobSeekerToken();
  }
}

//
export class EmployerGuard implements CanActivate {
  constructor(private authService: AuthService, private router: Router) {}

  canActivate(): boolean {
    if (this.authService.isEmployerLoggedIn()) {
      return true;
    } else {
      this.router.navigate(['/login']);
      return false;
    }
  }
}

//
export class JobSeekerGuard implements CanActivate {
  constructor(private authService: AuthService, private router: Router) {}

  canActivate(): boolean {
    if (this.authService.isJobSeekerLoggedIn()) {
      return true;
    } else {
      this.router.navigate(['/login']);
      return false;
    }
  }
}

//
// logoutEmployer() {
//   this.authService.logoutEmployer();
//   this.router.navigate(['/login']);
// }

// logoutJobSeeker() {
//   this.authService.logoutJobSeeker();
//   this.router.navigate(['/login']);
// }





