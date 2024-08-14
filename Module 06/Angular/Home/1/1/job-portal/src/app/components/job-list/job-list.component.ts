import { Component, OnInit } from '@angular/core';
import { JobService } from '../../services/job.service';
import { Job } from '../../model/job.model';

@Component({
  selector: 'app-job-list',
  templateUrl: './job-list.component.html',
})
export class JobListComponent implements OnInit {
  jobs: Job[] = [];
  searchText = '';

  constructor(private jobService: JobService) {}

  ngOnInit(): void {
    this.jobs = this.jobService.getJobs();
  }

  searchJobs() {
    if (this.searchText) {
      this.jobs = this.jobs.filter(job => 
        job.title.includes(this.searchText) || 
        job.company.includes(this.searchText) ||
        job.location.includes(this.searchText)
      );
    } else {
      this.jobs = this.jobService.getJobs();
    }
  }
}

