import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import {Job} from "../model/job.model";
import {JobService} from "../service/job/job.service";
import {Application} from "../model/applications.model";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent implements OnInit{

  jobs: Job[] = [];  // Changed the property name to 'jobs' for consistency
  applications: Application[] = [];

  constructor(
    private jobService: JobService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loadData();
    this.getJobApplications();
  }


  getJobApplications(): void {
    this.jobService.getAllJobApplications().subscribe(
      (data: Application[]) => {
        this.applications = data;
      },
      (error: any) => { // Using 'any' type
        console.error('There was an error fetching the jobs!', error);
      }
    );
  }

  loadData(): void {
    this.jobService.getAllJobs().subscribe({
      next: (jobs) => {
        this.jobs = jobs;  // Updated the variable name to 'jobs'
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  deleteJob(jobId?: string): void {
    this.jobService.deleteJob(jobId).subscribe({
      next: () => {
        this.loadData(); // Refresh the list after deletion
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  updateJob(jobId?: string): void {
    this.router.navigate(['/admin', jobId]);
  }

}


