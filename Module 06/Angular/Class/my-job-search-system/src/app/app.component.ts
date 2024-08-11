import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  //title = 'my-job-search-system';

  isLoggedIn: boolean = false;

  userInfo: any;

  // constructor() {
  //   // const userData = localStorage.getItem('jobLoginUser');
  //   // if(userData == null) {
  //   //   this.isLoggedIn = false;
  //   // }
  //   // else{
  //   //   this.isLoggedIn = true;
  //   //   this.userInfo = JSON.parse(userData);
  //   // }
  // }

  // logOff(){
  //   //localStorage.removeItem('jobLoginUser');
  //   this.isLoggedIn = false;
  // }

}
