import { Component } from '@angular/core';
import { JobService } from '../../service/job.service';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  //
  loginObj: any = {
    "Username": "",
    "Password": "string"
  }


  constructor(private jobSrv: JobService, private router: Router){}

  onLogin() {
    this.jobSrv.login(this.loginObj).subscribe((res:any)=>{
      if(res.result){

        alert('User Logged in success')
        //localStorage.setItem('jobLoginUser', JSON.stringify(res.data));
        this.router.navigateByUrl('home') //after declaring localstorage ridirrect to the home with profile name
        
      } else {
        alert('res.message')
      }
    }

    )
  }

}
