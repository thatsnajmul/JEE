import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import { JobService } from '../service/job/job.service';
import { Job } from '../model/job.model';

@Component({
  selector: 'app-update-modify-jobs',
  templateUrl: './update-modify-jobs.component.html',
  styleUrl: './update-modify-jobs.component.css'
})
export class UpdateModifyJobsComponent {
    
  jobForm!: FormGroup;
  jobId: string = "";
  job: Job = new Job();

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private jobService: JobService,
  ) { }

  ngOnInit(): void {
    this.jobId = this.route.snapshot.params['id'];
    this.jobForm = this.formBuilder.group({
      title: [''],
      description: [''],
      location: [''],
      company: [''],
      type: ['']
    });

    this.loadJob();
  }

  loadJob(): void {
    this.jobService.getJobById(this.jobId).subscribe({
      next: (job: Job) => {
        this.job = job;
        this.jobForm.patchValue({
          title: job.title,
          description: job.description,
          location: job.location,
          company: job.company,
          type: job.type,
        });
      },
      error: err => {
        console.log(err);
      }
    });
  }

  updateJob(): void {
    if (this.jobForm.invalid) {
      return;
    }

    const updatedJob: Job = {
      ...this.job,
      ...this.jobForm.value
    };
    
    this.jobService.updateJob(updatedJob).subscribe({
      next: res => {
        console.log('Job updated successfully:', res);
        this.router.navigate(['/modify-jobs']); // Navigate to the jobs list after update
      },
      error: err => {
        console.log('Error updating job:', err);
      }
    });
  }
  
  }

  

