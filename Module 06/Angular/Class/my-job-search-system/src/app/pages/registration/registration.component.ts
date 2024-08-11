import { Component } from '@angular/core';
import { JobService } from '../../service/job.service';
import { Router } from '@angular/router';


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

  jobSeekerObj: any = {
    
    "JobSeekerId": 0,
    "Fullname": "",
    "EmailId": "",
    "MobileNo": "",
    "ExperienceStatus": "",
    "ResumeUrl": ""
}

  //
  isJobSeeker: boolean = true;


  constructor(
    private job: JobService,
    private router: Router,

  ){}

  registration(){
    this.job.registrationEmployer(this.employerObj).subscribe((res:any)=>{
      if(res.result){
        alert('Save Successfully')
      }
      else{
        alert('Save not Successfully')
      }
    })

  }

  registerAsJobSeeker(){
    this.job.registrationAsJobSeeker(this.jobSeekerObj).subscribe((res:any)=>{
      if(res.result){
        alert('Save Successfully')
      }
      else{
        alert('Save not Successfully')
      }
    })
  }

}
