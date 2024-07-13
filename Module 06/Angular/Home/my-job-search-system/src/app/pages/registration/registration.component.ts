import { Component } from '@angular/core';
import { JobService } from '../../service/job.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrl: './registration.component.css'
})
export class RegistrationComponent {

  employerObj: any = {
    
      "EmployerId": 0,
      "CompanyName": "",
      "EmailId": "",
      "MobileNo": "",
      "PhoneNo": "",
      "CompanyAddress": "",
      "City": "",
      "State": "",
      "PinCode": "",
      "LogoURL": "",
      "GstNo": ""
  }

  constructor(private job: JobService){
    this.job.registrationEmployer(this.employerObj).subscribe((res:any)=>{
      if(res.result){
        alert('Save Successfully')
      }
      else{
        alert('Save not Successfully')
      }
    })
  }

}
