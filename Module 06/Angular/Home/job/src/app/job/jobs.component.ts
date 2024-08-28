import { Component, OnInit } from '@angular/core';
import { JobService } from '../service/job/job.service';
import { Job } from '../model/job.model';

@Component({
  selector: 'app-jobs',
  templateUrl: './jobs.component.html',
  styleUrl: './jobs.component.css'
})
export class JobsComponent implements OnInit{
  jobs: Job[] = [];

  constructor(private jobService: JobService) {}

  ngOnInit(): void {
    this.getJobs();
  }

  getJobs(): void {
  this.jobService.getAllJobs().subscribe(
    (data: Job[]) => {
      this.jobs = data;
    },
    (error: any) => { // Using 'any' type
      console.error('There was an error fetching the jobs!', error);
    }
  );
  }



  //SEARCH
  



}
