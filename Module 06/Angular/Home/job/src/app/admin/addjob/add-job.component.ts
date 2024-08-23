import { Component } from '@angular/core';
import {Job} from "../../model/job.model";
import {JobService} from "../../service/job/job.service";

@Component({
  selector: 'app-add-job',
  templateUrl: './add-job.component.html',
  styleUrl: './add-job.component.css'
})
export class AddJobComponent {
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
    return this.job?.title?.trim() !== '' &&
      this.job?.description?.trim() !== '' &&
      this.job?.location?.trim() !== '' &&
      this.job?.company?.trim() !== '' &&
      this.job?.type?.trim() !== '';
  }
}
