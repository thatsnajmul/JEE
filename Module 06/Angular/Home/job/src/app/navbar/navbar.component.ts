import { Component } from '@angular/core';
import { UserModel } from '../model/user.model';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

  user: UserModel | null = null;

}
