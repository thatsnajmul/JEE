import { Component } from '@angular/core';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.css'
})
export class MenuComponent {
  authService: any;
  router: any;
  logout() {
    this.authService.logout();
    this.router.navigate(['/']);
  }
  
}
