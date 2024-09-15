import { Component, OnInit } from '@angular/core';
import { JobService } from '../service/job.service';
import { Job } from '../model/job.model';

import { HttpClient } from '@angular/common/http';

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


  constructor(
    private jobService: JobService,
    private http: HttpClient

  ) {}

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
  

  openOrDownloadPdf(url: string): void {
    // Create a temporary anchor element
    const link = document.createElement('a');
    link.href = url;

    // Set the desired file name (optional)
    link.download = 'CV.pdf';

    // Open in a new tab or download
    window.open(url, '_blank'); // Open in a new tab

    // Trigger a download (comment this line if you only want to open in a new tab)
    link.click();
  }

}
