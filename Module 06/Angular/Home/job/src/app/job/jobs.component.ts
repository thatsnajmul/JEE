import { Component, OnInit } from '@angular/core';
import { JobService } from '../service/job/job.service';
import { Job } from '../model/job.model';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-jobs',
  templateUrl: './jobs.component.html',
  styleUrl: './jobs.component.css'
})
export class JobsComponent implements OnInit{
  jobs: Job[] = [];

  constructor(
    private jobService: JobService,
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    this.getJobs();
    this.getJobss();
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
  jobss: any[] = [];
  filteredJobs: any[] = [];

  searchTitle: string = '';
  searchLocation: string = '';
  searchCompany: string = '';

 

  getJobss(): void {
    this.http.get<any[]>('http://localhost:3000/jobs').subscribe(data => {
      this.jobss = data;
      this.filteredJobs = this.jobss; // Initially, display all jobs
    });
  }

  onSearch(): void {
    this.filteredJobs = this.jobs.filter(job =>
      (this.searchTitle ? job.title.toLowerCase().includes(this.searchTitle.toLowerCase()) : true) &&
      (this.searchLocation ? job.location.toLowerCase().includes(this.searchLocation.toLowerCase()) : true) &&
      (this.searchCompany ? job.company.toLowerCase().includes(this.searchCompany.toLowerCase()) : true)
    );
  }



}
