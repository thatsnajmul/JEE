import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { JobService } from '../service/job.service';

@Component({
  selector: 'app-create-job-application',
  templateUrl: './create-job-application.component.html',
  styleUrl: './create-job-application.component.css'
})
export class CreateJobApplicationComponent {
  application = {
    name: '',
    email: '',
    phone: '',
    resume: '',
    coverLetter: '',
    jobId: ''
  };

  constructor(private jobService: JobService) {}

  onSubmit(form: NgForm): void {
    if (form.valid) {
      this.jobService.submitApplication(this.application).subscribe({
        next: () => {
          alert('Application submitted successfully!');
          form.reset();
        },
        error: (err) => {
          console.error('Error submitting application:', err);
          alert('Failed to submit application.');
        }
      });
    }
  }
}
