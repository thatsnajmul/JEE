import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private users: User[] = [];
  private isLoggedIn = false;
  private loggedInUser: User | null = null;

  constructor(private router: Router) {}

  register(user: User): void {
    this.users.push(user);
    this.router.navigate(['/login']);
  }

  login(email: string, password: string): boolean {
    const user = this.users.find(u => u.email === email && u.password === password);
    if (user) {
      this.isLoggedIn = true;
      this.loggedInUser = user;
      this.router.navigate(['/']);
      return true;
    }
    return false;
  }

  logout(): void {
    this.isLoggedIn = false;
    this.loggedInUser = null;
    this.router.navigate(['/login']);
  }

  isAuthenticated(): boolean {
    return this.isLoggedIn;
  }

  getLoggedInUser(): User | null {
    return this.loggedInUser;
  }
}

