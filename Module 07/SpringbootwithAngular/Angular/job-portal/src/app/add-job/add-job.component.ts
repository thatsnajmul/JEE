import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { JobsService } from '../service/jobs/jobs.service';

@Component({
  selector: 'app-add-job',
  templateUrl: './add-job.component.html',
  styleUrl: './add-job.component.css'
})
export class AddJobComponent {

  jobForm: FormGroup;
  selectedImage: File | null = null;

  constructor(private fb: FormBuilder, private jobService: JobsService) {
    this.jobForm = this.fb.group({
      jobTitle: [''],
      companyName: [''],
      jobType: [''],
      jobLocation: [''],
      jobExperience: [''],
      jobMinSalary: [''],
      jobMaxSalary: [''],
      jobCategory: [''],
      jobDeadline: [''],
      jobDescription: ['']
    });
  }

  // Called when the user selects a file
  onFileSelected(event: any) {
    const file = event.target.files[0];
    if (file) {
      this.selectedImage = file;
    }
  }

  // Submits the form data, including the file
  submitForm() {
    const formData = new FormData();
    formData.append('jobTitle', this.jobForm.get('jobTitle')?.value);
    formData.append('companyName', this.jobForm.get('companyName')?.value);
    formData.append('jobType', this.jobForm.get('jobType')?.value);
    formData.append('jobLocation', this.jobForm.get('jobLocation')?.value);
    formData.append('jobExperience', this.jobForm.get('jobExperience')?.value);
    formData.append('jobMinSalary', this.jobForm.get('jobMinSalary')?.value);
    formData.append('jobMaxSalary', this.jobForm.get('jobMaxSalary')?.value);
    formData.append('jobCategory', this.jobForm.get('jobCategory')?.value);
    formData.append('jobDeadline', this.jobForm.get('jobDeadline')?.value);
    formData.append('jobDescription', this.jobForm.get('jobDescription')?.value);

    // Append the selected image file to the FormData if one is selected
    if (this.selectedImage) {
      formData.append('companyImage', this.selectedImage);
    }

    // Call the service to post the data
    this.jobService.addJob(formData).subscribe(
      response => {
        console.log('Job added successfully:', response);
      },
      error => {
        console.error('Error adding job:', error);
      }
    );
  }

}
