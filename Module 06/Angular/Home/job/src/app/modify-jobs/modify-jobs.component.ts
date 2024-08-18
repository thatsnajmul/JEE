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

  jobs: Job[] = [];  // Changed the property name to 'jobs' for consistency

  constructor(
    private jobService: JobService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadData();
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

  deleteJob(jobId: string): void {
    this.jobService.deleteJob(jobId).subscribe({
      next: () => {
        this.loadData(); // Refresh the list after deletion
      },
      error: (err) => {
        console.log(err);
      }
    });
  }

  updateJob(job: Job): void {
    if (job.id) {  // Check if job.id is defined
      this.router.navigate(['/update-modify-jobs', job.id]);
    } else {
      console.error('Job ID is undefined.');
    }
  }



}
