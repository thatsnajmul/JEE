import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { JobService } from '../service/job/job.service';

@Component({
  selector: 'app-personaldetails',
  templateUrl: './personaldetails.component.html',
  styleUrl: './personaldetails.component.css'
})
export class PersonaldetailsComponent {

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

  onSubmit(form: NgForm): void {
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
