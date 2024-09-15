import { Component, OnInit } from '@angular/core';
import { JobService } from '../service/job.service';
import { Job } from '../model/job.model';

@Component({
  selector: 'app-job-list',
  templateUrl: './job-list.component.html',
  styleUrl: './job-list.component.css'
})
export class JobListComponent implements OnInit{

  jobs: Job[] = [];
  currentPage = 0;
  pageSize = 10;
  totalPages: number=0;


  constructor(private jobService: JobService) {}

  ngOnInit(): void {
    this.loadJobs();
  }

  loadJobs(): void {
    this.jobService.getJobs(this.currentPage, this.pageSize).subscribe(data => {
      this.jobs = data.content;
      this.totalPages = data.totalPages;
    });
  }

  searchJobs(event: Event): void {
    const inputElement = event.target as HTMLInputElement;
    if (inputElement) {
      const inputValue = inputElement.value;
      console.log(inputValue);
    }
  }
  

  downloadCv(url: string): void {
    window.open(url, '_blank');
  }

}
