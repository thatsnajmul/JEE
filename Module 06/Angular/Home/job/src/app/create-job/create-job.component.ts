import { Component } from '@angular/core';
import { JobService } from '../service/job.service';
import { Job } from '../model/job.model';

@Component({
  selector: 'app-create-job',
  templateUrl: './create-job.component.html',
  styleUrl: './create-job.component.css'
})
export class CreateJobComponent {
  job: Job = {
    title: '',
    description: '',
    location: '',
    company: '',
    type: ''
  };

  constructor(private jobService: JobService) {}

  onSubmit() {
    if (this.isFormValid()) {
      this.jobService.createJob(this.job).subscribe(response => {
        console.log('Job created successfully:', response);
        
        // Optionally reset the form or navigate to another page
        // this.job = { title: '', description: '', location: '', company: '', type: '' };
        // this.router.navigate(['/jobs']);
        window.location.reload();
      });
    } else {
      console.log('Form is invalid');
    }
  }

  isFormValid(): boolean {
    // Add your custom validation logic here if needed
    return this.job.title.trim() !== '' &&
           this.job.description.trim() !== '' &&
           this.job.location.trim() !== '' &&
           this.job.company.trim() !== '' &&
           this.job.type.trim() !== '';
  }
}
