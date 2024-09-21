import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { JobApplication } from '../model/job-application.model';
import { JobApplicationService } from '../service/job-application/job-application.service';

@Component({
  selector: 'app-create-job-application',
  templateUrl: './create-job-application.component.html',
  styleUrl: './create-job-application.component.css'
})
export class CreateJobApplicationComponent implements OnInit{

  jobapplicationForm!: FormGroup;
  isEditMode = false;
  jobapplicationId: number =0;
  

  constructor(
    private fb: FormBuilder,
    private jobApplicationService: JobApplicationService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  goToJobPage() {
    this.router.navigate(['/create-job-location']);
  }

  ngOnInit(): void {
    this.jobapplicationForm = this.fb.group({
      // Applicant-specific details
      applicantName: ['', Validators.required],
      applicantEmail: ['', [Validators.required, Validators.email]],
      applicantPhone: ['', Validators.required],
      resumeUrl: ['', Validators.required],
      
      // Job-related details
      experience: [0, Validators.required],
      minSalary: [0, Validators.required],
      maxSalary: [0, Validators.required],
      coverLetter: ['', Validators.required],

      // Job ID
      jobId: ['', Validators.required]
    });

    this.route.params.subscribe(params => {
      this.jobapplicationId = +params['id'];
      if (this.jobapplicationId) {
        this.isEditMode = true;
        this.loadJob(this.jobapplicationId);
      }
    });
  }

  loadJob(id: number): void {
    this.jobApplicationService.getJobApplicationById(id).subscribe(jobApplication => {
      this.jobapplicationForm.patchValue(jobApplication);
    });
  }

  onSubmit(): void {
    if (this.jobapplicationForm.invalid) {
      return;
    }

    const job: JobApplication = this.jobapplicationForm.value;

    if (this.isEditMode) {
      this.jobApplicationService.updateJobApplication(this.jobapplicationId, job).subscribe(() => {
        this.router.navigate(['/']);
      });
    } else {
      this.jobApplicationService.createJobApplication(job).subscribe(() => {
        this.router.navigate(['/']);
      });
    }
  }

}
