import { Component } from '@angular/core';
import { JobService } from '../../services/job.service';
import { Job } from '../../model/job.model';

@Component({
  selector: 'app-job-post',
  templateUrl: './job-post.component.html',
})
export class JobPostComponent {
  job: Job = { title: '', description: '', company: '', location: '' };

  constructor(private jobService: JobService) {}

  postJob() {
    this.jobService.postJob(this.job);
  }
}
