import { Component, OnInit } from '@angular/core';

//import oninit and implements
import { JobService } from '../../service/job.service';

@Component({
  selector: 'app-create-new-job',
  templateUrl: './create-new-job.component.html',
  styleUrl: './create-new-job.component.css'
})
export class CreateNewJobComponent implements OnInit {
  jobObj: any = {
    "JobId": 0,
    "JobName": "",
    "CreatedDate": new Date(),
    "EmployerId": 0,
    "CategoryId": 0,
    "Experience": "",
    "Package": "",
    "Location": "",
    "JobDescription": "",
    "IsActive": true
  }

  categoryList: any [] = [];

  //we need must
  constructor(private jobSrv: JobService){}

  ngOnInit(): void {
    this.getJobCategories();
  }

  getJobCategories() {
    this.jobSrv.getAllCategory().subscribe((res:any) =>{
    this.categoryList = res.data;
    })
  }



  
}
