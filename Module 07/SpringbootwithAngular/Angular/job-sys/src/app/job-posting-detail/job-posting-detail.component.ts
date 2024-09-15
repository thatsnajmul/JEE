import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { JobPostingService } from '../service/job-posting.service';
import { JobPosting } from '../model/job-posting.model';

@Component({
  selector: 'app-job-posting-detail',
  templateUrl: './job-posting-detail.component.html',
  styleUrl: './job-posting-detail.component.css'
})
export class JobPostingDetailComponent implements OnInit{

  jobPosting: JobPosting | undefined;

  constructor(private route: ActivatedRoute, private jobPostingService: JobPostingService) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.jobPostingService.getJobPostingById(+id).subscribe(data => {
        this.jobPosting = data;
      });
    }
  }

  downloadCv(): void {
    if (this.jobPosting?.cvUrl) {
      window.open(this.jobPosting.cvUrl, '_blank');
    }
  }



}
