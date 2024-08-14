import { Component } from '@angular/core';
import { AuthService } from '../../services/auth/auth.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { employeerModel } from '../../model/employeer.model';
import { jobSeekerModel } from '../../model/jobSeeker.model';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrl: './registration.component.css'
})
export class RegistrationComponent {

  isJobSeeker: boolean = true;

  employeeRegForm!: FormGroup;
  jobSeekerRegForm!: FormGroup;
  
  constructor(
    public authService: AuthService,
    private router: Router,
    private formBuilder: FormBuilder
  ) {
    // Initialize the employee registration form
    this.employeeRegForm = this.formBuilder.group({
      companyName: ['', Validators.required],
      EmailId: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      mobileNo: ['', Validators.required],
      companyAddress: ['', Validators.required],
      city: ['', Validators.required],
      state: ['', Validators.required],
      pinCode: ['', Validators.required],
      logoURL: ['', Validators.required],
      gstNo: ['', Validators.required]
    });
  
    // Initialize the job seeker registration form
    this.jobSeekerRegForm = this.formBuilder.group({
      fullname: ['', Validators.required],
      emailId: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      mobileNo: ['', Validators.required],
      experienceStatus: ['', Validators.required],
      city: ['', Validators.required]
    });
  }
  
  //For Employeer
  employeerOnSubmit(): void {
    if (this.employeeRegForm.valid) {
      const employeeruser: employeerModel = this.employeeRegForm.value;
      this.authService.registerEmployer(employeeruser).subscribe({
        next: (res) => {
          console.log('employeeruser registered successfully:', res);
          this.authService.employeerStoreToken(res.employeertoken);
          this.router.navigate(['/']); // Navigate to a protected route after registration
        },
        error: (err) => {
          console.error('Error registering employeeruser:', err);
        }
      });
    }
    else{
      alert("Complte mandatory Field");
    }
  }

  //For Job Seeker
  jobSeekerOnSubmit(): void {
    if (this.jobSeekerRegForm.valid) {
      const jobseekeruser: jobSeekerModel = this.jobSeekerRegForm.value;
      this.authService.registerJobSeeker(jobseekeruser).subscribe({
        next: (res) => {
          console.log('jobseekeruser registered successfully:', res);
          this.authService.jobSeekerStoreToken(res.jobseekertoken);
          this.router.navigate(['/']); // Navigate to a protected route after registration
        },
        error: (err) => {
          console.error('Error registering jobseekeruser:', err);
        }
      });
    }
    else{
      alert("Complte mandatory Field");
    }
  }


  

  }


