import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { JobsService } from '../service/jobs/jobs.service';
import { Job } from '../model/jobs.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-job-create',
  templateUrl: './job-create.component.html',
  styleUrl: './job-create.component.css'
})
export class JobCreateComponent implements OnInit{

  jobForm!: FormGroup;
  selectedFile: File | null = null;

  constructor(
    private fb: FormBuilder,
    private jobService: JobsService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.jobForm = this.fb.group({
      jobTitle: ['', Validators.required],
      companyName: ['', Validators.required],
      jobType: ['', Validators.required],
      jobLocation: ['', Validators.required],
      jobExperience: ['', Validators.required],
      jobMinSalary: [0, Validators.required],
      jobMaxSalary: [0, Validators.required],
      jobCategory: ['', Validators.required],
      jobDeadline: ['', Validators.required],
      jobDescription: ['', Validators.required],
      companyImage: [null],  // For file input
    });
  }

  onFileSelected(event: any) {
    const file = event.target.files[0];
    if (file) {
      this.selectedFile = file;
      this.jobForm.patchValue({
        companyImage: file,
      });
    }
  }

  onSubmit() {
    if (this.jobForm.valid) {
      const formData = new FormData();
      const formValue = this.jobForm.value;

      // Append job data
      formData.append('jobTitle', formValue.jobTitle);
      formData.append('companyName', formValue.companyName);
      formData.append('jobType', formValue.jobType);
      formData.append('jobLocation', formValue.jobLocation);
      formData.append('jobExperience', formValue.jobExperience);
      formData.append('jobMinSalary', formValue.jobMinSalary);
      formData.append('jobMaxSalary', formValue.jobMaxSalary);
      formData.append('jobCategory', formValue.jobCategory);
      formData.append('jobDeadline', formValue.jobDeadline);
      formData.append('jobDescription', formValue.jobDescription);

      // Append file if selected
      if (this.selectedFile) {
        formData.append('companyImage', this.selectedFile, this.selectedFile.name);
      }

      // Call the service to create or update the job
      if (formValue.id) {
        this.jobService.updateJobWithImage(formValue.id, formData).subscribe(() => {
          this.router.navigate(['/']); // Redirect after update
        });
      } else {
        this.jobService.createJobWithImage(formData).subscribe(() => {
          this.router.navigate(['/']); // Redirect after submission
        });
      }
    }
  }

 

}
