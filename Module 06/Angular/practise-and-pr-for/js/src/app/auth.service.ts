import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  login(username: string, password: string) {
    // Check against json-server
    // Save user data and role in local storage
    localStorage.setItem('user', JSON.stringify({ username, role: 'job-seeker' }));
  }

  logout() {
    localStorage.removeItem('user');
  }

  isLoggedIn() {
    return localStorage.getItem('user') !== null;
  }

  getUserRole() {
    const user = JSON.parse(localStorage.getItem('user') || '{}');
    return user.role;
  }
}

