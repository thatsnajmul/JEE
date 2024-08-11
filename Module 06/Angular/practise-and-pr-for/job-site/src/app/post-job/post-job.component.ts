import { Component } from '@angular/core';
import { JobService } from '../services/job.service';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-post-job',
  templateUrl: './post-job.component.html'
})
export class PostJobComponent {
  job = { title: '', description: '', postedBy: '' };

  constructor(private jobService: JobService, private authService: AuthService) {}

  postJob() {
    this.job.postedBy = this.authService.getCurrentUser().email;
    this.jobService.addJob(this.job).subscribe(() => {
      alert('Job posted successfully');
    });
  }
}
