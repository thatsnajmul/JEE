import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { JobService } from '../../services/job.service';
import { Job } from '../../model/job.model';

@Component({
  selector: 'app-job-details',
  templateUrl: './job-details.component.html',
})
export class JobDetailsComponent implements OnInit {
  job: Job | undefined;

  constructor(private route: ActivatedRoute, private jobService: JobService) {}

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id')!;
    this.job = this.jobService.getJobById(id);
  }

  applyForJob() {
    alert('Application submitted!');
  }
}

