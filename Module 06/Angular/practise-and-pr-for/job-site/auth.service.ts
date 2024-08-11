import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:3000/users';

  constructor(private http: HttpClient, private router: Router) {}

  register(user: any) {
    return this.http.post(this.apiUrl, user);
  }

  login(email: string, password: string) {
    return this.http.get<any[]>(`${this.apiUrl}?email=${email}&password=${password}`);
  }

  logout() {
    localStorage.removeItem('user');
    this.router.navigate(['/login']);
  }

  isLoggedIn() {
    return localStorage.getItem('user') !== null;
  }

  getCurrentUser() {
    return JSON.parse(localStorage.getItem('user') || '{}');
  }
}
