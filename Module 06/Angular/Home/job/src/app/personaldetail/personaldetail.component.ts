import { Component } from '@angular/core';
import { JobService } from '../service/job/job.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-personaldetail',
  templateUrl: './personaldetail.component.html',
  styleUrl: './personaldetail.component.css'
})
export class PersonaldetailComponent {
  cvData = {
    fullName: '',
    email: '',
    phone: '',
    address: '',
    degree: '',
    institution: '',
    companyName: '',
    jobTitle: '',
    jobDescription: '',
    skills: ''
  };

  constructor(private jobService: JobService) {}

  onSubmits(form: NgForm): void {
    if (form.valid) {
      this.jobService.submitCvData(this.cvData).subscribe({
        next: () => {
          alert(' submitted successfully!');
          form.reset();
        },
        error: (err) => {
          console.error('Error submitting:', err);
          alert('Failed to submit');
        }
      });
    }
  }
}
