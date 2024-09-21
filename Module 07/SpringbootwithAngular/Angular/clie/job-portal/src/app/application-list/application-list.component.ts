import { Component, OnInit } from '@angular/core';
import { JobApplicationService } from '../service/job-application/job-application.service';
import { JobApplication } from '../model/job-application.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-application-list',
  templateUrl: './application-list.component.html',
  styleUrl: './application-list.component.css'
})
export class ApplicationListComponent implements OnInit{

  jobApplications: JobApplication[] = [];
  currentPage = 0;
  pageSize = 10;
  totalPages: number = 0;

  constructor(
    private jobApplicationService: JobApplicationService,
    private router: Router  // Add the Router service here
  ) {}

  ngOnInit(): void {
    this.loadJobApplications();
  }

  loadJobApplications(): void {
    this.jobApplicationService.getJobApplications(this.currentPage, this.pageSize).subscribe(data => {
      this.jobApplications = data.content;
      this.totalPages = data.totalPages;
    });
  }

  // Handle page navigation
  onPageChange(page: number): void {
    this.currentPage = page;
    this.loadJobApplications();
  }

  // Edit job application (navigate to the edit form)
  // Navigate to edit route
  editJobApplication(id: number | undefined): void {
    if (id !== undefined) {
      this.router.navigate([`/job-applications/edit`, id]);
    } else {
      console.error('Job Application ID is undefined');
    }
  }

  // Delete a job application
deleteJobApplication(id: number | undefined): void {
  if (id !== undefined) {  // Check if the id is defined
    if (confirm('Are you sure you want to delete this job application?')) {
      this.jobApplicationService.deleteJobApplication(id).subscribe(() => {
        this.loadJobApplications(); // Reload the list after deletion
      }, error => {
        console.error('Error deleting job application:', error);  // Error handling
      });
    }
  } else {
    console.error('Job application ID is undefined');  // Handle the undefined case
  }
}


}
