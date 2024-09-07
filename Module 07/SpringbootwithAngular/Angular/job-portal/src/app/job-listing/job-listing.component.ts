import { Component, OnInit } from '@angular/core';
import { JobsService } from '../service/jobs/jobs.service';
import { Job } from '../model/jobs.model';

@Component({
  selector: 'app-job-listing',
  templateUrl: './job-listing.component.html',
  styleUrl: './job-listing.component.css'
})
export class JobListingComponent implements OnInit{
  jobs: Job[] = [];

  constructor(private jobService: JobsService) {}

  ngOnInit(): void {
    this.loadJobs();
  }

  loadJobs() {
    this.jobService.getJobs().subscribe((data) => {
      this.jobs = data;
    });
  }

  deleteJob(id: number) {
    this.jobService.deleteJob(id).subscribe(() => {
      this.loadJobs(); // Refresh the list after deletion
    });
  }
}
