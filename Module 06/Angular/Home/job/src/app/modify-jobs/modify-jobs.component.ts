import { Component, OnInit } from '@angular/core';
import { JobService } from '../service/job.service';
import { Job } from '../model/job.model';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-modify-jobs',
  templateUrl: './modify-jobs.component.html',
  styleUrl: './modify-jobs.component.css'
})
export class ModifyJobsComponent implements OnInit {


  jobs: Job[] = [];

  constructor(
    private jobService: JobService,
    private router: Router,
    private httpClient: HttpClient
  ) { }

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

  updateJob(id?: string) {
    this.router.navigate(["/update-modify-jobs", id])
  }





}
