import { Component, OnInit } from '@angular/core';
import { JobService } from '../service/job/job.service';
import { Job } from '../model/job.model';
import { debounceTime, distinctUntilChanged } from 'rxjs/operators';
import { Subject } from 'rxjs';
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
    private http: HttpClient,
  

  ) {

    this.searchSubject.pipe(
      debounceTime(300), // wait 300ms after the last event before emitting last event
      distinctUntilChanged() // only emit if value is different from the last
    ).subscribe((query) => {
      this.jobService.searchJobs(query).subscribe((results) => {
        this.searchResults = results;
      });
    });
  }

  ngOnInit(): void {
    this.loadJobs();
    
  }

  loadJobs(): void {
    this.jobService.getJobs(this.currentPage, this.pageSize).subscribe(data => {
      this.jobs = data.content;
      this.totalPages = data.totalPages;
    });
  }





  searchResults: Job[] = [];
  private searchSubject = new Subject<string>();
  searchJobs(event: Event): void {
    const inputElement = event.target as HTMLInputElement;
    if (inputElement) {
      const inputValue = inputElement.value;
      this.searchSubject.next(inputValue); // Emit the input value
    }
  }

  openOrDownloadPdf(url: string): void {
    this.http.head(url, { observe: 'response', responseType: 'text' }).subscribe(response => {
      const contentType = response.headers.get('Content-Type');
      if (contentType && contentType.includes('pdf')) {
        // Create a temporary anchor element
        const link = document.createElement('a');
        link.href = url;
        link.download = 'CV.pdf'; // Specify the filename

        // Open the PDF in a new tab
        window.open(url, '_blank'); // Open in a new tab

        // Trigger a download
        link.click();
      } else {
        // Handle other file types or errors
        console.error('The URL does not point to a PDF.');
      }
    }, error => {
      console.error('Error fetching file type:', error);
    });
  }

  deleteJob(id: number): void {
    if (confirm('Are you sure you want to delete this job?')) {
      this.jobService.deleteJob(id).subscribe(() => {
        this.loadJobs();  // Refresh the job list after deletion
      });
    }

  }

}