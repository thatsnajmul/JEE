import { Inject, Injectable, PLATFORM_ID } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthService } from '../service/auth.service';

@Injectable({
    providedIn: 'root',
  })
  export class AdminEmployerGuard implements CanActivate {
   
  
    constructor(
      private authService: AuthService,
      private router: Router,
      @Inject(PLATFORM_ID) private platformId: Object
    ) {}
  
    canActivate(): boolean {
      if (this.authService.isAdminOrEmployer()) {
        return true;
      } else {
        this.router.navigate(['/login']); // Redirect to a forbidden page if unauthorized
        return false;
      }
    }
  }