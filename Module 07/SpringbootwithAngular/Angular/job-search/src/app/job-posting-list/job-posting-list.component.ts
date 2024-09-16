import { Component, OnInit } from '@angular/core';
import { JobPostingService } from '../service/job-posting.service';
import { JobPosting } from '../model/job-posting.model';

@Component({
  selector: 'app-job-posting-list',
  templateUrl: './job-posting-list.component.html',
  styleUrls: ['./job-posting-list.component.css']
})
export class JobPostingListComponent implements OnInit {

  jobPostings: JobPosting[] = [];
  page = 0;
  size = 10;

  constructor(private jobPostingService: JobPostingService) { }

  ngOnInit(): void {
    this.loadJobPostings();
  }

  loadJobPostings(): void {
    this.jobPostingService.getJobPostings(this.page, this.size).subscribe(data => {
      this.jobPostings = data;
    });
  }

  onPageChange(page: number): void {
    this.page = page;
    this.loadJobPostings();
  }

  onSearch(searchTerm: string): void {
    // Implement search functionality
  }
}

