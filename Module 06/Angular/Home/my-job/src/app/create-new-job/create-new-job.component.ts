import { Component } from '@angular/core';
import { JobService } from '../service/job/job.service';
import { Job } from '../model/job.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-new-job',
  templateUrl: './create-new-job.component.html',
  styleUrls: ['./create-new-job.component.css']
})
export class CreateNewJobComponent {
  job: Job = { id: 0, title: '', description: '', company: '', location: '', postedBy: 0 };

  constructor(private jobService: JobService, private router: Router) { }

  createJob(): void {
    this.jobService.createJob(this.job).subscribe(() => {
      this.router.navigate(['/jobs']);
    });
  }
}

