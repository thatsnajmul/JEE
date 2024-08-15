import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { JobService } from '../service/job.service';
import { Job } from '../model/job.model';

@Component({
  selector: 'app-update-modify-jobs',
  templateUrl: './update-modify-jobs.component.html',
  styleUrl: './update-modify-jobs.component.css'
})
export class UpdateModifyJobsComponent implements OnInit{

  job: Job = { title: '', description: '', location: '', company: '', type: '' };
  jobId: string = ''; // Store the ID of the job to update

  constructor(
    private jobService: JobService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.jobId = this.route.snapshot.paramMap.get('id')!;
    if (this.jobId) {
      this.jobService.getJob(this.jobId).subscribe({
        next: (job: Job) => {
          this.job = job;
        },
        error: (err) => {
          console.error('Error fetching job:', err);
          alert('Failed to load job data.');
        }
      });
    } else {
      alert('Invalid job ID.');
    }
  }
  

  onSubmit(form: NgForm): void {
    if (form.valid) {
      this.jobService.updateJob(this.jobId, this.job).subscribe({
        next: () => {
          alert('Job updated successfully!');
          this.router.navigate(['/jobs']); // Navigate to the jobs list or another route
        },
        error: (err) => {
          console.error('Error updating job:', err);
          alert('Failed to update job.');
        }
      });
    }
  }

  

}
